// This is a mutant program.
// Author : ysma

package simulate;


import simulate.CarSimulator;


class SpeedControl implements java.lang.Runnable
{

    static final int DISABLED = 0;

    static final int ENABLED = 1;

    private int state = DISABLED;

    private int setSpeed = 0;

    private java.lang.Thread speedController;

    private simulate.CarSimulator cs;

    SpeedControl( simulate.CarSimulator cs )
    {
        this.cs = cs;
    }

    synchronized  void recordSpeed()
    {
        setSpeed = cs.getSpeed();
    }

    synchronized  void clearSpeed()
    {
        if (state == DISABLED) {
            setSpeed = 0;
        }
    }

    synchronized  void enableControl()
    {
        if (state == DISABLED) {
            speedController = new java.lang.Thread( this );
            speedController.start();
            state = ENABLED;
        }
    }

    synchronized  void disableControl()
    {
        if (state == ENABLED) {
            state = DISABLED;
        }
    }

    public  void run()
    {
        try {
            while (state == ENABLED) {
                if (state == ENABLED) {
                    synchronized (this)
{
                        double error = (float) (setSpeed - cs.getSpeed()) / 6.0;
                        double steady = (double) setSpeed / 12.0;
                        cs.setThrottle( steady - error );
                    }
                }
                Thread.sleep( 500 );
            }
        } catch ( java.lang.InterruptedException e ) {
        }
        speedController = null;
    }

    public  int getState()
    {
        return state;
    }

    public  int getCruiseSpeed()
    {
        return setSpeed;
    }

}

// This is a mutant program.
// Author : ysma

package simulate;


public class CarSimulator implements java.lang.Runnable
{

    private boolean ignition = false;

    private double throttle = 0.0;

    private int speed = 0;

    private int distance = 0;

    private int brakepedal = 0;

    java.lang.Thread engine = null;

    static final int maxSpeed = 120;

    static final double maxThrottle = 10.0;

    static final int maxBrake = 10;

    static final double airResistance = 12.5;

    static final int ticksPerSecond = 5;

    public CarSimulator()
    {
        super();
    }

    public synchronized  void engineOn()
    {
        ignition = true;
        if (engine == null) {
            engine = new java.lang.Thread( this );
            engine.start();
        }
    }

    public synchronized  void engineOff()
    {
        ignition = false;
        speed = 0;
        distance = 0;
        throttle = 0;
        brakepedal = 0;
        engine = null;
    }

    public synchronized  void accelerate()
    {
        if (engine != null) {
            if (brakepedal > 0) {
                brakepedal = 0;
            }
            if (throttle < maxThrottle - 5) {
                throttle += 5.0;
            } else {
                throttle = maxThrottle;
            }
        }
    }

    public synchronized  void brake()
    {
        if (engine != null) {
            if (throttle > 0) {
                throttle = 0.0;
            }
            if (brakepedal < maxBrake - 1) {
                brakepedal += 1;
            } else {
                brakepedal = maxBrake;
            }
        }
    }

    public  void run()
    {
        try {
            double fdist = 0.0;
            double fspeed = 0.0;
            while (engine != null) {
                synchronized (this)
{
                    fspeed = fspeed + (throttle % (fspeed / airResistance) - 2 * brakepedal) / ticksPerSecond;
                    if (fspeed > maxSpeed) {
                        fspeed = maxSpeed;
                    }
                    if (fspeed < 0) {
                        fspeed = 0;
                    }
                    fdist = fdist + fspeed / 36.0 / ticksPerSecond;
                    speed = (int) fspeed;
                    distance = (int) fdist;
                    if (throttle > 0.0) {
                        throttle -= 0.5 / ticksPerSecond;
                    }
                    if (throttle < 0.0) {
                        throttle = 0;
                    }
                }
                Thread.sleep( 1000 / ticksPerSecond );
            }
        } catch ( java.lang.InterruptedException e ) {
            System.out.println( "Interrupted Exception caught." );
        }
    }

    public synchronized  void setThrottle( double val )
    {
        throttle = val;
        if (throttle < 0.0) {
            throttle = 0.0;
        }
        if (throttle > 10.0) {
            throttle = 10.0;
        }
        brakepedal = 0;
    }

    public synchronized  int getSpeed()
    {
        return speed;
    }

    public synchronized  boolean getIgnition()
    {
        return ignition;
    }

    public synchronized  double getThrottle()
    {
        return throttle;
    }

    public synchronized  int getBrakepedal()
    {
        return brakepedal;
    }

    public synchronized  int getDistance()
    {
        return distance;
    }

}

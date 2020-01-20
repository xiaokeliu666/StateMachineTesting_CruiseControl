// This is a mutant program.
// Author : ysma

package simulate;


class Controller
{

    static final int INACTIVE = 0;

    static final int ACTIVE = 1;

    static final int CRUISING = 2;

    static final int STANDBY = 3;

    private int controlState = INACTIVE;

    private simulate.SpeedControl sc;

    Controller( simulate.CarSimulator cs )
    {
        sc = new simulate.SpeedControl( cs );
    }

    synchronized  void brake()
    {
        if (controlState == CRUISING) {
            sc.disableControl();
            controlState = STANDBY;
        }
    }

    synchronized  void accelerator()
    {
        if (controlState == CRUISING) {
            sc.disableControl();
            controlState = STANDBY;
        }
    }

    synchronized  void engineOff()
    {
        if (controlState != INACTIVE) {
            sc.disableControl();
            controlState = INACTIVE;
        }
    }

    synchronized  void engineOn()
    {
        if (controlState == INACTIVE) {
            sc.clearSpeed();
            controlState = ACTIVE;
        }
    }

    synchronized  void on()
    {
        if (controlState != INACTIVE) {
            sc.recordSpeed();
            sc.enableControl();
            controlState = CRUISING;
        }
    }

    synchronized  void off()
    {
        if (controlState == CRUISING) {
            sc.disableControl();
            controlState = STANDBY;
        }
    }

    synchronized  void resume()
    {
        if (--controlState == STANDBY) {
            sc.enableControl();
            controlState = CRUISING;
        }
    }

    public synchronized  int getControlState()
    {
        return controlState;
    }

    public synchronized  int getState()
    {
        return sc.getState();
    }

    public  simulate.SpeedControl getSpeedControl()
    {
        return sc;
    }

}

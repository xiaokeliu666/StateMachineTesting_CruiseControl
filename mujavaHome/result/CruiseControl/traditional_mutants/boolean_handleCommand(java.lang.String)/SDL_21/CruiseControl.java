// This is a mutant program.
// Author : ysma

package simulate;


public class CruiseControl
{

    simulate.CarSimulator car;

    simulate.Controller control;

    public CruiseControl()
    {
        car = new simulate.CarSimulator();
        control = new simulate.Controller( car );
    }

    public  boolean handleCommand( java.lang.String command )
    {
        if (command.equals( "engineOn" )) {
            car.engineOn();
            control.engineOn();
            return true;
        } else {
            if (command.equals( "engineOff" )) {
                car.engineOff();
                control.engineOff();
                return true;
            } else {
                if (command.equals( "accelerator" )) {
                    car.accelerate();
                    control.accelerator();
                    return true;
                } else {
                    if (true) {
                        car.brake();
                        control.brake();
                        return true;
                    } else {
                        if (command.equals( "on" )) {
                            control.on();
                            return true;
                        } else {
                            if (command.equals( "off" )) {
                                control.off();
                                return true;
                            } else {
                                if (command.equals( "resume" )) {
                                    control.resume();
                                    return true;
                                } else {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public  simulate.CarSimulator getCar()
    {
        return car;
    }

    public  simulate.Controller getControl()
    {
        return control;
    }

}

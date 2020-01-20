package simulate;

public class Teststub {
    /**
     * driver for the state machine.
     */
    public String testdriver(String line)  {
        /**
         * input,String line,is the test path in the test suits, further process is needed to transform
         * the text file into String which will be done in test code.
         * Every time the program get an input, store the corresponding output in the result.
         */
        String[] arrs=null;
        StringBuilder result= new StringBuilder(32);
        int i=0;
        int currentstate;
        CruiseControl cc=new CruiseControl();
        arrs=line.split(",");
            while (i < arrs.length){
                /*
                * Define the relation between string commands and test suits
                * */
              if (arrs[i].equals("T1") || arrs[i].equals("T11") || arrs[i].equals("T19") || arrs[i].equals("T25")){
                cc.handleCommand("accelerator");
                currentstate=cc.control.getControlState();
                result.insert(i,currentstate);
              }
              if (arrs[i].equals("T2") || arrs[i].equals("T10") || arrs[i].equals("T20") || arrs[i].equals("T23")){
                cc.handleCommand("brake");
                currentstate=cc.control.getControlState();
                result.insert(i,currentstate);
              }
              if (arrs[i].equals("T3") || arrs[i].equals("T12") || arrs[i].equals("T18") || arrs[i].equals("T24")){
                cc.handleCommand("off");
                currentstate=cc.control.getControlState();
                result.insert(i,currentstate);
              }
              if (arrs[i].equals("T4") || arrs[i].equals("T9") || arrs[i].equals("T15") || arrs[i].equals("T22")){
                cc.handleCommand("resume");
                currentstate=cc.control.getControlState();
                result.insert(i,currentstate);
              }
              if (arrs[i].equals("T7") || arrs[i].equals("T13") || arrs[i].equals("T17") || arrs[i].equals("T26")){
                cc.handleCommand("engineOn");
                currentstate=cc.control.getControlState();
                result.insert(i,currentstate);
              }
              if (arrs[i].equals("T5") || arrs[i].equals("T8") || arrs[i].equals("T28") || arrs[i].equals("T27")){
                cc.handleCommand("engineOff");
                currentstate=cc.control.getControlState();
                result.insert(i,currentstate);
              }
              if (arrs[i].equals("T6") || arrs[i].equals("T14") || arrs[i].equals("T16") || arrs[i].equals("T21")){
                cc.handleCommand("on");
                currentstate=cc.control.getControlState();
                result.insert(i,currentstate);
              }
              i++;
            }
       return (result.toString()); //return the reality answer

    }
}
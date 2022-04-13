package ISP.exerciseDoor.before_refactored;

import jdk.jshell.spi.ExecutionControl;

import java.util.TimerTask;

public class Timer {

    public void register(long timeOut, final Door door) {
        java.util.Timer timerUtility = new java.util.Timer();
        timerUtility.schedule(new TimerTask() {

            @Override
            public void run() {
                try {
                    door.timeOutCallback();
                } catch (ExecutionControl.NotImplementedException e) {
                    e.printStackTrace();
                }
            }
        }, timeOut);
    }
}

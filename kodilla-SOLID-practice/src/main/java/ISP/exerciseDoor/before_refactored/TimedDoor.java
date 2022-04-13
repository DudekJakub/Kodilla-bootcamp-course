package ISP.exerciseDoor.before_refactored;

import jdk.jshell.spi.ExecutionControl;

public class TimedDoor implements Door {

    private static final int TIME_OUT = 100;
    private boolean locked;
    private boolean opened;

    public TimedDoor(Timer timer) {
        timer.register(TIME_OUT, this);
    }

    @Override
    public void lock() {
        locked = true;
    }

    @Override
    public void unlock() {
        locked = false;
    }

    @Override
    public void open() {
        opened = true;
    }

    @Override
    public void close() {
        opened = false;
    }

    @Override
    public void timeOutCallback() throws ExecutionControl.NotImplementedException {
        locked = true;
    }

    @Override
    public void proximityCallBack() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Method redundant in class -> " + this.getClass().getSimpleName());
    }
}

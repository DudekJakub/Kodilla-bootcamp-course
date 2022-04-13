package ISP.exerciseDoor.before_refactored;

import jdk.jshell.spi.ExecutionControl;

public class SensingDoor implements Door {

    private boolean locked;
    private boolean opened;

    public SensingDoor(Sensor sensor) throws ExecutionControl.NotImplementedException {
        sensor.register(this);
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
        throw new ExecutionControl.NotImplementedException("Method redundant in class -> " + this.getClass().getSimpleName());
    }

    @Override
    public void proximityCallBack() {
        opened = true;
    }
}

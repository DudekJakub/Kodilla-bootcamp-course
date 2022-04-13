package ISP.exerciseDoor.before_refactored;

import jdk.jshell.spi.ExecutionControl;

public interface Door {

    void lock();

    void unlock();

    void open();

    void close();

    void timeOutCallback() throws ExecutionControl.NotImplementedException;

    void proximityCallBack() throws ExecutionControl.NotImplementedException;
}

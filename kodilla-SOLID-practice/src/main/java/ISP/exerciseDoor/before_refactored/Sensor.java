package ISP.exerciseDoor.before_refactored;

import jdk.jshell.spi.ExecutionControl;

import java.util.Random;

public class Sensor {

    public void register(Door door) throws ExecutionControl.NotImplementedException {
        while (true) {
            if (isPersonClose()) {
                door.proximityCallBack();
                break;
            }
        }
    }

    private boolean isPersonClose() {
        return new Random().nextBoolean();
    }
}

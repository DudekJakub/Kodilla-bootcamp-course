package LSP.exerciseDuck.before_refactored;

public class ElectronicDuck extends Duck {

    private boolean on = false;

    @Override
    public void quack() {
        if (on) {
            System.out.println("Electronic duck quack...");
        } else {
            throw new RuntimeException("Can't quack when off");
        }
    }

    @Override
    public void swim() {
        if (on) {
            System.out.println("Electronic duck swim...");
        } else {
            throw new RuntimeException("Can't swim when off");
        }
    }

    public void turnOn() {
        on = true;
    }

    public void turnOff() {
        on = false;
    }
}

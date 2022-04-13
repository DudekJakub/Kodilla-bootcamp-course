package LSP.exerciseDuck.after_refactored;

public class ElectronicDuck implements IDuck {

    private boolean on = false;

    @Override
    public void quack() throws DuckIsOffException {
        if (on) {
            System.out.println("Electronic duck quack...");
        } else {
            throw new DuckIsOffException("Can't quack if turned OFF!");
        }
    }

    @Override
    public void swim() throws DuckIsOffException {
        if (on) {
            System.out.println("Electronic duck swim...");
        } else {
            throw new DuckIsOffException("Can't swim if turned OFF!");
        }
    }

    void turnOn() {
        on = true;
    }

    void turnOff() {
        on = false;
    }
}

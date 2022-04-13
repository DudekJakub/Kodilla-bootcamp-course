package LSP.exerciseDuck.before_refactored;

public class Pool {

    public void run() {
        Duck donaldDuck = new Duck();
        Duck aylesburyDuck = new AylesburyDuck();
        Duck electronicDuck = new ElectronicDuck();

        electronicDuck.swim();
        electronicDuck.quack();

//        donaldDuck.quack();
//        donaldDuck.swim();
//
//        aylesburyDuck.quack();
//        aylesburyDuck.swim();
//
//        quack(donaldDuck, aylesburyDuck);
//        swim(donaldDuck, aylesburyDuck);
    }

    private void quack(Duck...ducks) {
        for (Duck duck : ducks) {
            duck.quack();
        }
    }

    private void swim(Duck... ducks) {
        for (Duck duck : ducks) {
            duck.swim();
        }
    }

    public static void main(String[] args) {
        Pool pool = new Pool();
        pool.run();
    }
}

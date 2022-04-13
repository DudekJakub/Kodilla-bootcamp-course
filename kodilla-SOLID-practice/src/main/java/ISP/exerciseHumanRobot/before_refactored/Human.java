package ISP.exerciseHumanRobot.before_refactored;

public class Human implements Worker {

    @Override
    public void work() {
        System.out.println("Human works...");
    }

    @Override
    public void eat() {
        System.out.println("Human eats...");
    }
}

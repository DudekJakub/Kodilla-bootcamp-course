package ISP.exerciseHumanRobot.before_refactored;

public class Robot implements Worker {

    @Override
    public void work() {
        System.out.println("Robot works...");
    }

    @Override
    public void eat() {
        throw new RuntimeException("Robot can't eat!");
    }
}

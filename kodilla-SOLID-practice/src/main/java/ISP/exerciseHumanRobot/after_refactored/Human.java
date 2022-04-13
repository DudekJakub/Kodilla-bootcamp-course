package ISP.exerciseHumanRobot.after_refactored;

public class Human implements IWorker, IEater {

    @Override
    public void work() {
        System.out.println("Human worker works...");
    }

    @Override
    public void eat() {
        System.out.println("Human worker eats...");
    }
}

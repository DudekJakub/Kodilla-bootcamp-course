package ISP.exerciseHumanRobot.before_refactored;

import java.util.List;

public class MessHall {

    private List<Worker> workers;

    public MessHall(List<Worker> workers) {
        this.workers = workers;
    }

    public int manage() {
        int counter = 0;
        for (Worker worker : workers) {
            worker.eat();
            counter++;
        }
        System.out.println("Quantity of workers eating at MessHall = " + counter);
        return counter;
    }
}

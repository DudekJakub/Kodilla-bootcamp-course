package ISP.exerciseHumanRobot.after_refactored;

import java.util.ArrayList;
import java.util.List;

public class MessHall {

    private List<IEater> workers = new ArrayList<>();

    public MessHall(List<IEater> workers) {
        this.workers = workers;
    }

    public int manage() {
        int counter = 0;
        for (IEater worker : workers) {
            worker.eat();
            counter++;
        }
        System.out.println("Quantity of workers eating = " + counter);

        return counter;
    }
}

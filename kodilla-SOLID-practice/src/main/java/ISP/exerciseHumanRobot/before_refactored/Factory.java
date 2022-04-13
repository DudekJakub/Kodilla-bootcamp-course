package ISP.exerciseHumanRobot.before_refactored;

import java.util.List;

public class Factory {

    private List<Worker> workers;

    public Factory(List<Worker> workers) {
        this.workers = workers;
    }

    public int manage() {
        int counter = 0;
        for (Worker worker : workers) {
            worker.work();
            counter++;
        }
        System.out.println("Quantity of workers working at Factory = " + counter);
        return counter;
    }
}

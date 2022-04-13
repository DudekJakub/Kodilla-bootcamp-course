package ISP.exerciseHumanRobot.after_refactored;

import ISP.exerciseHumanRobot.before_refactored.Worker;

import java.util.List;

public class Factory {

    List<IWorker> workers;

    public Factory(List<IWorker> workers) {
        this.workers = workers;
    }

    public int manage() {
        int counter = 0;
        for (IWorker worker : workers) {
            worker.work();
            counter++;
        }
        System.out.println("Quantity of workers working = " + counter);

        return counter;
    }
}

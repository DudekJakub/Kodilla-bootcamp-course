package com.kodilla.patterns.factory.tasks;

public final class DrivingTask implements Task {

    private final String taskName;
    private final String where;
    private final String using;
    private boolean isTaskDone = false;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public void executeTask() {
        System.out.println("Task: " + getTaskName() + "... to " + where + " by " + using);
        isTaskDone = true;
    }

    @Override
    public boolean isTaskExecuted() {
        return isTaskDone;
    }

    public String getWhere() {
        return where;
    }

    public String getUsing() {
        return using;
    }
}

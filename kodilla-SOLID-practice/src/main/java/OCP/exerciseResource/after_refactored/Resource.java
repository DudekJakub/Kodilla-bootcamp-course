package OCP.exerciseResource.after_refactored;

public interface Resource {

    int findFreeSlot();

    void markSlotFree(int resourceId);

    void markSlotBusy(int resourceId);
}

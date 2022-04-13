package OCP.exerciseResource.after_refactored;

import java.io.PrintStream;

public class ResourceAllocator {

    public int allocate(Resource resource) {
        int resourceId = resource.findFreeSlot();
        resource.markSlotBusy(resourceId);

        System.out.println("Resource (of resourceType: " + resource.getClass().getSimpleName() + ") with given ID (" + resourceId + ") has been allocated.");

        return resourceId;
    }

    public void free(Resource resource, int resourceId) {
        resource.markSlotFree(resourceId);

        System.out.println("Resource (of resourceType: " + resource.getClass().getSimpleName() + ") with given ID (" + resourceId + ") has been freed.");
    }
}

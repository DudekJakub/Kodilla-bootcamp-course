package OCP.exerciseResource.after_refactored;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ResourceAllocatorTest {

    @Test
    public void allocate() {
        //Given
        ResourceAllocator allocator = new ResourceAllocator();

        Resource resource1 = new TimeResource();
        Resource resource2 = new SpaceResource();

        //When
        int allocatedResource_1_Result = allocator.allocate(resource1);
        int allocatedResource_2_Result = allocator.allocate(resource2);

        //Then
        assertEquals(0, allocatedResource_1_Result);
        assertEquals(0, allocatedResource_2_Result);
    }

    @Test
    void free() throws IOException {
        //Given
        int resourceId = 1;
        Resource resource = new TimeResource();
        ResourceAllocator allocator = new ResourceAllocator();

        ByteArrayOutputStream byteResult = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteResult));

        //When
        allocator.free(resource, resourceId);
        byteResult.flush();
        String writtenLines = byteResult.toString();

        //Then
        assertTrue(writtenLines.contains("Resource (of resourceType: TimeResource) with given ID (1) has been freed."));
    }
}
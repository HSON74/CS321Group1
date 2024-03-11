import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import org.openjfx.Group1workflow.*;

public class CountWFItemsTest {
    @Test
    void TestNewWFCout() {
        Workflow wfobj = new Workflow();
        int totalwf = wfobj.CountWFltems("null");
        assertEquals(totalwf, 0);
    }
}

package Business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openjfx.Workflow.*;

public class Group1TestCase1 {
    public static DataEntry case1;

    @BeforeAll
    public static void inti() {

        case1 = new DataEntry();
    }

    @AfterAll
    public static void dispose() {
        case1 = null;
    }

    // Data Entry
    @Test
    public void testCase1() {
        Form testForm = case1.systemInitiate.convertToForm();
        assertNotNull(testForm, "");
    }

    // Review & Approval
    @AfterEach
    public void testCase2() {
        Form testForm = case1.systemInitiate.convertToForm();
        assertNotNull(testForm, "");
    }
}

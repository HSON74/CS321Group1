package org.openjfx.Workflow;

public class DataEntry {
    public Initiate systemInitiate;
    public Form systemForm;

    public DataEntry() {
        systemInitiate = new Initiate();
    }

    // Cool UI/UX developer here--------------------------------
    /**
     * @param args
     */
    public static void main(String[] args) {
        DataEntry user = new DataEntry();
        // Initiate Form by creating a new Form.
        user.systemForm = user.systemInitiate.convertToForm();
        // Input User Information in the Form.

        // Resigter Form in system.
        user.systemInitiate.registerPerson(user.systemForm);

    }
}
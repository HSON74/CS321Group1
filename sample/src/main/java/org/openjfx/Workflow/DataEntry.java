package org.openjfx.Workflow;

public class DataEntry {
    public Workflow system;
    public Form systemForm;

    public DataEntry() {
        system = new Workflow();
    }

    // Cool UI/UX developer here--------------------------------
    public static void main(String[] args) {
        DataEntry user = new DataEntry();
        user.systemForm.inputInfo();

    }
}
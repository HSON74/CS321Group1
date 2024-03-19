package org.openjfx.Workflow;

public class Initiate {
    private String nextStep;
    protected Workflow system;

    public Initiate() {
        system = new Workflow();
    }

    public Form convertToForm() {
        return new Form();
    }

    public void registerPerson(Form form) {

    }

    /* Setter and Getter for Initiate Class */
    public void setNextStep(String nextStep) {
        this.nextStep = nextStep;
    }

    public String getNextString() {
        return nextStep;
    }
}

package org.openjfx.Business;

import org.openjfx.Workflow.Workflow;

public class Initiate {
    private String nextStep;
    protected Workflow system;

    public Initiate() {
        system = new Workflow();
    }

    public Form convertToForm() {
        Form tempForm = system.generateForm();
        return tempForm;
    }

    public boolean registerPerson(Form form) {
        // Workflow for review and approval
        return system.Sumbit(form);
    }

    /* Setter and Getter for Initiate Class */
    public void setNextStep(String nextStep) {
        this.nextStep = nextStep;
    }

    public String getNextString() {
        return nextStep;
    }

}

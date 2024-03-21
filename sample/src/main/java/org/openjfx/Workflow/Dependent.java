package org.openjfx.Workflow;

import org.openjfx.Business.Immigrant;

public class Dependent extends Immigrant {
    private boolean prevClaim;
    private int dependentPid;

    public Dependent() {

    }

    /*
     * Setter and Getter for Immigrant class that
     * extends to the Immirgrant class just extend
     * the Person class.
     */
    public void setPrevClaim(boolean prevClaim) {
        this.prevClaim = prevClaim;
    }

    public boolean setPrevClaim() {
        return prevClaim;
    }

    public void setPid(int pid) {
        this.dependentPid = pid;
    }

    public int setPid() {
        return dependentPid;
    }
}

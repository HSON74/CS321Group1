package org.openjfx.Business;

public class Dependent extends Immigrant {
    private boolean prevClaim;
    private int dependentPid;

    

    /*
     * Setter and Getter for Immigrant class that
     * extends to the Immirgrant class just extend
     * the Person class.
     */
    public void setPrevClaim(boolean prevClaim) {
        this.prevClaim = prevClaim;
    }

    @Override
    public void setemploymentStatus(boolean employmentStatus){
        this.employmentStatus = employmentStatus;
    }
    
    @Override
    public int getDependentPid() {
        return dependentPid;
    }

    
    public boolean getPrevClaim(){
        return prevClaim;
    }

    @Override
    public boolean getemploymentStatus(){
        return employmentStatus;
    }
    
}

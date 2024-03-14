package org.openjfx.Group1workflow;

public class Workflow {
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Hello World");
        // System.out.println(GetNextWFltem("Hello"));
    }

    private Integer wfid;
    private String step;
    private Integer objid;

    public Boolean AddWFltem(String step, Integer onjid) {
        return true;
    }

    public Integer GetNextWFltem(String step) {
        return Integer.parseInt(step);
    }

    public Integer CountWFltems(String step) {
        return 0;
    }

    public Integer getWfid() {
        return wfid;
    }

    public void setWfid(Integer wfid) {
        this.wfid = wfid;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public Integer getObjid() {
        return objid;
    }

    public void setObjid(Integer objid) {
        this.objid = objid;
    }
}
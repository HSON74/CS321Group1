
public class Workflow {
    private Integer wfid;
    private String step;
    private Integer objid;

    public Boolean AddWFltem(String step, Integer onjid) {
        return new Boolean();
    }

    public Integer GetNextWFltem(String step) {
        return 5;
    }

    public Integer CountWFltems(String step) {
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println(GetNextWFltem("Hello"));
    }
}
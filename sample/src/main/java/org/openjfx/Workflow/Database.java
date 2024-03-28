package org.openjfx.Workflow;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

import org.openjfx.Business.Dependent;
import org.openjfx.Business.Form;
import org.openjfx.Business.Immigrant;

public class Database {

    private Immigrant iForm; //
    private Dependent dForm; //
    private String dataNameForImmigrant; //
    private String dataNameForDependent; //
    protected ArrayList<Immigrant> DatabaseFormsImmigrant;
    protected ArrayList<Dependent> DatabaseFormsDependent;

    /*
     * Inital the table by create a table or access
     * the table if the table exist.
     */
    public Database(String databaseNameImmigrant, String databaseNameDependent) {
        if (databaseNameImmigrant == null) {
            databaseNameImmigrant = "Immigrant";
        }
        if (databaseNameDependent == null) {
            databaseNameImmigrant = "Dependent";
        }
        this.dataNameForImmigrant = "./sample/src/main/java/org/openjfx/Database/" + databaseNameImmigrant + ".txt";
        this.dataNameForDependent = "./sample/src/main/java/org/openjfx/Database/" + databaseNameDependent + ".txt";

        try {
            File datafile = new File(dataNameForImmigrant);
            Scanner scr;
            if (datafile.exists()) {
                scr = new Scanner(datafile);
                System.err.println("File Exist");
            } else {
                datafile.createNewFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter(datafile));
                // writer.write(
                // "Huy/null/Son/13/04/30/2001/012931/Student/Male/false/703-300-3003/Hello/World/1234/Huy/Son/Huy/null/Son/13/04/30/2001/012931/Student/Male/false/703-300-3003/Hello/World/1234/Huy
                // Son/1234/May/COMPLETE\n");
                scr = new Scanner(datafile);
                System.err.println("File Exist not exist");
                writer.close();
            }
            while (scr.hasNextLine()) {
                // Form tempForm = new Form();
                String mystring = scr.nextLine();
                /*
                 * Immigrant tempImmigrantForm = new Immigrant();
                 * // Dependent tempDependentForm = new Dependent();
                 * // int i = 0;
                 * // String StringArray[] = mystring.split("/", 0);
                 */

            }
            scr.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.toString());
        }

    }

    public static void main(String[] args) {
        Database testbase = new Database("HuyTest", null);

        // testbase.addData(new Form());

    }

    // Add the
    public boolean addData(Form form) {
        if (form == null) {
            return false;
        }
        if (form.getImmigrant() == null || form.getDependent() == null) {
            return false;
        }
        boolean addDatatoFile = saveData(form);
        return addDatatoFile;
    }

    // Check the data are in system.
    public boolean checkData(int iPID, int dPID) {

        return true;
    }

    public static Immigrant getDataImmigrant(int iPID) {

        return new Immigrant();
    }

    public static Dependent getDataDependent(int iPID) {

        return new Dependent();
    }

    private boolean saveData(Form inputForm) {
        if (inputForm.getDependent() == null || inputForm.getImmigrant() == null) {
            return false;
        }
        String dataString = null;
        dataString = inputForm.getImmigrant().getFirstName() + "/";
        dataString += inputForm.getImmigrant().getMiddleName() + "/";
        dataString += inputForm.getImmigrant().getLastName() + "/";
        dataString += inputForm.getImmigrant().getAge() + "/";
        try {
            Files.write(Paths.get(dataNameForImmigrant),
                    dataString.getBytes(),
                    StandardOpenOption.APPEND);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean removeImmigrant(int pid) {
        return true;
    }

    public boolean removeDependent(int pid) {
        return true;
    }

    public void updateImmigrant(Immigrant immigrant) {

    }

    public void updateDependent(Dependent dependent) {

    }
}
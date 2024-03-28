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
import org.openjfx.Business.FormStatus;
import org.openjfx.Business.Immigrant;

public class Database {

    private Immigrant iForm; //
    private Dependent dForm; //
    private String dataImmigrantName; //
    private String dataDependentName; //
    protected ArrayList<Immigrant> dabaseFormsForImmigrant;
    protected ArrayList<Dependent> databaseFormsForDependent;

    /*
     * Inital the table by create a table or access
     * the table if the table exist.
     */
    public Database(String databaseNameImmigrant, String databaseNameDependent) {
        if (databaseNameImmigrant == null) {
            this.dataImmigrantName = "./sample/src/main/java/org/openjfx/Database/" + "ImmigrantRecord" + ".txt";
        } else {
            this.dataImmigrantName = "./sample/src/main/java/org/openjfx/Database/" + this.dataImmigrantName + ".txt";
        }
        if (databaseNameImmigrant == null) {
            this.dataDependentName = "./sample/src/main/java/org/openjfx/Database/" + "DependentRecord" + ".txt";
        } else {
            this.dataDependentName = "./sample/src/main/java/org/openjfx/Database/" + this.dataDependentName + ".txt";
        }

        try {
            File datafile = new File(dataImmigrantName);
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
            dabaseFormsForImmigrant = new ArrayList<Immigrant>();
            while (scr.hasNextLine()) {
                Immigrant tmpImmigrant = new Immigrant();
                String mystring = scr.nextLine();
                Immigrant tempImmigrantForm = new Immigrant();
                Dependent tempDependentForm = new Dependent();
                int i = 0;
                String StringArray[] = mystring.split("/", 0);

            }
            scr.close();

            // Scannering second Database for Dependent
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
            databaseFormsForDependent = new ArrayList<Dependent>();

            while (scr.hasNextLine()) {
                Dependent tmpImmigrant = new Dependent();
                String mystring = scr.nextLine();
                Immigrant tempImmigrantForm = new Immigrant();
                Dependent tempDependentForm = new Dependent();
                int i = 0;
                String StringArray[] = mystring.split("/", 0);

            }
            scr.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.toString());
        }

    }

    public static void main(String[] args) {
        Database testbase = new Database("HuyTest", "HuyDependent");

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

    public Immigrant getDataImmigrant(int iPID) {
        Immigrant dataImmigrant = new Immigrant();

        return dataImmigrant;
    }

    public Dependent getDataDependent(int iPID) {
        Dependent dataDependent = new Dependent();

        return dataDependent;
    }

    private boolean saveData(Form inputForm) {
        if (inputForm.getDependent() == null || inputForm.getImmigrant() == null) {
            return false;
        }
        String dataStringImmigrant = new String("");
        dataStringImmigrant += inputForm.getImmigrant().getFirstName() + "/";
        dataStringImmigrant += inputForm.getImmigrant().getMiddleName() + "/";
        dataStringImmigrant += inputForm.getImmigrant().getLastName() + "/";
        dataStringImmigrant += inputForm.getImmigrant().getAge() + "/";

        String dataStringDependent = new String("");
        dataStringDependent += inputForm.getImmigrant().getFirstName() + "/";
        dataStringDependent += inputForm.getImmigrant().getMiddleName() + "/";
        dataStringDependent += inputForm.getImmigrant().getLastName() + "/";
        dataStringDependent += inputForm.getImmigrant().getAge() + "/";
        try {
            Files.write(Paths.get(dataImmigrantName),
                    dataStringImmigrant.getBytes(),
                    StandardOpenOption.APPEND);
            Files.write(Paths.get(dataDependentName),
                    dataStringDependent.getBytes(),
                    StandardOpenOption.APPEND);
        } catch (Exception e) {
            // TODO: handle exception
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

    public void setDataName(String name) {
        this.dataImmigrantName = name;
    }

    public String getDataName() {
        return dataImmigrantName;
    }

    public void clear() {

    }
}
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
    protected ArrayList<Immigrant> databaseRecordImmigrant;
    protected ArrayList<Dependent> databaseRecordDependent;

    /*
     * Inital the table by create a table or access
     * the table if the table exist.
     */
    public Database(String databaseNameImmigrant, String databaseNameDependent) {
        if (databaseNameImmigrant == null) {
            databaseNameImmigrant = "ImmigrantRecord";
        }
        if (databaseNameDependent == null) {
            databaseNameImmigrant = "DependentRecord";
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
                scr = new Scanner(datafile);
                System.err.println("File Exist not exist");
                writer.close();
            }
            databaseRecordImmigrant = new ArrayList<Immigrant>();
            while (scr.hasNextLine()) {
                String mystring = scr.nextLine();
                Immigrant tempImmigrantForm = new Immigrant();
                int i = 0;
                String stringArray[] = mystring.split("/", 0);
                tempImmigrantForm.setFirstName(stringArray[i++]);
                if (stringArray[i] == null) {
                    tempImmigrantForm.setMiddleName(stringArray[i++]);
                }
                tempImmigrantForm.setLastName(stringArray[i++]);
                tempImmigrantForm.setAge(Integer.parseInt(stringArray[i++]));
                tempImmigrantForm.setAddress(stringArray[i++]);
                tempImmigrantForm.setPhoneNumber(stringArray[i++]);
                tempImmigrantForm.setbirthMonth(Integer.parseInt(stringArray[i++]));
                tempImmigrantForm.setbirthDay(Integer.parseInt(stringArray[i++]));
                tempImmigrantForm.setbirthYear(Integer.parseInt(stringArray[i++]));
                tempImmigrantForm.setemploymentStatus(Boolean.parseBoolean(stringArray[i++]));
                tempImmigrantForm.setMarried(Boolean.parseBoolean(stringArray[i++]));
                tempImmigrantForm.setFather(stringArray[i++]);
                tempImmigrantForm.setMother(stringArray[i++]);
                tempImmigrantForm.setGender(stringArray[i++]);
                tempImmigrantForm.setRace(stringArray[i++]);
                tempImmigrantForm.setSSNumber(Integer.parseInt(stringArray[i++]));
                tempImmigrantForm.setImmigrantPid(Integer.parseInt(stringArray[i++]));
                tempImmigrantForm.setDependentPid(Integer.parseInt(stringArray[i++]));

            }
            scr.close();
            if (datafile.exists()) {
                scr = new Scanner(datafile);
                System.err.println("File Exist");
            } else {
                datafile.createNewFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter(datafile));
                scr = new Scanner(datafile);
                System.err.println("File Exist not exist");
                writer.close();
            }
            datafile = new File(databaseNameDependent);
            databaseRecordDependent = new ArrayList<Dependent>();
            while (scr.hasNextLine()) {
                String mystring = scr.nextLine();
                Dependent tempDependentForm = new Dependent();
                int i = 0;
                String stringArray[] = mystring.split("/", 0);
                tempDependentForm.setFirstName(stringArray[i++]);
                if (stringArray[i] == null) {
                    tempDependentForm.setMiddleName(stringArray[i++]);
                }
                tempDependentForm.setLastName(stringArray[i++]);
                tempDependentForm.setAge(Integer.parseInt(stringArray[i++]));
                tempDependentForm.setAddress(stringArray[i++]);
                tempDependentForm.setPhoneNumber(stringArray[i++]);
                tempDependentForm.setbirthMonth(Integer.parseInt(stringArray[i++]));
                tempDependentForm.setbirthDay(Integer.parseInt(stringArray[i++]));
                tempDependentForm.setbirthYear(Integer.parseInt(stringArray[i++]));
                tempDependentForm.setemploymentStatus(Boolean.parseBoolean(stringArray[i++]));
                tempDependentForm.setMarried(Boolean.parseBoolean(stringArray[i++]));
                tempDependentForm.setFather(stringArray[i++]);
                tempDependentForm.setMother(stringArray[i++]);
                tempDependentForm.setGender(stringArray[i++]);
                tempDependentForm.setRace(stringArray[i++]);
                tempDependentForm.setSSNumber(Integer.parseInt(stringArray[i++]));
                tempDependentForm.setPrevClaim(Boolean.parseBoolean(mystring));
                tempDependentForm.setImmigrantPid(Integer.parseInt(stringArray[i++]));
                tempDependentForm.setDependentPid(Integer.parseInt(stringArray[i++]));

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

    public Immigrant getDataImmigrant(int iPID) {
        for (int i = 0; i < databaseRecordImmigrant.size(); i++) {
            if (databaseRecordImmigrant.get(i).getImmigrantPid() == iPID) {
                return databaseRecordImmigrant.get(i);
            }
        }
        return null;
    }

    public Dependent getDataDependent(int iPID) {
        for (int i = 0; i < databaseRecordDependent.size(); i++) {
            if (databaseRecordDependent.get(i).getImmigrantPid() == iPID) {
                return databaseRecordDependent.get(i);
            }
        }
        return null;
    }

    private boolean saveData(Form inputForm) {
        if (inputForm.getDependent() == null || inputForm.getImmigrant() == null) {
            return false;
        }
        String dataStringImmigrant = null;
        dataStringImmigrant = inputForm.getImmigrant().getFirstName() + "/";
        dataStringImmigrant += inputForm.getImmigrant().getMiddleName() + "/";
        dataStringImmigrant += inputForm.getImmigrant().getLastName() + "/";
        dataStringImmigrant += inputForm.getImmigrant().getAge() + "/";
        dataStringImmigrant += inputForm.getImmigrant().getAddress() + "/";
        dataStringImmigrant += inputForm.getImmigrant().getPhoneNumber() + "/";
        dataStringImmigrant += inputForm.getImmigrant().getbirthMonth() + "/";
        dataStringImmigrant += inputForm.getImmigrant().getbirthDay() + "/";
        dataStringImmigrant += inputForm.getImmigrant().getbirthYear() + "/";
        dataStringImmigrant += inputForm.getImmigrant().getemploymentStatus() + "/";
        dataStringImmigrant += inputForm.getImmigrant().getMarriedStatus() + "/";
        dataStringImmigrant += inputForm.getImmigrant().getFatherName() + "/";
        dataStringImmigrant += inputForm.getImmigrant().getMotherName() + "/";
        dataStringImmigrant += inputForm.getImmigrant().getGender() + "/";
        dataStringImmigrant += inputForm.getImmigrant().getRace() + "/";
        dataStringImmigrant += inputForm.getImmigrant().getSSNumber() + "/";
        dataStringImmigrant += inputForm.getImmigrant().getImmigrantPid() + "/";
        dataStringImmigrant += inputForm.getImmigrant().getDependentPid();

        String dataStringDependent = null;
        dataStringDependent = inputForm.getDependent().getFirstName() + "/";
        dataStringDependent += inputForm.getDependent().getMiddleName() + "/";
        dataStringDependent += inputForm.getDependent().getLastName() + "/";
        dataStringDependent += inputForm.getDependent().getAge() + "/";
        dataStringDependent += inputForm.getDependent().getAddress() + "/";
        dataStringDependent += inputForm.getDependent().getPhoneNumber() + "/";
        dataStringDependent += inputForm.getDependent().getbirthMonth() + "/";
        dataStringDependent += inputForm.getDependent().getbirthDay() + "/";
        dataStringDependent += inputForm.getDependent().getbirthYear() + "/";
        dataStringDependent += inputForm.getDependent().getemploymentStatus() + "/";
        dataStringDependent += inputForm.getDependent().getMarriedStatus() + "/";
        dataStringDependent += inputForm.getDependent().getFatherName() + "/";
        dataStringDependent += inputForm.getDependent().getMotherName() + "/";
        dataStringDependent += inputForm.getDependent().getGender() + "/";
        dataStringDependent += inputForm.getDependent().getRace() + "/";
        dataStringDependent += inputForm.getDependent().getSSNumber() + "/";
        dataStringDependent += inputForm.getDependent().getPrevClaim() + "/";
        dataStringDependent += inputForm.getDependent().getImmigrantPid() + "/";
        dataStringDependent += inputForm.getDependent().getDependentPid();

        try {
            Files.write(Paths.get(dataNameForImmigrant),
                    dataStringImmigrant.getBytes(),
                    StandardOpenOption.APPEND);
            Files.write(Paths.get(dataNameForDependent),
                    dataStringDependent.getBytes(),
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
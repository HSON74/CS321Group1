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
    private String dataName; //
    protected ArrayList<Form> DatabaseForms;

    /*
     * Inital the table by create a table or access
     * the table if the table exist.
     */
    public Database(String databaseName) {
        this.dataName = "./sample/src/main/java/org/openjfx/Database/" + databaseName + ".txt";
        try {
            File datafile = new File(dataName);
            Scanner scr;
            if (datafile.exists()) {
                scr = new Scanner(datafile);
                System.err.println("File Exist");
            } else {
                datafile.createNewFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter(datafile));
                writer.write(
                        "Huy/null/Son/13/04/30/2001/012931/Student/Male/false/703-300-3003/Hello/World/1234/Huy/Son/Huy/null/Son/13/04/30/2001/012931/Student/Male/false/703-300-3003/Hello/World/1234/Huy Son/1234/May/COMPLETE\n");
                scr = new Scanner(datafile);
                System.err.println("File Exist not exist");
                writer.close();
            }
            DatabaseForms = new ArrayList<Form>();
            while (scr.hasNextLine()) {
                Form tempForm = new Form();
                String mystring = scr.nextLine();
                Immigrant tempImmigrantForm = new Immigrant();
                Dependent tempDependentForm = new Dependent();
                int i = 0;
                String StringArray[] = mystring.split("/", 0);
                for (String s : StringArray) {
                    System.out.println(s);
                }
                tempImmigrantForm.setFirstName(StringArray[i++]);
                tempImmigrantForm.setMiddleName(StringArray[i++]);
                tempImmigrantForm.setLastName(StringArray[i++]);
                tempImmigrantForm.setAge(Integer.parseInt(StringArray[i++]));
                tempImmigrantForm.setBirthDay(Integer.parseInt(StringArray[i++]));
                tempImmigrantForm.setBirthDay(Integer.parseInt(StringArray[i++]));
                tempImmigrantForm.setBirthYear(Integer.parseInt(StringArray[i++]));
                tempImmigrantForm.setSSNumber(Integer.parseInt(StringArray[i++]));
                tempImmigrantForm.setRace(StringArray[i++]);
                tempImmigrantForm.setGender(StringArray[i++]);
                tempImmigrantForm.setMarried(Boolean.parseBoolean(StringArray[i++]));
                tempImmigrantForm.setPhoneNumber(StringArray[i++]);
                tempImmigrantForm.setFather(StringArray[i++]);
                tempImmigrantForm.setMother(StringArray[i++]);
                tempImmigrantForm.setImmigrantPid(Integer.parseInt(StringArray[i++]));
                tempImmigrantForm.setFirstName(StringArray[i++]);
                tempImmigrantForm.setMiddleName(StringArray[i++]);
                tempImmigrantForm.setLastName(StringArray[i++]);
                tempImmigrantForm.setAge(Integer.parseInt(StringArray[i++]));
                tempImmigrantForm.setBirthDay(Integer.parseInt(StringArray[i++]));
                tempImmigrantForm.setBirthDay(Integer.parseInt(StringArray[i++]));
                tempImmigrantForm.setBirthYear(Integer.parseInt(StringArray[i++]));
                tempImmigrantForm.setSSNumber(Integer.parseInt(StringArray[i++]));
                tempImmigrantForm.setRace(StringArray[i++]);
                tempImmigrantForm.setGender(StringArray[i++]);
                tempImmigrantForm.setMarried(Boolean.parseBoolean(StringArray[i++]));
                tempImmigrantForm.setPhoneNumber(StringArray[i++]);
                tempImmigrantForm.setFather(StringArray[i++]);
                tempImmigrantForm.setMother(StringArray[i++]);
                tempImmigrantForm.setImmigrantPid(Integer.parseInt(StringArray[i++]));
                tempForm.setImmigrant(tempImmigrantForm);
                tempForm.setDependent(tempDependentForm);
                tempForm.setlastEdit(StringArray[i++]);

            }
            scr.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.toString());
        }

    }

    public static void main(String[] args) {
        Database testbase = new Database("HuyTest");

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
        String dataString = new String("");
        dataString += inputForm.getImmigrant().getFirstName() + "/";
        dataString += inputForm.getImmigrant().getMiddleName() + "/";
        dataString += inputForm.getImmigrant().getLastName() + "/";
        dataString += inputForm.getImmigrant().getAge() + "/";
        try {
            Files.write(Paths.get("./sample/src/main/java/org/openjfx/Database/" + dataName + ".txt"),
                    dataString.getBytes(),
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
        this.dataName = name;
    }

    public String getDataName() {
        return dataName;
    }

    public void clear() {
        DatabaseForms.clear();
    }
}
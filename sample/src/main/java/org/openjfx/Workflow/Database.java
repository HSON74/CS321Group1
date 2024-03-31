package org.openjfx.Workflow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
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
    private int ImmigrantPIDGenerate;
    private int DependentPIDGenerate;
    private String dataNameForImmigrant; //
    private String dataNameForDependent; //
    protected ArrayList<Immigrant> DatabaseFormsImmigrant;
    protected ArrayList<Dependent> DatabaseFormsDependent;

    /*
     * Inital the table by create a table or access
     * the table if the table exist.
     */
    public Database(Form form, String databaseNameImmigrant, String databaseNameDependent) {
        this.iForm = form.getImmigrant();
        this.dForm = form.getDependent();
        if (databaseNameImmigrant == null) {
            databaseNameImmigrant = "Immigrant";
        }
        if (databaseNameDependent == null) {
            databaseNameDependent = "Dependent";
        }
        this.dataNameForImmigrant = System.getProperty("user.dir") + "/src/main/java/org/openjfx/Database/"
                + databaseNameImmigrant
                + ".txt";
        this.dataNameForDependent = System.getProperty("user.dir") + "./src/main/java/org/openjfx/Database/"
                + databaseNameDependent + ".txt";
        System.out.println(dataNameForImmigrant);
        try {
            File datafile = new File(dataNameForImmigrant);
            Scanner scr;
            if (datafile.exists()) {
                scr = new Scanner(datafile);
                this.ImmigrantPIDGenerate = Integer.parseInt(scr.nextLine());
                System.out.println(datafile.getAbsolutePath());
                System.err.println("File Exist");
            } else {
                datafile.createNewFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter(datafile));
                // writer.write(
                // "Huy/null/Son/13/04/30/2001/012931/Student/Male/false/703-300-3003/Hello/World/1234/Huy/Son/Huy/null/Son/13/04/30/2001/012931/Student/Male/false/703-300-3003/Hello/World/1234/Huy
                // Son/1234/May/COMPLETE\n");
                writer.write("1");
                scr = new Scanner(datafile);
                System.err.println("File Exist not exist");
                writer.close();
            }
            this.DatabaseFormsImmigrant = new ArrayList<Immigrant>();
            while (scr.hasNextLine()) {
                String mystring = scr.nextLine();
                Immigrant tempImmigrantForm = setRecordtoImmigrant(mystring);
                this.DatabaseFormsImmigrant.add(tempImmigrantForm);
            }
            scr.close();
            Scanner dscr;
            File datafiled = new File(databaseNameDependent);
            if (datafiled.exists()) {
                dscr = new Scanner(datafiled);
                System.out.println(datafiled.getAbsolutePath());
                this.DependentPIDGenerate = Integer.parseInt(dscr.nextLine());
                System.err.println("File Exist");
            } else {
                datafiled.createNewFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter(datafiled));
                writer.write("1");
                dscr = new Scanner(datafiled);
                System.err.println("File Exist not exist");
                writer.close();
            }
            this.DatabaseFormsDependent = new ArrayList<Dependent>();
            while (dscr.hasNextLine()) {
                String mystring = dscr.nextLine();
                Dependent tempDependentForm = setRecordtoDependent(mystring);
                DatabaseFormsDependent.add(tempDependentForm);
            }
            dscr.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.toString());
        }

    }

    public static void main(String[] args) {
        Database testbase = new Database(new Form(), "FakeRecordImmigrant", "FakeRecordDependent");

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
        System.out.println("add to system");
        return addDatatoFile;
    }

    // Check the data are in system.
    public boolean checkData(int iPID, int dPID) {
        Immigrant myImmigrant = getDataImmigrant(iPID);
        Dependent myDependent = getDataDependent(dPID);
        if (myImmigrant == null) {
            System.err.println("Immigrant information is not in system");
            return false;
        }
        if (myDependent == null) {
            System.err.println("Dependent information is not in system");
            return false;
        }
        if (myDependent.getPrevClaim()) {
            if (myImmigrant.getDependentPid() == myDependent.getDependentPid()) {
                return true;
            } else {
                return false;
            }
        } else {
            myDependent.setPrevClaim(true);
            myImmigrant.setDependentPid(myDependent.getDependentPid());
            updateImmigrant(myImmigrant);
            updateDependent(myDependent);
        }
        return true;
    }

    public Immigrant getDataImmigrant(int iPID) {
        if (DatabaseFormsImmigrant == null) {
            return null;
        }
        for (int i = 0; i < DatabaseFormsImmigrant.size(); i++) {
            if (DatabaseFormsImmigrant.get(i).getImmigrantPid() == iPID) {
                return DatabaseFormsImmigrant.get(i);
            }
        }
        return null;
    }

    public Dependent getDataDependent(int iPID) {
        if (DatabaseFormsDependent == null) {
            return null;
        }
        for (int i = 0; i < DatabaseFormsDependent.size(); i++) {
            if (DatabaseFormsDependent.get(i).getImmigrantPid() == iPID) {
                return DatabaseFormsDependent.get(i);
            }
        }
        return null;
    }

    public Immigrant getDataImmigrantSSN(int sSNumber) {
        if (DatabaseFormsImmigrant == null) {
            return null;
        }
        for (int i = 0; i < DatabaseFormsImmigrant.size(); i++) {
            if (DatabaseFormsImmigrant.get(i).getSSNumber() == sSNumber) {
                return DatabaseFormsImmigrant.get(i);
            }
        }
        return null;
    }

    public Dependent getDataDependentSSN(int sSNumber) {
        if (DatabaseFormsDependent == null) {
            return null;
        }
        for (int i = 0; i < DatabaseFormsDependent.size(); i++) {
            if (DatabaseFormsDependent.get(i).getSSNumber() == sSNumber) {
                return DatabaseFormsDependent.get(i);
            }
        }
        return null;
    }

    public int giveImmigrantPid() {
        int oldNumber = ImmigrantPIDGenerate;
        ImmigrantPIDGenerate++;
        return oldNumber;
    }

    public int giveDependentPid() {
        int oldNumber = DependentPIDGenerate;
        DependentPIDGenerate++;
        return oldNumber;
    }

    private boolean saveData(Form inputForm) {
        if (inputForm.getDependent() == null || inputForm.getImmigrant() == null) {
            return false;
        }
        this.iForm = inputForm.getImmigrant();
        this.dForm = inputForm.getDependent();
        iForm.setImmigrantPid(ImmigrantPIDGenerate++);
        dForm.setDependentPid(DependentPIDGenerate++);
        String dataStringImmigrant = setImmigranttoRecord(iForm);
        String dataStringDependent = setDependenttoRecord(dForm);
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
        ArrayList<Immigrant> temp = new ArrayList<Immigrant>();
        Boolean result = false;
        for (int j = 0; j < DatabaseFormsImmigrant.size(); j++) {
            if (DatabaseFormsImmigrant.get(j).getImmigrantPid() == pid) {
                updateLine("", dataNameForImmigrant, j + 1, "Delete");
                result = true;
            } else {
                temp.add(DatabaseFormsImmigrant.get(j));
            }
        }
        DatabaseFormsImmigrant.clear();
        DatabaseFormsImmigrant = temp;
        return result;
    }

    public boolean removeDependent(int pid) {
        ArrayList<Dependent> temp = new ArrayList<Dependent>();
        Boolean result = false;
        for (int j = 0; j < DatabaseFormsDependent.size(); j++) {
            if (DatabaseFormsDependent.get(j).getDependentPid() == pid) {
                updateLine("", dataNameForDependent, j + 1, "Delete");
                result = true;
            } else {
                temp.add(DatabaseFormsDependent.get(j));
            }
        }
        DatabaseFormsDependent.clear();
        DatabaseFormsDependent = temp;
        return result;
    }

    public Boolean updateImmigrant(Immigrant immigrant) {
        if (immigrant == null || DatabaseFormsImmigrant == null) {
            return false;
        }
        ArrayList<Immigrant> temp = new ArrayList<Immigrant>();
        Boolean result = false;
        for (int j = 0; j < DatabaseFormsImmigrant.size(); j++) {
            if (DatabaseFormsImmigrant.get(j).getImmigrantPid() == immigrant.getImmigrantPid()
                    || immigrant.getSSNumber() == DatabaseFormsImmigrant.get(j).getSSNumber()) {
                String newLine = setImmigranttoRecord(immigrant);
                updateLine(newLine, dataNameForImmigrant, j + 1, "Update");
                temp.add(immigrant);
            } else {
                temp.add(DatabaseFormsImmigrant.get(j));
            }
        }
        DatabaseFormsImmigrant.clear();
        DatabaseFormsImmigrant = temp;
        return result;
    }

    public Boolean updateDependent(Dependent dependent) {
        if (dependent == null || DatabaseFormsDependent == null) {
            return false;
        }
        ArrayList<Dependent> temp = new ArrayList<Dependent>();
        Boolean result = false;
        for (int j = 0; j < DatabaseFormsDependent.size(); j++) {
            if (DatabaseFormsDependent.get(j).getDependent().getDependentPid() == dependent.getDependentPid()
                    || dependent.getSSNumber() == DatabaseFormsDependent.get(j).getSSNumber()) {
                String newLine = setImmigranttoRecord(dependent);
                updateLine(newLine, dataNameForDependent, j + 1, "Update");
                temp.add(dependent);
            } else {
                temp.add(DatabaseFormsDependent.get(j));
            }
        }
        DatabaseFormsDependent.clear();
        DatabaseFormsDependent = temp;
        return result;
    }

    public void updateLine(String lineChange, String DatabaseFile, int changeline, String command) {
        String tempFileString = "./sample/src/main/java/org/openjfx/Database/temp.txt";
        File oldFile = new File(DatabaseFile);
        File newFile = new File(tempFileString);
        int line = 0;
        String currentLine;
        try {
            FileWriter fw = new FileWriter(tempFileString, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(DatabaseFile);
            BufferedReader br = new BufferedReader(fr);

            while ((currentLine = br.readLine()) != null) {
                line++;
                if (changeline != line) {
                    pw.println(currentLine);
                } else {
                    if (command.equalsIgnoreCase("Delete")) {

                    } else if (command.equalsIgnoreCase("Update")) {
                        pw.println(lineChange);
                    } else {

                    }
                }
            }
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();

            oldFile.delete();
            File dump = new File(DatabaseFile);
            newFile.renameTo(dump);

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public String setImmigranttoRecord(Immigrant immigrant) {
        String myString = Helper.nullStringNullString(immigrant.getFirstName()) + "/";
        myString = Helper.nullStringNullString(immigrant.getMiddleName()) + "/";
        myString = Helper.nullStringNullString(immigrant.getLastName()) + "/";
        myString = String.valueOf(immigrant.getAge()) + "/";
        myString = String.valueOf(immigrant.getbirthMonth()) + "/";
        myString = String.valueOf(immigrant.getbirthDay()) + "/";
        myString = String.valueOf(immigrant.getbirthYear()) + "/";
        myString = Helper.nullStringNullString(immigrant.getAddress()) + "/";
        myString = String.valueOf(immigrant.getSSNumber()) + "/";
        myString = Helper.nullStringNullString(immigrant.getRace()) + "/";
        myString = Helper.nullStringNullString(immigrant.getGender()) + "/";
        myString = Helper.BooleantoYN(immigrant.getMarriedStatus()) + "/";
        myString = Helper.nullStringNullString(immigrant.getPhoneNumber()) + "/";
        myString = Helper.nullStringNullString(immigrant.getFatherName()) + "/";
        myString = Helper.nullStringNullString(immigrant.getMotherName()) + "/";
        myString = Helper.BooleantoYN(immigrant.getemploymentStatus()) + "/";
        myString = String.valueOf(immigrant.getImmigrantPid()) + "/";
        myString = String.valueOf(immigrant.getDependentPid());
        return myString;
    }

    public String setDependenttoRecord(Dependent dependent) {
        String myString = Helper.nullStringNullString(dependent.getFirstName()) + "/";
        myString = Helper.nullStringNullString(dependent.getMiddleName()) + "/";
        myString = Helper.nullStringNullString(dependent.getLastName()) + "/";
        myString = String.valueOf(dependent.getAge()) + "/";
        myString = String.valueOf(dependent.getbirthMonth()) + "/";
        myString = String.valueOf(dependent.getbirthDay()) + "/";
        myString = String.valueOf(dependent.getbirthYear()) + "/";
        myString = Helper.nullStringNullString(dependent.getAddress()) + "/";
        myString = String.valueOf(dependent.getSSNumber()) + "/";
        myString = Helper.nullStringNullString(dependent.getRace()) + "/";
        myString = Helper.nullStringNullString(dependent.getGender()) + "/";
        myString = Helper.BooleantoYN(dependent.getMarriedStatus()) + "/";
        myString = Helper.nullStringNullString(dependent.getPhoneNumber()) + "/";
        myString = Helper.nullStringNullString(dependent.getFatherName()) + "/";
        myString = Helper.nullStringNullString(dependent.getMotherName()) + "/";
        myString = Helper.BooleantoYN(dependent.getemploymentStatus()) + "/";
        myString = Helper.BooleantoYN(dependent.getPrevClaim()) + "/";
        myString = String.valueOf(dependent.getDependentPid());
        return myString;
    }

    public Immigrant setRecordtoImmigrant(String record) {
        Immigrant myImmigrant = new Immigrant();
        int i = 0;
        String StringArray[] = record.split("/", 0);
        myImmigrant.setFirstName(Helper.nullStringNull(StringArray[i++]));
        myImmigrant.setMiddleName(Helper.nullStringNull(StringArray[i++]));
        myImmigrant.setLastName(Helper.nullStringNull(StringArray[i++]));
        myImmigrant.setAge(Integer.parseInt(StringArray[i++]));
        myImmigrant.setBirthMonth(Integer.parseInt(StringArray[i++]));
        myImmigrant.setBirthDay(Integer.parseInt(StringArray[i++]));
        myImmigrant.setBirthYear(Integer.parseInt(StringArray[i++]));
        myImmigrant.setAddress(Helper.nullStringNull(StringArray[i++]));
        myImmigrant.setSSNumber(Integer.getInteger(StringArray[i++]));
        myImmigrant.setRace(Helper.nullStringNull(StringArray[i++]));
        myImmigrant.setGender(Helper.nullStringNull(StringArray[i++]));
        myImmigrant.setMarried(Helper.yntoBoolean(StringArray[i++]));
        myImmigrant.setPhoneNumber(Helper.nullStringNull(StringArray[i++]));
        myImmigrant.setFather(Helper.nullStringNull(StringArray[i++]));
        myImmigrant.setMother(Helper.nullStringNull(StringArray[i]));
        myImmigrant.setemploymentStatus(Helper.yntoBoolean(StringArray[i++]));
        myImmigrant.setImmigrantPid(Integer.parseInt(StringArray[i++]));
        myImmigrant.setDependentPid(Integer.parseInt(StringArray[i++]));
        return myImmigrant;
    }

    public Dependent setRecordtoDependent(String record) {
        Dependent myDependent = new Dependent();
        int i = 0;
        String StringArray[] = record.split("/", 0);
        myDependent.setFirstName(Helper.nullStringNull(StringArray[i++]));
        myDependent.setMiddleName(Helper.nullStringNull(StringArray[i++]));
        myDependent.setLastName(Helper.nullStringNull(StringArray[i++]));
        myDependent.setAge(Integer.parseInt(StringArray[i++]));
        myDependent.setBirthMonth(Integer.parseInt(StringArray[i++]));
        myDependent.setBirthDay(Integer.parseInt(StringArray[i++]));
        myDependent.setBirthYear(Integer.parseInt(StringArray[i++]));
        myDependent.setAddress(Helper.nullStringNull(StringArray[i++]));
        myDependent.setSSNumber(Integer.getInteger(StringArray[i++]));
        myDependent.setRace(Helper.nullStringNull(StringArray[i++]));
        myDependent.setGender(Helper.nullStringNull(StringArray[i++]));
        myDependent.setMarried(Helper.yntoBoolean(StringArray[i++]));
        myDependent.setPhoneNumber(Helper.nullStringNull(StringArray[i++]));
        myDependent.setFather(Helper.nullStringNull(StringArray[i++]));
        myDependent.setMother(Helper.nullStringNull(StringArray[i]));
        myDependent.setemploymentStatus(Helper.yntoBoolean(StringArray[i++]));
        myDependent.setPrevClaim(Helper.yntoBoolean(StringArray[i++]));
        myDependent.setDependentPid(Integer.parseInt(StringArray[i++]));
        return myDependent;
    }

}
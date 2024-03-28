package org.openjfx.Business;

public class Immigrant extends Person {
    private int ImmigrantPid;

    public Dependent getDependent() {
        return new Dependent();
    }

    public void newDependent() {

    }

    public boolean addDependent(Dependent dependent) {
        return true;
    }

    public boolean removeDependent(Dependent dependent) {
        return true;
    }

    public void employmentStatus() {

    }

    /*
     * Setter and Getter Methods for the Immigrant class
     * that extends from the person class.
     */
    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    public void setMiddleName(String mName) {
        this.middleName = mName;
    }

    public void setLastName(String lName) {
        this.lastName = lName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setSSNumber(int ssnumber) {
        this.ssnumber = ssnumber;
    }

    public void setImmigrantPid(int pid) {
        this.ImmigrantPid = pid;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFather(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setMother(String motherName) {
        this.motherName = motherName;
    }

    public String getFirstName() {
        return fatherName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int getImmigrantPid() {
        return ImmigrantPid;
    }
}

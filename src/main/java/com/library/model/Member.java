package main.java.com.library.model;

public class Member {
    private int id;
    private String fullName;
    private String adress;

    public Member( String fullName, String adress) {
        this.fullName = fullName;
        this.adress = adress;
    }
    public int getId() {
        return id;
    }
    public String getFullName() {
        return fullName;
    }
    public String getAdress() {
        return adress;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
}

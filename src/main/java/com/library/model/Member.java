package main.java.com.library.model;

public class Member {
    private int id;
    private String fullName;
    private String address;

    public Member( int id, String fullName, String address) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
    }
    public int getId() {
        return id;
    }
    public String getFullName() {
        return fullName;
    }
    public String getAddress() {
        return address;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}

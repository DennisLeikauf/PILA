package model;

public class Address {

    private int id;

    private String residence;

    public Address(int id, String residence) {
        this.id = id;
        this.residence = residence;
    }

    public int getId() {
        return id;
    }

    public String getResidence() {
        return residence;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }
}

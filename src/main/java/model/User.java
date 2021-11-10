package model;

public class User {
    private String email;

    private String name;
    private String address;

    public User(String e, String n, String a) {
        this.email = e;
        this.name = n;
        this.address=a;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return this.name;
    }
    public String getAddress() {
        return this.address;
    }

    public void setName(String n) {
        this.name = n;
    }
    public void setAddress(String a) {
        this.address = a;
    }

}

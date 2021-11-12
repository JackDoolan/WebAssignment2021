package model;

public class User {
    private String email;

    private String name;
    private String password;

    public User(String e, String n, String a) {
        this.email = e;
        this.name = n;
        this.password=a;
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
    public String getpassword() {
        return this.password;
    }

    public void setName(String n) {
        this.name = n;
    }
    public void setpassword(String a) {
        this.password = a;
    }

}

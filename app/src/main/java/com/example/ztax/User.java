package com.example.ztax;

public class User {
    String ussername;
    String email;
    String password;

    public User(String ussername, String email, String password) {
        this.ussername = ussername;
        this.email = email;
        this.password = password;
    }

    public String getUssername() {
        return ussername;
    }

    public void setUssername(String ussername) {
        this.ussername = ussername;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

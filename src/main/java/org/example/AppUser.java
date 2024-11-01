package org.example;

import java.util.Objects;


public class AppUser {

    private String username;
    //@EqualsAndHashCode.Exclude
    private String password;
    private AppRole role;

    public AppUser(String username, String password, AppRole role) {
        if(username.trim().isEmpty() || password.trim().isEmpty()) throw new RuntimeException("Username and paswword cant be empty.");
        this.username = Objects.requireNonNull(username, "No null username!");
        this.password = Objects.requireNonNull(password, "No null password!");
        this.role = Objects.requireNonNull(role, "No null role!");
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public AppRole getRole() {
        return role;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRole(AppRole role) {
        this.role = role;
    }

    @Override
    public String toString(){
        return "Username: " + getUsername() + ", role: " + getRole();
    }
    /*
    @Override
    public int hashCode(){
        return (getUsername().hashCode() * getRole().hashCode());
    }
     */

    @Override
    public int hashCode() {
        return Objects.hash(username, role);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(username, appUser.username) && role == appUser.role;
    }
}

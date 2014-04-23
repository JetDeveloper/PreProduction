/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.epam.springproject.model;

import java.util.List;

/**
 * Class describes user profile
 * @author Dima
 */
public class User {
    private String login;
    private int id;
    private String password;
    private Role role;
    private String fullName;
    private String contactNumber;
    private List<Auto> auto;

    public User() {
    }
    
    
    public User(String login, int id, String password, Role role, 
            String fullName, String contactNumber, List<Auto> auto) {
        this.login = login;
        this.id = id;
        this.password = password;
        this.role = role;
        this.fullName = fullName;
        this.contactNumber = contactNumber;
        this.auto = auto;
    }

    public User(String login, int id, String password, Role role, 
            String fullName, String contactNumber) {
        this.login = login;
        this.id = id;
        this.password = password;
        this.role = role;
        this.fullName = fullName;
        this.contactNumber = contactNumber;
        this.auto = null;
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public List<Auto> getAuto() {
        return auto;
    }

    public void setAuto(List<Auto> auto) {
        this.auto = auto;
    }

    @Override
    public String toString() {
        return "User{" + "login=" + login + ", id=" + id + ", password=" 
                + password + ", role=" + role + ", fullName=" + fullName 
                + ", contactNumber=" + contactNumber + ", auto=" + auto + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.login != null ? this.login.hashCode() : 0);
        hash = 37 * hash + this.id;
        hash = 37 * hash + (this.password != null ? this.password.hashCode() : 0);
        hash = 37 * hash + (this.role != null ? this.role.hashCode() : 0);
        hash = 37 * hash + (this.fullName != null ? this.fullName.hashCode() : 0);
        hash = 37 * hash + (this.contactNumber != null ? this.contactNumber.hashCode() : 0);
        hash = 37 * hash + (this.auto != null ? this.auto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if ((this.login == null) ? (other.login != null) : !this.login.equals(other.login)) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        if ((this.password == null) ? (other.password != null) : !this.password.equals(other.password)) {
            return false;
        }
        if (this.role != other.role && (this.role == null || !this.role.equals(other.role))) {
            return false;
        }
        if ((this.fullName == null) ? (other.fullName != null) : !this.fullName.equals(other.fullName)) {
            return false;
        }
        if ((this.contactNumber == null) ? (other.contactNumber != null) : !this.contactNumber.equals(other.contactNumber)) {
            return false;
        }
        if (this.auto != other.auto && (this.auto == null || !this.auto.equals(other.auto))) {
            return false;
        }
        return true;
    }
    
}

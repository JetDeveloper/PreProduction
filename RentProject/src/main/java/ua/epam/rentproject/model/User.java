package ua.epam.rentproject.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Dmytro_Svynarenko
 * @version 1.0
 * @created 05-май-2014 15:25:44
 */
@Entity
@Table(name = "Users")
@NamedQueries({
    @NamedQuery(name = "User.getAllUsers", query = "SELECT u from User u"),
    @NamedQuery(name = "User.getUserById", query = "SELECT u from User u WHERE u.userId = :id")
})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private int userId;
    @Column(name = "fullName")
    private String fullName;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "regDate")
    @Temporal(value = TemporalType.DATE)
    private Calendar regDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role")
    private Role role;
    @OneToMany(mappedBy = "user")
    private Set<Deal> userDeals = new HashSet<>();
    @OneToMany(mappedBy = "manager")
    private Set<Deal> managerDeals = new HashSet<>();

    /**
     *
     * @param login
     * @param password
     * @param regDate
     * @param role
     */
    public User(String login, String password, Calendar regDate, Role role) {
        this.login = login;
        this.password = password;
        this.regDate = regDate;
        this.role = role;
    }

    public User() {
    }

    public String getFullName() {
        return fullName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Calendar getRegDate() {
        return regDate;
    }

    public Role getRole() {
        return role;
    }

    public int getUserId() {
        return userId;
    }

    public void setFullName(String newVal) {
        fullName = newVal;
    }

    public void setLogin(String newVal) {
        login = newVal;
    }

    public void setPassword(String newVal) {
        password = newVal;
    }

    public void setRegDate(Calendar newVal) {
        regDate = newVal;
    }

    public void setRole(Role newVal) {
        role = newVal;
    }

    public void setUserId(int newVal) {
        userId = newVal;
    }

    public Set<Deal> getUserDeals() {
        return userDeals;
    }

    public void setUserDeals(Set<Deal> userDeals) {
        this.userDeals = userDeals;
    }

    public Set<Deal> getManagerDeals() {
        return managerDeals;
    }

    public void setManagerDeals(Set<Deal> managerDeals) {
        this.managerDeals = managerDeals;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", fullName=" + fullName + ", login=" + login + ", password=" + password + ", regDate=" + regDate + ", role=" + role + '}';
    }

    
}
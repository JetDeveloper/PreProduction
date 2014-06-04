package ua.epam.rentproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Dmytro_Svynarenko
 * @version 1.0
 * @created 05-май-2014 15:25:52
 */
@Entity
@Table(name="Role")
@NamedQueries({
    @NamedQuery(name = "Role.getAllRoles", query = "SELECT r from Role r"),
    @NamedQuery(name = "Role.getRoleById", query = "SELECT r from Role r WHERE r.roleId = :id")
})
public class Role {

    @Id
    @Column(name="roleId")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int roleId;
    @Column(name="roleName")
    private String roleName;


    public Role(String name) {
        this.roleName = name;
    }

    public Role() {
    }

    public int getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }


    public void setRoleId(int newVal) {
        roleId = newVal;
    }

    public void setRoleName(String newVal) {
        roleName = newVal;
    }
 
    @Override
    public String toString() {
        return "Role{" + "roleId=" + roleId + ", roleName=" + roleName + '}';
    }
    
}
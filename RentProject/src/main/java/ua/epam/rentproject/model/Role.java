package ua.epam.rentproject.model;

/**
 * @author Dmytro_Svynarenko
 * @version 1.0
 * @created 05-май-2014 15:25:52
 */
public class Role {

    private int roleId;
    private String roleName;

    /**
     *
     * @param name
     */
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

    /**
     *
     * @param newVal
     */
    public void setRoleId(int newVal) {
        roleId = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void setRoleName(String newVal) {
        roleName = newVal;
    }
}
package ua.epam.rentproject.model;

import java.util.Calendar;

/**
 * @author Dmytro_Svynarenko
 * @version 1.0
 * @created 05-май-2014 15:25:44
 */
public class User {

	private String fullName;
	private String login;
	private String password;
	private Calendar regDate;
	private Role role;
	private int userId;

	/**
	 * 
	 * @param login
	 * @param password
	 * @param regDate
	 * @param role
	 */
	public User(String login, String password, Calendar regDate, Role role){
            this.login = login;
            this.password = password;
            this.regDate = regDate;
            this.role = role;
	}

	public User(){

	}

	public String getFullName(){
		return fullName;
	}

	public String getLogin(){
		return login;
	}

	public String getPassword(){
		return password;
	}

	public Calendar getRegDate(){
		return regDate;
	}

	public Role getRole(){
		return role;
	}

	public int getUserId(){
		return userId;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFullName(String newVal){
		fullName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLogin(String newVal){
		login = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPassword(String newVal){
		password = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRegDate(Calendar newVal){
		regDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRole(Role newVal){
		role = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUserId(int newVal){
		userId = newVal;
	}

}
package ua.epam.rentproject.controller;

/**
 * @author Dmytro_Svynarenko
 * @version 1.0
 * @created 05-май-2014 15:35:41
 */
public class NonAuthorizedClient extends ClientController {

	public NonAuthorizedClient(){

	}

	public void formOrder(){

	}

	public boolean signUp(){
		return false;
	}

	public boolean singIn(){
		return false;
	}

}
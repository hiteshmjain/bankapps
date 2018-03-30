package com.creditunion.app.security;

public class SecuirtyService {

	public static boolean validateToken(String token){
		boolean authenicate = false;
		if(token.equals("Bearer 123XXX456"))
			 authenicate = true;
		
		return authenicate;
	}
}

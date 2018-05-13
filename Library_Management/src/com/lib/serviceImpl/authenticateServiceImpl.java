package com.lib.serviceImpl;

import javax.ws.rs.core.Response;

import com.lib.serviceInterface.AuthenticateInterface;

public class authenticateServiceImpl implements AuthenticateInterface {

	@Override
	public Response authenticateUser(String userId, String password) {
		if(userId=="123" && password=="sun") {
			System.out.println("---Inside authenticate User---");
			return Response.ok().build();
		}
		else {
			return Response.serverError().build();
		}
	}

}

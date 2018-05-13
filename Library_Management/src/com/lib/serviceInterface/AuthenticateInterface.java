package com.lib.serviceInterface;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Produces({"application/xml","application/json"})
@Path("/")
public interface AuthenticateInterface {

	@GET
	@Path("user")
	public Response authenticateUser(@QueryParam("name") String userId, @QueryParam("password") String password);
}

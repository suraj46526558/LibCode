package com.lib.serviceInterface;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.lib.pojo.UserDetails;

@Produces({"application/xml","application/json"})
@Path("userService")
public interface AdminUserInterface {

	@POST
	@Path("/users")
	public Response addUser(UserDetails user);
	
	@PUT
	@Path("/users")
	public Response updateUser(UserDetails user);
	
	@DELETE
	@Path("/users/{id}")
	public Response deleteUser(@PathParam("id")int id);
	
	@GET
	@Path("/users/{id}")
	public UserDetails FindUser(@PathParam("id")int id);
	
}

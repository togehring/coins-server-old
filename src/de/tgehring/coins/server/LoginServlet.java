package de.tgehring.coins.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import de.tgehring.coins.server.service.LoginService;

@Path("/login")
public class LoginServlet {

	@GET
	@Produces("application/json")
	@Path("/{name}/{password}")
	public Response login(@PathParam("name") String name, @PathParam("password") String password) {
		boolean validUser = LoginService.getInstance().login(name, password);
		int status = 500;
		if (validUser) {
			status = 200;
		}

		return Response.status(status).entity(name).build();
	}
}

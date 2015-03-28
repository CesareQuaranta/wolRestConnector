package wol.server.connector.jaxrs.resource;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/*@WebServlet(loadOnStartup=1)
@ApplicationPath("rs")

@Component*/
@Path("user")
public class Login {

	public Login() {
		// TODO Auto-generated constructor stub
	}
	
	@POST
	@Path("/login")
	@Produces(MediaType.TEXT_PLAIN)
	public String loginUtente(
			@FormParam("email") String email,
			@FormParam("password") String password) {
		if (email == null || password == null ) {
			//logger.warn("Missing Required Fields");
			return "KO";
		}
		/*
		if (tipo == 1) {
			if (userManager.checksForUnreadDocuments(email)) {
				return false;
			}
		}
		*/
		return"OK";
	}

}

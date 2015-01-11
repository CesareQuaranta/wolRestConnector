package wol.server.connector.jaxrs;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import wol.WolContainer;
import wol.dom.Window;
import wol.dom.iEvent;
import wol.dom.space.Position;

@WebServlet(loadOnStartup=1)
@ApplicationPath("rs")
@Path("view")
@Component
public class View {
	@Autowired 
	private WolContainer<?,?> wolContainer;
	
	public View() {
		// TODO Auto-generated constructor stub
	}
	
	@GET
	@Path("/window")
	@Produces(MediaType.APPLICATION_JSON)
	public Window openWindow(@QueryParam("x") Long x,@QueryParam("y") Long y,@QueryParam("z") Long z) {
		Position centerWindow=new Position(x,y,z);
		
		Window window=wolContainer.openWindow(centerWindow);
		return window;
	}
	
	@GET
	@Path("/window/events")
	@Produces(MediaType.APPLICATION_JSON)
	public List<iEvent> getEvents(@QueryParam("id") String id){
		List<iEvent> events=wolContainer.getEvents(id);
		return events;
	}
			

}

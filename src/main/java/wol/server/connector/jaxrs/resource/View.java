package wol.server.connector.jaxrs.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import wol.dom.Window;
import wol.dom.iEvent;
import wol.dom.space.Position;

//@ApplicationPath("rs")
@Path("view")
@Component
public class View {
	//@Autowired 
	//private WolContainer<?,?> wolContainer=null;
	
	public View() {
		// TODO Auto-generated constructor stub
	}
	
	@GET
	@Path("/window")
	@Produces(MediaType.APPLICATION_JSON)
	public Window openWindow(@QueryParam("x") Long x,@QueryParam("y") Long y,@QueryParam("z") Long z) {
		Position centerWindow=new Position(x,y,z);
		
		Window window=null;//wolContainer.openWindow(centerWindow);
		return window;
	}
	
	@GET
	@Path("/window/events")
	@Produces(MediaType.APPLICATION_JSON)
	public List<iEvent> getEvents(@QueryParam("id") String id){
		List<iEvent> events=null;//wolContainer.getEvents(id);
		return events;
	}
			

}

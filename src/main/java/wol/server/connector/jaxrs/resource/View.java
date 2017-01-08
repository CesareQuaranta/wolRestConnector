package wol.server.connector.jaxrs.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import wol.dom.Window;
import wol.dom.WolContainer;
import wol.dom.iEvent;
import wol.dom.space.Position;
import wol.server.connector.jaxrs.BcSerializer;

@Path("view")
public class View {
	@Autowired 
	private WolContainer wolContainer;
	
	public View() {
		// TODO Auto-generated constructor stub
	}
	
	@GET
	  @Produces(MediaType.TEXT_PLAIN)
	  public Response get() {
	    return Response.ok("hello").build();
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
	//@JsonSerialize(using=BcSerializer.class) 
	@Produces(MediaType.APPLICATION_JSON)
	public List<iEvent> getEvents(@QueryParam("id") String id){
		List<iEvent> events=wolContainer.getEvents(id);
		if(events!=null && events.size()>0){
			return events;
		}else{
			return null;
		}
		
	}
			

}

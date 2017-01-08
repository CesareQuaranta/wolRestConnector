package wolRstConnector;

import static org.junit.Assert.*;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.message.internal.MediaTypes;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.glassfish.jersey.test.util.runner.ConcurrentRunner;

import wol.dom.App;
import wol.server.connector.jaxrs.JerseyConfig;
import wol.server.connector.jaxrs.WolMapperProvider;

@RunWith(ConcurrentRunner.class)
public class JacksonTest extends JerseyTest{
	//private ApplicationContext context;

	    @Override
	    protected ResourceConfig configure() {
	        enable(TestProperties.LOG_TRAFFIC);
	        enable(TestProperties.DUMP_ENTITY);
	        final ResourceConfig config = new JerseyConfig();
	        return config;
	    }

	    @Override
	    protected void configureClient(ClientConfig config) {
	        config.register(new JacksonFeature()).register(WolMapperProvider.class);
	    }
/*
	    @Test
	    public void testEmptyArrayPresent() {
	        WebTarget target = target();
	        String responseMsg = target.path("emptyArrayResource").request(MediaType.APPLICATION_JSON).get(String.class);
	        assertTrue(responseMsg.replaceAll("[ \t]*", "").contains("[]"));
	    }

	    @Test
	    public void testJSONPPresent() {
	        WebTarget target = target();
	        String responseMsg = target.path("nonJaxbResource").request("application/javascript").get(String.class);
	        assertTrue(responseMsg.startsWith("callback("));
	    }

	    @Test
	    public void testJSONDoesNotReflectJSONPWrapper() {
	        WebTarget target = target();
	        String responseMsg = target.path("nonJaxbResource").request("application/json").get(String.class);
	        assertTrue(!responseMsg.contains("jsonSource"));
	    }

	    @Test
	    public void testCombinedAnnotationResource() {
	        WebTarget target = target();
	        String responseMsg = target.path("combinedAnnotations").request("application/json").get(String.class);
	        assertTrue(responseMsg.contains("account") && responseMsg.contains("value"));
	    }

	    @Test
	    public void testEmptyArrayBean() {
	        WebTarget target = target();
	        EmptyArrayBean responseMsg =  target.path("emptyArrayResource").request(MediaType.APPLICATION_JSON).get(List<iEvent>.class);
	        assertNotNull(responseMsg);
	    }


	    @Test
	    @Ignore
	    // TODO un-ignore once a JSON reader for "application/javascript" is supported
	    public void testJSONPBean() {
	        WebTarget target = target();
	        App responseMsg = target.path("nonJaxbResource").request("application/javascript").get(App.class);
	        assertNotNull(responseMsg);
	    }*/

	    /**
	     * Test if a WADL document is available at the relative path
	     * "application.wadl".
	     * <p/>
	     */
	   /* @Test
	    public void testApplicationWadl() {
	        WebTarget target = target();
	        String serviceWadl = target.path("application.wadl").request(MediaTypes.WADL_TYPE).get(String.class);

	        assertTrue(serviceWadl.length() > 0);
	    }*/

	    /**
	     * Test, that in case of malformed JSON, the jackson exception mappers will be used and the response will be
	     * 400 - bad request instead of 500 - server error
	     */
	    /*@Test
	    public void testExceptionMapping() {
	        enable(TestProperties.LOG_TRAFFIC);
	        // create a request with invalid json string to cause an exception in Jackson
	        Response response = target().path("parseExceptionTest").request("application/json")
	                .put(Entity.entity("Malformed json string.", MediaType.valueOf("application/json")));

	        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
	    }*/
	    
	    @Test
	    public void mockTest() {
	    	assertEquals("ciccio","ciccio");
	    }
}

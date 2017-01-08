package wol.server.connector.jaxrs;

import javax.ws.rs.ext.ContextResolver;

import wol.dom.server.BackgroundChange;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
public class WolMapperProvider implements ContextResolver<ObjectMapper>{
	final ObjectMapper wolObjectMapper;
	
	 public WolMapperProvider() {
		 wolObjectMapper = createWolMapper();
	    }
	 
	private ObjectMapper createWolMapper() {
		final ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        SimpleModule testModule = new SimpleModule("MyModule", new Version(1, 0, 0, null,null,null));
        testModule.addSerializer(BackgroundChange.class,new BcSerializer(BackgroundChange.class)); // assuming serializer declares correct class to bind to
        mapper.registerModule(testModule);
 
        return mapper;
	}
	
	@Override
	public ObjectMapper getContext(Class<?> type) {
		return wolObjectMapper;
	}

}

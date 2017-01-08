package wol.server.connector.jaxrs;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import wol.dom.server.BackgroundChange;

public class BcSerializer extends StdSerializer<BackgroundChange>{
	private static final long serialVersionUID = 5347228809980987349L;

	protected BcSerializer(Class<BackgroundChange> t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void serialize(BackgroundChange event, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			jgen.writeStartObject();
			jgen.writeStringField("bc",event.getUrl().toExternalForm());
			jgen.writeEndObject();
	}

}

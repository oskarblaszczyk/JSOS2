package pl.kurs.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import pl.kurs.model.Auto;

import java.io.IOException;

public class AutoSerializer extends StdSerializer<Auto> {

    public AutoSerializer(Class<Auto> t) {
        super(t);
    }

    @Override
    public void serialize(Auto auto, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("brand", auto.getProducer());
        jsonGenerator.writeNumberField("doorsNumber", auto.getDoors());
        jsonGenerator.writeEndObject();
    }
}

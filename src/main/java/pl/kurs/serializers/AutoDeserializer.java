package pl.kurs.serializers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import pl.kurs.model.Auto;

import java.io.IOException;

public class AutoDeserializer extends StdDeserializer<Auto> {
    public AutoDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Auto deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String producer = node.get("brand").asText();
        int doors = node.get("doorsNumber").intValue();
        return new Auto(producer, doors);
    }
}

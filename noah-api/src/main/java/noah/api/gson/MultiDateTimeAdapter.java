package noah.api.gson;

import static org.apache.commons.lang.StringUtils.isNotBlank;

import java.lang.reflect.Type;
import java.util.Date;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeParser;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;

/**
 * @author dennis_yen
 */
public class MultiDateTimeAdapter extends ISODateTimeAdapter {

    private DateTimeFormatter deserializeFormatter;

    public MultiDateTimeAdapter() {

        DateTimeParser[] dateTimeParsers = { 
                DateTimeFormat.forPattern("yyyy/MM/dd").getParser(),
                DateTimeFormat.forPattern("yyyy-MM-dd").getParser(),
                DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZZ").getParser() };

        deserializeFormatter = new DateTimeFormatterBuilder().append(null, dateTimeParsers).toFormatter();
    }

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {

        String jsonString = json.getAsString();

        if (isNotBlank(jsonString)) {
            return deserializeFormatter.parseDateTime(jsonString).toDate();
        }

        return null;
    }

}

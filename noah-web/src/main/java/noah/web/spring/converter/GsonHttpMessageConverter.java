package noah.web.spring.converter;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.util.ClassUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import noah.api.gson.MultiDateTimeAdapter;

public class GsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> {

    public static final String CHARSET = "UTF-8";

    private Gson gson;

    public GsonHttpMessageConverter() {
        super(new MediaType("application", "json", Charset.forName(CHARSET)));
        GsonBuilder builder = new GsonBuilder();
        builder = builder.registerTypeAdapter(java.sql.Date.class, new MultiDateTimeAdapter());
        builder = builder.registerTypeAdapter(java.util.Date.class, new MultiDateTimeAdapter());
        gson = builder.create();
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return ClassUtils.isAssignable(clazz, Serializable.class);
    }

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return MediaType.APPLICATION_JSON.isCompatibleWith(mediaType);
    }

    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return MediaType.APPLICATION_JSON.isCompatibleWith(mediaType);
    }

    @Override
    protected Object readInternal(Class<? extends Object> clazz, HttpInputMessage inputMessage) throws IOException {
        InputStreamReader messageBody = new InputStreamReader(inputMessage.getBody());
        return gson.fromJson(messageBody, clazz);
    }

    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException {
        OutputStream messageBody = outputMessage.getBody();
        messageBody.write(gson.toJson(object).getBytes(CHARSET));
    }

}

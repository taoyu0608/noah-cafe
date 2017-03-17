package noah.api.gson;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;

/**
 * @author dennis_yen
 */
public abstract class AbstractTypeAdapter<T> 
        implements RegisterTypeAdapter, JsonSerializer<T>, JsonDeserializer<T> {

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

}

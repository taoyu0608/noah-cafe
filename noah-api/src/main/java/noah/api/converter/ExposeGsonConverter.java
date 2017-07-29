package noah.api.converter;

import static com.google.common.collect.Collections2.transform;
import static java.util.Collections.emptyList;
import static org.apache.commons.collections.CollectionUtils.isEmpty;

import java.util.Collection;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import noah.api.gson.ISODateTimeAdapter;

abstract public class ExposeGsonConverter {

	public static <T> T convert(Object model, Class<T> clazz) {

		if (model == null) {
			return null;
		}

		String jsonString = toJsonString(model);
		return toObject(jsonString, clazz);
	}

	final public static <T> List<T> convert(Collection<?> source, final Class<T> clazz) {

		if (isEmpty(source)) {
			return emptyList();
		}

		Iterable<T> elements = transform(source, new Function<Object, T>() {
			@Override
			public T apply(final Object input) {
				return convert(input, clazz);
			}
		});

		return Lists.newArrayList(elements);
	}

	public static String toJsonString(Object model) {
		return getGson().toJson(model);
	}

	public static <T> T toObject(String jsonString, Class<T> clazz) {
		return getGson().fromJson(jsonString, clazz);
	}

	private static Gson getGson() {

		GsonBuilder builder = new GsonBuilder();
		builder = builder.registerTypeAdapter(java.sql.Date.class, new ISODateTimeAdapter());
		builder = builder.registerTypeAdapter(java.util.Date.class, new ISODateTimeAdapter());
		builder = builder.excludeFieldsWithoutExposeAnnotation();
		return builder.create();
	}

}

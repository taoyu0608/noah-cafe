package noah.api.converter;

import static com.google.common.collect.Iterables.transform;
import static java.util.Collections.emptyList;
import static org.apache.commons.collections.CollectionUtils.isEmpty;

import java.util.Collection;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

/**
 * The entity converter. (to DTO)
 * 
 * @param <S>
 *            - the source model.
 * @param <T>
 *            - the target entity.
 * 
 * @author dennis_yen.
 */
abstract public class ModelConverter<S, T> {

    abstract protected T mapping(S source);


    /**
     * convert source model to target model.
     * 
     * @param source
     *            - the source model.
     * 
     * @return the target model.
     */
    final public T convert(S source) {

        if (source == null) {
            return null;
        }

        return mapping(source);
    }

    /**
     * convert source model to target model.
     * 
     * @param sources
     *            - the collection of source models.
     * 
     * @return the list of target model
     */
    final public List<T> convert(Collection<S> sources) {

        if (sources == null) {
            return null;
        }

        if (isEmpty(sources)) {
            return emptyList();
        }

        Iterable<T> elements = transform(sources, new ConvertFunction());
        return Lists.newArrayList(elements);
    }

    final private class ConvertFunction implements Function<S, T> {
        @Override
        public T apply(S input) {
            return convert(input);
        }
    }

}


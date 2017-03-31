/* AbstractConverter.java.
 *
 * Copyright (C) 2013 Galaxy Software Services, All Rights Reserved.
 */
package noah.api.converter;

import java.util.Collection;
import java.util.List;

import com.google.common.base.Function;

import static com.google.common.collect.Iterables.transform;
import static com.google.common.collect.Lists.newArrayList;
import static java.util.Collections.emptyList;
import static org.apache.commons.collections.CollectionUtils.isEmpty;

/**
 * The class define the basic behaviors that a DTO (Data Transfer Object) to VIEW (Value Object)
 * and VIEW to DTO bi-direction converter should have.
 *
 * @param <Dto> the DTO type
 * @param <View> the VIEW type
 */
public abstract class AbstractConverter<Dto, View> {

	/**
	 * Convert the DTO to VIEW.
	 *
	 * @param dto the DTO to be converted
	 * @return the converted VIEW
	 */
	public abstract View toView(Dto dto);

	/**
	 * Convert the VIEW to DTO.
	 *
	 * @param view the VIEW to be converted
	 * @return the converted DTO
	 */
	public abstract Dto toDto(View view);

	/**
	 * Convert a list of DTO to a list of VIEW.
	 *
	 * @param dtos a list of DTO to be converted
	 * @return the converted VIEWs
	 */
	public List<View> toViews(Collection<Dto> dtos) {
		if (isEmpty(dtos)) {
			return emptyList();
		}
		return newArrayList(transform(dtos, new Function<Dto, View>() {

			@Override
			public View apply(Dto input) {
				return toView(input);
			}
		}));
	}

	/**
	 * Convert a list of VIEW to a list of DTO.
	 *
	 * @param views a list of VIEW to be converted
	 * 
	 * @return the converted DTOs
	 */
	public List<Dto> toDtos(Collection<View> views) {
		if (isEmpty(views)) {
			return emptyList();
		}
		return newArrayList(transform(views, new Function<View, Dto>() {

			@Override
			public Dto apply(View input) {
				return toDto(input);
			}
		}));
	}
}

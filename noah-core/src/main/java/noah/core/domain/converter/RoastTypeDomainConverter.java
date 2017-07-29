package noah.core.domain.converter;

import org.springframework.stereotype.Component;

import noah.api.converter.ModelConverter;
import noah.core.domain.RoastTypeDomain;
import noah.core.model.RoastType;

@Component
public class RoastTypeDomainConverter extends ModelConverter<RoastType, RoastTypeDomain> {

	@Override
	protected RoastTypeDomain mapping(RoastType source) {
		
		RoastTypeDomain target = new RoastTypeDomain();
		
		target.setId(source.getId());
		target.setTypeName(source.getTypeName());
		
		return target;
	}

}

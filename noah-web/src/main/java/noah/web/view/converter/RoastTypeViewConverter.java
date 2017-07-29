package noah.web.view.converter;

import org.springframework.stereotype.Component;

import noah.api.converter.ModelConverter;
import noah.core.domain.RoastTypeDomain;
import noah.web.view.RoastTypeView;

@Component
public class RoastTypeViewConverter extends ModelConverter<RoastTypeDomain, RoastTypeView> {

	@Override
	protected RoastTypeView mapping(RoastTypeDomain source) {

		RoastTypeView target = new RoastTypeView();
		target.setRoastTypeId(source.getId());
		target.setRoastTypeName(source.getTypeName());
		
		return target;
	}
}

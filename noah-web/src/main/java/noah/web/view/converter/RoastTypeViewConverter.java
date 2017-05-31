package noah.web.view.converter;

import org.springframework.stereotype.Component;

import noah.api.converter.ModelConverter;
import noah.core.model.RoastType;
import noah.web.view.RoastTypeView;

@Component
public class RoastTypeViewConverter extends ModelConverter<RoastType, RoastTypeView> {

	@Override
	protected RoastTypeView mapping(RoastType source) {

		RoastTypeView target = new RoastTypeView();
		target.setRoastTypeId(source.getId());
		target.setRoastTypeName(source.getTypeName());
		
		return target;
	}
}

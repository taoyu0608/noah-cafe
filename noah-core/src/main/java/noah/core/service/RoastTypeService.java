package noah.core.service;

import noah.core.domain.RoastTypeDomain;
import noah.core.model.RoastType;

public interface RoastTypeService {
	RoastType save(RoastType roastType);
	RoastType getRoastTypeById(Integer id);
	RoastTypeDomain getRoastTypeDomainById(Integer id);
}

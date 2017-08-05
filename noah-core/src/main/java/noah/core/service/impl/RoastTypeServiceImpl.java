package noah.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import noah.core.dao.RoastTypeDao;
import noah.core.domain.RoastTypeDomain;
import noah.core.domain.converter.RoastTypeDomainConverter;
import noah.core.model.RoastType;
import noah.core.service.RoastTypeService;

@Service
@Transactional
public class RoastTypeServiceImpl implements RoastTypeService{
	
	@Autowired
	private RoastTypeDao roastTypeDao;
	
	@Autowired
	private RoastTypeDomainConverter roastTypeDomainConverter;
	
	public RoastType getRoastTypeById(Integer id) {
		return roastTypeDao.findOne(id);
	}
	
	@Override
	public RoastTypeDomain getRoastTypeDomainById(Integer id) {
		RoastType roastType = this.getRoastTypeById(id);
		return roastTypeDomainConverter.convert(roastType);
	}
	
	public RoastType save(RoastType roastType) {
		return roastTypeDao.save(roastType);
	}
}

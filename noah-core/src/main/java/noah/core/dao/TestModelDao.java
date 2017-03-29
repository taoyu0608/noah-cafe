package noah.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import noah.core.model.TestModel;


public interface TestModelDao extends JpaRepository<TestModel, String> {
	
}

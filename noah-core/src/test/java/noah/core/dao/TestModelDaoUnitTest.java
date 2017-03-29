package noah.core.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import noah.core.model.TestModel;

@Rollback(value = true)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-spring-noah-core.xml")
public class TestModelDaoUnitTest {

	@Autowired
	private TestModelDao testModelDao;
	
	@Test
	public void testSave() {
		
		TestModel model = new TestModel();
		
		model.setUsername("name");
		model.setPassword("pwd");

		TestModel savedModel = testModelDao.save(model);
		
		Assert.assertTrue(savedModel.getId() > 0);
	}
	
}

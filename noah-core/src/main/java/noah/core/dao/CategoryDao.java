package noah.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import noah.core.model.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

}

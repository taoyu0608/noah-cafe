package noah.core.model.search.condition;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import lombok.Data;
import noah.core.model.Product;
import noah.core.model.Product_;

@Data
public class ProductSearchCondition implements Specification<Product> {

	@Override
	public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		return getSpecification().toPredicate(root, query, cb);
	}
	
	public Specification<Product> getSpecification() {
		Specifications<Product> conditions = Specifications.where(alwaysTrue());
		return conditions;
	}

	public Specification<Product> alwaysTrue() {
		return new Specification<Product>() {
			public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.conjunction();
			}
		};
	}
	
	public Specification<Product> likeName(String name) {
		return new Specification<Product>() {
			public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.like(root.get(Product_.name), "%" + name+ "%");
			}
		};
	}

}

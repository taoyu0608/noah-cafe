package noah.core.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "RoastType")
public class RoastType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "PRODUCT_ROASTTYPE", joinColumns = @JoinColumn(name="PRODUCT_ID"), inverseJoinColumns = @JoinColumn(name = "ROASTTYPE_ID"))
	private List<Product> products = new ArrayList<>();
	
	@Column(name = "TYPE_DESC")
	private String typeDescription;
}

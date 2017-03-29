package noah.core.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.common.collect.Sets;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ORDER")
public class Order implements Serializable{
	/**
	 * UID for serialization version control 
	 */
	private static final long serialVersionUID = 2001L;
	
	/**
	 * UUID for this order.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Many orders can be made by one user
	 */
	@Column(name = "USERNAME", nullable = false)
	private String userName;
	
	/**
	 * For each order, many details can be included.
	 */
	@Setter(AccessLevel.NONE)
	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "order", foreignKey = @ForeignKey(name = "FK_ORDER_DETAIL"))
	private Set<OrderDetail> orderDetails = Sets.newHashSet();
	
	/**
	 * The date that this order was created.
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "ORDER_DATE", nullable = false)
	private Date orderDate;
	
	/**
	 * The status of this order.
	 * Actual delivery/delivered/received date will be in the details.
	 */
	@Column(name = "IS_FINISHED")
	private boolean isFinished;
	
	public void appendDetail(OrderDetail detail) {
		orderDetails.add(detail);
	}
	
}

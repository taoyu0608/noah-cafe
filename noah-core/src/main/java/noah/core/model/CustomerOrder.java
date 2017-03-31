package noah.core.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.common.collect.Lists;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
@Table(name = "CUSTOMER_ORDER")
public class CustomerOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * The customer info.
	 */
	@ManyToOne
	@JoinColumn(name = "FK_CUSTOMER")
	private Customer customer;
	
	/**
	 * For each order, many details can be included.
	 */
	@Setter(AccessLevel.NONE)
	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "CUSTOMERORDER", foreignKey = @ForeignKey(name = "FK_ORDER_DETAIL"))
	private List<OrderDetail> orderDetails = Lists.newArrayList();

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
	private boolean isFinished = false;

	
	public void appendDetail(OrderDetail detail) {
		orderDetails.add(detail);
	}
}

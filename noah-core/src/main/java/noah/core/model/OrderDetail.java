package noah.core.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetail implements Serializable{
	/**
	 * UID for serialization version control 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * UUID for this order detail.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ODID", nullable = false)
	private Long id;
	
	/**
	 * For each detail in this list belongs to one order.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMERORDER", foreignKey = @ForeignKey(name = "FK_CUSTOMER_ORDER"))
	private CustomerOrder customerOrder;
	
	/**
	 * For each order detail may contain many products.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product", foreignKey = @ForeignKey(name = "FK_PRODUCT"))
	private Product product;
	
	/**
	 * Memo for this detail(e.g. fragile, don't arrive before afternoon...)
	 */
	@Column(name = "MEMO", length = 500)
	private String memo;
	
	/**
	 * "Possible" date that this detail is delivered.
	 */
	@Temporal(TemporalType.DATE)
	private Date deliveryDate;
	
	/**
	 * "Actual" date that this detail is delivered.
	 */
	@Temporal(TemporalType.DATE)
	private Date deliveredDate;
	
	/**
	 * Date that this detail is "recieved" by the user who ordered.
	 */
	@Temporal(TemporalType.DATE)
	private Date receivedDate;
}

package noah.web.view;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class OrderDetailView {
	
	/**
	 * 訂單明細編號
	 */
	private Long id;
	
	/**
	 * 訂單編號
	 */
	private Long oId;
	
	/**
	 * 產品編號
	 */
	private Long pId;
	
	/**
	 * 產品名稱
	 */
	private String productName;
	
	/**
	 * 產品單價
	 */
	private BigDecimal unitPrice;
	
	/**
	 * 預計交貨日
	 */
	private Date deliveryDate;
	
	/**
	 * 實際交貨日
	 */
	private Date deliveredDate;
	
	/**
	 * 簽收日
	 */
	private Date receivedDate;
	
	/**
	 * 備註
	 */
	private String memo;
}

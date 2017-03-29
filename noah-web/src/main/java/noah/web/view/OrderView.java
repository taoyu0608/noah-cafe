package noah.web.view;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class OrderView {
	
	private Long Id;
	
	/**
	 * 訂購人
	 */
	private String userName;
	
	/**
	 * 訂購日期
	 */
	private Date orderDate;
	
	/**
	 * 訂單處理完成與否
	 */
	private String finishedText;
	
	/**
	 * 訂單明細
	 */
	private List<OrderDetailView> detailViews;
}

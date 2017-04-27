package noah.web.view;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class ProductView {

	private Long id;
	
	/**
	 * 商品名稱
	 * */
	private String name;
	
	/**
	 * 商品顯示的名稱
	 * */
	private String displayName;
	
	/**
	 * 商品價格
	 * */
	private BigDecimal unitPrice; 
	
	/**
	 * 烘培方式
	 */
	private List<CookTypeView> cookTypes;
	
	/**
	 * 圖片位址
	 * */
	private String imageName;
	
	/**
	 * 圖片名稱(給前端 alt 顯示用)
	 * */
	private String imageDisplayName;
	
	/**
	 * 種類：掛耳式咖啡 / 咖啡豆
	 * */
	private Integer category;
}

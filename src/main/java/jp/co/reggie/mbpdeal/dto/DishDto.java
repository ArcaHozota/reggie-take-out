package jp.co.reggie.mbpdeal.dto;

import java.util.List;

import jp.co.reggie.mbpdeal.entity.Dish;
import jp.co.reggie.mbpdeal.entity.DishFlavour;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜品以及口味數據傳輸專用類
 *
 * @author Administrator
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DishDto extends Dish {

	private static final long serialVersionUID = 363782191754121480L;

	/**
	 * 口味集合
	 */
	private List<DishFlavour> flavors;

	/**
	 * 分類名稱
	 */
	private String categoryName;

	/**
	 * 複製品
	 */
	private Integer copy;
}

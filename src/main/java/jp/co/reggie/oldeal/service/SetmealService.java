package jp.co.reggie.oldeal.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import jp.co.reggie.oldeal.dto.SetmealDto;
import jp.co.reggie.oldeal.entity.Setmeal;

/**
 * @author Administrator
 */
public interface SetmealService extends IService<Setmeal> {

	/**
	 * 新增套餐，同時保存套餐和菜品的關聯
	 *
	 * @param setmealDto 數據傳輸類
	 */
	void saveWithDish(SetmealDto setmealDto);

	/**
	 * 刪除套餐，同時刪除套餐和菜品的關聯
	 *
	 * @param ids 套餐ID的集合
	 */
	void removeWithDish(List<Long> ids);
}

package jp.co.reggie.oldeal.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.postgresql.util.PSQLException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import jp.co.reggie.oldeal.common.CustomException;
import jp.co.reggie.oldeal.common.CustomMessage;
import jp.co.reggie.oldeal.dto.SetmealDto;
import jp.co.reggie.oldeal.entity.Setmeal;
import jp.co.reggie.oldeal.entity.SetmealDish;
import jp.co.reggie.oldeal.mapper.SetmealMapper;
import jp.co.reggie.oldeal.service.SetmealDishService;
import jp.co.reggie.oldeal.service.SetmealService;

/**
 * @author Administrator
 * @date 2022-11-19
 */
@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {

	/**
	 * 套餐與菜品服務類
	 */
	@Resource
	private SetmealDishService setmealDishService;

	/**
	 * 新增套餐同時保存套餐和菜品的關聯關係
	 *
	 * @param setmealDto 數據傳輸類
	 */
	@Override
	@Transactional(rollbackFor = PSQLException.class)
	public void saveWithDish(final SetmealDto setmealDto) {
		// 保存套餐的基本信息；
		this.save(setmealDto);
		// 獲取套餐菜品關聯集合；
		List<SetmealDish> setmealDishes = setmealDto.getSetmealDishes();
		// 獲取菜品ID並插入集合；
		setmealDishes = setmealDishes.stream().map((item) -> {
			item.setDishId(setmealDto.getId());
			return item;
		}).collect(Collectors.toList());
		// 保存套餐和菜品的關聯關係；
		this.setmealDishService.saveBatch(setmealDishes);
	}

	/**
	 * 刪除套餐同時刪除套餐和菜品的關聯關係
	 *
	 * @param ids 套餐ID的集合
	 */
	@Override
	public void removeWithDish(final List<Long> ids) {
		// 查詢套餐狀態以確認是否可以刪除；
		final LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.in(Setmeal::getId, ids);
		queryWrapper.eq(Setmeal::getStatus, 1);
		final long count = this.count(queryWrapper);
		if (count > 0) {
			// 如果無法刪除，則抛出異常；
			throw new CustomException(CustomMessage.ERP012);
		}
		// 刪除套餐表中的數據；
		this.removeByIds(ids);
		// 刪除套餐口味表中的數據；
		final LambdaQueryWrapper<SetmealDish> lambdaQueryWrapper = new LambdaQueryWrapper<>();
		lambdaQueryWrapper.in(SetmealDish::getSetmealId, ids);
		this.setmealDishService.remove(lambdaQueryWrapper);
	}
}

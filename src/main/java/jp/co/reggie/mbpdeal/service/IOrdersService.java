package jp.co.reggie.mbpdeal.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import jp.co.reggie.mbpdeal.entity.Orders;

/**
 * @author Administrator
 */
public interface IOrdersService extends IService<Orders> {

	/**
	 * 分頁查詢
	 *
	 * @param pageNum      頁碼
	 * @param pageSize     頁面大小
	 * @param orderId      訂單ID
	 * @param beginTime    開始時間
	 * @param terminalTime 截止時間
	 * @return Page<Orders>
	 */
	Page<Orders> pagination(Integer pageNum, Integer pageSize, Long orderId, String beginTime, String terminalTime);
}

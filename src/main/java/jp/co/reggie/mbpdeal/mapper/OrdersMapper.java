package jp.co.reggie.mbpdeal.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import jp.co.reggie.mbpdeal.entity.Orders;

/**
 * 訂單實體類接口
 *
 * @author Administrator
 * @date 2023-02-18
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
}

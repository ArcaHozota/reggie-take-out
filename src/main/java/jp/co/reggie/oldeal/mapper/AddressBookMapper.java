package jp.co.reggie.oldeal.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import jp.co.reggie.oldeal.entity.AddressBook;

/**
 * 地址簿實體類接口
 *
 * @author Administrator
 * @date 2022-11-08
 */
@Mapper
public interface AddressBookMapper extends BaseMapper<AddressBook> {
}

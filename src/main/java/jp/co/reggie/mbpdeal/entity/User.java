package jp.co.reggie.mbpdeal.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 客戸信息實體類
 *
 * @author Administrator
 */
@Data
@TableName(value = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 2324630650798877027L;

	/**
	 * ID
	 */
	@TableId
	private Long id;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 手機號
	 */
	@TableField(value = "phone_num")
	private String phoneNo;

	/**
	 * 性別
	 */
	@TableField(value = "sex")
	private String gender;

	/**
	 * 身份證號
	 */
	private String idNumber;

	/**
	 * 頭像
	 */
	private String avatar;

	/**
	 * 狀態： 0禁用，1正常
	 */
	private Integer status;
}

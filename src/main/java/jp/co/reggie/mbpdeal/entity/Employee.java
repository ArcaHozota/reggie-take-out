package jp.co.reggie.mbpdeal.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 員工管理實體類
 *
 * @author Administrator
 */
@Data
@TableName(value = "employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = -6540113185665801143L;

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
	 * 賬號名
	 */
	private String username;

	/**
	 * 密碼
	 */
	private String password;

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
	 * 賬號狀態：0:禁用，1:正常
	 */
	private Integer status;

	/**
	 * 創建時間
	 */
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createdTime;

	/**
	 * 更新時間
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updatedTime;

	/**
	 * 創建人
	 */
	@TableField(fill = FieldFill.INSERT)
	private Long createdUser;

	/**
	 * 修改者
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Long updatedUser;
}

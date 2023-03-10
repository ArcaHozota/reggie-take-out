package jp.co.reggie.oldeal.service;

import com.baomidou.mybatisplus.extension.service.IService;

import jp.co.reggie.oldeal.entity.Employee;

/**
 * @author Administrator
 */
public interface EmployeeService extends IService<Employee> {

	/**
	 * 根據所提供的用戸名進行查詢
	 *
	 * @param username 用戸名
	 * @return Employee
	 */
	Employee findOneByUsernameProvided(String username);
}

package jp.co.reggie.oldeal.repository;

import jp.co.reggie.oldeal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 客戸信息實體類接口
 *
 * @author Administrator
 */
public interface UserDao extends JpaRepository<User, Long> {
}
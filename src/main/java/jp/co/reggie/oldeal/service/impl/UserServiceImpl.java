package jp.co.reggie.oldeal.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import jp.co.reggie.oldeal.entity.User;
import jp.co.reggie.oldeal.mapper.UserMapper;
import jp.co.reggie.oldeal.service.UserService;

/**
 * @author Administrator
 * @date 2022-11-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}

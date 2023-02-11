package jx.pgz.dao.service.impl;

import jx.pgz.dao.entity.User;
import jx.pgz.dao.mapper.UserMapper;
import jx.pgz.dao.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2023-02-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

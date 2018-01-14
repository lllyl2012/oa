package cn.yl.oa.service;

import cn.yl.oa.dao.DaoSupport;
import cn.yl.oa.entity.User;

public interface UserService extends DaoSupport<User>{
	/**
	 * 根据用户名和密码，查找用户
	 * @param loginName
	 * @param password
	 * @return
	 */
	User findByLoginNameAndPassword(String loginName, String password);

}

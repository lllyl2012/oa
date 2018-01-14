package cn.yl.oa.service;

import cn.yl.oa.dao.DaoSupport;
import cn.yl.oa.entity.User;

public interface UserService extends DaoSupport<User>{
	/**
	 * �����û��������룬�����û�
	 * @param loginName
	 * @param password
	 * @return
	 */
	User findByLoginNameAndPassword(String loginName, String password);

}

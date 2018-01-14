package cn.yl.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yl.oa.dao.RoleDao;
import cn.yl.oa.dao.impl.DaoSupportImpl;
import cn.yl.oa.entity.Role;
import cn.yl.oa.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl extends DaoSupportImpl<Role> implements RoleService{
//	@Resource
//	private RoleDao roleDao;
//	
//	public List<Role> findAll() {
//		return roleDao.findAll();
//	}
//
//	public void delete(Long id) {
//		roleDao.delete(id);
//	}
//
//	public void save(Role role) {
//		roleDao.save(role);
//	}
//
//	public Role getById(Long id) {
//		return roleDao.getById(id);
//	}
//
//	public void update(Role role) {
//		roleDao.update(role);
//	}

}

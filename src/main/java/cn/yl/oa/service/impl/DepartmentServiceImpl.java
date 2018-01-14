package cn.yl.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yl.oa.dao.DepartmentDao;
import cn.yl.oa.dao.impl.DaoSupportImpl;
import cn.yl.oa.entity.Department;
import cn.yl.oa.service.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl extends DaoSupportImpl<Department> implements DepartmentService {
//	@Resource
//	private DepartmentDao departmentDao;
//
	@Resource
	private SessionFactory sessionFactory;
//	
//	public List<Department> findAll() {
//		return departmentDao.findAll();
//	}
//
//	public void delete(Long id) {
//		departmentDao.delete(id);
//	}
//
//	public void save(Department model) {
//		departmentDao.save(model);
//	}
//
//	public Department getById(Long id) {
//		return departmentDao.getById(id);
//	}
//
//	public void update(Department department) {
//		departmentDao.update(department);
//	}
//
	public List<Department> fintTopList() {
		return sessionFactory.getCurrentSession().createQuery(//
				"FROM Department d WHERE d.parent IS null")//
				.list();
	}

	public List<Department> findChildrenList(Long parentId) {
		return sessionFactory.getCurrentSession().createQuery(//
				"FROM Department d WHERE d.parent.id = ?")//
				.setParameter(0, parentId)//
				.list();
	}

}

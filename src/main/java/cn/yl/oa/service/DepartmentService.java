package cn.yl.oa.service;

import java.util.List;

import cn.yl.oa.dao.DaoSupport;
import cn.yl.oa.entity.Department;

public interface DepartmentService extends DaoSupport<Department>{

//	List<Department> findAll();
//
//	void delete(Long id);
//
//	void save(Department model);
//
//	Department getById(Long id);
//
//	void update(Department department);

	/**
	 * 查询顶级部门列表
	 * @return
	 */
	List<Department> fintTopList();

	/**
	 * 查询子部门列表
	 * @return
	 */
	List<Department> findChildrenList(Long parentId);
	
}

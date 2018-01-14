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
	 * ��ѯ���������б�
	 * @return
	 */
	List<Department> fintTopList();

	/**
	 * ��ѯ�Ӳ����б�
	 * @return
	 */
	List<Department> findChildrenList(Long parentId);
	
}

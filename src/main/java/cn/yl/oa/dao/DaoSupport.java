package cn.yl.oa.dao;

import java.util.List;

public interface DaoSupport<T> {
	/**
	 * ��������
	 * @param entity
	 */
	void save(T entity);
	
	/**
	 * ɾ������
	 * @param id
	 */
	void delete(Long id);
	
	/**
	 * ��������
	 * @param entity
	 */
	void update(T entity);
	
	/**
	 * ����id��ѯ
	 * @param id
	 * @return
	 */
	
	T getById(Long id);
	
	/**
	 * ����id��ѯ
	 */
	List<T> getByIds(Long[] ids);
	
	/**
	 * ��ѯ����
	 * @return
	 */
	List<T> findAll();
}

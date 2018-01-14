package cn.yl.oa.dao;

import java.util.List;

public interface DaoSupport<T> {
	/**
	 * 保存数据
	 * @param entity
	 */
	void save(T entity);
	
	/**
	 * 删除数据
	 * @param id
	 */
	void delete(Long id);
	
	/**
	 * 更新数据
	 * @param entity
	 */
	void update(T entity);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	
	T getById(Long id);
	
	/**
	 * 根据id查询
	 */
	List<T> getByIds(Long[] ids);
	
	/**
	 * 查询所有
	 * @return
	 */
	List<T> findAll();
}

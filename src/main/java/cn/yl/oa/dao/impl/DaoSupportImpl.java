package cn.yl.oa.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.transaction.annotation.Transactional;

import cn.yl.oa.dao.DaoSupport;
@Transactional
@SuppressWarnings("unchecked")
public abstract class DaoSupportImpl<E> implements DaoSupport<E> {
	@Resource
	private SessionFactory sessionFactory;
	private Class<E> clazz;
	public DaoSupportImpl() {
		ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass();
		this.clazz = (Class<E>)pt.getActualTypeArguments()[0];
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(E entity) {
		getSession().save(entity);
	}

	public void delete(Long id) {
		Object obj = getById(id);
		if(obj != null) {
			getSession().delete(obj);
		}
	}

	public void update(E entity) {
		getSession().update(entity);
	}

	public E getById(Long id) {
		if(id==null) {
			return null;
		}else {
			return (E)getSession().get(clazz, id);
		}
	}

	public List<E> getByIds(Long[] ids) {
		if(ids==null|| ids.length==0) {
			return Collections.EMPTY_LIST;
		}else {
			return getSession().createQuery(//
				"FROM "+clazz.getSimpleName()+" WHERE id IN (:ids)")//
				.setParameterList("ids", ids)
				.list();
		}
	}

	public List<E> findAll() {
		return getSession().createQuery(//
				"FROM "+clazz.getSimpleName())//
				.list();
	}

}

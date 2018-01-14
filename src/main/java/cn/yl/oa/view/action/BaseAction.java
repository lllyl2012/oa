package cn.yl.oa.view.action;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.yl.oa.entity.Department;
import cn.yl.oa.service.DepartmentService;
import cn.yl.oa.service.PrivilegeService;
import cn.yl.oa.service.RoleService;
import cn.yl.oa.service.UserService;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	protected  T model;
	
	public BaseAction() {
		try {
			//通过反射获得model真实类型
			ParameterizedType  pt = (ParameterizedType)this.getClass().getGenericSuperclass();
			Class<T>  clazz = (Class<T>)pt.getActualTypeArguments()[0];
			model = clazz.newInstance();		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public T getModel() {
		return model;
	}
	
	//service
	@Resource
	protected DepartmentService departmentService;
	
	@Resource
	protected RoleService roleService;
	
	@Resource
	protected UserService userService;
	
	@Resource
	protected PrivilegeService privilegeService;
}

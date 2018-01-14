package cn.yl.oa.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.yl.oa.entity.Department;
/**
 * 该类实现部门上下级树状结构
 * @author toshiba2
 *
 */
public class DepartmentUtils {

	public static List<Department> getAllDepartments(List<Department> topList) {
		List<Department> list = new ArrayList<Department>();
		String spaces = "┣";
		List<Department> departmentList = walkDepartmentTreeList(topList,list,spaces);
		return list;
	}

	private static List<Department> walkDepartmentTreeList(Collection<Department> topList,List<Department> list,String spaces) {
		for (Department department : topList) {
			Department copy = new Department();
			copy.setId(department.getId());
			copy.setName(spaces+department.getName());
			list.add(copy);
			walkDepartmentTreeList(department.getChildren(),list,"　　"+spaces);
		}
		return list;
	}
}

package cn.yl.oa.view.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.yl.oa.entity.Department;
import cn.yl.oa.service.DepartmentService;
import cn.yl.oa.util.DepartmentUtils;

@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department>{

	private Long parentId;
	
	public String list() throws Exception {
		List<Department> departmentList = null;
		if(parentId==null) {
			departmentList = departmentService.fintTopList();
		}else {
			departmentList = departmentService.findChildrenList(parentId);
			Department parent = departmentService.getById(parentId);
			ActionContext.getContext().put("parent", parent);
		}
		ActionContext.getContext().put("departmentList", departmentList);
		return "list";
	}
	public String delete() throws Exception {
		departmentService.delete(model.getId());
		return "toList";
	}
	public String addUI() throws Exception {
		List<Department> topList = departmentService.fintTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);
		return "addUI";
	}
	
	public String add() throws Exception {
		Department parent = departmentService.getById(parentId);
		model.setParent(parent);
		departmentService.save(model);
		return "toList";
	}
	public String editUI() throws Exception {
		List<Department> topList = departmentService.fintTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);
		Department department = departmentService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(department);
		if(department.getParent()!=null) {
			parentId = department.getParent().getId();
		}
		return "editUI";
	}
	public String edit() throws Exception {
		Department department = departmentService.getById(model.getId());
		department.setDescription(model.getDescription());
		department.setName(model.getName());
		department.setParent(departmentService.getById(parentId));
		departmentService.update(department);
		return "toList";
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
}

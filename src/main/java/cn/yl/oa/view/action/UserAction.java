package cn.yl.oa.view.action;

import java.util.HashSet;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.yl.oa.entity.Department;
import cn.yl.oa.entity.Role;
import cn.yl.oa.entity.User;
import cn.yl.oa.util.DepartmentUtils;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	private Long departmentId;
	private Long[] roleIds;

	public String list() throws Exception {
		List<User> userList = userService.findAll();
		ActionContext.getContext().put("userList", userList);
		return "list";
	}

	public String delete() throws Exception {
		userService.delete(model.getId());
		return "toList";
	}

	public String addUI() throws Exception {
		List<Department> topList = departmentService.fintTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "addUI";
	}

	public String add() throws Exception {
		model.setDepartment(departmentService.getById(departmentId));
		List<Role> roleList = roleService.getByIds(roleIds);
		model.setRoles(new HashSet<Role>(roleList));
		String md5Digest = DigestUtils.md5Hex("1234");
		model.setPassword(md5Digest);
		userService.save(model);
		return "toList";
	}

	public String editUI() throws Exception {
		List<Department> topList = departmentService.fintTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);

		User user = userService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(user);
		if (user.getDepartment() != null) {
			departmentId = user.getDepartment().getId();
		}
		if (user.getRoles() != null) {
			roleIds = new Long[user.getRoles().size()];
			int index = 0;
			for (Role role : user.getRoles()) {
				roleIds[index++] = role.getId();
			}
		}
		return "editUI";
	}

	public String edit() throws Exception {
		User user = userService.getById(model.getId());
		userService.update(user);
		user.setLoginName(model.getLoginName());
		user.setName(model.getGender());
		user.setPhoneNumber(model.getPhoneNumber());
		user.setEmail(model.getEmail());
		user.setDescription(model.getDescription());
		user.setDepartment(departmentService.getById(departmentId));
		List<Role> roleList = roleService.getByIds(roleIds);
		user.setRoles(new HashSet<Role>(roleList));
		userService.update(user);
		return "toList";
	}
	/**
	 * 加密密码
	 * @return
	 * @throws Exception
	 */
	public String initPassword() throws Exception{
		User user = userService.getById(model.getId());
		String md5Digest = DigestUtils.md5Hex("1234");
		user.setPassword(md5Digest);
		userService.update(user);
		return "toList";
	}
	
	/**
	 * 登陆页面
	 * @return
	 */
	public String loginUI() throws Exception {
		return "loginUI";
	}
	
	/**
	 * 处理登陆
	 * @return
	 */
	public String login() throws Exception{
		String username = model.getName();
		String password = model.getPassword();
		User user = userService.findByLoginNameAndPassword(model.getLoginName(),model.getPassword());
		if(user==null) {
			addFieldError("login", "用户名或密码不正确");
			return "loginUI";
		}else {
			ActionContext.getContext().getSession().put("user", user);
			return "toIndex";
		}
		
	}
	
	/**
	 * 注销
	 * @return
	 */
	public String logout() throws Exception{
	ActionContext.getContext().getSession().remove("user");
		return "loginUI";
	}
	//setter和getter
	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}

}

package cn.yl.oa.view.action;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.apache.catalina.tribes.util.Arrays;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.yl.oa.entity.Privilege;
import cn.yl.oa.entity.Role;
import cn.yl.oa.service.RoleService;

@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {
	private Long[] privilegeIds;
	/**
	 * Ȩ�޹�����ҳ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}

	public String delete() throws Exception {
		roleService.delete(model.getId());
		return "toList";
	}

	public String addUI() throws Exception {
		return "addUI";
	}

	public String add() throws Exception {
		roleService.save(model);
		return "toList";
	}

	public String editUI() throws Exception {
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		return "editUI";
	}

	public String edit() throws Exception {
		Role role = roleService.getById(model.getId());
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		roleService.update(role);
		return "toList";
	}
	/**
	 * ����Ȩ��ҳ��
	 * @return
	 * @throws Exception
	 */
	public String setPrivilegeUI() throws Exception {
		//׼����������
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		if(role.getPrivileges()!=null) {
			privilegeIds = new Long[role.getPrivileges().size()];
			int i = 0;
			for (Privilege pri : role.getPrivileges()) {
				privilegeIds[i++] = pri.getId();
			}
		}
		List<Privilege> privilegeList = privilegeService.findAll();
		ActionContext.getContext().put("privilegeList", privilegeList);
		return "setPrivilegeUI";
	}
	/**
	 * ����Ȩ��
	 * @return
	 * @throws Exception
	 */
	
	public String setPrivilege() throws Exception {
		//�����ݿ��ȡԭ����
		Role role = roleService.getById(model.getId());
		//�����޸�����
		List<Privilege> privilegeList = privilegeService.getByIds(privilegeIds);
		role.setPrivileges(new HashSet<Privilege>(privilegeList));
		//���µ����ݿ�
		roleService.update(role);
		return "toList";
	}
	
	//-------------------------set and get
	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}



}

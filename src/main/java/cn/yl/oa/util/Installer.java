package cn.yl.oa.util;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.yl.oa.entity.Privilege;
import cn.yl.oa.entity.User;
/**
 * ��װȨ�޺ͳ�������Ա
 * @author toshiba2
 *
 */
@Component
public class Installer {
	@Resource
	private SessionFactory sessionFactory;
	
	@Transactional
	public void install() {
		Session session = sessionFactory.getCurrentSession();
		//���泬������Ա�û�
		User user = new User();
		user.setLoginName("admimn");
		user.setName("��������Ա");
		user.setPassword(DigestUtils.md2Hex("admin"));
		session.save(user);
		//����Ȩ������
		Privilege menu = new Privilege("ϵͳ����",null,null);
		Privilege menu1 = new Privilege("��λ����","/role_list",menu);
		Privilege menu2 = new Privilege("���Ź���","/department_list",menu);
		Privilege menu3 = new Privilege("�û�����","/user_list",menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		
		session.save(new Privilege("��λ�б�","/role_list",menu1));
		session.save(new Privilege("��λɾ��","/role_delete",menu1));
		session.save(new Privilege("��λ���","/role_add",menu1));
		session.save(new Privilege("��λ�޸�","/role_edit",menu1));
		
		session.save(new Privilege("�����б�","/department_list",menu2));
		session.save(new Privilege("����ɾ��","/department_delete",menu2));
		session.save(new Privilege("�������","/department_add",menu2));
		session.save(new Privilege("�����޸�","/department_edit",menu2));
		
		session.save(new Privilege("�û��б�","/user_list",menu3));
		session.save(new Privilege("�û�ɾ��","/user_delete",menu3));
		session.save(new Privilege("�û����","/user_add",menu3));
		session.save(new Privilege("�û��޸�","/user_edit",menu3));
		session.save(new Privilege("��ʼ������","/user_initPassword",menu3));
		
		//------------------------
		session.save(new Privilege("���Ͻ���",null,null));
		session.save(new Privilege("��̳����","/formManage_list",menu));
		session.save(new Privilege("��̳","/forum_list",menu));
		
		//-----------------------
		session.save(new Privilege("������ת",null,null));
		session.save(new Privilege("�������̹���","/processDefinition",menu));
		session.save(new Privilege("����ģ�����","/template_list",menu));
		session.save(new Privilege("�������","/flow_templateList",menu));
		session.save(new Privilege("��������","/flow_myTaskList",menu));
		session.save(new Privilege("�ҵ������ѯ","/flow_myApplicationList",menu));
	}
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Installer installer = ac.getBean("installer",Installer.class);
		installer.install();
	}
}

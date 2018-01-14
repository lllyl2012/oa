package cn.yl.oa.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yl.oa.dao.impl.DaoSupportImpl;
import cn.yl.oa.entity.Privilege;
import cn.yl.oa.service.PrivilegeService;
@Service("privilegeService")
@Transactional
public class PrivilegeServiceImpl extends DaoSupportImpl<Privilege> implements PrivilegeService{

}

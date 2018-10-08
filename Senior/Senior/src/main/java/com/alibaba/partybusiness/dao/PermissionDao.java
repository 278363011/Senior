package com.alibaba.partybusiness.dao;

import java.util.List;
import com.alibaba.partybusiness.model.Permission;

public interface PermissionDao {
	 public List<Permission> findAll();
	 public List<Permission> findByAdminUserId(int userId);
}

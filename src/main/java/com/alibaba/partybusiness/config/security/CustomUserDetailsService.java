package com.alibaba.partybusiness.config.security;

//import java.util.ArrayList;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import com.alibaba.partybusiness.dao.PermissionDao;
//import com.alibaba.partybusiness.dao.UserDao;
//import com.alibaba.partybusiness.model.Permission;
//import com.alibaba.partybusiness.model.User;

//public class CustomUserDetailsService implements UserDetailsService {
	//spring security userService处理账号密码
//	@Autowired
//    UserDao userDao;
//    @Autowired
//    PermissionDao permissionDao;
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		   User user = userDao.findByUserName(username);
//	        if (user != null) {
//	            List<Permission> permissions = permissionDao.findByAdminUserId(user.getId());
//	            List<GrantedAuthority> grantedAuthorities = new ArrayList <>();
//	            for (Permission permission : permissions) {
//	                if (permission != null && permission.getName()!=null) {
//
//	                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
//	                //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
//	                grantedAuthorities.add(grantedAuthority);
//	                }
//	            }
//	            return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
//	        } else {
//	            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
//	        }
//	    }
//		
//		
//		
//		return null;
//	}

//}


package com.toughguy.sinograin.controller.authority;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Constants;
import com.toughguy.sinograin.dto.UserDTO;
import com.toughguy.sinograin.model.authority.Operation;
import com.toughguy.sinograin.model.authority.Role;
import com.toughguy.sinograin.model.authority.User;
import com.toughguy.sinograin.persist.authority.prototype.IOperationDao;
import com.toughguy.sinograin.persist.authority.prototype.IResourceDao;
import com.toughguy.sinograin.persist.authority.prototype.IRoleDao;
import com.toughguy.sinograin.persist.authority.prototype.IUserDao;
import com.toughguy.sinograin.util.JsonUtil;


/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the"License"); 
 * you may not use this file except in compliance with the License.  
 * You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  
 * See the License for the specific language governing permissions and limitations under the License.
 * Copyright [2017] [RanJi] [Email-jiran1221@163.com]
 * 
 * 登录控制器类
 * @author RanJi
 * @date 2017-9-12
 * @since JDK1.7
 * @version 1.0
 */

@Controller
public class LoginController {
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IOperationDao operationDao;
	
	@Autowired
	private IResourceDao resourceDao;
	
	@Autowired
	private IRoleDao roleDao;

	private String userPass;
	
	/**
	 *  登录页面
	 * @return  登录页面
	 * @throws Exception 
	 */
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginPage(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/default/login/login");
		return mv;
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String indexPage(){
		return "/index";
	}
	/**
	 * 登录
	 * @param user
	 * @param session
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	//@SystemControllerLog(description="登录系统")
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public String login(User user, String verityCode, HttpSession session,HttpServletRequest request, String captcha){		
		//-- 产生的验证码获取的方法，若需要认证则自己写验证的逻辑, verityCode为用户输入的验证码，嘿嘿，简单吧
//		String rightCode = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if(!captcha.equals(verityCode.trim())){
			return "{ \"success\" : false ,\"code\":\"您输入的验证码信息不正确,请重新输入\" }";
		}
		//ModelAndView mv = new ModelAndView();
	    try{
	    	Subject currentUser = SecurityUtils.getSubject();
	    	UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getUserPass());
	    	System.out.println(new DefaultPasswordService().encryptPassword(user.getUserPass()));
	    	currentUser.login(token);
	    } catch ( UnknownAccountException e ) {
	    	return "{ \"success\" : false ,\"code\":\"您输入的用户名或密码不正确,请重新输入\" }";
        } catch ( IncorrectCredentialsException e ) {
        	return "{ \"success\" : false ,\"code\":\"您输入的用户名或密码不正确,请重新输入\" }";
        }
		
		User u = userDao.findUserInfoByUserName(user.getUserName());
		Role role = roleDao.findByUserId(u.getId());
		UserDTO ut = new UserDTO();
		List<Operation> list = operationDao.findByUserId(u.getId());
		String name = "";          //用户拥有的操作名称
		String ResourceName ="";   
		for (Operation operation : list) {
			String permission = operation.getPermission();
			name += permission+",";
			int resourceId = operation.getResourceId();
			String reName = resourceDao.find(resourceId).getResourceName();
			ResourceName += reName+",";
		}
		//去重
		String [] stringArr= ResourceName.substring(0, ResourceName.length()-1).split(",");;
		Set set = new HashSet();
		for (int i = 0; i < stringArr.length; i++) {
			set.add(stringArr[i]);
		}
		stringArr = (String[]) set.toArray(new String[0]);
		String resourceName = ""; //用户拥有的资源名称
		for (int i = 0; i < stringArr.length; i++) {
			resourceName +=stringArr[i]+",";
		}
        ut.setRoleName(role.getDisplayName());
		ut.setPermissions(name.substring(0, name.length()-1));
		ut.setResourceName(resourceName.substring(0, resourceName.length()-1));
		ut.setToken(session.getId());
		BeanUtils.copyProperties(u, ut); //省去set的烦恼，利用beanUtils进行属性copy
		String userDTO = JsonUtil.objectToJson(ut);
		//mv.setViewName("redirect:/index.html");
		return "{ \"success\" : true ,\"user\":"+userDTO+"}";
	}
}
/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.teligen.sample.rest;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.teligen.sample.domain.User;
import com.teligen.sample.service.UserService;

@Component
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserEndpoint {

	@Autowired
	UserService userSvc;

	@GET
	public List<User> getAllUsers(@Context HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");

		User user = userSvc.sampleService();

		List<User> users = new ArrayList<User>();
		user = new User();
		user.setId(Long.valueOf(123));
		user.setPassword("xxx");
		user.setUsername("panmq");
		users.add(user);
		users.add(user);
		users.add(user);
		return users;
	}

	@GET
	@Path("{id}")
	public User getUser(@Context HttpServletResponse response, @PathParam("id") @NotNull String id) {
		response.setHeader("Access-Control-Allow-Origin", "*");

		User user = userSvc.sampleService();
		return user;
	}

	@POST
	@Path("/add")
	public boolean addUser(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		Map<String,String> parmMap=new HashMap<String,String>();  
        //方式一：getParameterMap()，获得请求参数map  
        Map<String,String[]> map= request.getParameterMap();  
        //参数名称  
        Set<String> key=map.keySet();  
        //参数迭代器  
        Iterator<String> iterator = key.iterator();  
        while(iterator.hasNext()){  
            String k=iterator.next();  
            parmMap.put(k, map.get(k)[0]);  
        }  
        System.out.println("parmMap====="+parmMap.toString());  
          
          
        //方式二：getParameterNames()：获取所有参数名称  
        Enumeration<String> a = request.getParameterNames();  
        String parm=null;  
        String val="";  
        while(a.hasMoreElements()){  
            //参数名  
            parm=a.nextElement();  
            //值  
            val=request.getParameter(parm);  
            parmMap.put(parm, val);  
        }  
        System.out.println("parmMap=========="+parmMap);  
		
		
		response.setHeader("Access-Control-Allow-Origin", "*");

		User user = userSvc.sampleService();

		List<User> users = new ArrayList<User>();
		user = new User();
		user.setId(Long.valueOf(123));
		user.setPassword("xxx");
		user.setUsername("panmq");
		users.add(user);
		users.add(user);
		users.add(user);
		return true;
	}

}

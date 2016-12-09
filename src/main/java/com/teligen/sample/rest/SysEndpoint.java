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

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.teligen.sample.bean.SysInfo;
import com.teligen.sample.service.SysService;

@Component
@Path("/sys")
@Produces(MediaType.APPLICATION_JSON)
public class SysEndpoint {

	@Autowired
	SysService sysSvc;

	@GET
	public SysInfo getSysInfo(@Context HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");

		SysInfo sysInfo = sysSvc.getSysInfo();

		return sysInfo;
	}
	
	@GET
	@Path("/gc")
	public String dumpThreads(@Context HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		System.gc();
		System.err.println("called gc...");
		for(int i=0;i<100*100;i++){
			String si = new String(i+"");
			for(int j=0;j<100*100;j++){
				String sj = new String(j+"") + si;
			}
			
		}
		System.gc();

		return "GCed";
	}
	
}

/**
 * 
 */
package com.bunnyinc.test.core.service;

import com.bunnyinc.test.api.bunny.BunnyService;
import com.bunnyinc.test.api.bunny.BunnyServiceImpl;
import com.bunnyinc.test.api.external.ExternalService;
import com.bunnyinc.test.api.external.ExternalServiceImpl;

/**
 * @author Rodrigo
 * Core service class that calls the api services and do the use case requeried.
 */
public class CoreTestService {
	
	private BunnyService bunnyService = new BunnyServiceImpl();
	
	private ExternalService externalService = new ExternalServiceImpl();
	
	
	String executeTest(String title) throws Exception{
		String script = "";
		
		script = externalService.getRandomQuote();
		
		//Step 1 Publish project with generated script.
		String result = "";
		if(script!=null && !script.equals("")){
			result = bunnyService.postProject(script, title);
		}
		
		//Step 2: Get info of the project
		//JSONObject obj;
		//result = bunnyService.getProject(id);
		
		//Step 3 Approve read
		//bunnyService.approveRead(id);
		
		return result;
	}

}

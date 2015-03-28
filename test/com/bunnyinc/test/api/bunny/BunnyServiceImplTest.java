/**
 * 
 */
package com.bunnyinc.test.api.bunny;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Rodrigo Torres
 *
 */
public class BunnyServiceImplTest {
	
	BunnyService service;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		service = new BunnyServiceImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.bunnyinc.test.api.bunny.BunnyServiceImpl#postProject()}.
	 */
	@Test
	public void testPostProject() {
		//params.put("script", "Hello world.");
        //params.put("title", "JTorres Test Project");
		String result = null;
		try {
			result = service.postProject("Hello world.", "JTorres Test Project");
		} catch (MalformedURLException e) {
			System.err.println(e.getMessage());
			fail();
		} catch (ProtocolException e) {
			System.err.println(e.getMessage());
			fail();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			fail();
		}finally{
			System.out.println(
					"Result: \n"+result
			);
		}
	}

	/**
	 * Test method for {@link com.bunnyinc.test.api.bunny.BunnyServiceImpl#getProject(java.lang.String)}.
	 */
	@Test
	public void testGetProject() {
		String projectId = "750B831AEECD599DB181";
		
		String result = null;
		try {
			result = service.getProject(projectId);
		} catch (MalformedURLException e) {
			System.err.println(e.getMessage());
			fail();
		} catch (ProtocolException e) {
			System.err.println(e.getMessage());
			fail();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			fail();
		}finally{
			System.out.println(
					"Result: \n"+result
			);
		}
	}
	
	/**
	 * Test method for {@link com.bunnyinc.test.api.bunny.BunnyServiceImpl#approveRead(java.lang.String)}.
	 */
	@Test
	public void testApproveRead () {
		
		String readId = "868859";
		
		String result = null;
		try {
			result = service.approveRead(readId);
		} catch (MalformedURLException e) {
			System.err.println(e.getMessage());
			fail();
		} catch (ProtocolException e) {
			System.err.println(e.getMessage());
			fail();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			fail();
		}finally{
			System.out.println(
					"Result: \n"+result
			);
		}
		
	}

}

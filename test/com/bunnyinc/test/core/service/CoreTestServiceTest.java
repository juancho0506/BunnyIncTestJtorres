package com.bunnyinc.test.core.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CoreTestServiceTest {
	
	CoreTestService service;
	@Before
	public void setUp() throws Exception {
		service = new CoreTestService();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExecuteTest() {
		try {
			String res = service.executeTest("Jtorres Test 2");
			System.out.println(res);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			fail();
		}
	}

}

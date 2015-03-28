/**
 * 
 */
package com.bunnyinc.test.api.external;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Rodrigo
 *
 */
public class ExternalServiceImplTest {
	
	ExternalService service;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		service = new ExternalServiceImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.bunnyinc.test.api.external.ExternalServiceImpl#getRandomQuote()}.
	 */
	@Test
	public void testGetRandomQuote() {
		String result = null;
		try {
			result = service.getRandomQuote();
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

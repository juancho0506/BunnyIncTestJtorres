/**
 * 
 */
package com.bunnyinc.test.api.external;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

/**
 * @author Rodrigo
 *
 */
public interface ExternalService {
	
	String getRandomQuote() throws MalformedURLException, IOException, ProtocolException;;

}

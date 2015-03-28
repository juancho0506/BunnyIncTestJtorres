/**
 * 
 */
package com.bunnyinc.test.api.bunny;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;


/**
 * @author Rodrigo
 * Class that uses the API of bunny inc with REST services.
 */
public interface BunnyService {
	
    /**
     * Set up and posts a quick project to voice bunny.
     * @return
     * @throws ProtocolException 
     * @throws IOException 
     * @throws MalformedURLException 
     */
	
    String postProject(String script, String title) throws MalformedURLException, IOException, ProtocolException;
    
    /**
     * Gives the infomation of a project given de id.
     * @param id of the project
     * @return 
     * @throws MalformedURLException
     * @throws IOException
     * @throws ProtocolException
     */
    String getProject(String id) throws MalformedURLException, IOException, ProtocolException;
    
    /**
     * Approves the recording to be published and the project can be disposed.
     * @param id The id of the project
     * @return The result response
     * @throws UnsupportedEncodingException
     * @throws MalformedURLException
     * @throws ProtocolException
     * @throws IOException
     */
    String approveRead(String id) throws UnsupportedEncodingException, MalformedURLException, ProtocolException, IOException;
    
}

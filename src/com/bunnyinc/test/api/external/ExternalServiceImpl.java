/**
 * 
 */
package com.bunnyinc.test.api.external;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * @author Rodrigo
 *
 */
public class ExternalServiceImpl implements ExternalService {
	
	 private String host = "http://www.iheartquotes.com/api/v1/random";
	 

	/**
	 * Default constructor
	 */
	public ExternalServiceImpl() {
		
	}



	/* (non-Javadoc)
	 * @see com.bunnyinc.test.api.external.ExternalService#getRandomQuote()
	 */
	@Override
	public String getRandomQuote() throws MalformedURLException, IOException,
			ProtocolException {
		return get("");
	}
	
	/**
	 * Implements the get method obtain the info of a project previously sent to the rest api of voice bunny. 
	 * @param resource
	 * @return
	 * @throws IOException
	 * @throws ProtocolException
	 */
    private String get(String resource) throws IOException, ProtocolException {
        URL url = new URL(host + "/" + resource);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        InputStream in = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuffer sb = new StringBuffer();
        String line = "";
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        return sb.toString();
    }

}

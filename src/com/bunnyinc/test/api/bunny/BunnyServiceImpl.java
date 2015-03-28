/**
 * 
 */
package com.bunnyinc.test.api.bunny;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.codec.binary.Base64;

/**
 * @author Rodrigo Torres
 * Class that implements the API services of BunnyInc Rest API.
 */
public class BunnyServiceImpl implements BunnyService{
	
	private String user = "46645";
    private String token = "a3b264e208e353974bf4d7f430194c81";
    private String encodedAuthorization = "";
    private String host = "https://api.voicebunny.com";
    
    
	/**
	 * The default constructor
	 */
	public BunnyServiceImpl() {
		String userpassword = user + ":" + token;
        encodedAuthorization = Base64.encodeBase64String(userpassword.getBytes());
	}
	@Override
	public String postProject(String script, String title) throws MalformedURLException, IOException, ProtocolException{
		Map<String, String> params = new HashMap<String, String>();
        //params.put("script", "Hello world.");
        //params.put("title", "JTorres Test Project");
		params.put("script", script);
        params.put("title", title);
        params.put("test", "true");
        params.put("ping", "juanro.toes@gmail.com");
        return post("projects/addSpeedy", params);
	}
	
	/**
     * Implements the post method to send the data to the rest api of voice bunny.
     * @param resource The method to call from the api.
     * @param params the params to be sended to the api service.
     * @return a String with the result of the creation of the project.
     * @throws ProtocolException 
     * @throws IOException 
     * @throws MalformedURLException 
     * @throws UnsupportedEncodingException 
     */
	private String post(String resource, Map<String, String> params) throws UnsupportedEncodingException, MalformedURLException, IOException, ProtocolException{
		String data = "";
        for (Entry<String, String> entry : params.entrySet()) {
            if (!data.isEmpty()) {
                data += "&";
            }
            data += (URLEncoder.encode(entry.getKey(), "UTF-8") + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        URL url = new URL(host + "/" + resource);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", "Basic " + encodedAuthorization);
        connection.setDoOutput(true);
        //connection.connect();
        OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
        wr.write(data);
        wr.flush();
        InputStream in = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuffer sb = new StringBuffer();
        String line = "";
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        wr.close();
        reader.close();
        return sb.toString();
	}
    
	public String getProject(String id) throws MalformedURLException, IOException, ProtocolException {
        return get("projects/" + id);
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
        connection.setRequestProperty("Authorization", "Basic " + encodedAuthorization);
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
    
    public String approveRead(String id) throws UnsupportedEncodingException, MalformedURLException, ProtocolException, IOException {
        Map<String, String> params = new HashMap<String, String>();
        return post("reads/approve/" + id, params);
    }

}

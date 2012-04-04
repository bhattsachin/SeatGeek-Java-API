package com.bhatt.seakgeek.util;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;


public class Client {
	
	//static HttpClient httpclient = new DefaultHttpClient();
	
	public String fetchUrl(final String url) throws Exception{
		HttpClient httpclient = new DefaultHttpClient();
		String body;
		try{
			HttpGet httpget = new HttpGet(url);
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			body = httpclient.execute(httpget, responseHandler);
		}catch(Exception ex){
			throw ex;
		}finally{
			httpclient.getConnectionManager().shutdown();
		}
		
		return body;
		
	}
	
	public static void main(String args[]){
		
		Client cli = new Client();
		try{
			System.out.println(cli.fetchUrl("http://api.seatgeek.com/2/venues?city=buffalo"));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

}



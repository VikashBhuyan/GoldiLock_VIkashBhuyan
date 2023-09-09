package com.goldilock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
	public static void main(String[]args) {
		String Url =  "http://127.0.0.1:8999/test?value=p" ;
		
		try {
			URL u = new URL(Url);
			HttpURLConnection con = (HttpURLConnection)u.openConnection();
			con.setRequestMethod("GET");
			int code = con.getResponseCode();
			
			if(code==HttpURLConnection.HTTP_OK) {
				BufferedReader r1 = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String l = r1.readLine();
				String ans ="";
				while(l!=null){
					ans+=l;
				}
				r1.close();
				System.out.println("Output :"+ans);
			}else {
				System.out.println("Something Went Wrong/Server not running");
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

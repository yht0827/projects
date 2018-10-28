package com.web.util;

import javax.servlet.http.Cookie;

public class CookieManager {

	public static String getCookie(Cookie[] coos,String key){
		
		if(coos!=null){
			for(Cookie ck : coos){
				if(ck.getName().equals(key)){
				    return ck.getValue();
				}
			}
		}
		return "";
	}
}
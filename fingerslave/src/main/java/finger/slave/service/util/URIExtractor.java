package finger.slave.service.util;

import java.net.*;

public class URIExtractor{
	
	public static boolean isRelativePath(String uri){
		if(uri.isEmpty()) return true;
		return uri.charAt(0) == '/';
	}
	
	public static String getHost(String uri){
		try{
			return new URI(uri).getHost();
		}catch(URISyntaxException USE){
			USE.printStackTrace();
		}
		return "";
	}
	
	public static String getProtocol(String uri){
		try{
			return new URI(uri).getScheme() + "://";
		}catch(URISyntaxException USE){
			USE.printStackTrace();
		}
		return "";
	}
	
}
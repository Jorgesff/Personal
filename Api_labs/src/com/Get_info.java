package com;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.scope.ScopeBuilder;
import com.restfb.scope.UserDataPermissions;

public class Get_info {
	
	private final static String appId = "863709503695545";
	
	public static String get_token(){
		ScopeBuilder scope = new ScopeBuilder();
		scope.addPermission(UserDataPermissions.USER_ABOUT_ME);
		FacebookClient client = new DefaultFacebookClient(Version.VERSION_2_3);
		String loginDialogUrlString = client.getLoginDialogUrl(appId, "https://www.facebook.com/connect/login_success.html.", scope);
		return loginDialogUrlString;
	}
	public static void ConnectFB(){
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

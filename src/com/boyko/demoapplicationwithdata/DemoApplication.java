package com.boyko.demoapplicationwithdata;

import android.app.Application;

public class DemoApplication extends Application {

	private static DemoApplication demoApplicationInstance;
	
	private String networkStatus;
	
	@Override
	public void onCreate() {
		super.onCreate();
		demoApplicationInstance = this;
	}
	
	public static DemoApplication getDemoApplicationInstance() {
		return demoApplicationInstance;
	}
	
	public String getNetworkStatus() {
		return networkStatus;
	}
	
	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
	}
}

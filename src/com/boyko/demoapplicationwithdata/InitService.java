package com.boyko.demoapplicationwithdata;

import android.app.IntentService;
import android.content.Intent;

public class InitService extends IntentService {
	public static final String EXTRA_NETWORK_STATUS = "EXTRA_NETWORK_STATUS";
	public static final String ACTION_UPDATE_NETWORK_STATE = "ACTION_UPDATE_NETWORK_STATE";

	public InitService() {
		super("InitService");
	}

	@Override
	public void onCreate() {
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		if (intent != null && intent.getStringExtra(NetworkConnectivityReceiver.NETWORK) != null) {
			String currentNetworkState = intent.getStringExtra(NetworkConnectivityReceiver.NETWORK);
			DemoApplication.getDemoApplicationInstance().setNetworkStatus(currentNetworkState);
			
			Intent intentBr = new Intent(ACTION_UPDATE_NETWORK_STATE);
			intentBr.putExtra(EXTRA_NETWORK_STATUS, currentNetworkState);
			sendBroadcast(intentBr);
		}
	}

}

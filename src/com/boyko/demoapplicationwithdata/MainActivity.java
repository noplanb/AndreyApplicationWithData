package com.boyko.demoapplicationwithdata;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView twLabel;
	private NetworkStateStatusReceiver networkStatusBrodcastReceiver;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		twLabel = (TextView)findViewById(R.id.tw_label);
		twLabel.setText("Initialization...");
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		networkStatusBrodcastReceiver = new NetworkStateStatusReceiver();
		IntentFilter filter = new IntentFilter(InitService.ACTION_UPDATE_NETWORK_STATE);
		registerReceiver(networkStatusBrodcastReceiver , filter );
		
		String ns = DemoApplication.getDemoApplicationInstance().getNetworkStatus();
		if(ns!=null){
			twLabel.setText(ns);
		}
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		unregisterReceiver(networkStatusBrodcastReceiver);
	}
	
	private class NetworkStateStatusReceiver extends BroadcastReceiver{
		@Override
		public void onReceive(Context context, Intent intent) {
			String stringExtra = intent.getStringExtra(InitService.EXTRA_NETWORK_STATUS);
			if(stringExtra!=null){
				twLabel.setText(stringExtra);
			}
		}
	}
}

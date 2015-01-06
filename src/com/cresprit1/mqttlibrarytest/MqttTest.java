package com.cresprit1.mqttlibrarytest;


import java.util.Vector;

import org.eclipse.paho.client.mqttv3.MqttException;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;







import com.cresprit.mqtt_sdk.IUpdateListener;
//import com.cresprit.mqttlibrarytest.R;
import com.cresprit.mqtt_sdk.MQTTSDK;;

public class MqttTest extends Activity {
	String LoginKey = null;
	Vector<MQTTSDK.DeviceInfo> deviceinfo = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mqtt_test_layout);
		new task().execute("");
		Log.i("","LoginKey : "+LoginKey);
	}

	class task extends AsyncTask{

		@Override
		protected Object doInBackground(Object... params) {
			// TODO Auto-generated method stub
			LoginKey = MQTTSDK.LogIn("tough45@naver.com", "aaaaaa");
			Log.i("","LoginKey : "+LoginKey);
			int result=0;
			deviceinfo = MQTTSDK.getDeviceList();
			MQTTSDK.Subscribe(MqttTest.this, deviceinfo.get(0).getDeviceName(), _listener);
			//result=  MQTTSDK.Publish("tesal", "test");
			Log.i("","LoginKey : "+LoginKey+" result : "+result);
			
			return null;
		}
		
	}
	
	IUpdateListener _listener = new IUpdateListener()
	{

		public void update(String arg0) {
			// TODO Auto-generated method stub
			Log.i("",""+arg0);
		}
		
	};
}

package com.example.myqrscanner;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void onClickToScan(View v)
	{
		IntentIntegrator integrator = new IntentIntegrator(this);
		integrator.initiateScan();		
	}
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent)
	{
			IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
			if (scanResult != null) 
			{
				String result = scanResult.getContents();
				Log.i("String From Qr Code Scanned", result);
				Toast.makeText(getBaseContext(), result, 1000);
			}
	}
	
	public void CreateQR(View V)
	{
		EditText mytxt = (EditText) findViewById(R.id.editText1);
		//initialization
		IntentIntegrator integrator = new IntentIntegrator(this);
		//Generate QR
		Log.i("String From Qr Code Scanned", mytxt.getText().toString());
		integrator.shareText(mytxt.getText().toString());
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}

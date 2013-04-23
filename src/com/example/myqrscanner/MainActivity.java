package com.example.myqrscanner;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

//import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.*;
//import android.webkit.URLUtil;
import android.widget.*;
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.util.Log;
//import android.widget.EditText;


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
			
			TextView output = (TextView) findViewById (R.id.result);
			
			if (scanResult != null) 
			{
				String result = scanResult.getContents();
				output.setText(result);
				/*if(result!="")
				{
					if(URLUtil.isNetworkUrl(result))
					{
			            //mMakeTextToast(result, true);
			            Uri mUri = Uri.parse(result);
			            Intent intent1 = new Intent(Intent.ACTION_VIEW, mUri);
			            startActivity(intent1);
					}
				}*/
			}
	}
}

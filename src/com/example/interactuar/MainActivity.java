package com.example.interactuar;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void navegador(View view) {
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.android.com"));
		startActivity(intent);
	}
	
	public void mapa(View view) {
		try {
			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:23.626240,-99.074707?z=8"));
			startActivity(intent);
		} catch (Exception e) {
			Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
		}
	}
	
	public void email(View view) {
		Intent intent = new Intent(Intent.ACTION_SEND);
		
		intent.setType("message/rfc822");
		intent.putExtra(Intent.EXTRA_EMAIL  , new String[]{"jma_hernandez@hotmail.com"});
		intent.putExtra(Intent.EXTRA_SUBJECT, "Probando SMS");
		intent.putExtra(Intent.EXTRA_TEXT   , "Listo");
		
		try {
		    startActivity(Intent.createChooser(intent, "Enviar mail ..."));
		} catch (android.content.ActivityNotFoundException ex) {
		    Toast.makeText(this, "No hay cliente de email instalado", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void sms(View view) {
		String phoneNumber = "5556";
	    String message = "Hola, como estas ?";

	    SmsManager smsManager = SmsManager.getDefault();
	    smsManager.sendTextMessage(phoneNumber, null, message, null, null);
	}
	
	public void foto(View view) {
		Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(takePictureIntent, 0);
	}

}

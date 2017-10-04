package dz.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;

public class On extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		try {
			Settings.System.putInt(getContentResolver(),
					Settings.System.AIRPLANE_MODE_ON, 1);
			Intent i = new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
			i.putExtra("state", true); // toggle is an boolean
										// primitive.
			On.this.sendBroadcast(i);
			finish();
		} catch (Exception e) {
			Log.e("AIRPLANE", e.getMessage());
		}
	}
}

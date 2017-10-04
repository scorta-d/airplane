package dz.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class AirplaneActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);
		final Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				try {
					Settings.System.putInt(getContentResolver(),
							Settings.System.AIRPLANE_MODE_ON, 1);
					Intent i = new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
					i.putExtra("state", true); // toggle is an boolean
												// primitive.
					AirplaneActivity.this.sendBroadcast(i);
				} catch (Exception e) {
					Log.e("AIRPLANE", e.getMessage());
				}

			}
		});

		final Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				try {
					Settings.System.putInt(getContentResolver(),
							Settings.System.AIRPLANE_MODE_ON, 0);
					Intent i = new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
					i.putExtra("state", false); // toggle is an boolean
												// primitive.
					AirplaneActivity.this.sendBroadcast(i);
				} catch (Exception e) {
					Log.e("AIRPLANE", e.getMessage());
				}

			}
		});

	}
}
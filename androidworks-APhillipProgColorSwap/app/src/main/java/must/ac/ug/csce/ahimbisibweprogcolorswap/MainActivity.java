package must.ac.ug.csce.ahimbisibweprogcolorswap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Receiver phillip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button buttontapMe = findViewById(R.id.pressbutton);
        final TextView newColor = findViewById(R.id.newColor);

        // Receive broadcast from External App
        IntentFilter intentFilter = new IntentFilter("com.must.ac.ug.csce.ahimbisibweprogcolorswap");
        phillip = new Receiver();
        registerReceiver(phillip, intentFilter);

        buttontapMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random random = new Random();
                int r = random.nextInt(255);
                int g = random.nextInt(255);
                int b = random.nextInt(255);

                int textTrueColor = Color.rgb(r, g, b);

                newColor.setTextColor(textTrueColor);
                newColor.setText("COLOR: "+ Integer.toString(r)+ "r, "+ Integer.toString(g)+ "g, " + Integer.toString(b)+ "b");
            }
        });

    }
}

class Receiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String message = intent.getStringExtra("message");

        if (intent.getAction().equals("com.must.ac.ug.csce.ahimbisibweprogcolorswap")) {
            // Display message
            Toast.makeText(context, "" + message + "New Broad cast", Toast.LENGTH_LONG).show();
        }


    }
}

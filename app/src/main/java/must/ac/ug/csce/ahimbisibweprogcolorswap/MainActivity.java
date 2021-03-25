package must.ac.ug.csce.ahimbisibweprogcolorswap;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttontapMe = findViewById(R.id.pressbutton);
        final TextView newColor = findViewById(R.id.newColor);

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
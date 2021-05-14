package must.ac.ug.csce.aphilllipxmlcolorswap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button tapMebutton = findViewById(R.id.pressButton);

        final TextView newColor = findViewById(R.id.newColor);

        List<Integer> colors = new ArrayList<>();
        colors.add(getResources().getColor(R.color.blue));
        colors.add(getResources().getColor(R.color.black));
        colors.add(getResources().getColor(R.color.teal_700));
        colors.add(getResources().getColor(R.color.teal_200));
        colors.add(getResources().getColor(R.color.purple_700));
        colors.add(getResources().getColor(R.color.purple_500));
        colors.add(getResources().getColor(R.color.purple_200));
        colors.add(getResources().getColor(R.color.yellow));
        colors.add(getResources().getColor(R.color.red));
        colors.add(getResources().getColor(R.color.darkorange));
        colors.add(getResources().getColor(R.color.green));
        colors.add(getResources().getColor(R.color.purple));

        colors.add(getResources().getColor(R.color.pink));



        tapMebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tapMebutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int color = randomColor();
                        if(newColor.getCurrentTextColor() != color){
                            newColor.setTextColor(color);
                        }else{
                            newColor.setTextColor(randomColor());
                        }
                    }
                });


                String message="Broadcast Message";

                String p = "A Broad cast Message";
                Intent intent = new Intent();
                intent.setAction("com.must.ac.ug.csce.ahimbisibweprogcolorswap");
                intent.putExtra("message",p);
                intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);

                sendBroadcast(intent);

            }

            private int randomColor(){
                Random rand = new Random();
                return colors.get(rand.nextInt(colors.size()));

            }
        });
    }
}
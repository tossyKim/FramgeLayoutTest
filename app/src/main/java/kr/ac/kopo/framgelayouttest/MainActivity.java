package kr.ac.kopo.framgelayouttest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearSpring, linearSummer, linearFall, linearWinter;
    Button btnSpring, btnSummer, btnFall, btnWinter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        linearSpring = findViewById(R.id.linear_spring);
        linearSummer = findViewById(R.id.linear_summer);
        linearFall = findViewById(R.id.linear_fall);
        linearWinter = findViewById(R.id.linear_winter);

        btnSpring = findViewById(R.id.btn_spring);
        btnSummer = findViewById(R.id.btn_summer);
        btnFall = findViewById(R.id.btn_fall);
        btnWinter = findViewById(R.id.btn_winter);

        btnSpring.setOnClickListener(btnListener);
        btnSummer.setOnClickListener(btnListener);
        btnFall.setOnClickListener(btnListener);
        btnWinter.setOnClickListener(btnListener);
    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            linearSpring.setVisibility(View.INVISIBLE);
            linearSummer.setVisibility(View.INVISIBLE);
            linearFall.setVisibility(View.INVISIBLE);
            linearWinter.setVisibility(View.INVISIBLE);
            Button btnEvent = (Button) v;
            if(btnEvent == btnSpring){
                linearSpring.setVisibility(View.VISIBLE);
            }
            else if(btnEvent == btnSummer){
                linearSummer.setVisibility(View.VISIBLE);
            }
            else if(btnEvent == btnFall){
                linearFall.setVisibility(View.VISIBLE);
            }
            else{
                linearWinter.setVisibility(View.VISIBLE);
            }
        }
    };
}
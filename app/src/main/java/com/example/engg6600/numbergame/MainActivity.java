package com.example.engg6600.numbergame;



import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.util.*;

public class MainActivity extends Activity {
    private int Number1;
    private int Number2;
    private int points;


    public void clickButton1(View view) {
        compare(Number1, Number2);
    }


    public void clickButton2(View view) {
        compare(Number2, Number1);
    }


    private void compare(int x, int y) {
        if (x > y) {
            points++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            points--;
            Toast.makeText(this, "Uhhh..so close!", Toast.LENGTH_SHORT).show();
        }

        TextView pointsView = (TextView) findViewById(R.id.pointsTextView);
        pointsView.setText("Points: " + points);
        randomNumbers();
    }


    private void randomNumbers() {
        Random r = new Random();
        Number1 = r.nextInt(9);
        Number2 = r.nextInt(9);
        while (Number2 == Number1) {
            Number2 = r.nextInt(9);
        }

        Button left = (Button) findViewById(R.id.buttonLeft);
        left.setText("" + Number1);

        Button right = (Button) findViewById(R.id.buttonRight);
        right.setText("" + Number2);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomNumbers();
    }
}

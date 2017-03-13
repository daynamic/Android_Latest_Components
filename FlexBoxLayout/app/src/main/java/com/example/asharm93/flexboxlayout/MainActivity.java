package com.example.asharm93.flexboxlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.flexbox.FlexboxLayout;

public class MainActivity extends AppCompatActivity {
   // private FlexboxLayout mFlexboxLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //   mFlexboxLayout = (FlexboxLayout) findViewById(R.id.flexbox_layout);
    }
    public void flexboxLayout1(View view) {
        Intent intent = new Intent(getApplicationContext(), FlexBoxActivity1.class);
        startActivity(intent);
    }

    public void flexboxLayout2(View view) {
        Intent intent1 = new Intent(getApplicationContext(), FlexBoxActivity2.class);
        startActivity(intent1);
    }

    public void flexboxLayout3(View view) {
        Intent intent2 = new Intent(getApplicationContext(), FlexBoxActivity3.class);
        startActivity(intent2);
    }

}

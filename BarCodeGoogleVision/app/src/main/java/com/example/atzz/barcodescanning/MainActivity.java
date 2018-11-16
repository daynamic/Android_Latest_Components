package com.example.atzz.barcodescanning;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.atzz.barcodescanning.Fragments.BarCodeFragment;
import com.example.atzz.barcodescanning.Fragments.YourQRFragment;
import com.example.atzz.barcodescanning.Interface.OnFragmentInteractionListener;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeFragment(1);
    }

    @Override
    public void changeFragment(int id){
        if (id == 1) {
            YourQRFragment fragment = new YourQRFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, fragment);
            ft.commit();
        }
        else if (id == 2) {
            BarCodeFragment fragment = new BarCodeFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, fragment);
            ft.commit();
        }
    }
}

package com.example.atzz.barcodescanning.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.atzz.barcodescanning.Interface.OnFragmentInteractionListener;
import com.example.atzz.barcodescanning.R;

public class YourQRFragment extends Fragment {
    Button chng_frag;
    ImageView change_Toscan,change_Myscan;
    private OnFragmentInteractionListener mListener;
    public YourQRFragment() {
        // Required empty public constructor
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.your_qr_fragment, container,
                false);
        change_Toscan= (ImageView)view.findViewById(R.id.imageView2);
        change_Toscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.changeFragment(2);
            }
        });
        change_Myscan=(ImageView)view.findViewById(R.id.imageView);
        change_Myscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Already on My Scan", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;

    }

}

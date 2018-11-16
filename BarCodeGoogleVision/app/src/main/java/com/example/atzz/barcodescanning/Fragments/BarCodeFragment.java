package com.example.atzz.barcodescanning.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.atzz.barcodescanning.Interface.OnFragmentInteractionListener;
import com.example.atzz.barcodescanning.R;
import com.google.android.gms.vision.barcode.Barcode;

import java.util.List;

public class BarCodeFragment extends Fragment implements BarcodeReaderFragment.BarcodeReaderListener {
    private OnFragmentInteractionListener mListener;

    private String TAG="FirstCapAppBarcodeReaderFragment";

    private BarcodeReaderFragment barcodeReader;

    public BarCodeFragment() {
        // Required empty public constructor
    }
    public static BarCodeFragment newInstance() {
        Bundle args = new Bundle();
        BarCodeFragment fragment = new BarCodeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.barcode_fragment, container,
                false);

        barcodeReader = (BarcodeReaderFragment) getChildFragmentManager().findFragmentById(R.id.barcode_fragment);
        barcodeReader.setListener(this);

        View footerLayout = view.findViewById(R.id.footer);
        ImageView img_cross= (ImageView)footerLayout.findViewById(R.id.imageView3) ;
        ImageView your_QR=(ImageView)footerLayout.findViewById(R.id.imageView);
        ImageView scan_QR=(ImageView)footerLayout.findViewById(R.id.imageView2);
        img_cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "clicked on cross", Toast.LENGTH_SHORT).show();
            }
        });

        your_QR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mListener.changeFragment(1);
            }
        });
        scan_QR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "You are already on Scan QR", Toast.LENGTH_SHORT).show();
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
    public void onScanned(final Barcode barcode) {
        Log.e(TAG, "onScanned: " + barcode.displayValue);
        barcodeReader.playBeep();
        try {
            Toast.makeText(getActivity(), "Barcode: " + barcode.displayValue, Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onScannedMultiple(List<Barcode> barcodes) {
        Log.e(TAG, "onScannedMultiple: " + barcodes.size());

        String codes = "";
        for (Barcode barcode : barcodes) {
            codes += barcode.displayValue + ", ";
        }

        final String finalCodes = codes;
        Toast.makeText(getActivity(), "Barcodes: " + finalCodes, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {

    }

    @Override
    public void onScanError(String errorMessage) {
        Log.e(TAG, "onScanError: " + errorMessage);
    }

    @Override
    public void onCameraPermissionDenied() {
        Toast.makeText(getActivity(), "Camera permission denied!", Toast.LENGTH_LONG).show();
    }
}

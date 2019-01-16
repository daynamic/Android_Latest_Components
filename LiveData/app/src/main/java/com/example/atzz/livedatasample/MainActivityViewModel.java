package com.example.atzz.livedatasample;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class MainActivityViewModel extends ViewModel {
    private String TAG = MainActivityViewModel.class.getSimpleName();

    private MutableLiveData<List<String>> fruitList;

    LiveData<List<String>> getFruitList() {
        if (fruitList == null) {
            fruitList = new MutableLiveData<>();
            loadFruits();
        }
        return fruitList;
    }

    private void loadFruits() {
        // do async operation to fetch users
        Handler myHandler = new Handler() {
        };
        myHandler.postDelayed(() -> {
            List<String> fruitsStringList = new ArrayList<>();
            fruitsStringList.add("Mango");
            fruitsStringList.add("Apple");
            fruitsStringList.add("Orange");
            fruitsStringList.add("Banana");
            fruitsStringList.add("Grapes");
            long seed = System.nanoTime();
            Collections.shuffle(fruitsStringList, new Random(seed));

            fruitList.setValue(fruitsStringList);
        }, 5000);

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "on cleared called");
    }

}

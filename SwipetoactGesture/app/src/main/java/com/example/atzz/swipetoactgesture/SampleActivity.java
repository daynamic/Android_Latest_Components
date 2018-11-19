package com.example.atzz.swipetoactgesture;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SampleActivity extends AppCompatActivity {
    public static final String EXTRA_PRESSED_BUTTON = "extra_pressed_button";
    private List<com.example.atzz.swipetoactgesture.View.View> mSlideList;
    private SimpleDateFormat dateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        final int pressedButton = getIntent().getExtras().getInt(EXTRA_PRESSED_BUTTON, 0);
        dateFormat = new SimpleDateFormat("HH:mm:ss", getResources().getConfiguration().locale);

        switch (pressedButton) {
            case R.id.button_area_margin:
                setContentView(R.layout.content_area_margin);
                break;
            case R.id.button_colors:
                setContentView(R.layout.content_color);
                break;
            case R.id.button_border_radius:
                setContentView(R.layout.content_border_radius);
                break;
            case R.id.button_elevation:
                setContentView(R.layout.content_elevation);
                break;
            case R.id.button_text_size:
                setContentView(R.layout.content_text_size);
                break;
            case R.id.button_slider_dimension:
                setContentView(R.layout.content_slider_dimensions);
                break;
            case R.id.button_event_callbacks:
                setContentView(R.layout.content_event_callbacks);
                //setupEventCallbacks();
                break;
            case R.id.button_locked_slider:
                setContentView(R.layout.content_locked_slider);
                break;
            case R.id.button_custom_icon:
                setContentView(R.layout.content_custom_icon);
                break;
            default:
                finish();
                break;
        }
        mSlideList = getSlideList();

    }

    private List<com.example.atzz.swipetoactgesture.View.View> getSlideList() {
        final List<com.example.atzz.swipetoactgesture.View.View> slideList = new ArrayList<>();
        final LinearLayout container = findViewById(R.id.slide_container);
        for (int i = 0; i < container.getChildCount(); i++) {
            final View child = container.getChildAt(i);
            if (child instanceof com.example.atzz.swipetoactgesture.View.View) {
                slideList.add((com.example.atzz.swipetoactgesture.View.View) child);
            }
        }
        return slideList;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.reset:
                for (com.example.atzz.swipetoactgesture.View.View slide : mSlideList) {
                    slide.resetSlider();
                }
                return true;
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    /*private void setupEventCallbacks() {
        final com.example.atzz.swipetoactgesture.View.View slide = findViewById(R.id.event_slider);
        final TextView log = findViewById(R.id.event_log);
        slide.setOnSlideCompleteListener(new com.example.atzz.swipetoactgesture.View.OnSlideCompleteListener() {
            @Override
            public void onSlideComplete(@NonNull com.example.atzz.swipetoactgesture.View.View  view) {
                log.append("\n" + getTime() + " onSlideComplete");
            }
        });
        slide.setOnSlideResetListener(new com.example.atzz.swipetoactgesture.View.View.OnSlideResetListener() {
            @Override
            public void onSlideReset(@NonNull com.example.atzz.swipetoactgesture.View.View  view) {
                log.append("\n" + getTime() + " onSlideReset");
            }
        });
        slide.setOnSlideUserFailedListener(new com.example.atzz.swipetoactgesture.View.View.OnSlideUserFailedListener() {
            @Override
            public void onSlideFailed(@NonNull com.example.atzz.swipetoactgesture.View.View  view, boolean isOutside) {
                log.append("\n" + getTime() + " onSlideUserFailed - Clicked outside: " + isOutside);
            }
        });
        slide.setOnSlideToActAnimationEventListener(new com.example.atzz.swipetoactgesture.View.View.OnSlideToActAnimationEventListener() {
            @Override
            public void onSlideCompleteAnimationStarted(@NonNull com.example.atzz.swipetoactgesture.View.View  view, float threshold) {
                log.append("\n" + getTime() + " onSlideCompleteAnimationStarted - " + threshold + "");
            }

            @Override
            public void onSlideCompleteAnimationEnded(@NonNull com.example.atzz.swipetoactgesture.View.View  view) {
                log.append("\n" + getTime() + " onSlideCompleteAnimationEnded");
            }

            @Override
            public void onSlideResetAnimationStarted(@NonNull com.example.atzz.swipetoactgesture.View.View  view) {
                log.append("\n" + getTime() + " onSlideResetAnimationStarted");
            }

            @Override
            public void onSlideResetAnimationEnded(@NonNull com.example.atzz.swipetoactgesture.View.View  view) {
                log.append("\n" + getTime() + " onSlideResetAnimationEnded");
            }
        });
    }*/

    private String getTime() {
        return dateFormat.format(new Date());
    }
}

package com.raywenderlich.alltherecipes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class RecipeDetailActivity extends AppCompatActivity {
    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        // 1
        String title = this.getIntent().getExtras().getString("title");
        String url = this.getIntent().getExtras().getString("url");

// 2
        setTitle(title);

// 3
        mWebView = (WebView) findViewById(R.id.detail_web_view);

// 4
        mWebView.loadUrl(url);
    }
}

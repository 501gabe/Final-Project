package com.gabe.android.aca.snoozecamp;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class UpcomingEventsActivity extends MainActivity{

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_events);

        mWebView  = new WebView(this);

        mWebView.getSettings().setJavaScriptEnabled(true); // enable javascript

        final Activity activity = this;

        mWebView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
        });

        mWebView .loadUrl("http://www.snoozecamp.com/events/");
        setContentView(mWebView );

    }
    }


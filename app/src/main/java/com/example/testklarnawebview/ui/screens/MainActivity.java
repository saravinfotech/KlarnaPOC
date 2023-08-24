package com.example.testklarnawebview.ui.screens;

import static com.example.testklarnawebview.utilities.Constants.getTAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testklarnawebview.R;
import com.example.testklarnawebview.callbacks.KlarnaHybridSDKCallback;
import com.example.testklarnawebview.ui.components.MyWebViewClient;
import com.klarna.mobile.sdk.KlarnaMobileSDKError;
import com.klarna.mobile.sdk.api.KlarnaLoggingLevel;
import com.klarna.mobile.sdk.api.OnCompletion;
import com.klarna.mobile.sdk.api.callback.KlarnaEventCallback;
import com.klarna.mobile.sdk.api.hybrid.KlarnaFullscreenEventCallback;
import com.klarna.mobile.sdk.api.hybrid.KlarnaHybridSDK;

import java.util.Map;


public class MainActivity extends AppCompatActivity implements KlarnaEventCallback, KlarnaFullscreenEventCallback {

    MyWebViewClient webViewClient;
    private WebView webView;
    private KlarnaHybridSDK klarnaHybridSDK;
    //  private Constants constants = Constants.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize KlarnaHybridSDK
        klarnaHybridSDK = new KlarnaHybridSDK("https://boots.com", new KlarnaHybridSDKCallback()/*,this,*/);
        klarnaHybridSDK.setLoggingLevel(KlarnaLoggingLevel.Verbose);
        webView = findViewById(R.id.webView);
        webView.setWebViewClient(webViewClient);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.loadUrl("https://www.klarna.com/demo");
        klarnaHybridSDK.addWebView(webView);
    }

    @Override
    public void onErrorOccurred(@NonNull View view, @NonNull KlarnaMobileSDKError klarnaMobileSDKError) {
        Log.i(getTAG(), "********************* onErrorOccurred");
    }

    @Override
    public void onEvent(@NonNull View view, @NonNull String s, @NonNull Map<String, ?> map) {
        Log.i(getTAG(), "********************* onEvent");
    }


    @Override
    public void didHideFullscreenContent(@NonNull WebView webView, @NonNull OnCompletion onCompletion) {
        Log.i(getTAG(), "********************* didHideFullscreenContent");
        onCompletion.run();

    }

    @Override
    public void didShowFullscreenContent(@NonNull WebView webView, @NonNull OnCompletion onCompletion) {
        Log.i(getTAG(), "********************* didShowFullscreenContent");
        onCompletion.run();

    }

    @Override
    public void willHideFullscreenContent(@NonNull WebView webView, @NonNull OnCompletion onCompletion) {
        Log.i(getTAG(), "********************* willHideFullscreenContent");
        onCompletion.run();

    }

    @Override
    public void willShowFullscreenContent(@NonNull WebView webView, @NonNull OnCompletion onCompletion) {
        Log.i(getTAG(), "********************* willShowFullscreenContent");
        onCompletion.run();
    }
}


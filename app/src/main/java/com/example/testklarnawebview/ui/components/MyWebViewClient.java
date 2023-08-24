package com.example.testklarnawebview.ui.components;

import static com.example.testklarnawebview.utilities.Constants.getTAG;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.RequiresApi;

import com.klarna.mobile.sdk.api.hybrid.KlarnaHybridSDK;

public class MyWebViewClient extends WebViewClient {

    KlarnaHybridSDK klarnaHybridSDK;

    public MyWebViewClient(KlarnaHybridSDK klarnaHybridSDK) {
        Log.i(getTAG(), "********************* MyWebViewClient()");
        this.klarnaHybridSDK = klarnaHybridSDK;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Log.i(getTAG(), "********************* MyWebViewClient:shouldOverrideUrlLoading() 1");
        return !klarnaHybridSDK.shouldFollowNavigation(url);

    }

    @Override
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        //return super.shouldOverrideUrlLoading(view, request);
        Log.i(getTAG(), "********************* MyWebViewClient:shouldOverrideUrlLoading()");
        if (request.getUrl().toString() != null) {
            return !klarnaHybridSDK.shouldFollowNavigation(request.getUrl().toString());
        } else {
            return super.shouldOverrideUrlLoading(view, request);
        }
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        Log.i(getTAG(), "********************* MyWebViewClient:onPageFinished()");
        klarnaHybridSDK.newPageLoad(view);
    }

    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        // super.onReceivedSslError(view, handler, error);
        Log.i(getTAG(), "*********************  MyWebViewClient:onReceivedSslError()");

        handler.proceed();
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        //super.onPageStarted(view, url, favicon);
        Log.i(getTAG(), "*********************  MyWebViewClient:onPageStarted()");
    }

    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        // super.onReceivedError(view, request, error);
        Log.i(getTAG(), "*********************  MyWebViewClient:onReceivedError()");
    }

    @Override
    public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
        //super.onReceivedHttpError(view, request, errorResponse);
        Log.i(getTAG(), "*********************  MyWebViewClient:onReceivedHttpError()");
    }

    @Override
    public void onLoadResource(WebView view, String url) {
        Log.i(getTAG(), "*********************  MyWebViewClient:onLoadResource()");
        // super.onLoadResource(view, url);
    }
}

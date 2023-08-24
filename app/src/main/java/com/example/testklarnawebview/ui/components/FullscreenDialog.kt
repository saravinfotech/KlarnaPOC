package com.example.testklarnawebview.ui.components


import android.util.Log
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.example.testklarnawebview.utilities.Constants.getTAG
import com.klarna.mobile.sdk.api.OnCompletion
import com.klarna.mobile.sdk.api.hybrid.KlarnaFullscreenEventCallback

class FullscreenDialog : AppCompatActivity(), KlarnaFullscreenEventCallback {
    // ...
    override fun willShowFullscreenContent(webView: WebView, completion: OnCompletion) {
        Log.i(
            getTAG(), "********************* FullscreenDialog:willShowFullscreenContent "
        )
        completion.run()
    }

    override fun didShowFullscreenContent(webView: WebView, completion: OnCompletion) {
        Log.i(
            getTAG(), "********************* FullscreenDialog:didShowFullscreenContent "
        )
        completion.run()
    }

    override fun willHideFullscreenContent(webView: WebView, completion: OnCompletion) {
        Log.i(
            getTAG(), "********************* FullscreenDialog:willHideFullscreenContent "
        )
        completion.run()
    }

    override fun didHideFullscreenContent(webView: WebView, completion: OnCompletion) {
        Log.i(
            getTAG(), "********************* FullscreenDialog:didHideFullscreenContent "
        )
        completion.run()
    }
}
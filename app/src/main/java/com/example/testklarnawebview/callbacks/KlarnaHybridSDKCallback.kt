package com.example.testklarnawebview.callbacks

import android.util.Log
import android.webkit.WebView
import android.widget.Toast
import com.example.testklarnawebview.ui.components.FullscreenDialog
import com.example.testklarnawebview.utilities.Constants.getTAG
import com.klarna.mobile.sdk.KlarnaMobileSDKError
import com.klarna.mobile.sdk.api.OnCompletion
import com.klarna.mobile.sdk.api.hybrid.KlarnaHybridSDKCallback

/**
 * Implementation of the [KlarnaHybridSDKCallback]
 */
class KlarnaHybridSDKCallback : KlarnaHybridSDKCallback {

    var fullscreenDialog: FullscreenDialog? = null

    override fun willShowFullscreenContent(webView: WebView, completion: OnCompletion) {
        Log.i(getTAG(), "********************* KlarnaHybridSDKCallback:willShowFullscreenContent()")
        Toast.makeText(webView.context, "willShowFullscreenContent", Toast.LENGTH_LONG).show()
        completion.run()
    }

    override fun didShowFullscreenContent(webView: WebView, completion: OnCompletion) {
        Log.i(getTAG(), "********************* KlarnaHybridSDKCallback:didShowFullscreenContent()")
        Toast.makeText(webView.context, "didShowFullscreenContent", Toast.LENGTH_LONG).show()
        completion.run()
    }

    override fun willHideFullscreenContent(webView: WebView, completion: OnCompletion) {
        Log.i(getTAG(), "********************* KlarnaHybridSDKCallback:willHideFullscreenContent()")
        Toast.makeText(webView.context, "willHideFullscreenContent", Toast.LENGTH_LONG).show()

        // fullscreenDialog?.prepareToHideContent()

        completion.run()
    }

    override fun didHideFullscreenContent(webView: WebView, completion: OnCompletion) {
        Log.i(getTAG(), "********************* KlarnaHybridSDKCallback:didHideFullscreenContent()")
        Toast.makeText(webView.context, "didHideFullscreenContent", Toast.LENGTH_LONG).show()

        // fullscreenDialog?.hideContent()
        fullscreenDialog = null

        completion.run()
    }

    override fun onErrorOccurred(webView: WebView, error: KlarnaMobileSDKError) {
        Log.i(getTAG(), "********************* KlarnaHybridSDKCallback:onErrorOccurred()")
        Toast.makeText(webView.context, "An error occurred: $error", Toast.LENGTH_LONG).show()
    }
}
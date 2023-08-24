package com.example.testklarnawebview.utilities;

import android.app.Application;

public class Constants extends Application {

    private static Constants constants = null;

    public static synchronized Constants getInstance() {
        if (null == constants) {
            constants = new Constants();
        }
        return constants;
    }

    public static String getTAG() {

        return "TestKlarnaWebview";
    }
}

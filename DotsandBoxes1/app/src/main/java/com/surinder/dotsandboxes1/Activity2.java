package com.surinder.dotsandboxes1;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by navpreet on 3/12/2016.
 */
public class Activity2 extends Activity {
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_layout);
      //  overridePendingTransition(R.animator.enter, R.animator.exit);
    }
}

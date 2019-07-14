package com.hzjason.glesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int mGLESVersion = 0;
    private static final String TAG = "wujian";
    private GLSurfaceView mGLSurfaceView = null;
    private boolean renderset = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        mGLESVersion = configurationInfo.reqGlEsVersion;

        Log.d(TAG, "onCreate: gles version:"+mGLESVersion+", version:"+configurationInfo.getGlEsVersion());

        if(mGLESVersion >= 0x20000) {
            mGLSurfaceView = new GLSurfaceView(this);
            mGLSurfaceView.setEGLContextClientVersion(2);

            mGLSurfaceView.setRenderer(new MyRenderer());
            renderset = true;
            setContentView(mGLSurfaceView);



        } else {
            setContentView(R.layout.activity_main);
            renderset = false;
            Log.e(TAG, "onCreate: OpenGL ES Version is too old!");
        }

    }


    @Override
    protected void onResume() {
        super.onResume();
        if(renderset)
            mGLSurfaceView.onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
        if(renderset)
            mGLSurfaceView.onPause();
    }
}

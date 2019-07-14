package com.hzjason.glesdemo;

import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import static android.opengl.GLES20.*;

public class MyRenderer implements GLSurfaceView.Renderer {
    @Override

    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        //清空屏幕颜色
        glClearColor(1.0f,0.0f,0.5f,1.0f);
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int width, int height) {
        //设置视口大小
        glViewport(0,0,width,height);
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        //清除渲染缓存
        glClear(GL_COLOR_BUFFER_BIT);
    }
}

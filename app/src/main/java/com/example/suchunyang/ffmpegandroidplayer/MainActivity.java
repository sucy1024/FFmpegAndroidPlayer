package com.example.suchunyang.ffmpegandroidplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback{
    final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SurfaceView surfaceView = (SurfaceView) findViewById(R.id.surface_view);
//        SurfaceHolder holder = surfaceView.getHolder();
//        holder.addCallback(this);

        Button button = (Button) findViewById(R.id.buttonPanel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                decode("/data/sintel.wmv", "/data/sintel.yuv");
//                  decode("/data/Forrest_Gump_IMAX.mp4", "/data/Forrest_Gump_IMAX.yuv");
                Log.e("MainActivity", "开始推流: streamer");
//                streamer("/mnt/usb/sda1/Forrest_Gump_IMAX.mp4", "rtmp://192.168.1.100/live/livestream"); //推流
                savestream("rtmp://192.168.1.100:1935/live/123", "/mnt/usb/0000-0000/receive.flv");//保存网络流到本地
            }
        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native String urlprotocolinfo();
    public native int decode(String inputfile, String outputfile);
    public native int streamer(String inputfile, String outputfile);
    public native int savestream(String inputfile, String outputfile);
    public native int play(Object surface, String file_path);
    public native int playUrlVideo(String file_path, Object surface);
//    public static final String url = "http://pl.cp31.ott.cibntv.net/playlist/m3u8?ts=1499163218&keyframe=0&vid=XNzIyNjI0ODc2&type=hd2&guid=3a66405d00839be94778bf0b00091b38&ver=V5.4.8&pid=a51da0d1b3ac7f85&ctype=30&sid=0499163218448306a5b89&token=4013&ev=1&oip=1780885170&did=3a66405d00839be94778bf0b00091b38&ep=WDnya%2FgT6ZWKXhuxSLi0oPNQs2RYOBMRSy68lGelwt0n6XXHRc9feEmYaL8tY0Dq";
//    public static final String url = "rtmp://192.168.1.100:1935/live/123";
//    public static final String url = "rtmp://www.bj-mobiletv.com:8000/live/123";
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    public void surfaceCreated(final SurfaceHolder surfaceHolder) {
        Log.i(TAG, "#########################sucy surfaceCreated!");
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
////              play(surfaceHolder.getSurface(), "/mnt/usb/sda1/Forrest_Gump_IMAX.mp4");//本地视频播放
////                play(surfaceHolder.getSurface(), url);//网络视频播放
////              playUrlVideo(url, surfaceHolder.getSurface());//网络视频播放
//            }
//        }).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
}

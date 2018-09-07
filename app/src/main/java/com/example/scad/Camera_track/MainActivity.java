package com.example.scad.Camera_track;

import android.app.Dialog;
import android.content.Context;
import android.hardware.camera2.*;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //Button button;
    Button button2;
    Boolean light = true;
    String b1,a1;



   /* public Boolean fun(String cameraId){
                boolean a=true;
        Toast.makeText(MainActivity.this, "camera not running", Toast.LENGTH_SHORT).show();

        return a;
    }
    public Boolean fun1(String cameraId){
         a1="0";
        if (cameraId==a1){
            b1="Back";
        }
        else
        {
            b1="front";
        }
        boolean b=true;
        Toast.makeText(MainActivity.this, b1+" camera running", Toast.LENGTH_SHORT).show();

        return b;
    }*/
    public void showdialog(String cameraId){
        a1="0";
        if (cameraId==a1){
            b1="Back";
        }
        else
        {
            b1="front";
        }

        final Dialog dialog = new Dialog(this); // Context, this, etc.

        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        dialog.setContentView(R.layout.activity_pop);
        dialog.setTitle(R.string.app_name);
        dialog.show();


    }
    CameraDevice cameraDevice;

    private CameraManager cameraManager;

    private CameraCharacteristics cameraCharacteristics;

    String cameraId;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cameraManager = (CameraManager)
                getSystemService(Context.CAMERA_SERVICE);
        try {
            cameraId = cameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

        Button button2=findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraManager manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

                Handler yourHandler = new Handler();

                manager.registerAvailabilityCallback(new CameraManager.AvailabilityCallback() {
                    @Override
                    public void onCameraAvailable(String cameraId) {
                        super.onCameraAvailable(cameraId);
                        //Do your work
                       // fun(cameraId);
                    }

                    @Override
                    public void onCameraUnavailable(String cameraId) {
                        super.onCameraUnavailable(cameraId);
                        showdialog(cameraId);
                       // fun1(cameraId);
                    }
                },yourHandler);


            }
        });


    }
}

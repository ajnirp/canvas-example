package com.example.rohan.sensorcw3;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

//    private SensorManager sm;
//    private Sensor s;
//    private List<Sensor> l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//        l = sm.getSensorList(Sensor.TYPE_ALL);
//        s = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
//
//        sm.registerListener(this, s, 1000000);
    }

//    @Override
//    public void onSensorChanged(SensorEvent event) {
//        float lux = event.values[0];
//        PlotView pv = (PlotView) findViewById((R.id.sensorData));
//        pv.addPoint(lux);
//        pv.invalidate();
//    }

//    @Override
//    public void onAccuracyChanged(Sensor s, int acc) {
//    }

    public void foo(View v) {
        float randomVal = (float)Math.random() * 100;
        PlotView pv = (PlotView) findViewById(R.id.sensorData);
        pv.addPoint(randomVal);
        pv.invalidate();
    }
}

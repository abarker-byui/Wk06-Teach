package com.example.teach;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {
    private WeakReference<Activity> _activityRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _activityRef = new WeakReference<>((Activity)this);
    }

    public void countEven(View view) {
        EvenCounter even = new EvenCounter(_activityRef);
        Thread evenThread = new Thread(even, "Even Thread");
        evenThread.start();
    }

    public void countOdd(View view) {
        OddCounter odd = new OddCounter(_activityRef);
        Thread oddThread = new Thread(odd, "Odd Thread");
        oddThread.start();
    }
}

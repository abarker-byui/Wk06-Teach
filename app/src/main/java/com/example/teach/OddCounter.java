package com.example.teach;

import android.app.Activity;
import android.widget.Toast;
import java.lang.ref.WeakReference;

public class OddCounter implements Runnable {
    WeakReference<Activity> _activityRef;

    public OddCounter(WeakReference<Activity> activityRef) {
        _activityRef = activityRef;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i += 2){
            System.out.println(i);

            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        final Activity activity = _activityRef.get();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast toast = Toast.makeText(activity, R.string.odd_finished, Toast.LENGTH_LONG);
                    toast.show();
                }
            });
        }
    }
}

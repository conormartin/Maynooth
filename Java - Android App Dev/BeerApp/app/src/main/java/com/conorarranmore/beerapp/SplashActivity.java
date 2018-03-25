
// Code by Conor Martin

package com.conorarranmore.beerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Splash screen method, shows image for 3 seconds.
        Thread timer = new Thread()
        {
            public void run()
            {
                try {
                    sleep(3000);
                    finish();
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
                //After timer finishes, start signup activity
                finally {
                    Intent intent = new Intent(SplashActivity.this,SignupActivity.class);
                    startActivity(intent);
                }
            }
        };
        timer.start();
    }
}

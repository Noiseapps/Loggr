package pl.noiseapps.loggrapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pl.noiseapps.loggr.Loggr;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Loggr.setTag(null);
    }
}

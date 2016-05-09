package pl.noiseapps.loggrapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import pl.noiseapps.loggr.Loggr;
import pl.noiseapps.loggr.LoggrConfig;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Loggr.init(new LoggrConfig(this));

        Loggr.i("TEST");
        Loggr.i("TEST", "MESSAGE");
        Loggr.i("TEST", 2);

        TestClass testClass = new TestClass();
        testClass.anInt = 24;
        testClass.aBoolean = true;
        testClass.aFloat = 39.32f;

        Loggr.d(testClass);

    }

    public static class TestClass {
        int anInt;
        boolean aBoolean;
        float aFloat;
    }
}

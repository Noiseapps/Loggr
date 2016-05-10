package pl.noiseapps.loggrapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import pl.noiseapps.loggr.*;
import pl.noiseapps.loggr.BuildConfig;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Loggr.init(new LoggrConfig(this, getClass().getSimpleName(), BuildConfig.DEBUG, 2));

        Loggr.i("TEST");
        Loggr.i("TEST", "MESSAGE");
        Loggr.i("TEST", 2);
        Loggr.v("MSG");

        TestClass testClass = new TestClass();
        testClass.anInt = 24;
        testClass.aBoolean = true;
        testClass.aFloat = 39.32f;

        Loggr.d(testClass);

        String json = "{'a':12, 'b':15}";
        Loggr.json(json);

    }

    public static class TestClass {
        int anInt;
        boolean aBoolean;
        float aFloat;
    }
}

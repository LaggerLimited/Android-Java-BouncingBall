package edu.owens.lagger.joshua.bouncingball;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * <h1>MainActivity</h1>
 * This is class initializes the application values
 * and instantiates the View.
 *
 * @author Joshua Lagger
 * @version 1.0
 * @since 2016-02-18
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View bouncingBallView = new BouncingBallView(this);
        setContentView(bouncingBallView);
        bouncingBallView.setBackgroundColor(Color.BLACK);
    }
}

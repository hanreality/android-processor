package com.hanreality.android.processor;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.butterknife.ButterKnife;
import com.butterknife.Unbinder;
import com.hanreality.android.annotation.BindView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.text)
    public TextView textView;

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUnbinder = ButterKnife.bind(this);
        textView.setText("Hello BindView");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
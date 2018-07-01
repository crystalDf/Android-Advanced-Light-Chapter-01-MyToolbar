package com.star.mytoolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class ToolbarActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        initViews();
    }

    private void initViews() {

        mToolbar = findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
    }
}

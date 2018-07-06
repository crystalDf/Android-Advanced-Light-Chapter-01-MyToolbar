package com.star.mytoolbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

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
        mToolbar.setTitle("Toolbar");

        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.drawable.bitmap);

        mToolbar.setOnMenuItemClickListener(item -> {

            switch (item.getItemId()) {

                case R.id.settings:
                    break;
                case R.id.share:
                    break;
                case R.id.search:
                    break;
                default:

            }

            return true;
        });

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bitmap);

        Palette.from(bitmap).generate(palette -> {

            Palette.Swatch swatch = palette.getVibrantSwatch();

            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(swatch.getRgb()));
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }
}

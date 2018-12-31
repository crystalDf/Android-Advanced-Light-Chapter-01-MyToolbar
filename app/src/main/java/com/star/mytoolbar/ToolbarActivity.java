package com.star.mytoolbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.palette.graphics.Palette;

public class ToolbarActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        initViews();
    }

    private void initViews() {

        setToolbar();
        setDrawerLayout();
        setPalette();
    }

    private void setToolbar() {
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle("Toolbar");

        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);

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
    }

    private void setDrawerLayout() {
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mTextView = findViewById(R.id.close);

        ActionBarDrawerToggle actionBarDrawerToggle =
                new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,
                        R.string.drawer_open, R.string.drawer_close);
        actionBarDrawerToggle.syncState();

        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);

        mTextView.setOnClickListener(v -> mDrawerLayout.closeDrawer(GravityCompat.START));

    }

    private void setPalette() {
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

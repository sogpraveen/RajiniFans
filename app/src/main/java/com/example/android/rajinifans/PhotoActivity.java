package com.example.android.rajinifans;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.rajinifans.PhotoListActivity;
import com.example.android.rajinifans.R;

public class PhotoActivity extends AppCompatActivity {


    /*
    for storing details of the photos
     */
    String[] photo_titles;
    String[] photo_descriptions;
    String[] photo_location_time;
    int[] photo_src = {R.drawable.photo1_full,
            R.drawable.photo2_full,
            R.drawable.photo3_full,
            R.drawable.photo4_full,
            R.drawable.photo5_full};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        /*
        reading intent to identify which photo to display
        photo_index stores this information
         */
        Intent intent = getIntent();
        String message = intent.getStringExtra(PhotoListActivity.EXTRA_MESSAGE);
        int photo_index = Integer.parseInt(message);

        ImageView photo_loc = (ImageView) findViewById(R.id.photo_src);
        TextView photo_title = (TextView) findViewById(R.id.photo_title);


        photo_titles = getResources().getStringArray(R.array.photo_titles);


        /*
        displaying the photo and textviews describing the photo
         */
        photo_title.setText(photo_titles[photo_index]);
        photo_loc.setImageResource(photo_src[photo_index]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_photo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

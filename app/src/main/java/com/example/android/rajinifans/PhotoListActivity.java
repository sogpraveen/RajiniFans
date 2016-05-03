package com.example.android.rajinifans;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class PhotoListActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.android.fivethings.MESSAGE";
    ListView photoListView;
    String[] photo_titles;
    String[] photo_brief_desc;
    //thumbnails of all photos
    int[] photo_src = {R.drawable.photo1_thumb,
            R.drawable.photo2_thumb,
            R.drawable.photo3_thumb,
            R.drawable.photo4_thumb,
            R.drawable.photo5_thumb};
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_list);

        context = this;

        photo_titles = getResources().getStringArray(R.array.photo_titles);


        //details of photos are passed to PhotoListAdapter and
        //that class handles how to display as a ListView
        photoListView = (ListView) findViewById(R.id.photo_list_view);
        photoListView.setAdapter(new PhotoListAdapter(this, photo_titles, photo_src));

        //handler for clicking on a photo list item
        photoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(PhotoListActivity.this, PhotoActivity.class);
                String message = Integer.toString(position);
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_photo_list, menu);
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

package com.gabe.android.aca.snoozecamp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import static com.gabe.android.aca.snoozecamp.R.id.UpcomingEvents;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    LookbookAdapter mAdapter;


    Button mButton;
    Button mPromoButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();





    }

    public void addListenerOnButton() {

        mButton = (Button) findViewById(R.id.shopbutton);
        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
/*
                Intent browserIntent =
                        new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.snoozecamp.com/shop/"));
                startActivity(browserIntent);
*/
                Intent intent = new Intent(getApplicationContext(),ShopActivity.class);
                startActivity(intent);
               // return true;
            }

        });


    }

/////////action bar

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.HomeTab){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            return true;
        }


        if (id == R.id.LookbookTab) {
            //Intent browserIntent =
             //       new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.snoozecamp.com/lookbook/"));
            //startActivity(browserIntent);
            Intent intent = new Intent(getApplicationContext(),LookbookActivity.class);
            startActivity(intent);
            return true;
        }


        if (id == R.id.scimagecapture){
            Intent intent = new Intent(getApplicationContext(),SnoozeCam.class);
            startActivity(intent);
            return true;


        }


        if (id == UpcomingEvents) {
            Intent intent = new Intent(getApplicationContext(),UpcomingEventsActivity.class);
            startActivity(intent);
            return true;

        }

        if (id == R.id.promo){
            Intent intent = new Intent(getApplicationContext(),Promo.class);
            startActivity(intent);
            return true;


        }

        if (id == R.id.ShopTab){
            Intent intent = new Intent(getApplicationContext(),ShopActivity.class);
            startActivity(intent);
            return true;


        }

        return super.onOptionsItemSelected(item);
    }

}










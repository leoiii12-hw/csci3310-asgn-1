package com.example.cupiggy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class ScrollingActivity extends AppCompatActivity {

    public static String INTENT_KEY_CUISINE_NAME = "com.example.cupiggy.message";
    public static String INTENT_KEY_ADDRESS = "com.example.cupiggy.address";
    public static String INTENT_KEY_FULL_NAME = "com.example.cupiggy.full_name";
    public static String INTENT_KEY_IMAGE_ID = "com.example.cupiggy.image";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = getSharedPreferences("MyPreferences", MODE_PRIVATE);

        TextView kebabRatingTextView = findViewById(R.id.kebabRatingTextView);
        kebabRatingTextView.setText("Rating: " + prefs.getFloat("Chicken Tikka Kebab" + "rating", 0));

        TextView pizzaRatingTextView = findViewById(R.id.pizzaRatingTextView);
        pizzaRatingTextView.setText("Rating: " + prefs.getFloat("Supreme Pizza" + "rating", 0));

        TextView porkRatingTextView = findViewById(R.id.porkRatingTextView);
        porkRatingTextView.setText("Rating: " + prefs.getFloat("Vegan BBQ Pork" + "rating", 0));

        TextView fishRatingTextView = findViewById(R.id.fishRatingTextView);
        fishRatingTextView.setText("Rating: " + prefs.getFloat("Vegan Fish Fillet" + "rating", 0));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
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

    /**
     * Shows a message that the kebab image was clicked.
     */
    public void showKebabDetails(View view) {
        Intent intent = new Intent(ScrollingActivity.this, DetailedActivity.class);

        intent
                .putExtra(INTENT_KEY_CUISINE_NAME, "Chicken Tikka Kebab")
                .putExtra(INTENT_KEY_FULL_NAME, "Ebeneezer’s Kebabs & Pizzeria")
                .putExtra(INTENT_KEY_ADDRESS, "G05, Lee Wai Chun Building")
                .putExtra(INTENT_KEY_IMAGE_ID, R.drawable.chicken_tikka_kebab_ebeneezer);

        startActivity(intent);
    }

    /**
     * Shows a message that the pizza image was clicked.
     */
    public void showPizzaDetails(View view) {
        Intent intent = new Intent(ScrollingActivity.this, DetailedActivity.class);

        intent
                .putExtra(INTENT_KEY_CUISINE_NAME, "Supreme Pizza")
                .putExtra(INTENT_KEY_FULL_NAME, "Ebeneezer’s Kebabs & Pizzeria")
                .putExtra(INTENT_KEY_ADDRESS, "G05, Lee Wai Chun Building")
                .putExtra(INTENT_KEY_IMAGE_ID, R.drawable.supreme_pizza_ebeneezer);

        startActivity(intent);
    }

    /**
     * Shows a message that the pork image was clicked.
     */
    public void showPorkDetails(View view) {
        Intent intent = new Intent(ScrollingActivity.this, DetailedActivity.class);

        intent
                .putExtra(INTENT_KEY_CUISINE_NAME, "Vegan BBQ Pork")
                .putExtra(INTENT_KEY_FULL_NAME, "CU Vegether")
                .putExtra(INTENT_KEY_ADDRESS, "G14, Benjamin Franklin Centre")
                .putExtra(INTENT_KEY_IMAGE_ID, R.drawable.vegan_bbq_pork_vegether);

        startActivity(intent);
    }

    /**
     * Shows a message that the fish image was clicked.
     */
    public void showFishDetails(View view) {
        Intent intent = new Intent(ScrollingActivity.this, DetailedActivity.class);

        intent
                .putExtra(INTENT_KEY_CUISINE_NAME, "Vegan Fish Fillet")
                .putExtra(INTENT_KEY_FULL_NAME, "CU Vegether")
                .putExtra(INTENT_KEY_ADDRESS, "G14, Benjamin Franklin Centre")
                .putExtra(INTENT_KEY_IMAGE_ID, R.drawable.vegan_fish_fillet_vegether);

        startActivity(intent);
    }

}

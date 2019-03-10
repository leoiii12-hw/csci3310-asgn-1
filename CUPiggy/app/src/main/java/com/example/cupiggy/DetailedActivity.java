package com.example.cupiggy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import static com.example.cupiggy.ScrollingActivity.INTENT_KEY_CUISINE_NAME;

public class DetailedActivity extends AppCompatActivity {

    private float ratingBeforeUpdate = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        setButtonsVisibility(View.INVISIBLE);

        Intent intent = getIntent();

        TextView cuisineNameView = findViewById(R.id.cuisineNameView);
        cuisineNameView.setText(intent.getStringExtra(INTENT_KEY_CUISINE_NAME));

        TextView fullNameView = findViewById(R.id.fullNameView);
        fullNameView.setText(intent.getStringExtra(ScrollingActivity.INTENT_KEY_FULL_NAME));

        TextView addressView = findViewById(R.id.addressView);
        addressView.setText(intent.getStringExtra(ScrollingActivity.INTENT_KEY_ADDRESS));

        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageDrawable(getResources().getDrawable(intent.getIntExtra(ScrollingActivity.INTENT_KEY_IMAGE_ID, 0)));

        RatingBar ratingBar = findViewById(R.id.ratingBar);
        SharedPreferences prefs = getSharedPreferences("MyPreferences", MODE_PRIVATE);
        float initialRating = prefs.getFloat(cuisineNameView.getText() + "rating", 0);

        ratingBar.setRating(initialRating);
        ratingBeforeUpdate = initialRating;

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (fromUser) {
                    setButtonsVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void setButtonsVisibility(int visibility) {
        final Button saveButton = findViewById(R.id.saveButton);
        final Button cancelButton = findViewById(R.id.cancelButton);
        saveButton.setVisibility(visibility);
        cancelButton.setVisibility(visibility);
    }

    public void save(View view) {
        TextView cuisineNameView = findViewById(R.id.cuisineNameView);
        RatingBar ratingBar = findViewById(R.id.ratingBar);

        float newRating = ratingBar.getRating();

        // Save rating
        SharedPreferences.Editor editor = getSharedPreferences("MyPreferences", MODE_PRIVATE).edit();
        editor.putFloat(cuisineNameView.getText() + "rating", newRating);
        editor.apply();

        this.ratingBeforeUpdate = newRating;

        setButtonsVisibility(View.INVISIBLE);

        finish();
    }

    public void cancel(View view) {
        RatingBar ratingBar = findViewById(R.id.ratingBar);

        ratingBar.setRating(this.ratingBeforeUpdate);

        setButtonsVisibility(View.INVISIBLE);
    }

}

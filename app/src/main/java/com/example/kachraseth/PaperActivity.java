package com.example.kachraseth;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class PaperActivity extends AppCompatActivity {

    private SearchView searchViewPaper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper);

        // Initialize the search view
        searchViewPaper = findViewById(R.id.searchViewPaper);

        // Implement search functionality
        searchViewPaper.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterItems(newText);
                return true;
            }
        });
    }

    // Function to filter items based on search query
    private void filterItems(String query) {
        // Retrieve the ScrollView and LinearLayout that holds all the cards
        ScrollView scrollView = findViewById(R.id.scrollView);
        LinearLayout layout = (LinearLayout) scrollView.getChildAt(0);

        for (int i = 0; i < layout.getChildCount(); i++) {
            View view = layout.getChildAt(i);

            // Ensure the view is a CardView before proceeding
            if (view instanceof CardView) {
                CardView cardView = (CardView) view;

                // Fetch the TextView displaying the item name
                TextView textView = cardView.findViewById(cardView.getChildAt(0).getId());

                // Hide or show the card based on search query
                if (!TextUtils.isEmpty(query) && !textView.getText().toString().toLowerCase().contains(query.toLowerCase())) {
                    cardView.setVisibility(View.GONE);
                } else {
                    cardView.setVisibility(View.VISIBLE);
                }
            }
        }
    }
}

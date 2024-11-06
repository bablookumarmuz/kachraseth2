package com.example.kachraseth;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class PlasticActivity extends AppCompatActivity {

    private SearchView searchViewPlastic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plastic);

        // Initialize the search view
        searchViewPlastic = findViewById(R.id.searchViewPlastic);

        // Implement search functionality
        searchViewPlastic.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
        ScrollView scrollView = findViewById(R.id.scrollViewPlastic);
        LinearLayout layout = (LinearLayout) scrollView.getChildAt(0);

        for (int i = 0; i < layout.getChildCount(); i++) {
            View view = layout.getChildAt(i);

            // Ensure the view is a CardView before proceeding
            if (view instanceof CardView) {
                CardView cardView = (CardView) view;
                TextView textView = cardView.findViewById(R.id.textPlasticSoft);

                // Get the item name from the TextView
                String itemName = textView.getText().toString().toLowerCase();

                // Show or hide the card view based on the query
                if (!TextUtils.isEmpty(query) && !itemName.contains(query.toLowerCase())) {
                    cardView.setVisibility(View.GONE);
                } else {
                    cardView.setVisibility(View.VISIBLE);
                }
            }
        }
    }
}

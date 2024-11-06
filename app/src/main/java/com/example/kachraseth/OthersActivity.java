package com.example.kachraseth;

import android.os.Bundle;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;

public class OthersActivity extends AppCompatActivity {

    private SearchView searchViewOthers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others); // Ensure this layout file exists in res/layout

        // Initialize the SearchView by matching the ID in the XML layout
        searchViewOthers = findViewById(R.id.searchViewOthers);

        // Setup the search view to listen for query changes
        setupSearchView();
    }

    private void setupSearchView() {
        searchViewOthers.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // You can handle search query submission here (optional)
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // This method will be called every time the user types something
                filterItems(newText);
                return true;
            }
        });
    }

    private void filterItems(String query) {
        // You can implement your filtering logic here, based on the user's search query
    }
}

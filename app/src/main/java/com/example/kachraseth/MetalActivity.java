package com.example.kachraseth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class MetalActivity extends AppCompatActivity {

    private CardView cardCopper, cardBrass, cardAluminium, cardBeveel, cardIron, cardAluminiumCable, cardTin, cardSteel;
    private SearchView searchViewMetal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metal);

        // Initialize card views
        cardCopper = findViewById(R.id.cardCopper);
        cardBrass = findViewById(R.id.cardBrass);
        cardAluminium = findViewById(R.id.cardAluminium);
        cardBeveel = findViewById(R.id.cardBeveel);
        cardIron = findViewById(R.id.cardIron);
        cardAluminiumCable = findViewById(R.id.cardAluminiumCable);
        cardTin = findViewById(R.id.cardTin);
        cardSteel = findViewById(R.id.cardSteel);
        searchViewMetal = findViewById(R.id.searchViewMetal);

        // Set onClick listeners for each card view
        cardCopper.setOnClickListener(v -> showRate("Copper", "₹400/kg"));
        cardBrass.setOnClickListener(v -> showRate("Brass", "₹300/kg"));
        cardAluminium.setOnClickListener(v -> showRate("Aluminium", "₹100/kg"));
        cardBeveel.setOnClickListener(v -> showRate("Beveel", "₹80/kg"));
        cardIron.setOnClickListener(v -> showRate("Iron", "₹26/kg"));
        cardAluminiumCable.setOnClickListener(v -> showRate("Aluminium Cable", "₹25/kg"));
        cardTin.setOnClickListener(v -> showRate("Tin", "₹20/kg"));
        cardSteel.setOnClickListener(v -> showRate("Steel", "₹45/kg"));

        // Set up search functionality
        searchViewMetal.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Implement search filtering logic if needed
                return false;
            }
        });
    }

    private void showRate(String metal, String rate) {
        Toast.makeText(this, metal + " rate: " + rate, Toast.LENGTH_SHORT).show();
    }
}

package com.example.kachraseth;

import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class EwasteActivity extends AppCompatActivity {

    private SearchView searchViewEwaste;
    private CardView cardAirConditioner, cardFridge, cardCPU, cardBulbLED, cardMobileBattery, cardPrinter, cardEwaste, cardKeywords;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ewaste);

        // Initialize views
        searchViewEwaste = findViewById(R.id.searchViewEwaste);
        cardAirConditioner = findViewById(R.id.cardAirConditioner);
        cardFridge = findViewById(R.id.cardFridge);
        cardCPU = findViewById(R.id.cardCPU);
        cardBulbLED = findViewById(R.id.cardBulbLED);
        cardMobileBattery = findViewById(R.id.cardMobileBattery);
        cardPrinter = findViewById(R.id.cardPrinter);
        cardEwaste = findViewById(R.id.cardEwaste);
        cardKeywords = findViewById(R.id.cardKeywords);

        // Set OnClickListeners for each card
        setCardListeners();

        // Set up search functionality
        setupSearch();
    }

    private void setCardListeners() {
        cardAirConditioner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EwasteActivity.this, "Air Conditioner selected", Toast.LENGTH_SHORT).show();
            }
        });

        cardFridge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EwasteActivity.this, "Fridge selected", Toast.LENGTH_SHORT).show();
            }
        });

        cardCPU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EwasteActivity.this, "CPU selected", Toast.LENGTH_SHORT).show();
            }
        });

        cardBulbLED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EwasteActivity.this, "Bulb/LED selected", Toast.LENGTH_SHORT).show();
            }
        });

        cardMobileBattery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EwasteActivity.this, "Mobile Battery selected", Toast.LENGTH_SHORT).show();
            }
        });

        cardPrinter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EwasteActivity.this, "Printer selected", Toast.LENGTH_SHORT).show();
            }
        });

        cardEwaste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EwasteActivity.this, "E-Waste selected", Toast.LENGTH_SHORT).show();
            }
        });

        cardKeywords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EwasteActivity.this, "Keywords selected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupSearch() {
        searchViewEwaste.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Filter logic can be implemented here
                return false;
            }
        });
    }
}

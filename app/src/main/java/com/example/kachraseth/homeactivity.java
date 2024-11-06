package com.example.kachraseth;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class homeactivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager; // Declare FragmentManager
    private static final String TAG = "HomeActivity"; // Added TAG for logging

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize the Bottom Navigation View
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        fragmentManager = getSupportFragmentManager(); // Initialize FragmentManager

        // Set the default fragment
        bottomNavigationView.setSelectedItemId(R.id.nav_home); // Default selection

        // Load the default fragment (HomeFragment)
        loadFragment(new HomeFragment());

        // Set up the bottom navigation listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                int id = item.getItemId();

                // Determine which fragment to load based on selected item
                if (id == R.id.nav_home) {
                    Log.d(TAG, "Home selected"); // Update log message
                    selectedFragment = new HomeFragment();
                } else if (id == R.id.nav_sell) {
                    Log.d(TAG, "Sell Scrap selected"); // Update log message
                    selectedFragment = new SellScrapFragment();
                } else if (id == R.id.nav_rate) {
                    Log.d(TAG, "Rate List selected"); // Handle Rate List Fragment
                    selectedFragment = new RateListFragment(); // Create a fragment for Rate List
                } else if (id == R.id.nav_profile) {
                    Log.d(TAG, "Profile selected"); // Handle Profile Fragment
                    selectedFragment = new ProfileFragment(); // Create a fragment for Profile
                }

                // Load the selected fragment if not null
                if (selectedFragment != null) {
                    loadFragment(selectedFragment);
                    return true; // Return true when fragment is selected and loaded
                }

                return false; // Return false if no fragment was selected
            }
        });
    }

    // Load the selected fragment
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, fragment) // Ensure this ID matches the XML layout
                    .commit();
            return true;
        }
        return false; // Return false if fragment was null
    }
}

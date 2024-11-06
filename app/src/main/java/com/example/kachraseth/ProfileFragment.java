package com.example.kachraseth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileFragment extends Fragment {

    private FirebaseAuth mAuth;
    private TextView textViewEmail;
    private TextView textViewUsername;
    private Button buttonLogout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Reference the TextViews and Button
        textViewEmail = view.findViewById(R.id.textViewEmail);
        textViewUsername = view.findViewById(R.id.textViewUsername);
        buttonLogout = view.findViewById(R.id.buttonLogout);

        // Fetch email and username of the current logged-in user
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            String userEmail = currentUser.getEmail(); // Get the email from Firebase Authentication
            String userUsername = currentUser.getDisplayName(); // Assuming username is set as display name

            // Display the email and username in the TextViews
            textViewEmail.setText(userEmail);
            if (userUsername != null) {
                textViewUsername.setText(userUsername);
            } else {
                textViewUsername.setText("Username not set");
            }
        } else {
            Toast.makeText(getContext(), "No user is logged in.", Toast.LENGTH_SHORT).show();
        }

        // Set up the logout button
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut(); // Sign out from Firebase
                Toast.makeText(getContext(), "Logged out successfully", Toast.LENGTH_SHORT).show();
                // Optionally, navigate back to login or home fragment
            }
        });

        return view; // Return the inflated view
    }
}

package com.example.kachraseth;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class SellScrapFragment extends Fragment {

    private CardView cardPlastic, cardPaper, cardMetal, cardEwaste, cardOthers;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sellscrap, container, false);

        // Initialize card views
        cardPlastic = view.findViewById(R.id.cardPlastic);
        cardPaper = view.findViewById(R.id.cardPaper);
        cardMetal = view.findViewById(R.id.cardMetal);
        cardEwaste = view.findViewById(R.id.cardEwaste);
        cardOthers = view.findViewById(R.id.cardOthers);

        // Set onClick listeners for each card view
        cardPlastic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PlasticActivity.class);
                startActivity(intent);
            }
        });

        cardPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PaperActivity.class);
                startActivity(intent);
            }
        });

        cardMetal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MetalActivity.class);
                startActivity(intent);
            }
        });

        cardEwaste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EwasteActivity.class);
                startActivity(intent);
            }
        });

        cardOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OthersActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
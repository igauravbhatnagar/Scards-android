package com.example.scards;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CardAdapter cardAdapter;
    private List<Card> cardList;
    private EditText searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        searchBar = findViewById(R.id.search_bar);

        cardList = new ArrayList<>();
        cardAdapter = new CardAdapter(cardList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(cardAdapter);

        findViewById(R.id.add_card_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                startActivity(intent);
            }
        });

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Do nothing
            }
        });

        // Load stored cards (this is just a placeholder, implement actual loading logic)
        loadStoredCards();
    }

    private void filter(String text) {
        List<Card> filteredList = new ArrayList<>();
        for (Card card : cardList) {
            if (card.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(card);
            }
        }
        cardAdapter.filterList(filteredList);
    }

    private void loadStoredCards() {
        // Placeholder for loading stored cards
        // Add logic to load stored cards from storage
    }

    @Override
    public void onBackPressed() {
        if (!searchBar.getText().toString().isEmpty()) {
            searchBar.setText("");
        } else {
            super.onBackPressed();
        }
    }
}

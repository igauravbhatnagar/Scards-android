package com.example.scards;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private List<Card> cardList;

    public CardAdapter(List<Card> cardList) {
        this.cardList = cardList;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Card card = cardList.get(position);
        holder.cardName.setText(card.getName());
        // Load the card image or QR code using an image loading library like Glide or Picasso
        // Example: Glide.with(holder.itemView.getContext()).load(card.getImagePath()).into(holder.cardImage);
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public void filterList(List<Card> filteredList) {
        cardList = filteredList;
        notifyDataSetChanged();
    }

    static class CardViewHolder extends RecyclerView.ViewHolder {
        TextView cardName;
        ImageView cardImage;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            cardName = itemView.findViewById(R.id.card_name);
            cardImage = itemView.findViewById(R.id.card_image);
        }
    }
}

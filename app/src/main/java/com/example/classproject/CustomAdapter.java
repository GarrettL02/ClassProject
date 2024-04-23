package com.example.classproject;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{

    String[] items;
    String[] price;
    Integer[] thumbnail;
    static TextView topTextView;

    public CustomAdapter(String[] items, String[] price, Integer[] thumbnail) {

        this.items = items;
        this.price = price;
        this.thumbnail = thumbnail;

    }//END TestAdapter constructor


    //Generates View
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        //Create this view for each row
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_custom_row, viewGroup,false);

        return new ViewHolder(view);
    }//END ViewHolder method

    //get reference to each widget inside each row
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        //GetTextView is method in this class
        viewHolder.getRowText().setText(items[position]);

        //GetTextView is method in this class
        viewHolder.getRowPrice().setText(price[position]);

        //GetTextView is method in this class
        viewHolder.getRowImage().setImageResource(thumbnail[position]);

    }//END onBindViewHolder method

    public int getItemCount() {

        return items.length;

    }//END getItemCount

    public int getPriceCount(){

        return price.length;

    }//END getPriceCount

    public int getThumbnailCount(){

        return thumbnail.length;

    }//END getThumbnailCount



    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView rowText;
        private final TextView rowPrice;
        private final ImageView rowImage;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            rowText = itemView.findViewById(R.id.rowLabel);
            rowPrice = itemView.findViewById(R.id.rowPrice);
            rowImage = itemView.findViewById(R.id.rowImg);


            //Create new OnClickListener for each value in the list
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    /* ---------- This is where to start the second activity ------------*/

                    //Create intent to open new activity
                    Intent activityIntent = new Intent(v.getContext(), BarsActivity.class);

                    //add key value pair data to activity -  data is index that is clicked
                    activityIntent.putExtra("index", getAdapterPosition());

                    v.getContext().startActivity(activityIntent);
                    /* ---------- This is where to start the second activity ------------*/

                }
            });//End OnClickListener

        }//END viewHolder Constructor


        public TextView getRowText() {
            return rowText;
        }

        public TextView getRowPrice() {
            return rowPrice;
        }

        public ImageView getRowImage() {
            return rowImage;
        }

    }//END Class ViewHolder


}

package com.example.classproject;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.ViewHolder>{

    String[] Names;

    static TextView topTextView;

    public FriendsAdapter(String[] Names) {

        this.Names = Names;


    }//END TestAdapter constructor


    //Generates View
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        //Create this view for each row
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.friends_custom_row, viewGroup,false);

        return new ViewHolder(view);
    }//END ViewHolder method

    //get reference to each widget inside each row
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        //GetTextView is method in this class
        viewHolder.getRowName().setText(Names[position]);


    }//END onBindViewHolder method

    public int getItemCount() {

        return Names.length;

    }//END getItemCount


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView rowName;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            rowName = itemView.findViewById(R.id.rowLabel);


            //Create new OnClickListener for each value in the list
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    /* ---------- This is where to start the second activity ------------*/

                    //Create intent to open new activity
                    Intent activityIntent = new Intent(v.getContext(), MessageActivity.class);

                    //add key value pair data to activity -  data is index that is clicked
                    activityIntent.putExtra("index", getAdapterPosition());

                    v.getContext().startActivity(activityIntent);
                    /* ---------- This is where to start the second activity ------------*/

                }
            });//End OnClickListener

        }//END viewHolder Constructor


        public TextView getRowName() {
            return rowName;
        }

    }//END Viewholder

}//END CLASS

package com.example.classproject.ui.homes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.classproject.AccountActivity;
import com.example.classproject.BarsActivity;
import com.example.classproject.DataProvider;
import com.example.classproject.FriendsActivity;
import com.example.classproject.MainActivity;
import com.example.classproject.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //declare variables
    ImageView imgBtnAccount;
    Button btnUber;
    Button btnFriends;
    ListView lvFriends;
    String[] userNamesList = DataProvider.UserName;

    public HomesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomesFragment newInstance(String param1, String param2) {
        HomesFragment fragment = new HomesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_homes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imgBtnAccount = view.findViewById(R.id.imgBtnAccount);
        btnUber = view.findViewById(R.id.btnUber);
        lvFriends = view.findViewById(R.id.lvFriends);
        btnFriends = view.findViewById(R.id.btnFriends);

        imgBtnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Create intent to open new activity
                Intent activityIntent = new Intent(v.getContext(), AccountActivity.class);

                v.getContext().startActivity(activityIntent);

            }
        });//END On-click Listener imgBtnAccount


        //when the friends button is clicked send to the friends page
        btnUber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //create intent to send user to uber.com
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uber.com"));

                //start the activity
                startActivity(websiteIntent);


            }
        });//END On-click Listener btnUber

        btnFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Create intent to open new activity
                Intent activityIntent = new Intent(v.getContext(), FriendsActivity.class);

                //start the activity
                v.getContext().startActivity(activityIntent);

            }
        });//END on-click listener btnFriends

    }//END main method

}//END class
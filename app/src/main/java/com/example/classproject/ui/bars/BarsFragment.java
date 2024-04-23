package com.example.classproject.ui.bars;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.classproject.CustomAdapter;
import com.example.classproject.DataProvider;
import com.example.classproject.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BarsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BarsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    //Declare Variables
    RecyclerView recyclerView;
    String[] items = DataProvider.itemdescriptions;
    String[] price = DataProvider.itemprice;
    Integer[] thumbnails = DataProvider.thumnbails;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BarsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BarsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BarsFragment newInstance(String param1, String param2) {
        BarsFragment fragment = new BarsFragment();
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
        return inflater.inflate(R.layout.fragment_bars, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //attack widget to variable
        recyclerView = view.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setHasFixedSize(true);

        CustomAdapter myAdapter = new CustomAdapter(items, price, thumbnails);

        recyclerView.setAdapter(myAdapter);


    }
}
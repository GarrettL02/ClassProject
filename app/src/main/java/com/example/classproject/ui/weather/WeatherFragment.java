package com.example.classproject.ui.weather;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.classproject.R;
import com.example.classproject.util.weatherUtil;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeatherFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeatherFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    //declare variables
    static final String TAG = "MainActivity";
    TextView txtMsg;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WeatherFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WeatherFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WeatherFragment newInstance(String param1, String param2) {
        WeatherFragment fragment = new WeatherFragment();
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
        return inflater.inflate(R.layout.fragment_weather, container, false);
    }

    //method for when view is created, put code here
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //link widgets to variables
        txtMsg = view.findViewById(R.id.txtmsg);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(weatherUtil.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .build();
        weatherUtil webUtil = retrofit.create(weatherUtil.class);



//        Call<String> call = webUtil.getWeatherByCity("Fort Wayne, US", WebUtil.API_KEY, "imperial");
        Call<String> call = webUtil.getWeatherByCity("Fort Wayne, US", weatherUtil.API_KEY, "imperial");

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String result = response.body().toString();

                int d = Log.d(TAG, response.body().toString());
                try {
                    JSONObject jsonObj = new JSONObject(result);

                    JSONObject main = jsonObj.getJSONObject("main");
                    JSONObject sys = jsonObj.getJSONObject("sys");
                    JSONObject wind = jsonObj.getJSONObject("wind");
                    JSONObject cloud = jsonObj.getJSONObject("clouds");
                    JSONObject weather = jsonObj.getJSONArray("weather").getJSONObject(0);
                    String temperature = main.getString("temp");
                    String humidity = main.getString("humidity");
                    String weather_desc = weather.getString("description");
                    String str_output = temperature + " " + humidity + " " + weather_desc;
                    Log.d(TAG, str_output);
                    str_output = "temperature: " +temperature + "\n"
                            + "humidity: " + humidity + "\n"
                            + "weather: " + weather_desc + "\n";
                    txtMsg.setText(str_output);



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }//END onViewCreated method

}//END class


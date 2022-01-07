package com.example.retrofit;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private TextView textViewResult;
    private RecyclerView recyclerView;
    private ApiService apiService;
    static ArrayList<MarvelMovieInfo> movieInfo;
    MyAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://simplifiedcoding.net/demos/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        apiService = retrofit.create(ApiService.class);

       getMarvels();
        //getMovieInfo();
    }

    /*public void getMovieInfo(){
        Call<List<MarvelMovieInfo>> call = apiService.getInfo();

        call.enqueue(new Callback<List<MarvelMovieInfo>>() {
            @Override
            public void onResponse(Call<List<MarvelMovieInfo>> call, Response<List<MarvelMovieInfo>> response) {
                if(!response.isSuccessful()){
                    textViewResult.setText("Code:" + response.code());
                    return;
                }
                List<MarvelMovieInfo> moviesInfo = response.body();
                for (MarvelMovieInfo movies : moviesInfo){
                    String content = "";
                    content += "Name: " + movies.getName() + "\n";
                    content += "Real Name: " + movies.getRealName() + "\n";
                    content += "Team: " + movies.getTeam() + "\n";
                    content += "First Appearance: " +movies.getFirstAppearance() + "\n";
                    content += "Created By: " +movies.getCreatedBy() + "\n";
                    content += "Publisher: " +movies.getPublisher() + "\n";
                    content += "Bio: " +movies.getBio() + "\n\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<MarvelMovieInfo>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }*/

    private void getMarvels()
    {
        Call<List<MarvelMovieInfo>> call = apiService.getInfo();

        call.enqueue(new Callback<List<MarvelMovieInfo>>() {
            @Override
            public void onResponse(Call<List<MarvelMovieInfo>> call, Response<List<MarvelMovieInfo>> response) {

                List <MarvelMovieInfo> Marvels = response.body();
                movieInfo = (ArrayList<MarvelMovieInfo>) response.body();
//                for (MarvelMovieInfo marvel:Marvels)
//                {
//
//                    movieInfo.add(new MarvelMovieInfo(marvel.getName(),
//                            marvel.getRealName(),
//                            marvel.getTeam(),
//                            marvel.getFirstAppearance(),
//                            marvel.getCreatedBy(),
//                            marvel.getPublisher(),
//                            marvel.getBio()));
//                            marvel.getImageUrl();
//                }
                createRecyclerView();
            }
            @Override
            public void onFailure(Call<List<MarvelMovieInfo>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "failed to retrieve data\ncheck your internet connection", Toast.LENGTH_LONG).show();
            }
        });

    }
    private void createRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new MyAdapter(this, movieInfo);
        recyclerView.setAdapter( adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}

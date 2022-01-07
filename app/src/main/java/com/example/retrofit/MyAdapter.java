package com.example.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    Context context;
    ArrayList<MarvelMovieInfo> movieInfo;
    LayoutInflater inflater;
    View view;
    String url;

    public MyAdapter(Context context, ArrayList<MarvelMovieInfo> movieInfo) {
        this.context = context;
        this.movieInfo = movieInfo;
        inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {


        holder.movieInfoText.setText(movieInfo.get(i).toString());
        url = movieInfo.get(i).getImageUrl();

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.mipmap.ic_launcher_round);

        Glide.with(context)
                .load(url)
                .apply(options)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {

        return movieInfo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView movieInfoText;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            movieInfoText = itemView.findViewById(R.id.textMovieInfo);
            imageView = itemView.findViewById(R.id.imageView);


        }

    }
}

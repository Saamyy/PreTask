package com.example.mahmoudsamy.pretask.views;

/**
 * Created by Mahmoud samy on 7/10/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mahmoudsamy.pretask.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import beans.Item;
import beans.Products;

public class ItemAddapter extends RecyclerView.Adapter<ItemAddapter.MyViewHolder>{
    private List<Products> moviesList;
    private  String userType ;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, subtittle;
        ImageView img;

        public MyViewHolder(View view) {
            super(view);
            name=(TextView) view.findViewById(R.id.name);
            subtittle=(TextView) view.findViewById(R.id.tittle);
            img=(ImageView) view.findViewById(R.id.img);

        }
    }


    public ItemAddapter(List<Products> moviesList,String userType) {
        this.moviesList = moviesList;
        this.userType=userType;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.products_listrow, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Products movie = moviesList.get(position);
        holder.name.setText(movie.getLabel());
        if (userType.equals("prepaid"))
        {
            holder.subtittle.setVisibility(View.GONE);
        }
        else
        {
            holder.subtittle.setText(movie.getSubtitle());
        }
        Picasso.with(GlobaleClass.context).load(movie.getIcon()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}


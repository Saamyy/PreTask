package com.example.mahmoudsamy.pretask.views;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.mahmoudsamy.pretask.R;

import java.util.ArrayList;
import java.util.List;

import beans.Item;
import beans.Products;
import beans.User;

public class ProductsList extends AppCompatActivity {
    private List<Products> itemList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ItemAddapter iAdapter;
    private  String usertype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);
        Intent i = getIntent();
        Item intentItem = new Item();
        usertype=new String();
        intentItem = (Item) i.getSerializableExtra("products");
        usertype=i.getStringExtra("userType");
        itemList.addAll(intentItem.getItems());
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(itemList.get(position).getUrl()));
                        startActivity(browserIntent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                })
        );
        iAdapter = new ItemAddapter(itemList,usertype);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(iAdapter);
    }


}

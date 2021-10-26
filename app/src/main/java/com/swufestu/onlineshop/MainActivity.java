package com.swufestu.onlineshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.swufestu.onlineshop.adapter.DiscountedProductAdapter;
import com.swufestu.onlineshop.model.DiscountedProducts;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView discountRecyclerView;
    DiscountedProductAdapter discountedProductAdapter;
    List<DiscountedProducts> discountedProductsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        discountRecyclerView = findViewById(R.id.discountedrecycler);

        //adding data to model
        discountedProductsList=new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(1,R.drawable.pizza));
        discountedProductsList.add(new DiscountedProducts(2,R.drawable.breakfast));
        discountedProductsList.add(new DiscountedProducts(3,R.drawable.doufu));
        discountedProductsList.add(new DiscountedProducts(4,R.drawable.beverage));
        discountedProductsList.add(new DiscountedProducts(5,R.drawable.bread));
        discountedProductsList.add(new DiscountedProducts(6,R.drawable.sukiyaki));

        setDiscountedRecycler(discountedProductsList);
    }

    private void setDiscountedRecycler(List<DiscountedProducts> dataList) {
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        discountRecyclerView.setLayoutManager(layoutManager);
        discountedProductAdapter = new DiscountedProductAdapter(this, (ArrayList<DiscountedProducts>) dataList);
        discountRecyclerView.setAdapter((discountedProductAdapter));
    }
}
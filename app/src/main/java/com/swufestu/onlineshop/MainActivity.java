package com.swufestu.onlineshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.swufestu.onlineshop.adapter.CategoryAdapter;
import com.swufestu.onlineshop.adapter.DiscountedProductAdapter;
import com.swufestu.onlineshop.adapter.RecentlyViewedAdapter;
import com.swufestu.onlineshop.model.item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView discountRecyclerView,categoryRecyclerView,recentlyViewedRecycler;
    DiscountedProductAdapter discountedProductAdapter;
    List<item> discountedProductsList;

    CategoryAdapter categoryAdapter;
    List<item> categoryList;
    RecentlyViewedAdapter recentlyViewedAdapter;
    List<item> recentlyViewedList;
    ImageView allCategory;
    List<item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        discountRecyclerView = findViewById(R.id.discountedRecycler);
        categoryRecyclerView = findViewById(R.id.categoryRecycler);
        allCategory = findViewById(R.id.allCategoryImage);
        recentlyViewedRecycler = findViewById(R.id.recently_item);

        items = new ArrayList<>();
        items.add(new item(1,R.drawable.pizza,"披萨","40",R.drawable.pizza));
        items.add(new item(2,R.drawable.c_cake2,"蛋糕","30",R.drawable.c_cake2));
        items.add(new item(3,R.drawable.kaoji,"烤鸡","50",R.drawable.kaoji));
        items.add(new item(4,R.drawable.beverage,"饮料","10",R.drawable.beverage));
        items.add(new item(5,R.drawable.m3,"虾","10",R.drawable.m3));
        items.add(new item(6,R.drawable.s_shousi,"寿司","10",R.drawable.s_shousi));
        items.add(new item(7,R.drawable.m1,"猪肉","10",R.drawable.m1));
        items.add(new item(8,R.drawable.salt,"盐","10",R.drawable.salt));
        items.add(new item(9,R.drawable.s_danta,"蛋挞","10",R.drawable.s_danta));
        items.add(new item(10,R.drawable.milk,"牛奶","10",R.drawable.milk));
        items.add(new item(11,R.drawable.jiangyou,"酱油","12",R.drawable.jiangyou));
        items.add(new item(12,R.drawable.tomato,"番茄","2",R.drawable.tomato));

        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,AllCategory.class);
                startActivity(i);
            }
        });

        findViewById(R.id.btn_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText search = findViewById(R.id.search);
                String value = search.getText().toString().trim();
                for(item it: items){
                    if (value.equals(it.getName())){
                        Intent i=new Intent(MainActivity.this, ProductDetails.class);
                        i.putExtra("name",it.getName());
                        i.putExtra("image",it.getBigimageurl());
                        i.putExtra("price",it.getPrice());
                        i.putExtra("desc",it.getDescription());
                        startActivity(i);
                        return;
                    }
                }
                Toast.makeText(MainActivity.this, "未找到该商品", Toast.LENGTH_SHORT).show();
            }
        });

        //adding data to model
        discountedProductsList= new ArrayList<>(items.subList(0,5));
        categoryList= new ArrayList<>(items.subList(0,8));;
        recentlyViewedList = new ArrayList<>(items.subList(5,11));;
//        Log.i("TAG", String.valueOf(items.subList(6,10)));
        setCategoryRecycler(categoryList);
        setDiscountedRecycler(discountedProductsList);
        setRecentlyViewedRecycler(recentlyViewedList);
    }

    private void setDiscountedRecycler(List<item> dataList) {
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        discountRecyclerView.setLayoutManager(layoutManager);
        discountedProductAdapter = new DiscountedProductAdapter(this, (ArrayList<item>) dataList);
        discountRecyclerView.setAdapter((discountedProductAdapter));
    }
    private void setCategoryRecycler(List<item> categoryDataList) {
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,categoryDataList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }
    private void setRecentlyViewedRecycler(List<item> recentlyViewedDataList) {
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(this,recentlyViewedDataList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }


}
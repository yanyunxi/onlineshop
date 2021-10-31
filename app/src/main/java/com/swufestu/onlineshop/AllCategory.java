package com.swufestu.onlineshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;


import com.swufestu.onlineshop.adapter.AllCategoryAdapter;
import com.swufestu.onlineshop.model.item;

import java.util.ArrayList;
import java.util.List;

public class AllCategory extends AppCompatActivity {
    RecyclerView AllCategoryRecycler;
    AllCategoryAdapter allCategoryAdapter;
    List<item>allCategoryModelList;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category);

        AllCategoryRecycler= findViewById(R.id.allCategory);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(AllCategory.this,MainActivity.class);
                startActivity(back);
                finish();
            }
        });

        allCategoryModelList = new ArrayList<>();
        allCategoryModelList.add(new item(1,R.drawable.pizza,"披萨","40",R.drawable.pizza));
        allCategoryModelList.add(new item(2,R.drawable.c_cake2,"蛋糕","30",R.drawable.c_cake2));
        allCategoryModelList.add(new item(3,R.drawable.kaoji,"烤鸡","50",R.drawable.kaoji));
        allCategoryModelList.add(new item(4,R.drawable.beverage,"饮料","10",R.drawable.beverage));
        allCategoryModelList.add(new item(5,R.drawable.m3,"虾","10",R.drawable.m3));
        allCategoryModelList.add(new item(6,R.drawable.s_shousi,"寿司","10",R.drawable.s_shousi));
        allCategoryModelList.add(new item(7,R.drawable.m1,"猪肉","10",R.drawable.m1));
        allCategoryModelList.add(new item(8,R.drawable.salt,"盐","10",R.drawable.salt));
        allCategoryModelList.add(new item(9,R.drawable.s_danta,"蛋挞","10",R.drawable.s_danta));
        allCategoryModelList.add(new item(10,R.drawable.milk,"牛奶","10",R.drawable.milk));
        allCategoryModelList.add(new item(11,R.drawable.jiangyou,"酱油","12",R.drawable.jiangyou));
        allCategoryModelList.add(new item(12,R.drawable.tomato,"番茄","2",R.drawable.tomato));


        setCategoryRecycler(allCategoryModelList);

    }

    private void setCategoryRecycler(List<item> allCategoryModelList) {
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(this,3);
        AllCategoryRecycler.setLayoutManager(layoutManager);
        AllCategoryRecycler.addItemDecoration(new GridSpacingItemDecoration(4,dpToPx(10),true));
        AllCategoryRecycler.setItemAnimator(new DefaultItemAnimator());
        allCategoryAdapter = new AllCategoryAdapter(this,allCategoryModelList);
        AllCategoryRecycler.setAdapter(allCategoryAdapter);

    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration{
        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge){
            this.spanCount = spanCount;
            this.spacing = spacing;
        }
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state){
            int position = parent.getChildAdapterPosition(view);
            int column = position % spanCount;

            if(includeEdge){
                outRect.left = spacing- column * spacing / spanCount;
                outRect.right = (column + 1) * spacing / spanCount;

                if(position < spanCount){
                    outRect.top = spacing;
                }
                outRect.bottom = spacing;
            }else{
                outRect.left = column * spacing/spanCount;
                outRect.right = spacing-(column + 1)*spacing/spanCount;
                if (position > spanCount){
                    outRect.top = spacing;
                }
            }
        }
    }
    private int dpToPx(int dp){
        Resources r =getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,r.getDisplayMetrics()));
    }
}
package com.etebarian.meowbottomnavigaion.screen;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.FrameLayout;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.etebarian.meowbottomnavigaion.R;
import com.etebarian.meowbottomnavigaion.adapter.ScreenAdapter;
import com.etebarian.meowbottomnavigaion.model.ScreenBO;

import java.util.ArrayList;
import java.util.List;

public class Screen {

    private Context mContext;
    RecyclerView mRecyclerView;
    List<ScreenBO> screenBOList;
    ScreenAdapter screenAdapter;

    public Screen(Context context){
        this.mContext = context;
        screenBOList = new ArrayList<>();
        initList();
    }

    public void setView(FrameLayout frameLayout){
        frameLayout.removeAllViews();
        initList();
        frameLayout.addView(mRecyclerView);

    }

    public void setData(List<ScreenBO> list){
        screenBOList = list;
        screenAdapter = new ScreenAdapter(mContext, screenBOList);
        mRecyclerView.setAdapter(screenAdapter);
    }



    private void initList(){
        if(mRecyclerView == null){
            int resId = R.anim.layout_animation_slide_right;
            mRecyclerView = new RecyclerView(mContext);
            LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(mContext, resId);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
            mRecyclerView.setLayoutAnimation(animation);
            mRecyclerView.setLayoutParams(params);


            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, RecyclerView.VERTICAL,false);
            linearLayoutManager.scrollToPosition(0);


            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setItemAnimator(new DefaultItemAnimator());
            mRecyclerView.setLayoutManager(linearLayoutManager);
        }
    }
}

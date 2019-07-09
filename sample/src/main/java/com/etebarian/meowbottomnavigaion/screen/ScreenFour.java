package com.etebarian.meowbottomnavigaion.screen;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.etebarian.meowbottomnavigaion.R;

public class ScreenFour {

    private Context mContext;
    TextView mName;
    TextView mAddress;
    ImageView mProfileImage;
    CardView cardview;
    LinearLayout.LayoutParams layoutparams;
    LinearLayout.LayoutParams layoutparamsImage;
    LinearLayout.LayoutParams layoutparamsTextView;
    LinearLayout linearLayout;
    RelativeLayout relativeLayout;

    public ScreenFour(Context context){
        this.mContext = context;
        initString();
    }

    public void setView(FrameLayout frameLayout){
        frameLayout.removeAllViews();
        initString();

        relativeLayout.addView(cardview);
        cardview.addView(linearLayout);
        linearLayout.addView(mProfileImage);
        linearLayout.addView(mName);
        linearLayout.addView(mAddress);
        frameLayout.addView(relativeLayout);
    }

    public void setData(){
        mName.setText("Ananya Chatterjee");
        mAddress.setText("Tollygunge");
        mProfileImage.setBackgroundResource(R.drawable.ic_home);
    }

    private void initString(){

        mName = new TextView(mContext);
        mAddress = new TextView(mContext);
        linearLayout = new LinearLayout(mContext);
        relativeLayout = new RelativeLayout(mContext);
        mProfileImage = new ImageView(mContext);
        cardview = new CardView(mContext);

        layoutparams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );

        layoutparamsImage = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                500
        );

        layoutparamsTextView = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        cardview.setLayoutParams(layoutparams);
        cardview.setRadius(100);
        cardview.setPadding(25, 25, 25, 25);
        cardview.setCardBackgroundColor(Color.TRANSPARENT);
//        cardview.setMaxCardElevation(50);
//        cardview.setMaxCardElevation(10);

        layoutparams.setMargins(20, 20, 20, 350);
        relativeLayout.setLayoutParams(layoutparams);
        relativeLayout.setPadding(50,50,50,50);
        relativeLayout.setGravity(Gravity.CENTER);

        linearLayout.setLayoutParams(layoutparams);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setPadding(50,50,50,50);
        linearLayout.setGravity(Gravity.CENTER);

        mProfileImage.setLayoutParams(layoutparamsImage);

        layoutparamsTextView.setMargins(0,20,0,0);
        mName.setLayoutParams(layoutparamsTextView);
        mName.setGravity(Gravity.CENTER);
        mName.setTextSize(20);

        mAddress.setLayoutParams(layoutparamsTextView);
        mAddress.setGravity(Gravity.CENTER);
        mAddress.setTextSize(18);


//        Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.zoom_in); relativeLayout.setAnimation(animation);

        final RotateAnimation rotate = new RotateAnimation(cardview.getRotation(),
                cardview.getRotation() - 360.0f, RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(1000);
        rotate.setFillEnabled(true);
        rotate.setFillAfter(true);
        cardview.startAnimation(rotate);

//        final RotateAnimation reverseRotate = new RotateAnimation(mProfileImage.getRotation(),
//                360.0f - mProfileImage.getRotation(), RotateAnimation.RELATIVE_TO_SELF, 0.5f,
//                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
//        reverseRotate.setDuration(600);
//        reverseRotate.setFillEnabled(true);
//        reverseRotate.setFillAfter(true);
//        mName.startAnimation(reverseRotate);

    }
}

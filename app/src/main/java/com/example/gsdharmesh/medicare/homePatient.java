package com.example.gsdharmesh.medicare;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class homePatient extends AppCompatActivity {
    private TextView[] dots;
    private LinearLayout dotsLayout;
    private int layouts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_patient);
        TextView send = (TextView) findViewById(R.id.tv_send);
        TextView view_prof = (TextView) findViewById(R.id.view_prof);
        ImageView messages = (ImageView) findViewById(R.id.thumbnail2);
        ImageView profile = (ImageView) findViewById(R.id.thumbnail);


        view_prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent INT=new Intent(homePatient.this,Profile.class);
                startActivity(INT);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent INT=new Intent(homePatient.this,Profile.class);
                startActivity(INT);
            }
        });


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent INT=new Intent(homePatient.this,showChatList.class);
                startActivity(INT);
            }
        });
        messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent INT=new Intent(homePatient.this,showChatList.class);
                startActivity(INT);
            }
        });




        dotsLayout=(LinearLayout) findViewById(R.id.layoutdots);
        addBottomDots(0);
        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPageAndroid);
        AndroidImageAdapter adapterView = new AndroidImageAdapter(this);
        mViewPager.setAdapter(adapterView);
        layouts=adapterView.getCount();
    }
    private void addBottomDots(int position)
    {
        dots=new TextView[5];
        dotsLayout.removeAllViews();
        int[] activecolor=getResources().getIntArray(R.array.act);
        int[] inactivecolor=getResources().getIntArray(R.array.inact);
        for(int i=0;i<dots.length;i++)
        {
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(inactivecolor[position]);

            dotsLayout.addView(dots[i]);

        }
        if(dots.length>0)
        {
            dots[position].setTextColor(activecolor[position]);
        }
    }
    ViewPager.OnPageChangeListener viewlistener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}

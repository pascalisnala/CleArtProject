package com.example.pascalisnala.cleart.Activities;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pascalisnala.cleart.R;
import com.example.pascalisnala.cleart.adapter.ImageAdapter;
import com.example.pascalisnala.cleart.adapter.ViewPageAdapter;
import com.example.pascalisnala.cleart.fragments.FragmentInformation;
import com.example.pascalisnala.cleart.fragments.FragmentReport;

public class DetailActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    private ImageButton backButton;
    private CardView addReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ViewPager viewPager = findViewById(R.id.viewPager_image);
        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);

        tabLayout = findViewById(R.id.tablayout_id);
        viewPager = findViewById(R.id.viewPager_id);
        ViewPageAdapter adapter1 = new ViewPageAdapter(getSupportFragmentManager());

        adapter1.AddFragment(new FragmentInformation(),"Information");
        adapter1.AddFragment(new FragmentReport(),"Report");

        viewPager.setAdapter(adapter1);
        tabLayout.setupWithViewPager(viewPager);

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        if(getIntent().hasExtra("attrname")&& getIntent().hasExtra("attrdesc")&& getIntent().hasExtra("attrloc")&& getIntent().hasExtra("attrschedule")){
            String attrname = getIntent().getStringExtra("attrname");
            setObject(attrname);
        }
    }

    private void setObject(String attrname){
        TextView tvAttrName;

        tvAttrName = findViewById(R.id.tvAttrName);
        tvAttrName.setText(attrname);
    }
}

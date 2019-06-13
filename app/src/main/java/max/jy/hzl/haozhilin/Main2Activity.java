package max.jy.hzl.haozhilin;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;

import max.jy.hzl.haozhilin.adapter.Vpadapter;
import max.jy.hzl.haozhilin.fragment.BlankFragment;
import max.jy.hzl.haozhilin.fragment.BlankFragment2;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView mRlv;
    private TextView mTvTool;
    private Toolbar mTool;
    private ViewPager mVp;
    private TabLayout mTab;
    private ArrayList<Fragment> fs;
    private BlankFragment blankFragment;
    private BlankFragment2 blankFragment2;
    private Vpadapter vpadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initFragment();
        initTab();
    }

    private void initTab() {
        mTab.getTabAt(0).setText("主页");
        mTab.getTabAt(1).setText("图册");

        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if(position==0){

                    mTvTool.setText("主页");
                }else if(position==1){
                    mTvTool.setText("图册");
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void initFragment() {
        fs = new ArrayList<>();
        blankFragment = new BlankFragment();
        blankFragment2 = new BlankFragment2();


        fs.add(blankFragment);
        fs.add(blankFragment2);

        vpadapter = new Vpadapter(getSupportFragmentManager(), fs);
        mVp.setAdapter(vpadapter);
        mTab.setupWithViewPager(mVp);
    }


    private void initView() {
        mTvTool = (TextView) findViewById(R.id.tv_tool);
        mTool = (Toolbar) findViewById(R.id.tool);
        mVp = (ViewPager) findViewById(R.id.vp);
        mTab = (TabLayout) findViewById(R.id.tab);

        mTool.setTitle("");
        setSupportActionBar(mTool);


    }
}

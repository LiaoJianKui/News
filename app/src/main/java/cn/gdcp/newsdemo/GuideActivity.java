package cn.gdcp.newsdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import cn.gdcp.newsdemo.Adapter.GuideAdpter;

/**
 * Created by Administrator on 2017/5/15.
 */

public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    //实现APP引导页面
    private ViewPager vpGuide;
    private int[] imgArray;
    private List<View> viewList;
    private ViewGroup viewGroup;
    private GuideAdpter adpter;

    //底部小圆点的实现
    private ImageView img_point;
    private ImageView[] img_pointArray;

    //最后一页的按钮
    private Button btn_start;

    //判断用户是否是第一次进入
    private boolean isFirst;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_guide);
        initView ();
    }

    private void initView() {
        vpGuide= (ViewPager) findViewById(R.id.vp_guide);
        btn_start= (Button) findViewById(R.id.btnStart);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(GuideActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        imgArray=new int[]{R.drawable.bg1,R.drawable.bg2,R.drawable.bg3};
    viewList=new ArrayList<>();
        //获取一个布局的参数
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//创建循环将数据导入ArrayList中
        for (int i = 0; i < imgArray.length; i++) {
            ImageView img = new ImageView(this);
            img.setLayoutParams(params);
            img.setBackgroundResource(imgArray[i]);
            img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            viewList.add(img);
        }

        adpter = new GuideAdpter(viewList);
        vpGuide.setAdapter(adpter);
        //设置滑动的监听
        vpGuide.setOnPageChangeListener(this);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
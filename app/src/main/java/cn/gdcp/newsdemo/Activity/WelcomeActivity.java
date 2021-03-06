package cn.gdcp.newsdemo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import cn.gdcp.newsdemo.Adapter.TopAdapter;
import cn.gdcp.newsdemo.R;
import cn.gdcp.newsdemo.Utils.SPUtils;

/**
 * Created by Administrator on 2017/5/16.
 */

public class WelcomeActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        // 如果是第一次运行  就显示引导页
        if(SPUtils.getIsFirstRun(WelcomeActivity.this)) {
            startActivity(new Intent(WelcomeActivity.this, GuideActivity.class));
            SPUtils.setIsFristRun(WelcomeActivity.this, false);
        }else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(WelcomeActivity.this, TopActivity.class));
                    finish();
                }
            }, 3000);
        }
    }
}

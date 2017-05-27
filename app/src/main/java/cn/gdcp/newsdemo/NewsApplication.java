package cn.gdcp.newsdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import cn.bmob.v3.Bmob;

/**
 * Created by Administrator on 2017/5/27 0027.
 */

public class NewsApplication extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this,"11272f2ccb5988c82f50139e890a94fa");
    }
}

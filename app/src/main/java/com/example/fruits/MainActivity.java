package com.example.fruits;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private List<PlantInfo> plantInfos;
    private TextView mPlantContentTV;
    private ImageView mPlantImgv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            //获取植物信息
            plantInfos = Utils.getPlantInfos(getResources().getAssets().open("plant.xml"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        initView();

    }

    //初始化控件
    private void initView() {
        findViewById(R.id.btn_pg).setOnClickListener(this);
        findViewById(R.id.btn_xj).setOnClickListener(this);
        findViewById(R.id.btn_xg).setOnClickListener(this);
        findViewById(R.id.btn_jz).setOnClickListener(this);
        mPlantContentTV = (TextView) findViewById(R.id.tv_plants_content);
        mPlantImgv = (ImageView) findViewById(R.id.imgv_plant);
        mPlantContentTV.setText(plantInfos.get(0).getPlantContent());
        mPlantImgv.setBackgroundResource(R.drawable.a);
    }

    //点击按钮
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_pg:
                //设置水果简介
                mPlantContentTV.setText(plantInfos.get(0).getPlantContent());
                mPlantImgv.setBackgroundResource(R.drawable.a);
                break;
            case R.id.btn_xj:
                mPlantContentTV.setText(plantInfos.get(1).getPlantContent());
                mPlantImgv.setBackgroundResource(R.drawable.b);
                break;
            case R.id.btn_xg:
                mPlantContentTV.setText(plantInfos.get(2).getPlantContent());
                mPlantImgv.setBackgroundResource(R.drawable.c);
                break;
            case R.id.btn_jz:
                mPlantContentTV.setText(plantInfos.get(3).getPlantContent());
                mPlantImgv.setBackgroundResource(R.drawable.d);
                break;
        }
    }
}


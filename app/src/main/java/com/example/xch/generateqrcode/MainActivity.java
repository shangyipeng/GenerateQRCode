package com.example.xch.generateqrcode;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_generate;
    private EditText et_content;
    private ImageView iv_qrcode;
    private String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_content = findViewById(R.id.et_content);
        btn_generate = findViewById(R.id.btn_generate);
        iv_qrcode = findViewById(R.id.iv_qrcode);
        btn_generate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_generate:
                content=et_content.getText().toString();
                Resources res = getResources();
                Bitmap logoBitmap= BitmapFactory.decodeResource(res,R.mipmap.logo);
                Bitmap blackBitmap= BitmapFactory.decodeResource(res,R.mipmap.bitmap_black2);

                Bitmap mBitmap = QRCodeUtil.createQRCodeBitmap(content, 800, 800,"UTF-8",
                        "H", "1", Color.BLACK, Color.WHITE,logoBitmap,0.2F,blackBitmap);
                iv_qrcode.setImageBitmap(mBitmap);
                break;
            default:
                break;
        }
    }
}

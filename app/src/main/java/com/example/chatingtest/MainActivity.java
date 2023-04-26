package com.example.chatingtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    String user_name = "nooty";
    String TAG = "MainActivity";

    Socket sk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView user_name_txt = (TextView) findViewById(R.id.user_ID);
        Button chat_bt = (Button) findViewById(R.id.chat_bt);

        user_name_txt.setText("이름 : " + user_name);
        user_name_txt.setTextSize(40);

        chat_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG,"채팅방 입장 클릭되나?");

                new Thread(() -> {
                    try {
                        sk = new Socket("172.30.1.17",6000);
                        Log.e(TAG,"서버와 연결되었습니다.");
                        Log.e(TAG,"소켓 바인딩 체크 : " + sk.isBound());

                        // 액티비티 전환
                        if (sk.isBound()) {
                            Log.e(TAG,"액티비티 옮겨지나?");
                        }else {
                            Log.e(TAG,"서버와 연결이 되지 않았습니다.");
                        }
                    } catch (IOException e) {

                        throw new RuntimeException(e);
                    }
                }).start();

            }
        });



    }
}
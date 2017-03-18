package com.example.laurescemama.chachat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.axample.chachat.MESSAGE";

    private ListView listView;
    private EditText chatText;
    private Button sendBtn;
    private ArrayAdapter<String> adapter;
    ArrayList<String> chatArray;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent intent = getIntent();
        chatArray = new ArrayList<String>();
        sendBtn = (Button) findViewById(R.id.btn);
        listView = (ListView)findViewById(R.id.listview);
        chatText = (EditText)findViewById(R.id.chat);
        adapter = new ArrayAdapter<String>(MainActivity.this,
                R.layout.list_item, R.id.SingleMessage, chatArray);
        listView.setAdapter(adapter);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getText = chatText.getText().toString();
                if (getText != null && getText.trim().length()>0){
                    chatArray.add((getText));

                    adapter.notifyDataSetChanged();
                }
                chatText.setText(" ");
            }
        });

    }



}

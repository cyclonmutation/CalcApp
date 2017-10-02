package jp.techacademy.yoshie.sekiguchi.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mTextView = (TextView) findViewById(R.id.textView);
        TextView mTextView;

        //画面遷移
        Log.d("CALC-APP", "画面遷移");
        Intent intent = getIntent();
        float value1 = (float) intent.getFloatExtra("VALUE1", 0);

        //textViewに結果を表示する
        Log.d("CALC-APP", "結果表示");
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(String.valueOf(value1));
    }


}

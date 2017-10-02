package jp.techacademy.yoshie.sekiguchi.calcapp;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText1;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        mEditText1 = (EditText) findViewById(R.id.editText1);
        mEditText2 = (EditText) findViewById(R.id.editText2);
    }

    @Override
    public void onClick(View v) {
        //四則演算結果
        float result = 0;

        //onClick時、buttonのidで挙動を分ける
        if (v.getId() == R.id.button1) {    //足し算
            Log.d("CALC-APP", "足し算" + result);
            result = Float.valueOf(this.mEditText1.getText().toString()) + Float.valueOf(this.mEditText2.getText().toString());
            Log.d("CALC-APP", "足し算" + result);

        } else if (v.getId() == R.id.button2) { //引き算
            result = Float.valueOf(this.mEditText1.getText().toString()) - Float.valueOf(this.mEditText2.getText().toString());
            Log.d("CALC-APP", "引き算" + result);

        } else if (v.getId() == R.id.button3) { //掛け算
            result = Float.valueOf(this.mEditText1.getText().toString()) * Float.valueOf(this.mEditText2.getText().toString());
            Log.d("CALC-APP", "掛け算" + result);

        } else if (v.getId() == R.id.button4) { //割り算
            result = Float.valueOf(this.mEditText1.getText().toString()) / Float.valueOf(this.mEditText2.getText().toString());
            Log.d("CALC-APP", "割り算" + result);
        }

        //画面遷移
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("VALUE1", result);
        startActivity(intent);
    }

}

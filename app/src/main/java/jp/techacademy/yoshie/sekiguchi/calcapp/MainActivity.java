package jp.techacademy.yoshie.sekiguchi.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;
import android.widget.Toast;

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
        //四則演算用の変数
        double result = 0;
        double num1 = 0;
        double num2 = 0;

        //入力チェック
        try{
            num1 = Double.valueOf(this.mEditText1.getText().toString());
            num2 = Double.valueOf(this.mEditText2.getText().toString());
        } catch (Exception e) {
            //プラスマイナスの数値以外が入力された場合、アラートを表示して四則演算処理しない
            Toast.makeText(this, "数字を入力してください", Toast.LENGTH_LONG).show();

/* 以下ToastだとgetActivity()がエラーになるので、toastで処理する方法へ変更
            new AlertDialog.Builder(getActivity())
                    .setTitle("Error")
                    .setMessage("入力内容に誤りがあります。数字を入力してください")
                    .setPositiveButton("修正する", null)
                    .show();
*/
            return; //以下の処理をしないで終える
        }

        //onClick時、buttonのidで挙動を分ける
        if (v.getId() == R.id.button1) {    //足し算
            Log.d("CALC-APP", "足し算" + result);
            result = num1 + num2;
            Log.d("CALC-APP", "足し算" + result);

        } else if (v.getId() == R.id.button2) { //引き算
            result = num1 - num2;
            Log.d("CALC-APP", "引き算" + result);

        } else if (v.getId() == R.id.button3) { //掛け算
            result = num1 * num2;
            Log.d("CALC-APP", "掛け算" + result);

        } else if (v.getId() == R.id.button4) { //割り算

            if (num2 == 0){
                //0では割れないため、intent飛ばさずに、toast表示して終了する
                Toast.makeText(this, "0では割ることができません", Toast.LENGTH_LONG).show();
                return;

            } else {    //0以外の場合は割り算をする
                result = num1 / num2;
                Log.d("CALC-APP", "割り算" + result);
            }
        }

        //画面遷移
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("VALUE1", result);
        startActivity(intent);
    }

}

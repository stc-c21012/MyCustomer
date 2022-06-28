package jp.suntech.c21012.mycustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btClick=findViewById(R.id.btClick);
        HelloListener listener =new HelloListener();//リスナのインスタンス生成
        btClick.setOnClickListener(listener);//ボタンにリスナを組み込む

        Button btnameClear=findViewById(R.id.btnameclear);
        btnameClear.setOnClickListener(listener);

        Button btaddressClear=findViewById(R.id.btaddressclear);
        btaddressClear.setOnClickListener(listener);
    }

    //リスナクラス<=イベントの監視
    private class HelloListener implements View.OnClickListener{

        //イベントハンドラ<=イベント発生時の処理
        @Override
        public void onClick(View view){
            EditText input = findViewById(R.id.etName);
            EditText ab=findViewById(R.id.etAddress);
            TextView output = findViewById(R.id.tvOutput);
            String inputStr =input.getText().toString();
            String inputStr2 =ab.getText().toString();
            int id=view.getId();
            switch (id){
                case R.id.btClick:

                    output.setText(inputStr+"にお住いの"+inputStr2+"さん、こんにちは！");
                    break;
                case R.id.btaddressclear:
                    input.setText("");
                    inputStr="";
                    output.setText(inputStr+"にお住いの"+inputStr2+"さん、こんにちは！");
                    break;
                case R.id.btnameclear:
                    ab.setText("");
                    inputStr2="";
                    output.setText(inputStr+"にお住いの"+inputStr2+"さん、こんにちは！");
                    break;
            }
        }
    }
}
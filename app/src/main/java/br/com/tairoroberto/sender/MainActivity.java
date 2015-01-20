package br.com.tairoroberto.sender;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity extends ActionBarActivity {
    private LinearLayout layout1,layout2;
    private ImageView imageView;
    private String correctPassword = "ttaairo";
    private String senhaDigitada;
    private int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout1 = (LinearLayout)findViewById(R.id.linear1Login);
        layout2 = (LinearLayout)findViewById(R.id.linear2Login);
        imageView = (ImageView)findViewById(R.id.imageView);
        count = 0;
        senhaDigitada = "";


        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count < 4){
                    senhaDigitada += "t";
                }else{
                    senhaDigitada += "r";
                }
                count++;
                Log.i("Script","senha: " +senhaDigitada);
                Log.i("Script","count: " +count);
                chamaTela();
            }
        });

        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count <= 4){
                    senhaDigitada += "a";
                }else{
                    senhaDigitada += "o";

                }
                count++;
                Log.i("Script","senha: " +senhaDigitada);
                Log.i("Script","count: " +count);
                chamaTela();
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count == 4){
                    senhaDigitada += "i";
                }else{
                    senhaDigitada += "t";
                }

                if (count < 7){
                    count++;
                }


                Log.i("Script","senha: " +senhaDigitada);
                Log.i("Script","count: " +count);
                chamaTela();
            }
        });


    }

    public  void chamaTela(){
        if (count == 7){
            Log.i("Script","senha digitada: " +senhaDigitada);
            Log.i("Script","senha correta: " + correctPassword);
            if (senhaDigitada.equals(correctPassword) ){
                Intent intent = new Intent(MainActivity.this,PrincipalActivity.class);
                startActivity(intent);
            }else{
                Intent intent = new Intent(MainActivity.this,FotosActivity.class);
                startActivity(intent);
            }
        }
    }
}

package com.example.currency;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void AlertDialog(String title, String message){
        AlertDialog.Builder Builder = new AlertDialog.Builder(MainActivity.this);
        Builder.setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setNegativeButton("ОК", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog Alert = Builder.create();
        Alert.show();
    }

    public void Consider(View view){
        EditText etRate = findViewById(R.id.etRate);
        EditText etSum = findViewById(R.id.etSum);
        TextView tvResult = findViewById(R.id.tvResult);
        Switch dollar = findViewById(R.id.switch1);

        if(etRate.getText().length() == 0){
            AlertDialog("Уведомление", "Введите стоимость доллара");
            return;
        }
        if(etSum.getText().length() == 0){
            AlertDialog("Уведомление", "Введите количество валюты");
            return;
        }

        float f_rate = Float.parseFloat(String.valueOf(etRate.getText()));
        float f_sum = Float.parseFloat(String.valueOf(etSum.getText()));

        String composition = "";
        if(dollar.isChecked()){
            composition = f_rate*f_sum + " р.";
        }
        else
            composition = f_sum/f_rate + " $.";
        tvResult.setText(composition);
    }

    public void URL(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.sberbank.ru/ru/quotes/currencies"));
        startActivity(intent);
    }
}
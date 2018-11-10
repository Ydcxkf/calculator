package com.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {
    boolean ready=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnZero = (Button) findViewById(R.id.buttonZero);
        Button btnOne = (Button) findViewById(R.id.buttonOne);
        Button btnTwo = (Button) findViewById(R.id.buttonTwo);
        Button btnThree = (Button) findViewById(R.id.buttonThree);
        Button btnFour = (Button) findViewById(R.id.buttonFour);
        Button btnFive = (Button) findViewById(R.id.buttonFive);
        Button btnSix = (Button) findViewById(R.id.buttonSix);
        Button btnSeven = (Button) findViewById(R.id.buttonSeven);
        Button btnEight = (Button) findViewById(R.id.buttonEight);
        Button btnNine = (Button) findViewById(R.id.buttonNine);
        Button btnLeft = (Button) findViewById(R.id.buttonLeft);
        Button btnRight = (Button) findViewById(R.id.buttonRight);
        Button btnDelete = (Button) findViewById(R.id.buttonDelete);
        Button btnRemainder = (Button) findViewById(R.id.buttonRemainder);
        Button btnPoint = (Button) findViewById(R.id.buttonPoint);
        Button btnClear = (Button) findViewById(R.id.buttonClear);
        Button btnRemove = (Button) findViewById(R.id.buttonRemove);
        Button btnRide = (Button) findViewById(R.id.buttonRide);
        Button btnPlus = (Button) findViewById(R.id.buttonPlus);
        Button btnReduce = (Button) findViewById(R.id.buttonReduce);
        Button btnEqual = (Button) findViewById(R.id.buttonEqual);
        final TextView txtResult = (TextView) findViewById(R.id.textResult);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ready) {
                    txtResult.setText(txtResult.getText().subSequence(0, (txtResult.getText().length() - 1)));
                    for (int i = 0; i < txtResult.getText().length(); i++) {
                        if (txtResult.getText().charAt(i) == '=') {
                            ready = false;
                        }
                    }
                }else{
                    int j=0;
                    txtResult.setText(txtResult.getText().subSequence(0, (txtResult.getText().length() - 1)));
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j++;
                        }
                    }
                    if(j==0){
                        ready=true;
                    }
                }
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ready) {
                    txtResult.setText(txtResult.getText() + "/");
                } else {
                    int j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(j,txtResult.getText().length()) + "/");
                }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("");
                ready=true;
            }
        });
        btnRemainder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ready){
                    txtResult.setText(txtResult.getText() + "%");
                }else{
                    int j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(j,txtResult.getText().length()) + "%");
                }
            }
        });
        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("");
                ready=true;
            }
        });
        btnReduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ready){
                    txtResult.setText(txtResult.getText() + "-");
                }else{
                    int j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(j,txtResult.getText().length()) + "-");
                }
                }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ready) {
                    txtResult.setText(txtResult.getText() + "=");
                    String str = txtResult.getText().toString();
                    Calculate cal = new Calculate();
                    Double result = cal.prepareParam(str);
                    if (result != null) {
                        // 处理结果并打印
                        txtResult.setText(txtResult.getText() + "\n" + MyUtils.formatResult(String.format("%." + MyUtils.RESULT_DECIMAL_MAX_LENGTH + "f", result)));
                    }
                    ready = false;
                }else{
                    txtResult.setText("");
                    ready = true;
                }
            }
        });
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ready) {
                    txtResult.setText(txtResult.getText() + "1");
                }else{
                    txtResult.setText("1");
                    ready=true;
                }
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ready) {
                    txtResult.setText(txtResult.getText() + "2");
                }else{
                    txtResult.setText("2");
                    ready=true;
                }
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ready) {
                    txtResult.setText(txtResult.getText() + "3");
                }else{
                    txtResult.setText("3");
                    ready=true;
                }
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ready) {
                    txtResult.setText(txtResult.getText() + "4");
                }else{
                    txtResult.setText("4");
                    ready=true;
                }
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ready) {
                    txtResult.setText(txtResult.getText() + "5");
                }else{
                    txtResult.setText("5");
                    ready=true;
                }
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ready) {
                    txtResult.setText(txtResult.getText() + "6");
                }else{
                    txtResult.setText("6");
                    ready=true;
                }
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ready) {
                    txtResult.setText(txtResult.getText() + "7");
                }else{
                    txtResult.setText("7");
                    ready=true;
                }
            }
        });
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ready) {
                    txtResult.setText(txtResult.getText() + "8");
                }else{
                    txtResult.setText("8");
                    ready=true;
                }
            }
        });
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ready) {
                    txtResult.setText(txtResult.getText() + "9");
                }else{
                    txtResult.setText("9");
                    ready=true;
                }
            }
        });
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ready) {
                    txtResult.setText(txtResult.getText() + "0");
                }else{
                    txtResult.setText("0");
                    ready=true;
                }
            }
        });
        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ready){
                    txtResult.setText(txtResult.getText() + "(");
                }else{
                    int j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(j,txtResult.getText().length()) + "(");
                }
            }
        });
        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ready) {
                    txtResult.setText(txtResult.getText() + ")");
                }else{
                    int j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(j,txtResult.getText().length()) + ")");
                }
            }
        });
        btnRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ready){
                    txtResult.setText(txtResult.getText() + "x");
                }else{
                    int j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(j,txtResult.getText().length()) + "x");
                }
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
                if(ready) {
                    txtResult.setText(txtResult.getText() + "+");
                }else{
                    int j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(j,txtResult.getText().length()) + "+");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.standard_item:
                Toast.makeText(this,"你已经在标准计算器界面了",Toast.LENGTH_SHORT).show();
                break;
            case R.id.science_item:
                Intent intent1=new Intent(MainActivity.this,SCActivity.class);
                startActivity(intent1);
                Toast.makeText(this,"欢迎使用科学计算器",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}
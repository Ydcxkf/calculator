package com.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SCActivity extends AppCompatActivity implements View.OnClickListener {
    boolean ready=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sc);
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
        Button btnSin = (Button) findViewById(R.id.buttonSin);
        Button btnCos = (Button) findViewById(R.id.buttonCos);
        Button btnTan = (Button) findViewById(R.id.buttonTan);
        Button btnLog = (Button) findViewById(R.id.buttonLog);
        Button btnLn = (Button) findViewById(R.id.buttonLn);
        Button btnΠ = (Button) findViewById(R.id.buttonΠ);
        Button btnMod = (Button) findViewById(R.id.buttonMod);
        Button btnPower = (Button) findViewById(R.id.buttonPower);
        Button btnScientific = (Button) findViewById(R.id.buttonScientific);
        Button btnSquare = (Button) findViewById(R.id.buttonSquare);
        Button btnCube = (Button) findViewById(R.id.buttonCube);
        Button btnRoot = (Button) findViewById(R.id.buttonRoot);
        Button btnSemicolon = (Button) findViewById(R.id.buttonSemicolon);
        Button btnFactorial = (Button) findViewById(R.id.buttonFactorial);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnZero.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnLeft.setOnClickListener(this);
        btnRight.setOnClickListener(this);
        btnSin.setOnClickListener(this);
        btnCos.setOnClickListener(this);
        btnTan.setOnClickListener(this);
        btnCube.setOnClickListener(this);
        btnFactorial.setOnClickListener(this);
        btnLn.setOnClickListener(this);
        btnLog.setOnClickListener(this);
        btnMod.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnPower.setOnClickListener(this);
        btnReduce.setOnClickListener(this);
        btnRemainder.setOnClickListener(this);
        btnRemove.setOnClickListener(this);
        btnRide.setOnClickListener(this);
        btnRoot.setOnClickListener(this);
        btnSemicolon.setOnClickListener(this);
        btnSquare.setOnClickListener(this);
        btnScientific.setOnClickListener(this);
        btnΠ.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final TextView txtResult = (TextView) findViewById(R.id.textResult);
        if(ready) {
            switch (v.getId()) {
                case R.id.buttonOne:
                    txtResult.setText(txtResult.getText() + "1");
                    break;
                case R.id.buttonTwo:
                    txtResult.setText(txtResult.getText() + "2");
                    break;
                case R.id.buttonThree:
                    txtResult.setText(txtResult.getText() + "3");
                    break;
                case R.id.buttonFour:
                    txtResult.setText(txtResult.getText() + "4");
                    break;
                case R.id.buttonFive:
                    txtResult.setText(txtResult.getText() + "5");
                    break;
                case R.id.buttonSix:
                    txtResult.setText(txtResult.getText() + "6");
                    break;
                case R.id.buttonSeven:
                    txtResult.setText(txtResult.getText() + "7");
                    break;
                case R.id.buttonEight:
                    txtResult.setText(txtResult.getText() + "8");
                    break;
                case R.id.buttonNine:
                    txtResult.setText(txtResult.getText() + "9");
                    break;
                case R.id.buttonZero:
                    txtResult.setText(txtResult.getText() + "0");
                    break;
                case R.id.buttonEqual:
                    txtResult.setText(txtResult.getText() + "=");
                    String str = txtResult.getText().toString();
                    Calculate cal = new Calculate();
                    Double result = cal.prepareParam(str);
                    if (result != null) {
                        // 处理结果并打印
                        txtResult.setText(txtResult.getText() + "\n" + MyUtils.formatResult(String.format("%." + MyUtils.RESULT_DECIMAL_MAX_LENGTH + "f", result)));
                    }
                    ready=false;
                    break;
                case R.id.buttonClear:
                    txtResult.setText("");
                    break;
                case R.id.buttonDelete:
                    if(txtResult.getText().charAt(txtResult.getText().length()-1)=='d'||
                            txtResult.getText().charAt(txtResult.getText().length()-1)=='g'||
                            txtResult.getText().charAt(txtResult.getText().length()-1)=='s'){
                        txtResult.setText(txtResult.getText().subSequence(0,
                                (txtResult.getText().length() - 3)));
                    }else if(txtResult.getText().charAt(txtResult.getText().length()-1)=='n'){
                        if(txtResult.getText().charAt(txtResult.getText().length()-2)=='l'){
                            txtResult.setText(txtResult.getText().subSequence(0,
                                    (txtResult.getText().length() - 2)));
                        }else{
                            txtResult.setText(txtResult.getText().subSequence(0,
                                    (txtResult.getText().length() - 3)));
                        }
                    }else {
                        txtResult.setText(txtResult.getText().subSequence(0,
                                (txtResult.getText().length() - 1)));
                    }
                    break;
                case R.id.buttonLeft:
                    txtResult.setText(txtResult.getText() + "(");
                    break;
                case R.id.buttonRight:
                    txtResult.setText(txtResult.getText() + ")");
                    break;
                case R.id.buttonSin:
                    txtResult.setText(txtResult.getText() + "sin");
                    break;
                case R.id.buttonCos:
                    txtResult.setText(txtResult.getText() + "cos");
                    break;
                case R.id.buttonTan:
                    txtResult.setText(txtResult.getText() + "tan");
                    break;
                case R.id.buttonCube:
                    txtResult.setText(txtResult.getText() + "^3");
                    break;
                case R.id.buttonFactorial:
                    txtResult.setText(txtResult.getText() + "!");
                    break;
                case R.id.buttonLn:
                    txtResult.setText(txtResult.getText() + "ln");
                    break;
                case R.id.buttonLog:
                    txtResult.setText(txtResult.getText() + "log");
                    break;
                case R.id.buttonMod:
                    txtResult.setText(txtResult.getText() + "mod");
                    break;
                case R.id.buttonPlus:
                    txtResult.setText(txtResult.getText() + "+");
                    break;
                case R.id.buttonPoint:
                    txtResult.setText(txtResult.getText() + ".");
                    break;
                case R.id.buttonPower:
                    txtResult.setText(txtResult.getText() + "^");
                    break;
                case R.id.buttonReduce:
                    txtResult.setText(txtResult.getText() + "-");
                    break;
                case R.id.buttonRemainder:
                    txtResult.setText(txtResult.getText() + "%");
                    break;
                case R.id.buttonRemove:
                    txtResult.setText(txtResult.getText() + "/");
                    break;
                case R.id.buttonRide:
                    txtResult.setText(txtResult.getText() + "x");
                    break;
                case R.id.buttonRoot:
                    txtResult.setText(txtResult.getText() + "√");
                    break;
                case R.id.buttonScientific:
                    txtResult.setText(txtResult.getText() + "x10^");
                    break;
                case R.id.buttonSemicolon:
                    txtResult.setText(txtResult.getText() + "1/");
                    break;
                case R.id.buttonSquare:
                    txtResult.setText(txtResult.getText() + "^2");
                    break;
                case R.id.buttonΠ:
                    txtResult.setText(txtResult.getText() + "Π");
                    break;
                default:
                    break;

            }
        }else{
            switch (v.getId()) {
                case R.id.buttonOne:
                    txtResult.setText("1");
                    ready=true;
                    break;
                case R.id.buttonTwo:
                    txtResult.setText("2");
                    ready=true;
                    break;
                case R.id.buttonThree:
                    txtResult.setText("3");
                    ready=true;
                    break;
                case R.id.buttonFour:
                    txtResult.setText("4");
                    ready=true;
                    break;
                case R.id.buttonFive:
                    txtResult.setText("5");
                    ready=true;
                    break;
                case R.id.buttonSix:
                    txtResult.setText("6");
                    ready=true;
                    break;
                case R.id.buttonSeven:
                    txtResult.setText("7");
                    ready=true;
                    break;
                case R.id.buttonEight:
                    txtResult.setText("8");
                    ready=true;
                    break;
                case R.id.buttonNine:
                    txtResult.setText("9");
                    ready=true;
                    break;
                case R.id.buttonZero:
                    txtResult.setText("0");
                    ready=true;
                    break;
                case R.id.buttonEqual:
                    txtResult.setText("");
                    ready=true;
                    break;
                case R.id.buttonClear:
                    txtResult.setText("");
                    ready=true;
                    break;
                case R.id.buttonDelete:
                    if(txtResult.getText().charAt(txtResult.getText().length()-1)=='d'||
                            txtResult.getText().charAt(txtResult.getText().length()-1)=='g'||
                            txtResult.getText().charAt(txtResult.getText().length()-1)=='s'){
                        txtResult.setText(txtResult.getText().subSequence(0,
                                (txtResult.getText().length() - 3)));
                    }else if(txtResult.getText().charAt(txtResult.getText().length()-1)=='n'){
                        if(txtResult.getText().charAt(txtResult.getText().length()-2)=='l'){
                            txtResult.setText(txtResult.getText().subSequence(0,
                                    (txtResult.getText().length() - 2)));
                        }else{
                            txtResult.setText(txtResult.getText().subSequence(0,
                                    (txtResult.getText().length() - 3)));
                        }
                    }else {
                        txtResult.setText(txtResult.getText().subSequence(0,
                                (txtResult.getText().length() - 1)));
                    }
                    int j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j++;
                        }
                    }
                    if(j==0){
                        ready=true;
                    }
                    break;
                case R.id.buttonLeft:
                    j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(
                            j,txtResult.getText().length()) + "(");
                    break;
                case R.id.buttonRight:
                    j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(
                            j,txtResult.getText().length()) + ")");
                    break;
                case R.id.buttonSin:
                    j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(
                            j,txtResult.getText().length()) + "sin");
                    break;
                case R.id.buttonCos:
                    j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(
                            j,txtResult.getText().length()) + "cos");
                    break;
                case R.id.buttonTan:
                    j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(
                            j,txtResult.getText().length()) + "tan");
                    break;
                case R.id.buttonCube:
                    j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(
                            j,txtResult.getText().length()) + "^3");
                    break;
                case R.id.buttonFactorial:
                    j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(
                            j,txtResult.getText().length()) + "!");
                    break;
                case R.id.buttonLn:
                    j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(
                            j,txtResult.getText().length()) + "ln");
                    break;
                case R.id.buttonLog:
                    j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(
                            j,txtResult.getText().length()) + "log");
                    break;
                case R.id.buttonMod:
                    j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(
                            j,txtResult.getText().length()) + "mod");
                    break;
                case R.id.buttonPlus:
                    j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(
                            j,txtResult.getText().length()) + "+");
                    break;
                case R.id.buttonPoint:
                    j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(
                            j,txtResult.getText().length()) + ".");
                    break;
                case R.id.buttonPower:
                    j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(
                            j,txtResult.getText().length()) + "^");
                    break;
                case R.id.buttonReduce:
                    j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(
                            j,txtResult.getText().length()) + "-");
                    break;
                case R.id.buttonRemainder:
                    j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(
                            j,txtResult.getText().length()) + "%");
                    break;
                case R.id.buttonRemove:
                    j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(
                            j,txtResult.getText().length()) + "/");
                    break;
                case R.id.buttonRide:
                    j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(
                            j,txtResult.getText().length()) + "x");
                    break;
                case R.id.buttonRoot:
                    j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(
                            j,txtResult.getText().length()) + "√");
                    break;
                case R.id.buttonScientific:
                    j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(
                            j,txtResult.getText().length()) + "x10^");
                    break;
                case R.id.buttonSemicolon:
                    j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(
                            j,txtResult.getText().length()) + "1/");
                    break;
                case R.id.buttonSquare:
                    j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(
                            j,txtResult.getText().length()) + "^2");
                    break;
                case R.id.buttonΠ:
                    j=0;
                    for(int i=0;i<txtResult.getText().length();i++){
                        if(txtResult.getText().charAt(i)=='='){
                            j=i+2;
                        }
                    }
                    ready=true;
                    txtResult.setText(txtResult.getText().subSequence(
                            j,txtResult.getText().length()) + "xΠ");
                    break;
                default:
                    break;
            }
        }
    }

    //菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.standard_item:
                Toast.makeText(this, "欢迎使用标准计算器", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(SCActivity.this, MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.science_item:
                Toast.makeText(this, "你已经在科学计算器界面了", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}

package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnadd,btnsub,btnmul,btndiv,btnclr,btneq,btndot;
    EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.b1);
        btn1.setOnClickListener(this);

        btn2 = (Button) findViewById(R.id.b2);
        btn2.setOnClickListener(this);

        btn3 = (Button) findViewById(R.id.b3);
        btn3.setOnClickListener(this);

        btn4 = (Button) findViewById(R.id.b4);
        btn4.setOnClickListener(this);

        btn5 = (Button) findViewById(R.id.b5);
        btn5.setOnClickListener(this);

        btn6 = (Button) findViewById(R.id.b6);
        btn6.setOnClickListener(this);

        btn7 = (Button) findViewById(R.id.b7);
        btn7.setOnClickListener(this);

        btn8 = (Button) findViewById(R.id.b8);
        btn8.setOnClickListener(this);

        btn9 = (Button) findViewById(R.id.b9);
        btn9.setOnClickListener(this);

        btn0 = (Button) findViewById(R.id.b0);
        btn0.setOnClickListener(this);

        btndot = (Button) findViewById(R.id.bdot);
        btndot.setOnClickListener(this);

        btnmul = (Button) findViewById(R.id.bmul);
        btnmul.setOnClickListener(this);

        btndiv = (Button) findViewById(R.id.bdiv);
        btndiv.setOnClickListener(this);

        btneq = (Button) findViewById(R.id.beq);
        btneq.setOnClickListener(this);

        btnadd = (Button) findViewById(R.id.badd);
        btnadd.setOnClickListener(this);

        btnsub = (Button) findViewById(R.id.bsub);
        btnsub.setOnClickListener(this);

        btnclr = (Button) findViewById(R.id.bclr);
        btnclr.setOnClickListener(this);

        txt = (EditText) findViewById(R.id.txt);
        txt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v.equals(btn1))
            txt.append("1");
        if(v.equals(btn2))
            txt.append("2");
        if(v.equals(btn3))
            txt.append("3");
        if(v.equals(btn4))
            txt.append("4");
        if(v.equals(btn5))
            txt.append("5");
        if(v.equals(btn6))
            txt.append("6");
        if(v.equals(btn7))
            txt.append("7");
        if(v.equals(btn8))
            txt.append("8");
        if(v.equals(btn9))
            txt.append("9");
        if(v.equals(btn0))
            txt.append("0");
        if(v.equals(btnadd))
            txt.append("+");
        if(v.equals(btnsub))
            txt.append("-");
        if(v.equals(btnmul))
            txt.append("X");
        if(v.equals(btndiv))
            txt.append("/");
        if(v.equals(btnclr))
            txt.setText("");
        if(v.equals(btndot))
            txt.append(".");
        if(v.equals(btneq))
        {
            try{
                String data = txt.getText().toString();
                if(data.contains("/"))
                    divide(data);
                else if(data.contains("X"))
                    multiply(data);
                else if(data.contains("+"))
                    addition(data);
                else if(data.contains("-"))
                    subtract(data);
            }
            catch(Exception e)
            {
                displayInvalidMessage("Invalid Operator");
            }
        }
    }

    private void subtract(String data)
    {
        String[] operands = data.split("-");
        if(operands.length == 2)
        {
            double operand1 = Double.parseDouble(operands[0]);
            double operand2 = Double.parseDouble(operands[1]);
            double res = operand1-operand2;
            txt.setText(String.valueOf(res));
        }
        else{
            displayInvalidMessage("Invalid Input");
        }
    }
    private void displayInvalidMessage(String msg)
    {
        Toast.makeText(getBaseContext(),msg, Toast.LENGTH_LONG).show();
    }

    private void addition(String data)
    {
        String[] operands = data.split(Pattern.quote("+"));
        if(operands.length == 2)
        {
            double operand1 = Double.parseDouble(operands[0]);
            double operand2 = Double.parseDouble(operands[1]);
            double res = operand1 + operand2;
            txt.setText(String.valueOf(res));
        }
        else{
            displayInvalidMessage("Invalid Input");
        }
    }

    private void multiply(String data)
    {
        String[] operands = data.split("X");
        if(operands.length == 2)
        {
            double operand1 = Double.parseDouble(operands[0]);
            double operand2 = Double.parseDouble(operands[1]);
            double res = operand1*operand2;
            txt.setText(String.valueOf(res));
        }
        else{
            displayInvalidMessage("Invalid Input");
        }
    }

    private void divide(String data)
    {
        String[] operands = data.split("/");
        if(operands.length == 2)
        {
            double operand1 = Double.parseDouble(operands[0]);
            double operand2 = Double.parseDouble(operands[1]);
            try{
                double res = operand1/operand2;
                txt.setText(String.valueOf(res));
            }
            catch(Exception e){
                displayInvalidMessage("Invalid Input");
            }
        }
        else{
            displayInvalidMessage("Invalid Input");
        }
    }
}

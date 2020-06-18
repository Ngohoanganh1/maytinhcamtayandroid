package com.example.maytinhcamtay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    TextView input,  output,tvResult;
    private Button AC,del,off,cong, tru,pi, nhan,canbac2,canbac3, chia, result, thapphan;
    private Button num1,num2,num3,num4,num5,num7,num8,num9, num6, num0;
    private DecimalFormat df;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
                output.setText("0");
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer str = new StringBuffer(input.getText());
                if(str.length() > 0){
                    str.deleteCharAt(str.length()-1);input.setText(str);
                    if(str.length() > 0) Result(); else output.setText("0");
                }
            }
        });
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"0");Result(); output.setText("");
            }
        });
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"1");Result(); output.setText("");
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"2");Result(); output.setText("");
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"3");Result(); output.setText("");
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"4");Result(); output.setText("");
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"5");Result(); output.setText("");
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"6");Result(); output.setText("");
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"7");Result(); output.setText("");
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"8");Result(); output.setText("");
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"9");
                output.setText("");
                Result();
            }
        });
        canbac3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             StringBuilder string = new StringBuilder();
              string.append(Math.cbrt(3));
              input.append(string);

            }
        });
        canbac2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                      StringBuilder string = new StringBuilder();
                      string.append(Math.sqrt(2));
                      input.append(string);


            }

        });
        pi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               StringBuilder string = new StringBuilder();
                string.append(Math.PI);
                input.append(string);
            }
        });
        thapphan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().length() >0) if(Character.isDigit(input.getText().charAt(input.getText().length()-1)) )  input.setText(input.getText()+".");
            }
        });
        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startActivity(startMain);
                finish();
            }
        });
        tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output.setText("");
                if(output.getText()!="0" && input.getText()=="")
                {
                    input.setText(output.getText()+"-");
                }
                if(input.getText().length()==0) input.setText(input.getText()+"-");
                else if(Character.isDigit(input.getText().charAt(input.getText().length()-1)) || input.getText().charAt(input.getText().length()-1)=='/' || input.getText().charAt(input.getText().length()-1)=='x' )  input.setText(input.getText()+"-");
            }
        });
        cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().length() >0) if(Character.isDigit(input.getText().charAt(input.getText().length()-1)) ) input.setText(input.getText()+"+");
                if(output.getText()!="0" && input.getText()=="")
                {
                    input.setText(output.getText()+"+");
                }
            }
        });
        nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().length() >0) if(Character.isDigit(input.getText().charAt(input.getText().length()-1)))  input.setText(input.getText()+"x");
                if(output.getText()!="0" && input.getText()=="")
                {
                    input.setText(output.getText()+"x");
                }
            }
        });
        chia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().length() >0) if(Character.isDigit(input.getText().charAt(input.getText().length()-1)))  input.setText(input.getText()+"/");
                if(output.getText()!="0" && input.getText()=="")
                {
                    input.setText(output.getText()+"/");
                }
            }
        });
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().length() > 1 ) Result();
                input.setText(output.getText()+" =");
                input.setText("");
            }
        });

    }
    private ArrayList<String> arrOperation;
    private ArrayList<Double> arrNumber;
    public int addOperation(String input) {
        arrOperation = new ArrayList<>();
        addNumber(this.input.getText().toString());
        if(this.input.getText().charAt(0)=='-') arrNumber.set(0,-arrNumber.get(0));
        char[] cArray = input.toCharArray();
        for (int i = 1; i < cArray.length; i++) {
            switch (cArray[i]) {
                case '+':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '-':
                    arrOperation.add(cArray[i] + "");
                    break;
                case 'x':
                    arrOperation.add(cArray[i] + "");
                    if(i<cArray.length-1) if(cArray[i+1] =='-' && i+1 <cArray.length-1 )
                    {
                        arrNumber.set(arrOperation.size(),-arrNumber.get(arrOperation.size()));
                        i++;
                    }
                    break;
                case '/':
                    arrOperation.add(cArray[i] + "");
                    if(i<cArray.length-1) if(cArray[i+1] =='-' && i+1 <cArray.length-1 )
                    {
                        arrNumber.set(arrOperation.size(),-arrNumber.get(arrOperation.size()));
                        i++;
                    }
                    break;
                default:
                    break;
            }
        }
        return 0;
    }

    public void addNumber(String stringInput) {
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while(matcher.find()){
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }
    public void Result()
    {
        DecimalFormat df = new DecimalFormat("###.#######");
        double result = 0;
        addOperation(input.getText().toString());
        if(arrNumber.size()==1)  result = arrNumber.get(0);
        if(arrOperation.size()>arrNumber.size() ||arrOperation.size()<0){
            output.setText("Input error!!");
        }else {
            for (int i = 0; i < (arrNumber.size() - 1); i++) {
                switch (arrOperation.get(i)) {
                    case "x":
                        arrNumber.set(i, arrNumber.get(i) * arrNumber.get(i + 1));
                        arrNumber.remove(i+1); arrOperation.remove(i);
                        i--;
                        break;
                    case "/":
                        arrNumber.set(i, arrNumber.get(i) / arrNumber.get(i + 1));
                        arrNumber.remove(i+1); arrOperation.remove(i);
                        i--;
                    default:
                        break;
                }
            }
            result = arrNumber.get(0);
            for (int i = 0; i < (arrNumber.size() - 1); i++) {
                switch (arrOperation.get(i)) {
                    case "+":
                        result = result + arrNumber.get(i + 1);
                        break;
                    case "-":
                        result = result - arrNumber.get(i + 1);
                        break;
                    default:
                        break;
                }
            }
            output.setText(df.format(result) + "");
        }
    }
    public void AnhXa()
    {
        canbac3 =(Button) findViewById(R.id.canbac3);
        canbac2 = (Button) findViewById(R.id.canbac2);
        pi = (Button) findViewById(R.id.pi) ;
        input = (TextView) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.output);
        AC = (Button) findViewById(R.id.AC);
        thapphan = (Button)findViewById(R.id.thapphan);
        del = (Button) findViewById(R.id.Delete);
        off = (Button) findViewById(R.id.off);
        cong = (Button) findViewById(R.id.daucong);
        tru = (Button) findViewById(R.id.dautru);
        nhan = (Button) findViewById(R.id.phepnhan);
        chia = (Button) findViewById(R.id.phepchia);
        result = (Button) findViewById(R.id.result);
        num0 = (Button) findViewById(R.id.num0);
        num1 = (Button) findViewById(R.id.num1);
        num2 = (Button) findViewById(R.id.num2);
        num3 = (Button) findViewById(R.id.num3);
        num4 = (Button) findViewById(R.id.num4);
        num5 = (Button) findViewById(R.id.num5);
        num6 = (Button) findViewById(R.id.num6);
        num7 = (Button) findViewById(R.id.num7);
        num8 = (Button) findViewById(R.id.num8);
        num9 = (Button) findViewById(R.id.num9);

    }

}

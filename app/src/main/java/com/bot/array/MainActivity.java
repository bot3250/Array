package com.bot.array;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView outPut;
    EditText inputText;
    Button buttonReady;
    String exponent;
    int[] arrayInt;
    int[] reversArrayInt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.text_input);
        outPut = findViewById(R.id.text_output);
        buttonReady = findViewById(R.id.button_ready);
        buttonReady.setOnClickListener(listenerReady);
    }

    private View.OnClickListener listenerReady = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            exponent = String.valueOf(inputText.getText());
            arrayInt = arrayInt(exponent);
            outPut.setText("Количество Цифр 3:"+valueNumber(3)+"\n Количество Цифр 5:"+valueNumber(5)+
                    "\n самая не популярная цифра:" + unpopularNumber()+"\n массив обратном порядке"+reversArrayInt());
        }
    };

    private int unpopularNumber(){
        int[] count = new int[10];
        for (int i : arrayInt){
            switch (i) {
                case 0:
                    count[0]++;
                    break;
                case 1:
                    count[1]++;
                    break;
                case 2:
                    count[2]++;
                    break;
                case 3:
                    count[3]++;
                    break;
                case 4:
                    count[4]++;
                    break;
                case 5:
                    count[5]++;
                    break;
                case 6:
                    count[6]++;
                    break;
                case 7:
                    count[7]++;
                    break;
                case 8:
                    count[8]++;
                    break;
                case 9:
                    count[9]++;
                    break;
            }
        }
        int unpopular = 0;
        for (int i = 0; i < count.length; i++)
            if(count[i]<=0)
                return i;
            else if(count[i]>count[unpopular]){
                unpopular=i;
            }
        return unpopular;
    }

    private int[] arrayInt(String exponent){
        String newExponent = exponent.replace(".", "");
        String[] arrayString = newExponent.split("");
        int[] arrayInteger = new int[arrayString.length];
        for(int i = 0; i < arrayInteger.length;i++){
            arrayInteger[i] = Integer.parseInt(arrayString[i]);
        }
        return arrayInteger;
    }

    private String reversArrayInt(){
        String arrayString="";
        for(int i = 0; i<=arrayInt.length-1; i++) {
            arrayString+=arrayInt[arrayInt.length - i-1];
        }
        return arrayString;
    }

    private int valueNumber(int number) {
        int count = 0;
        for (int i : arrayInt){
            if(i==(int) number){
                count++;
            }
        }
        return count;
    }

}
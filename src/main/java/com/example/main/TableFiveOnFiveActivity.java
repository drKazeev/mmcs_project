package com.example.main;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class TableFiveOnFiveActivity extends AppCompatActivity {

    private Chronometer mChronometer;
    private Button mButton;
    private TextView mTextView;
    private Button[] buttons = new Button[25];
    private int k = 1;
    long StartTime;
    private String value;
    private String mixing;
    private ArrayList<Integer> list = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_five_on_five);
        mButton = findViewById(R.id.button26);
        mTextView = findViewById(R.id.textView);
        mChronometer = findViewById(R.id.chronometer);
        Intent intent = getIntent();
        value = intent.getStringExtra("value");
        mixing = intent.getStringExtra("mixing");
        k = 1;
        buttons[0] = findViewById(R.id.button);
        buttons[1] = findViewById(R.id.button2);
        buttons[2] = findViewById(R.id.button3);
        buttons[3] = findViewById(R.id.button4);
        buttons[4] = findViewById(R.id.button5);
        buttons[5] = findViewById(R.id.button6);
        buttons[6] = findViewById(R.id.button7);
        buttons[7] = findViewById(R.id.button8);
        buttons[8] = findViewById(R.id.button9);
        buttons[9] = findViewById(R.id.button10);
        buttons[10] = findViewById(R.id.button11);
        buttons[11] = findViewById(R.id.button12);
        buttons[12] = findViewById(R.id.button13);
        buttons[13] = findViewById(R.id.button14);
        buttons[14] = findViewById(R.id.button15);
        buttons[15] = findViewById(R.id.button16);
        buttons[16] = findViewById(R.id.button17);
        buttons[17] = findViewById(R.id.button18);
        buttons[18] = findViewById(R.id.button19);
        buttons[19] = findViewById(R.id.button20);
        buttons[20] = findViewById(R.id.button21);
        buttons[21] = findViewById(R.id.button22);
        buttons[22] = findViewById(R.id.button23);
        buttons[23] = findViewById(R.id.button24);
        buttons[24] = findViewById(R.id.button25);

        for (int i = 0; i < 25; i++) {
            buttons[i].setVisibility(View.VISIBLE);
        }
        mTextView.setVisibility(View.VISIBLE);
        mChronometer.setVisibility(View.VISIBLE);
        mButton.setText("Начать новую игру");

        list = new ArrayList<>();
        for (int i = 1; i < 26; i++) {
            list.add(new Integer(i));
        }

        if (value.equals("Арабские цифры")) {
            Collections.shuffle(list);
            for (int i = 0; i < 25; i++) {
                buttons[i].setText(list.get(i).toString());
            }

            mTextView.setText("Найдите 1");
        }

        if (value.equals("Русские буквы")) {
            Collections.shuffle(list);
            for (int i = 0; i < 25; i++) {
                buttons[i].setText(FromDigitsToLetters(list.get(i).toString()));
            }

            mTextView.setText("Найдите А");
        }

        if (value.equals("Римские цифры")) {
            Collections.shuffle(list);
            for (int i = 0; i < 25; i++) {
                buttons[i].setText(FromRomansDigitsToLetters(list.get(i).toString()));
            }

            mTextView.setText("Найдите I");
        }

        if (value.equals("Английские буквы")) {
            Collections.shuffle(list);
            for (int i = 0; i < 25; i++) {
                buttons[i].setText(FromDigitsToEnglishLetters(list.get(i).toString()));
            }

            mTextView.setText("Найдите A");
        }

        mChronometer.setBase(SystemClock.elapsedRealtime());
        mChronometer.start();

        StartTime = System.currentTimeMillis();

    }

    public void onCLick5(View view) {

        k = 1;
        mChronometer.setVisibility(View.VISIBLE);

        list = new ArrayList<>();
        for (int i = 1; i < 26; i++) {
            list.add(new Integer(i));
        }

        if (value.equals("Арабские цифры")) {
            Collections.shuffle(list);
            for (int i = 0; i < 25; i++) {
                buttons[i].setText(list.get(i).toString());
            }

            mTextView.setText("Найдите 1");
        }

        if (value.equals("Русские буквы")) {
            Collections.shuffle(list);
            for (int i = 0; i < 25; i++) {
                buttons[i].setText(FromDigitsToLetters(list.get(i).toString()));
            }

            mTextView.setText("Найдите А");
        }

        if (value.equals("Римские цифры")) {
            Collections.shuffle(list);
            for (int i = 0; i < 25; i++) {
                buttons[i].setText(FromRomansDigitsToLetters(list.get(i).toString()));
            }

            mTextView.setText("Найдите I");
        }

        if (value.equals("Английские буквы")) {
            Collections.shuffle(list);
            for (int i = 0; i < 25; i++) {
                buttons[i].setText(FromDigitsToEnglishLetters(list.get(i).toString()));
            }

            mTextView.setText("Найдите A");
        }

        mChronometer.setBase(SystemClock.elapsedRealtime());
        mChronometer.start();

        StartTime = System.currentTimeMillis();
    }

    public void onClickRandom5(View view) {
        String text = ((Button) view).getText().toString();

        if (value.equals("Арабские цифры") && mixing.equals("Да") && text.equals(Integer.toString(k)) && (k != 25)) {
            list = new ArrayList<>();
            for (int i = 1; i < 26; i++) {
                list.add(new Integer(i));
            }
            Collections.shuffle(list);
            for (int i = 0; i < 25; i++) {
                buttons[i].setText(list.get(i).toString());
            }
        }
        if (value.equals("Арабские цифры")) {
            if (text.equals(Integer.toString(k))) {
                mTextView.setText("Найдите " + Integer.toString(k + 1));
                k++;
            }
        }


        if (value.equals("Русские буквы") && mixing.equals("Да") && text.equals(FromDigitsToLetters(Integer.toString(k))) && (k != 25)) {
            list = new ArrayList<>();
            for (int i = 1; i < 26; i++) {
                list.add(new Integer(i));
            }
            Collections.shuffle(list);
            for (int i = 0; i < 25; i++) {
                buttons[i].setText(FromDigitsToLetters(list.get(i).toString()));
            }
        }
        if (value.equals("Русские буквы")) {
            if (text.equals(FromDigitsToLetters(Integer.toString(k)))) {
                mTextView.setText("Найдите " + FromDigitsToLetters(Integer.toString(k + 1)));
                k++;
            }
        }

        if (value.equals("Римские цифры") && mixing.equals("Да") && text.equals(FromRomansDigitsToLetters(Integer.toString(k))) && (k != 25)) {
            list = new ArrayList<>();
            for (int i = 1; i < 26; i++) {
                list.add(new Integer(i));
            }
            Collections.shuffle(list);
            for (int i = 0; i < 25; i++) {
                buttons[i].setText(FromRomansDigitsToLetters(list.get(i).toString()));
            }
        }
        if (value.equals("Римские цифры")) {
            if (text.equals(FromRomansDigitsToLetters(Integer.toString(k)))) {
                mTextView.setText("Найдите " + FromRomansDigitsToLetters(Integer.toString(k + 1)));
                k++;
            }
        }

        if (value.equals("Английские буквы") && mixing.equals("Да") && text.equals(FromDigitsToEnglishLetters(Integer.toString(k))) && (k != 25)) {
            list = new ArrayList<>();
            for (int i = 1; i < 26; i++) {
                list.add(new Integer(i));
            }
            Collections.shuffle(list);
            for (int i = 0; i < 25; i++) {
                buttons[i].setText(FromDigitsToEnglishLetters(list.get(i).toString()));
            }
        }
        if (value.equals("Английские буквы")) {
            if (text.equals(FromDigitsToEnglishLetters(Integer.toString(k)))) {
                mTextView.setText("Найдите " + FromDigitsToEnglishLetters(Integer.toString(k + 1)));
                k++;
            }
        }

        if (k==26) {
            mChronometer.stop();
            long elapsedTimeMills = System.currentTimeMillis() - StartTime;
            final long sec = elapsedTimeMills / 1000;
            final int min = (int)(sec % 3600)/60;
            final int seconds = (int)sec % 60;
            mTextView.setText(String.format("    Игра окончена! \n Ваше время: %02d:%02d", min, seconds));
            mChronometer.setVisibility(View.INVISIBLE);
            k++;
        }
    }

    private static String FromDigitsToLetters(String s) {
        String res = "";
        switch (s) {
            case "1":
                res = "A";
                break;
            case "2":
                res = "Б";
                break;
            case "3":
                res = "В";
                break;
            case "4":
                res = "Г";
                break;
            case "5":
                res = "Д";
                break;
            case "6":
                res = "Е";
                break;
            case "7":
                res = "Ё";
                break;
            case "8":
                res = "Ж";
                break;
            case "9":
                res = "З";
                break;
            case "10":
                res = "И";
                break;
            case "11":
                res = "Й";
                break;
            case "12":
                res = "К";
                break;
            case "13":
                res = "Л";
                break;
            case "14":
                res = "М";
                break;
            case "15":
                res = "Н";
                break;
            case "16":
                res = "О";
                break;
            case "17":
                res = "П";
                break;
            case "18":
                res = "Р";
                break;
            case "19":
                res = "С";
                break;
            case "20":
                res = "Т";
                break;
            case "21":
                res = "У";
                break;
            case "22":
                res = "Ф";
                break;
            case "23":
                res = "Х";
                break;
            case "24":
                res = "Ц";
                break;
            case "25":
                res = "Ч";
                break;
        }
        return res;
    }

    private static String FromDigitsToEnglishLetters(String s) {
        String res = "";
        switch (s) {
            case "1":
                res = "A";
                break;
            case "2":
                res = "B";
                break;
            case "3":
                res = "C";
                break;
            case "4":
                res = "D";
                break;
            case "5":
                res = "E";
                break;
            case "6":
                res = "F";
                break;
            case "7":
                res = "G";
                break;
            case "8":
                res = "H";
                break;
            case "9":
                res = "I";
                break;
            case "10":
                res = "J";
                break;
            case "11":
                res = "K";
                break;
            case "12":
                res = "L";
                break;
            case "13":
                res = "M";
                break;
            case "14":
                res = "N";
                break;
            case "15":
                res = "O";
                break;
            case "16":
                res = "P";
                break;
            case "17":
                res = "Q";
                break;
            case "18":
                res = "R";
                break;
            case "19":
                res = "S";
                break;
            case "20":
                res = "T";
                break;
            case "21":
                res = "U";
                break;
            case "22":
                res = "V";
                break;
            case "23":
                res = "W";
                break;
            case "24":
                res = "X";
                break;
            case "25":
                res = "Y";
                break;
        }
        return res;
    }

    private static String FromRomansDigitsToLetters(String s) {
        String res = "";
        switch (s) {
            case "1":
                res = "I";
                break;
            case "2":
                res = "II";
                break;
            case "3":
                res = "III";
                break;
            case "4":
                res = "IV";
                break;
            case "5":
                res = "V";
                break;
            case "6":
                res = "VI";
                break;
            case "7":
                res = "VII";
                break;
            case "8":
                res = "VIII";
                break;
            case "9":
                res = "IX";
                break;
            case "10":
                res = "X";
                break;
            case "11":
                res = "XI";
                break;
            case "12":
                res = "XII";
                break;
            case "13":
                res = "XIII";
                break;
            case "14":
                res = "XIV";
                break;
            case "15":
                res = "XV";
                break;
            case "16":
                res = "XVI";
                break;
            case "17":
                res = "XVII";
                break;
            case "18":
                res = "XVIII";
                break;
            case "19":
                res = "XIX";
                break;
            case "20":
                res = "XX";
                break;
            case "21":
                res = "XXI";
                break;
            case "22":
                res = "XXII";
                break;
            case "23":
                res = "XXIII";
                break;
            case "24":
                res = "XXIV";
                break;
            case "25":
                res = "XXV";
                break;
        }
        return res;
    }
}

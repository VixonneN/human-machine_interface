package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.adapters.NumberOfConnectionAdapter;
import com.example.myapplication.adapters.TypeOfConnectionAdapter;
import com.example.myapplication.data_class.NumberOfConnectionData;
import com.example.myapplication.data_class.TypeOfConnectionData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements InformationFragment.OnFragmentInteractionListener {

    private TextView tv1, tv2, tv3, tv4, tv5, tv6;
    private EditText et1, et2, et3, et4, et5, et6;
    private double etS1 = 1, etS2 = 1, etS3 = 1, etS4 = 1, etS5 = 1, etS6 = 1, r0;
    private int idNumber;
    private int idType;
    private Button button;
    private Spinner numberSpinner, typeSpinner;
    private ResultDialogFragment dialogFragment;
    private static String LOG = "12312312312312312312312312";
    private InformationFragment informationFragment = new InformationFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.activity_main_frame, informationFragment)
                .commit();

        et1 = findViewById(R.id.et_r1);
        et2 = findViewById(R.id.et_r2);
        et3 = findViewById(R.id.et_r3);
        et4 = findViewById(R.id.et_r4);
        et5 = findViewById(R.id.et_r5);
        et6 = findViewById(R.id.et_r6);
        tv1 = findViewById(R.id.tv_r1);
        tv2 = findViewById(R.id.tv_r2);
        tv3 = findViewById(R.id.tv_r3);
        tv4 = findViewById(R.id.tv_r4);
        tv5 = findViewById(R.id.tv_r5);
        tv6 = findViewById(R.id.tv_r6);
        button = findViewById(R.id.buttonPanel);
        et1.setVisibility(View.INVISIBLE);
        et2.setVisibility(View.INVISIBLE);
        et3.setVisibility(View.INVISIBLE);
        et4.setVisibility(View.INVISIBLE);
        et5.setVisibility(View.INVISIBLE);
        et6.setVisibility(View.INVISIBLE);
        typeSpinner = findViewById(R.id.spinner1);
        numberSpinner = findViewById(R.id.spinner2);

        numberOfConnectionSpinner();
        typeOfConnectionSpinner();
        button();

        dialogFragment = new ResultDialogFragment();
    }

    private ArrayList<TypeOfConnectionData> typeOfConnectionDataArrayList() {
        ArrayList<TypeOfConnectionData> data = new ArrayList<>();
        data.add(new TypeOfConnectionData(1, "Параллельное подключение"));
        data.add(new TypeOfConnectionData(2, "Последовательное подключение"));
        return data;
    }

    private List<NumberOfConnectionData> numberOfConnectionArrayList() {
        List<NumberOfConnectionData> data = new ArrayList<>();
        data.add(new NumberOfConnectionData(1));
        data.add(new NumberOfConnectionData(2));
        data.add(new NumberOfConnectionData(3));
        data.add(new NumberOfConnectionData(4));
        data.add(new NumberOfConnectionData(5));
        data.add(new NumberOfConnectionData(6));
        return data;
    }

    private void numberOfConnectionSpinner() {
        NumberOfConnectionAdapter adapter = new NumberOfConnectionAdapter(this, numberOfConnectionArrayList());
        numberSpinner.setAdapter(adapter);
        numberSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    NumberOfConnectionData number = (NumberOfConnectionData) parent.getItemAtPosition(position);
                    idNumber = number.getId();
                    switch (idNumber) {
                        case (1):
                            idOne();
                            break;
                        case (2):
                            idTwo();
                            break;
                        case (3):
                            idThree();
                            break;
                        case (4):
                            idFour();
                            break;
                        case (5):
                            idFive();
                            break;
                        case (6):
                            idSix();
                            break;
                    }
                } else {
                    allInvisible();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void typeOfConnectionSpinner() {
        TypeOfConnectionAdapter adapter = new TypeOfConnectionAdapter(this, typeOfConnectionDataArrayList());
        typeSpinner.setAdapter(adapter);
        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    TypeOfConnectionData data = (TypeOfConnectionData) parent.getItemAtPosition(position);
                    idType = data.getId();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    //проверка на пустые значения
    private void button() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    switch (idNumber) {
                        case (1):
                            idNumberOne();
                            break;
                        case (2):
                            etS1 = Double.valueOf(et1.getText().toString());
                            etS2 = Double.valueOf(et2.getText().toString());
                            idNumberTwo(etS1, etS2);
                            break;
                        case (3):
                            etS1 = Double.valueOf(et1.getText().toString());
                            etS2 = Double.valueOf(et2.getText().toString());
                            etS3 = Double.valueOf(et3.getText().toString());
                            idNumberThree(etS1, etS2, etS3);
                            break;
                        case (4):
                            etS1 = Double.valueOf(et1.getText().toString());
                            etS2 = Double.valueOf(et2.getText().toString());
                            etS3 = Double.valueOf(et3.getText().toString());
                            etS4 = Double.valueOf(et4.getText().toString());
                            idNumberFour(etS1, etS2, etS3, etS4);
                            break;
                        case (5):
                            etS1 = Double.valueOf(et1.getText().toString());
                            etS2 = Double.valueOf(et2.getText().toString());
                            etS3 = Double.valueOf(et3.getText().toString());
                            etS4 = Double.valueOf(et4.getText().toString());
                            etS5 = Double.valueOf(et5.getText().toString());
                            idNumberFive(etS1, etS2, etS3, etS4, etS5);
                            break;
                        case (6):
                            etS1 = Double.valueOf(et1.getText().toString());
                            etS2 = Double.valueOf(et2.getText().toString());
                            etS3 = Double.valueOf(et3.getText().toString());
                            etS4 = Double.valueOf(et4.getText().toString());
                            etS5 = Double.valueOf(et5.getText().toString());
                            etS6 = Double.valueOf(et6.getText().toString());
                            idNumberSix(etS1, etS2, etS3, etS4, etS5, etS6);
                            break;
                    }

                    Log.d(LOG, String.valueOf(etS1));
                    Log.d(LOG, String.valueOf(etS2));
                    Log.d(LOG, String.valueOf(etS3));
                    Log.d(LOG, String.valueOf(etS4));
                    Log.d(LOG, String.valueOf(etS5));
                    Log.d(LOG, String.valueOf(etS6));


                    if (etS1 <= 0 || etS2 <= 0 || etS3 <= 0 || etS4 <= 0 || etS5 <= 0 || etS6 <= 0) {
                        Toast.makeText(MainActivity.this, "Проверьте введённые данные", Toast.LENGTH_SHORT).show();
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putInt("idType", idType);
                        bundle.putDouble("r0", r0);
                        dialogFragment.setArguments(bundle);
                        dialogFragment.show(getSupportFragmentManager(), "Dialog");
                    }

                } catch (NumberFormatException number) {
                    Toast.makeText(MainActivity.this, "Проверьте значения на наличие данных", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    private void idOne() {
        et1.setVisibility(View.VISIBLE);
        et2.setVisibility(View.INVISIBLE);
        et3.setVisibility(View.INVISIBLE);
        et4.setVisibility(View.INVISIBLE);
        et5.setVisibility(View.INVISIBLE);
        et6.setVisibility(View.INVISIBLE);
        tv1.setVisibility(View.VISIBLE);
        tv2.setVisibility(View.INVISIBLE);
        tv1.setEnabled(true);
        tv2.setEnabled(false);
        tv3.setEnabled(false);
        tv4.setEnabled(false);
        tv5.setEnabled(false);
        tv6.setEnabled(false);
        tv3.setVisibility(View.INVISIBLE);
        tv4.setVisibility(View.INVISIBLE);
        tv5.setVisibility(View.INVISIBLE);
        tv6.setVisibility(View.INVISIBLE);
    }

    private void idTwo() {
        et1.setVisibility(View.VISIBLE);
        et2.setVisibility(View.VISIBLE);
        et3.setVisibility(View.INVISIBLE);
        et4.setVisibility(View.INVISIBLE);
        et5.setVisibility(View.INVISIBLE);
        et6.setVisibility(View.INVISIBLE);
        tv1.setVisibility(View.VISIBLE);
        tv2.setVisibility(View.VISIBLE);
        tv3.setVisibility(View.INVISIBLE);
        tv4.setVisibility(View.INVISIBLE);
        tv5.setVisibility(View.INVISIBLE);
        tv6.setVisibility(View.INVISIBLE);
        tv1.setEnabled(true);
        tv2.setEnabled(true);
        tv3.setEnabled(false);
        tv4.setEnabled(false);
        tv5.setEnabled(false);
        tv6.setEnabled(false);
    }

    private void idThree() {
        et1.setVisibility(View.VISIBLE);
        et2.setVisibility(View.VISIBLE);
        et3.setVisibility(View.VISIBLE);
        et4.setVisibility(View.INVISIBLE);
        et5.setVisibility(View.INVISIBLE);
        et6.setVisibility(View.INVISIBLE);
        tv1.setVisibility(View.VISIBLE);
        tv2.setVisibility(View.VISIBLE);
        tv3.setVisibility(View.VISIBLE);
        tv4.setVisibility(View.INVISIBLE);
        tv5.setVisibility(View.INVISIBLE);
        tv6.setVisibility(View.INVISIBLE);
        tv1.setEnabled(true);
        tv2.setEnabled(true);
        tv3.setEnabled(true);
        tv4.setEnabled(false);
        tv5.setEnabled(false);
        tv6.setEnabled(false);
    }

    private void idFour() {
        et1.setVisibility(View.VISIBLE);
        et2.setVisibility(View.VISIBLE);
        et3.setVisibility(View.VISIBLE);
        et4.setVisibility(View.VISIBLE);
        et5.setVisibility(View.INVISIBLE);
        et6.setVisibility(View.INVISIBLE);
        tv1.setVisibility(View.VISIBLE);
        tv2.setVisibility(View.VISIBLE);
        tv3.setVisibility(View.VISIBLE);
        tv4.setVisibility(View.VISIBLE);
        tv5.setVisibility(View.INVISIBLE);
        tv6.setVisibility(View.INVISIBLE);
        tv1.setEnabled(true);
        tv2.setEnabled(true);
        tv3.setEnabled(true);
        tv4.setEnabled(true);
        tv5.setEnabled(false);
        tv6.setEnabled(false);

    }

    private void idFive() {
        et1.setVisibility(View.VISIBLE);
        et2.setVisibility(View.VISIBLE);
        et3.setVisibility(View.VISIBLE);
        et4.setVisibility(View.VISIBLE);
        et5.setVisibility(View.VISIBLE);
        et6.setVisibility(View.INVISIBLE);
        tv1.setVisibility(View.VISIBLE);
        tv2.setVisibility(View.VISIBLE);
        tv3.setVisibility(View.VISIBLE);
        tv4.setVisibility(View.VISIBLE);
        tv5.setVisibility(View.VISIBLE);
        tv6.setVisibility(View.INVISIBLE);
        tv1.setEnabled(true);
        tv2.setEnabled(true);
        tv3.setEnabled(true);
        tv4.setEnabled(true);
        tv5.setEnabled(true);
        tv6.setEnabled(false);

    }

    private void idSix() {
        et1.setVisibility(View.VISIBLE);
        et2.setVisibility(View.VISIBLE);
        et3.setVisibility(View.VISIBLE);
        et4.setVisibility(View.VISIBLE);
        et5.setVisibility(View.VISIBLE);
        et6.setVisibility(View.VISIBLE);
        tv1.setVisibility(View.VISIBLE);
        tv2.setVisibility(View.VISIBLE);
        tv3.setVisibility(View.VISIBLE);
        tv4.setVisibility(View.VISIBLE);
        tv5.setVisibility(View.VISIBLE);
        tv6.setVisibility(View.VISIBLE);
        tv1.setEnabled(true);
        tv2.setEnabled(true);
        tv3.setEnabled(true);
        tv4.setEnabled(true);
        tv5.setEnabled(true);
        tv6.setEnabled(true);
    }

    private void allInvisible() {
        tv1.setVisibility(View.INVISIBLE);
        tv2.setVisibility(View.INVISIBLE);
        tv3.setVisibility(View.INVISIBLE);
        tv4.setVisibility(View.INVISIBLE);
        tv5.setVisibility(View.INVISIBLE);
        tv6.setVisibility(View.INVISIBLE);

        et1.setVisibility(View.INVISIBLE);
        et2.setVisibility(View.INVISIBLE);
        et3.setVisibility(View.INVISIBLE);
        et4.setVisibility(View.INVISIBLE);
        et5.setVisibility(View.INVISIBLE);
        et6.setVisibility(View.INVISIBLE);

        tv1.setEnabled(false);
        tv2.setEnabled(false);
        tv3.setEnabled(false);
        tv4.setEnabled(false);
        tv5.setEnabled(false);
        tv6.setEnabled(false);
    }

    private void idNumberOne() {
        Toast.makeText(MainActivity.this, "Выберите больше одного аргумента", Toast.LENGTH_SHORT).show();
    }

    private void idNumberTwo(double number1, double number2) {
        if (idType == 1 && number1 > 0 && number2 > 0) {
            r0 = (number1 * number2) / (number1 + number2);
        } else if (idType == 2 && number1 > 0 && number2 > 0) {
            r0 = number1 + number2;
        }
//            Toast.makeText(this, String.valueOf(r0), Toast.LENGTH_SHORT).show();
    }

    private void idNumberThree(double number1, double number2, double number3) {
        if (idType == 1 && number1 > 0 && number2 > 0 && number3 > 0) {
            r0 = 1 / number1 + 1 / number2 + 1 / number3;//  1/r0
        } else if (idType == 2 && number1 > 0 && number2 > 0 && number3 > 0) {
            r0 = number1 + number2 + number3;
        }
//            Toast.makeText(this, String.valueOf(r0), Toast.LENGTH_SHORT).show();
    }

    private void idNumberFour(double number1, double number2, double number3, double number4) {
        if (idType == 1 && number1 > 0 && number2 > 0 && number3 > 0 && number4 > 0) {
            r0 = 1 / number1 + 1 / number2 + 1 / number3 + 1 / number4;//  1/r0
        } else if (idType == 2 && number1 > 0 && number2 > 0 && number3 > 0 && number4 > 0) {
            r0 = number1 + number2 + number3 + number4;
        }
//            Toast.makeText(this, String.valueOf(r0), Toast.LENGTH_SHORT).show();
    }

    private void idNumberFive(double number1, double number2, double number3, double number4, double number5) {
        if (idType == 1 && number1 > 0 && number2 > 0 && number3 > 0 && number4 > 0 && number5 > 0) {
            r0 = 1 / number1 + 1 / number2 + 1 / number3 + 1 / number4 + 1 / number5;//  1/r0
        } else if (idType == 2 && number1 > 0 && number2 > 0 && number3 > 0 && number4 > 0 && number5 > 0) {
            r0 = number1 + number2 + number3 + number4 + number5;
        }
//            Toast.makeText(this, String.valueOf(r0), Toast.LENGTH_SHORT).show();
    }

    private void idNumberSix(double number1, double number2, double number3, double number4, double number5, double number6) {
        if (idType == 1 && number1 > 0 && number2 > 0 && number3 > 0 && number4 > 0 && number5 > 0 && number6 > 0) {
            r0 = 1 / number1 + 1 / number2 + 1 / number3 + 1 / number4 + 1 / number5 + 1 / number6;//  1/r0
        } else if (idType == 2 && number1 > 0 && number2 > 0 && number3 > 0 && number4 > 0 && number5 > 0 && number6 > 0) {
            r0 = number1 + number2 + number3 + number4 + number5 + number6;
        }
//            Toast.makeText(this, String.valueOf(r0), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFragmentInteraction() {
        getSupportFragmentManager()
                .beginTransaction()
                .remove(informationFragment)
                .commit();
    }
}
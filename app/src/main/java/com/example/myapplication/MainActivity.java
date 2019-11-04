package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {

    private TextView tv1, tv2, tv3, tv4, tv5, tv6;
    private EditText et1, et2, et3, et4, et5, et6;
    private double etS1, etS2, etS3, etS4, etS5, etS6, r0;
    private int idNumber;
    private int idType;
    private Button button;
    private Spinner numberSpinner, typeSpinner;
    private ResultDialogFragment dialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                            idNumberOne();
                            break;
                        case (2):
                            idNumberTwo();
                            break;
                        case (3):
                            idNumberThree();
                            break;
                        case (4):
                            idNumberFour();
                            break;
                        case (5):
                            idNumberFive();
                            break;
                        case (6):
                            idNumberSix();
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

    private void button() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (idNumber) {
                    case (1):
                        idNumberOne();
                        break;
                    case (2):
                        idNumberTwo();
                        break;
                    case (3):
                        idNumberThree();
                        break;
                    case (4):
                        idNumberFour();
                        break;
                    case (5):
                        idNumberFive();
                        break;
                    case (6):
                        idNumberSix();
                        break;
                }

                Bundle bundle = new Bundle();
                bundle.putInt("idType", idType);
                bundle.putDouble("r0", r0);
                dialogFragment.setArguments(bundle);
                dialogFragment.show(getSupportFragmentManager(), "Dialog");
            }
        });
    }

    private void idNumberOne() {
        et1.setVisibility(View.VISIBLE);
        et2.setVisibility(View.INVISIBLE);
        et3.setVisibility(View.INVISIBLE);
        et4.setVisibility(View.INVISIBLE);
        et5.setVisibility(View.INVISIBLE);
        et6.setVisibility(View.INVISIBLE);
        tv1.setVisibility(View.VISIBLE);
        tv2.setVisibility(View.INVISIBLE);
        tv3.setVisibility(View.INVISIBLE);
        tv4.setVisibility(View.INVISIBLE);
        tv5.setVisibility(View.INVISIBLE);
        tv6.setVisibility(View.INVISIBLE);
        Toast.makeText(MainActivity.this, "Выберите больше одного аргумента", Toast.LENGTH_SHORT).show();
    }

    private void idNumberTwo() {
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
        if (button.isPressed()) {
            etS1 = Double.valueOf(et1.getText().toString());
            etS2 = Double.valueOf(et2.getText().toString());
            if (idType == 1) {
                r0 = (etS1 * etS2) / (etS1 + etS2);
            } else if (idType == 2) {
                r0 = etS1 + etS2;
            }
            Toast.makeText(this, String.valueOf(r0), Toast.LENGTH_SHORT).show();
        }
    }

    private void idNumberThree() {
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
        if (button.isPressed()) {
            etS1 = Double.valueOf(et1.getText().toString());
            etS2 = Double.valueOf(et2.getText().toString());
            etS3 = Double.valueOf(et3.getText().toString());
            if (idType == 1) {
                r0 = 1 / etS1 + 1 / etS2 + 1 / etS3;//  1/r0
            } else if (idType == 2) {
                r0 = etS1 + etS2 + etS3;
            }
            Toast.makeText(this, String.valueOf(r0), Toast.LENGTH_SHORT).show();
        }
    }

    private void idNumberFour() {
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
        if (button.isPressed()) {
            etS1 = Double.valueOf(et1.getText().toString());
            etS2 = Double.valueOf(et2.getText().toString());
            etS3 = Double.valueOf(et3.getText().toString());
            etS4 = Double.valueOf(et4.getText().toString());
            if (idType == 1) {
                r0 = 1 / etS1 + 1 / etS2 + 1 / etS3 + 1 / etS4;//  1/r0
            } else if (idType == 2) {
                r0 = etS1 + etS2 + etS3 + etS4;
            }
            Toast.makeText(this, String.valueOf(r0), Toast.LENGTH_SHORT).show();
        }
    }

    private void idNumberFive() {
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

        if (button.isPressed()) {
            etS1 = Double.valueOf(et1.getText().toString());
            etS2 = Double.valueOf(et2.getText().toString());
            etS3 = Double.valueOf(et3.getText().toString());
            etS4 = Double.valueOf(et4.getText().toString());
            etS5 = Double.valueOf(et5.getText().toString());

            if (idType == 1) {
                r0 = 1 / etS1 + 1 / etS2 + 1 / etS3 + 1 / etS4 + 1 / etS5;//  1/r0
            } else if (idType == 2) {
                r0 = etS1 + etS2 + etS3 + etS4 + etS5;
            }
            Toast.makeText(this, String.valueOf(r0), Toast.LENGTH_SHORT).show();
        }
    }

    private void idNumberSix() {
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
        if (button.isPressed()) {
            etS1 = Double.valueOf(et1.getText().toString());
            etS2 = Double.valueOf(et2.getText().toString());
            etS3 = Double.valueOf(et3.getText().toString());
            etS4 = Double.valueOf(et4.getText().toString());
            etS5 = Double.valueOf(et5.getText().toString());
            etS6 = Double.valueOf(et6.getText().toString());

            if (idType == 1) {
                r0 = 1 / etS1 + 1 / etS2 + 1 / etS3 + 1 / etS4 + 1 / etS5 + 1 / etS6;//  1/r0
            } else if (idType == 2) {
                r0 = etS1 + etS2 + etS3 + etS4 + etS5 + etS6;
            }
            Toast.makeText(this, String.valueOf(r0), Toast.LENGTH_SHORT).show();
        }

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
    }
}

package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class ResultDialogFragment extends DialogFragment {

    private double r0;
    private int idType;
    private String typeOfConnection;
    private TextView r0TV, typeTV;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_TITLE, android.R.style.Theme_Material_Light_Dialog_Alert);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_fragment_file, container, false);
        r0TV = view.findViewById(R.id.r0);
        typeTV = view.findViewById(R.id.id_type_fragment);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            r0 = args.getDouble("r0");
            idType = args.getInt("idType");
        }

        if (idType == 1){
            typeOfConnection = "Параллельное подключение";
        } else if (idType == 2){
            typeOfConnection = "Последовательное подключение";
        }

        r0TV.setText(String.valueOf(r0));
        typeTV.setText(typeOfConnection);

        //принять значение и вывести его на экран
    }
}
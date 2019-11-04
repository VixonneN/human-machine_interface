package com.example.myapplication.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.data_class.NumberOfConnectionData;

import java.util.ArrayList;
import java.util.List;

public class NumberOfConnectionAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<NumberOfConnectionData> number;

    public NumberOfConnectionAdapter(Context context, List<NumberOfConnectionData> number) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.number = number;
    }

    @Override
    public int getCount() {
        return number.size() + 1;
    }

    @Override
    public Object getItem(int position) {
        return number.get(position - 1);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        List<String> numbers = new ArrayList<>();
        numbers.add("");
        for (NumberOfConnectionData data : number) {
            numbers.add(String.valueOf(data.getId()));
        }

        @SuppressLint("ViewHolder")
        View view = layoutInflater.inflate(R.layout.spinner_item, parent, false);
        TextView textView = view.findViewById(R.id.spinner_id);
        textView.setText(String.valueOf(numbers.get(position)));
        return view;
    }
}
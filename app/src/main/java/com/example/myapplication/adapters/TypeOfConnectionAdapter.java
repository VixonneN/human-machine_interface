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
import com.example.myapplication.data_class.TypeOfConnectionData;

import java.util.ArrayList;
import java.util.List;

public class TypeOfConnectionAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<TypeOfConnectionData> data;

    public TypeOfConnectionAdapter(Context context, List<TypeOfConnectionData> data) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size() + 1;
    }

    @Override
    public Object getItem(int position) {
        return data.get(position - 1);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        List<String> datas = new ArrayList<>();
        datas.add("");
        for (TypeOfConnectionData data1 : data) {
            datas.add(String.valueOf(data1.getType()));
        }

        @SuppressLint("ViewHolder")
        View view = layoutInflater.inflate(R.layout.spinner_item, parent, false);
        TextView textView = view.findViewById(R.id.spinner_id);
        textView.setText(String.valueOf(datas.get(position)));
        return view;

    }
}

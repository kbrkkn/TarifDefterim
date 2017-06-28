package com.example.kubra.tarifdefterim;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
public class CustomAdapter extends BaseAdapter {
    LayoutInflater layoutInflater;
    ArrayList<TarifModel> tarifList;
    public CustomAdapter(Activity activity, ArrayList<TarifModel> tarifList){
        layoutInflater= (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.tarifList=tarifList;}
    @Override
    public int getCount() {
        return tarifList.size();
    }
    @Override
    public Object getItem(int position) {
        return tarifList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TarifModel tarif=tarifList.get(position);
        View satir=layoutInflater.inflate(R.layout.custom_satir,null);
        TextView isim= (TextView) satir.findViewById(R.id.textViewIsim);
        TextView malzemeler= (TextView) satir.findViewById(R.id.textViewMalzemeler);
        TextView detay= (TextView) satir.findViewById(R.id.textViewDetay);
        isim.setText(tarif.getIsim());
        malzemeler.setText(tarif.getMalzemeler());
        detay.setText(tarif.getDetay());
        return satir;
    }
}

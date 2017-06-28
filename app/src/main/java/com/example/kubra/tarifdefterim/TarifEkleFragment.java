package com.example.kubra.tarifdefterim;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class TarifEkleFragment extends Fragment {
    EditText isim,malzemeler,detay;
    Button kaydet;
    FirebaseDatabase database;
    public TarifEkleFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView=inflater.inflate(R.layout.fragment_tarif_ekle, container, false);
        isim= (EditText) rootView.findViewById(R.id.editTextİsim);
        malzemeler= (EditText) rootView.findViewById(R.id.editTextMalzemeler);
        detay= (EditText) rootView.findViewById(R.id.editTextTarif);
        kaydet= (Button) rootView.findViewById(R.id.buttonEkle);
        database=FirebaseDatabase.getInstance();
        final DatabaseReference dbRef=database.getReference("tarifler");
        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference idRef=dbRef.push();
                String t_isim,t_malzemeler,t_detay;
                t_isim=isim.getText().toString();
                t_malzemeler=malzemeler.getText().toString();
                t_detay=detay.getText().toString();
                if(!t_isim.equals("")&& !t_detay.equals("")&&!t_malzemeler.equals("")){
                    idRef.child("isim").setValue(t_isim);
                    idRef.child("malzemeler").setValue(t_malzemeler);
                    idRef.child("detay").setValue(t_detay);
                    isim.setText("");
                    malzemeler.setText("");
                    detay.setText("");}
                else{
                    Toast.makeText(rootView.getContext(),"Lütfen Tüm Alanları Doldurunuz",Toast.LENGTH_SHORT).show();
                }}
        });
        return rootView;
    }

}

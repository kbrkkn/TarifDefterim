package com.example.kubra.tarifdefterim;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TariflerFragment extends Fragment {
    ArrayList<TarifModel> tarifList;
    ListView listView;
    FirebaseDatabase database;
    public TariflerFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View view= inflater.inflate(R.layout.fragment_tarifler, container, false);
        tarifList=new ArrayList<TarifModel>();
        listView= (ListView) view.findViewById(R.id.listView);
        database=FirebaseDatabase.getInstance();
        final DatabaseReference dbRef=database.getReference("tarifler");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds:dataSnapshot.getChildren()){
                    String isim=ds.child("isim").getValue().toString();
                    String detay=ds.child("detay").getValue().toString();
                    String malzemeler=ds.child("malzemeler").getValue().toString();
                    tarifList.add(new TarifModel(isim,detay,malzemeler));
                }
                CustomAdapter adapter=new CustomAdapter(getActivity(),tarifList);
                listView.setAdapter(adapter);
                dbRef.removeEventListener(this);}
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return view;
    }

}

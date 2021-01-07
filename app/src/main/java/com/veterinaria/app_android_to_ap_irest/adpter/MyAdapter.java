package com.veterinaria.app_android_to_ap_irest.adpter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.veterinaria.app_android_to_ap_irest.R;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private  List<String> dataSet;

    public static class MyViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtNombre;
        public Button btn1;
        public CardView card;

        public MyViewHolder(View v){
            super(v);
            txtNombre= v.findViewById(R.id.tvUserName);
            btn1=v.findViewById(R.id.btnGoToReports);
            btn1.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(),"Hola "+this.txtNombre.getText().toString(),Toast.LENGTH_LONG).show();
        }
    }
    public MyAdapter(List<String> mydataSet){
        this.dataSet=mydataSet;
        System.out.println("--->2"+dataSet.toString());
    }
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        //CardView cardView= (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
           MyViewHolder vh= new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.txtNombre.setText(dataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}

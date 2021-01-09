package com.veterinaria.app_android_to_ap_irest.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.internal.$Gson$Preconditions;
import com.veterinaria.app_android_to_ap_irest.R;
import com.veterinaria.app_android_to_ap_irest.adpter.MyAdapter;
import com.veterinaria.app_android_to_ap_irest.models.Servicio;
import com.veterinaria.app_android_to_ap_irest.services.GetService;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainFragment extends Fragment{

    private MainViewModel mViewModel;
    private RecyclerView listaServicios;
    private MyAdapter adapter;
    private List<String> dataSet2;
    ArrayAdapter arrayAdapter;
    private static final String[] dataSet = {
            "PHP", "JS", "GO", "Python"
    };

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.main_fragment, container, false);
        listaServicios = vista.findViewById(R.id.listaServicios);
        listaServicios.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        listaServicios.setLayoutManager(layoutManager);
        dataSet2= new ArrayList<>();
        dataSet2.add("prueba 1");
        dataSet2.add("prueba 2");
        peticion(); //get a service from heroku
        //System.out.println("+1 line of methos "+ dataSet2.toString());

        /*arrayAdapter= new ArrayAdapter(getContext(),R.layout.item_text_view, dataSet2);
        listaServicios.setAdapter(arrayAdapter);*/
        return vista;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

    public void peticion() {
        //String url="https://spring-boot-deploy-test.herokuapp.com/";
        String url="http://192.168.3.7:8084/";
        Retrofit retrofit= new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        GetService getService= retrofit.create(GetService.class);
        Call<List<Servicio>>call= getService.getServices();
        System.out.println("Entra aqui ---->");
        call.enqueue(new Callback<List<Servicio>>() {
            @Override
            public void onResponse(Call<List<Servicio>> call, Response<List<Servicio>> response) {
                for(Servicio post : response.body()) {
                    dataSet2.add(post.getNombrePerro());
                    System.out.println("Agregado "+ dataSet2.size());
                }
                System.out.println(dataSet2.toString());
                //arrayAdapter.notifyDataSetChanged();
                adapter = new MyAdapter(dataSet2);
                listaServicios.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Servicio>> call, Throwable t) {

                System.out.println("Error: "+call.toString()+" "+t.getMessage());
            }
        });
    }
}
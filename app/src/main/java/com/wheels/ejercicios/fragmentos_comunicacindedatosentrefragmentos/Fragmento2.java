package com.wheels.ejercicios.fragmentos_comunicacindedatosentrefragmentos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;


public class Fragmento2 extends Fragment {


    private TextView tvResult;

    public Fragmento2() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getParentFragmentManager().setFragmentResultListener("datos", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String suma = result.getString("suma");
                // DecimalFormat decimalFormat = new DecimalFormat("#.##");
                // StringBuilder  resultado= new StringBuilder();
                //tvResult.setText(resultado.append(Fragmento2.this.getString(R.string.result_suma)).append(decimalFormat.format(result)).toString());
                tvResult.setText("El resultado de la suma es " + suma);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmento2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvResult = view.findViewById(R.id.tvResult);


    }
}
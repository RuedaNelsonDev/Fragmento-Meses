package com.wheels.ejercicios.fragmentos_comunicacindedatosentrefragmentos;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.DecimalFormat;


public class Fragmento1 extends Fragment {

    private EditText et1;
    private EditText et2;
    private Button btnCalcular;

    public Fragmento1() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_fragmento1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et1 = view.findViewById(R.id.et1);
        et2 = view.findViewById(R.id.et2);
        btnCalcular = view.findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!et1.getText().toString().isEmpty() && !et2.getText().toString().isEmpty()) {

                    try {

                        double valor1 = Double.parseDouble(et1.getText().toString());
                        double valor2 = Double.parseDouble(et2.getText().toString());

                        double calcular = valor1 + valor2;
                        DecimalFormat decimalFormat = new DecimalFormat("#.##");

                        String resultSuma = decimalFormat.format(calcular);

                        Bundle bundle = new Bundle();
                        bundle.putString("suma", (resultSuma));
                        getParentFragmentManager().setFragmentResult("datos", bundle);


                        //   tvResult.setText(result.append(Fragment1.this.getString(R.string.result_suma)).append(decimalFormat.format(resultSuma)).toString());
                    } catch (NumberFormatException e) {
                        //   tvResult.setText(R.string.syntax_error);
                        Log.i("TAG", String.valueOf(e));
                        e.printStackTrace();
                    }
                } else {

                    Toast.makeText(getContext(), "No deje espacios en blanco!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
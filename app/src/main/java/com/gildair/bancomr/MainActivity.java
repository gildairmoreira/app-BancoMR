package com.gildair.bancomr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.gildair.bancomr.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.imgSaldo.setOnClickListener(this);
        binding.imgFaturas.setOnClickListener(this);


        binding.imgTransferencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent navegarTelaDeFaturas = new Intent(MainActivity.this, Transferencia.class);
                startActivity(navegarTelaDeFaturas);
            }
        });
        binding.imgPoupanca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent navegarTelaDeFaturas = new Intent(MainActivity.this, Poupanca.class);
                startActivity(navegarTelaDeFaturas);
            }
        });
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.imgSaldo) {
            Intent navegarTelaDeSaldo = new Intent(MainActivity.this, Saldo.class);
            startActivity(navegarTelaDeSaldo);
        } else if (id == R.id.imgFaturas) {
            Intent navegarTelaDeFaturas = new Intent(MainActivity.this, Faturas.class);
            startActivity(navegarTelaDeFaturas);
        }
    }
}
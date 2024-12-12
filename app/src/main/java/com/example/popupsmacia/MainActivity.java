package com.example.popupsmacia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvSelectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSelectedItem = findViewById(R.id.tvSelectedItem);

        Button btnDialog1 = findViewById(R.id.btnDialog1);
        Button btnDialog2 = findViewById(R.id.btnDialog2);
        Button btnDialog3 = findViewById(R.id.btnDialog3);

        btnDialog1.setOnClickListener(v -> showDialog1());
        btnDialog2.setOnClickListener(v -> showDialog2());
        btnDialog3.setOnClickListener(v -> showDialog3());
    }

    private void showDialog1() {
        new AlertDialog.Builder(this)
                .setTitle("Dialog 1")
                .setMessage("Este es el contenido del dialog1")
                .setPositiveButton("Confirmar", (dialog, which) -> dialog.dismiss())
                .setNegativeButton("Cancelar", (dialog, which) -> dialog.dismiss())
                .create()
                .show();
    }

    private void showDialog2() {
        String[] frutas = {"· Manzana", "· Naranja", "· Pera"};
        new AlertDialog.Builder(this)
                .setTitle("Selecciona una fruta")
                .setItems(frutas, (dialog, which) -> {
                    tvSelectedItem.setText("Fruta seleccionada: " + frutas[which]);
                    dialog.dismiss();
                })
                .setNegativeButton("Cancelar", (dialog, which) -> dialog.dismiss())
                .create()
                .show();
    }

    private void showDialog3() {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_user_input, null);
        new AlertDialog.Builder(this)
                .setTitle("Dialog 3")
                .setView(dialogView)
                .setPositiveButton("Aceptar", (dialog, which) -> {
                    TextView etUsuario = dialogView.findViewById(R.id.etUsuario);
                    String usuario = etUsuario.getText().toString();
                    tvSelectedItem.setText("Usuario: " + usuario);
                })
                .setNegativeButton("Cancelar", (dialog, which) -> dialog.dismiss())
                .create()
                .show();
    }
}

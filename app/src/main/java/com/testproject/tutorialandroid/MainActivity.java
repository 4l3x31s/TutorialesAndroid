package com.testproject.tutorialandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.testproject.tutorialandroid.util.TextChangedListener;

public class MainActivity extends Activity {

    private EditText txtNombre, txtTelefono, txtEmail, txtDireccion;
    private Button btnAgregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponentesUI();
    }
    private void inicializarComponentesUI() {
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtTelefono = (EditText) findViewById(R.id.txtTelefono);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtDireccion = (EditText) findViewById(R.id.txtDireccion);

        txtNombre.addTextChangedListener(new TextChangedListener() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btnAgregar = (Button) findViewById(R.id.btnRegistrarContacto);
                btnAgregar.setEnabled(!s.toString().trim().isEmpty());
            }
        });
    }

    public void onClick(View view) {
        String msg = String.format("%s ha sido agregado a la lista!",txtNombre.getText());
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtNombre.getText().clear();
        txtTelefono.getText().clear();
        txtEmail.getText().clear();
        txtDireccion.getText().clear();
        txtNombre.requestFocus();
    }
}

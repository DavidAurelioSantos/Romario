package com.example.iuriranzatti.findbox;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    public TextView txtNovoCadastro;
    public TextView txtUsuario;
    public TextView txtSenha;
    public Button bEntrar;
    public Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNovoCadastro = (TextView) findViewById(R.id.txtNovoCadastro);
        bEntrar = (Button) findViewById(R.id.bEntrar);
        txtUsuario = (TextView) findViewById(R.id.txtUsuario);
        txtSenha = (TextView) findViewById(R.id.txtSenha);

        txtNovoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(view.getContext(), CadastroCliente.class);
                startActivity(intent);
            }
        });

        bEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if      (txtUsuario.getText().toString().equals("adm")&& txtSenha.getText().toString().equals("adm") ||
                            (txtUsuario.getText().toString().equals("David") && txtSenha.getText().toString().equals("123")) ||
                            (txtUsuario.getText().toString().equals("Iuri") && txtSenha.getText().toString().equals("123")) ||
                            (txtUsuario.getText().toString().equals("Thiago")&& txtSenha.getText().toString().equals("123"))) {
                    intent = new Intent(MainActivity.this, ActivityPrincipal.class);

                    // Envia o nome do usuário para a tela principal
                    Bundle bdlUsuario = new Bundle();
                    bdlUsuario.putString("ChaveUsuario",txtUsuario.getText().toString());
                    intent.putExtras(bdlUsuario);
                    startActivity(intent);
                    finish();
                }
                else {

                    AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);

                    alerta.setTitle("Aviso");
                    alerta.setMessage("Nome do usuário ou senha inválidos!");
                    alerta.setCancelable(false);
                    alerta.setPositiveButton("Tentar Novamente", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AlertDialog alertDialog = alerta.create();
                    alertDialog.show();
                    }
                }
        });
    }
}



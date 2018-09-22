package com.example.iuriranzatti.findbox;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.iuriranzatti.findbox.models.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastroCliente extends AppCompatActivity {

    public Spinner avatar;
    private Integer id;
    public ImageView imgAvatar;
    private DatabaseReference clienteRef;
    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    public FirebaseAuth auth;
    public Button btnSalvar;
    EditText txtNome;
    EditText txtEmail;
    EditText txtCpfCnpj;
    EditText txtCelular;
    EditText txtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);
        clienteRef = database.getReference("Usuario");

        imgAvatar = (ImageView) findViewById(R.id.imgAvatar);
        avatar = (Spinner) findViewById(R.id.spinnerSexo);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        txtNome = (EditText) findViewById(R.id.txtNome);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtCpfCnpj = (EditText) findViewById(R.id.txtCpfCnpj);
        txtCelular = (EditText) findViewById(R.id.txtCelular);
        txtSenha = (EditText) findViewById(R.id.txtSenha);

        auth = FirebaseAuth.getInstance();

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.avatar, android.R.layout.simple_spinner_item);
        avatar.setAdapter(adapter);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                inserirNovoDado(txtNome.getText().toString(), avatar.getSelectedItem().toString(), txtEmail.getText().toString(), txtSenha.getText().toString(), txtCpfCnpj.getText().toString(), txtCelular.getText().toString());
//                Toast.makeText(CadastroCliente.this, "Cadastro efetuado com sucesso", Toast.LENGTH_LONG).show();

                //Envia os dados para autenticação
                auth.createUserWithEmailAndPassword(txtEmail.getText().toString(), txtSenha.getText().toString())
                        .addOnCompleteListener(CadastroCliente.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                txtNome.setText(null);
                                txtEmail.setText(null);
                                txtCpfCnpj.setText(null);
                                txtCelular.setText(null);
                                txtSenha.setText(null);

                                Toast.makeText(CadastroCliente.this, "Cadastro efetuado com sucesso" , Toast.LENGTH_SHORT).show();

                                if (!task.isSuccessful()) {
                                    Toast.makeText(CadastroCliente.this, "Ocorreu algum erro " + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        avatar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0 || i == 1) {
                    imgAvatar.setImageResource(getImageDrawableResId("@drawable/avatar_i"));
                } else if (i == 2) {
                    imgAvatar.setImageResource(getImageDrawableResId("@drawable/avatar_m"));
                } else {
                    imgAvatar.setImageResource(getImageDrawableResId("@drawable/avatar_f"));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

//Pega o ID da imagem selecionada e retornando no IF do OnItemSelected
    public int getImageDrawableResId(String imageId ){
        Resources resources = this.getResources();
        return resources.getIdentifier(imageId, "drawable", this.getPackageName());
    }

    private void inserirNovoDado( String nome, String sexo, String email, String senha, String cpf, String celular) {

        Usuario usuario = new Usuario(nome, sexo, email, senha, cpf, celular);
        email = email.replace(".",",");
        clienteRef.child(email).setValue(usuario);
    }

    }


package com.example.iuriranzatti.findbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iuriranzatti.findbox.models.Encomenda;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityAddPedido extends AppCompatActivity {

    private DatabaseReference rastreioRef;
    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    TextView txtRastreio;
    TextView txtNomeProduto;
    Button btnSalvarRastreio;
    public FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_rastreio);

        rastreioRef = database.getReference("Encomenda");

        txtRastreio = (TextView) findViewById(R.id.txtRastreio);
        txtNomeProduto = (TextView) findViewById(R.id.txtNomeProduto);
        btnSalvarRastreio = (Button) findViewById(R.id.btnSalvarRastreio);

        auth = FirebaseAuth.getInstance();

        //Evento botão salvar Rastreio

        btnSalvarRastreio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                inserirNovoDado(txtRastreio.getText().toString(), txtNomeProduto.getText().toString());
                Toast.makeText(ActivityAddPedido.this, "Produto cadastrado", Toast.LENGTH_LONG).show();
            }
});
    }

    private void inserirNovoDado( String codigo, String produto ) {

        Encomenda encomenda = new Encomenda(codigo, produto);
        rastreioRef.child(codigo).setValue(encomenda);
    }
}
package br.usjt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ListarLocalizacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_localizacao);

        TextView nome = (TextView)findViewById(R.id.chamado_selecionado);
        Intent intent = getIntent();
        nome.setText(intent.getStringExtra(MainActivity.DESCRICAO));
    }
}

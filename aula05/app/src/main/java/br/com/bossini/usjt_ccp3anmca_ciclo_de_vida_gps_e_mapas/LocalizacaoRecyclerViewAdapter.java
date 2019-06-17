package br.com.bossini.usjt_ccp3anmca_ciclo_de_vida_gps_e_mapas;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class LocalizacaoRecyclerViewAdapter extends RecyclerView.Adapter < LocalizacaoViewHolder > {
    private List< Localizacao > localizacoes;
    public LocalizacaoRecyclerViewAdapter(List < Localizacao > localizacoes) {
        this.localizacoes = localizacoes;
    }
    @NonNull
    @Override
    public LocalizacaoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View raiz = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new LocalizacaoViewHolder(raiz);
    }

    @Override
    public void onBindViewHolder(@NonNull LocalizacaoViewHolder localizacaoViewHolder, int i) {
        //view holder sendo vinculado        //ele já existe, basta colocar os dados de interesse (eles estão na posição i da coleção)
        Localizacao localizacaoDaVez = localizacoes.get(i);

        localizacaoViewHolder.latitudeLocalizacaoTextView.setText(String.valueOf(localizacaoDaVez.getLatitude()));
        localizacaoViewHolder.longitudeLocalizacaoTextView.setText(String.valueOf(localizacaoDaVez.getLongitude()));
        localizacaoViewHolder.dataAberturaLocalizacaoTextView.setText(DateHelper.format(localizacaoDaVez.getDataAbertura()));

    }

    @Override
    public int getItemCount() {
        return localizacoes.size();
    }
}

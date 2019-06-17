package br.com.bossini.usjt_ccp3anmca_ciclo_de_vida_gps_e_mapas;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.util.List;


public class WeatherAdapter
        extends RecyclerView.Adapter <WeatherAdapter.WeatherViewHolder> {

    private Context context;
    private List<Weather> previsoes;

    public WeatherAdapter (Context context, List <Weather> previsoes){
        this.context = context;
        this.previsoes = previsoes;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View raiz = inflater.inflate(R.layout.list_item, viewGroup, false);
        return new WeatherViewHolder(raiz);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder weatherViewHolder, int i) {
        Weather caraDaVez = previsoes.get(i);
        Glide.with(context).load(caraDaVez.iconURL).into(weatherViewHolder.conditionImageView);
        weatherViewHolder.dayTextView.setText(
                context.getString(
                        R.string.day_description,
                        caraDaVez.dayOfWeek,
                        caraDaVez.description
                )
        );
        weatherViewHolder.lowTextView.setText(
                context.getString(
                        R.string.low_temp,
                        caraDaVez.minTemp
                )
        );
        weatherViewHolder.highTextView.setText(
                context.getString(
                        R.string.high_temp,
                        caraDaVez.maxTemp
                )
        );
        weatherViewHolder.humidityTextView.setText(
                context.getString(
                        R.string.humidity,
                        caraDaVez.humidity
                )
        );

    }

    @Override
    public int getItemCount() {
        return previsoes.size();
    }

    class WeatherViewHolder extends RecyclerView.ViewHolder{

        private ImageView conditionImageView;
        private TextView dayTextView;
        private TextView lowTextView;
        private TextView highTextView;
        private TextView humidityTextView;
        public WeatherViewHolder (View raiz){
            super (raiz);
            conditionImageView =
                    raiz.findViewById(R.id.conditionImageView);
            dayTextView =
                    raiz.findViewById(R.id.dayTextView);
            lowTextView =
                    raiz.findViewById(R.id.lowTextView);
            highTextView =
                    raiz.findViewById(R.id.highTextView);
            humidityTextView =
                    raiz.findViewById(R.id.humidityTextView);
        }

    }


}
package br.usjt;

import br.usjt.br.usjt.models.UsuarioModel;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private UsuarioModel usuario = new UsuarioModel();;
    private List<UsuarioModel> ListaUsuarios = new ArrayList<UsuarioModel>();
    private List<UsuarioModel> ListaUsuariosVal = new ArrayList<UsuarioModel>();
    private LocationManager locationManager;
    private LocationListener locationListener;
    private static final int REQUEST_CODE_GPS = 1001;
    private TextView locationTextView;
    private double latitudeAtual;
    private double longitudeAtual;

    public MainActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        locationManager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);


        locationListener = new LocationListener() {

            @Override
            public void onLocationChanged(Location location) {
                usuario.setLat(location.getLatitude());
                usuario.setLon(location.getLongitude());
                usuario.setLatAtual(location.getLatitude());
                usuario.setLonAtual(location.getLongitude());

                latitudeAtual =  location.getLatitude();
                longitudeAtual = location.getLongitude();



                ListaUsuarios.add(usuario);

                locationTextView.setText(String.format("Lat: %f, Long: %f", usuario.getLat(),
                        usuario.getLon()));

                verificaSeSalva(ListaUsuarios);

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationTextView = findViewById(R.id.locationTextView);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri =
                        Uri.parse(String.format("geo:%f,%f?q=restaurantes",
                                latitudeAtual, longitudeAtual));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }

        });
    }

    private void verificaSeSalva(List<UsuarioModel> listaUsuarios) {

        for (UsuarioModel usuario : listaUsuarios) {

            //vefirica se a distancia percorrida foi maior que 200
            if(usuario.getLat() - latitudeAtual == 200){
                ListaUsuariosVal.add(usuario);
            }

        }



        ListaUsuarios.add(usuario);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED){

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    120000, 200, locationListener);
        }
        else{

            ActivityCompat.requestPermissions(this,
                    new String[]
                            {Manifest.permission.ACCESS_FINE_LOCATION}, 1001);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        locationManager.removeUpdates(locationListener);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull
            String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1001){
            if (grantResults.length > 0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED){

                if (ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_FINE_LOCATION) ==
                        PackageManager.PERMISSION_GRANTED){
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                            120000, 200, locationListener);
                }
            }
            else{

                Toast.makeText(this, getString(R.string.no_gps_no_app),
                        Toast.LENGTH_SHORT).show();

            }
        }
    }


}

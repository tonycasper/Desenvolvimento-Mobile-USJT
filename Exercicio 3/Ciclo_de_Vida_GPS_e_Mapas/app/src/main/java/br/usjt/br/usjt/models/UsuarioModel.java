package br.usjt.br.usjt.models;

public class UsuarioModel {
    private double lat;
    private double lon;
    private double latAtual;
    private double lonAtual;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLatAtual() {
        return latAtual;
    }

    public void setLatAtual(double latAtual) {
        this.latAtual = latAtual;
    }

    public void setLonAtual(double lonAtual) {
        this.lonAtual = lonAtual;
    }
}

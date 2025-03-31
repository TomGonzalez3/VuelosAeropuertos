package viajes;

import lugares.Aeropuerto;
import lugares.Ciudad;
import personas.Pasajero;
import personas.Tripulacion;

import java.time.LocalDateTime;
import java.util.List;

public class Vuelo {
    private Aeropuerto aeropuertoOrigen;
    private Aeropuerto aeropuertoDestino;
    private LocalDateTime fecha;
    private Double duracion;
    private Integer cantAsientosOfrecidos;
    private Avion avion;
    private List<Pasajero> pasajeros;
    private Tripulacion tripulacion;

    public Vuelo(Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino, LocalDateTime fecha, Double duracion, Integer cantAsientosOfrecidos, Avion avion, List<Pasajero> pasajeros, Tripulacion tripulacion) {
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.fecha = fecha;
        this.duracion = duracion;
        this.cantAsientosOfrecidos = cantAsientosOfrecidos;
        this.avion = avion;
        this.pasajeros = pasajeros;
        this.tripulacion = tripulacion;
    }

    public Aeropuerto getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }

    public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }

    public Aeropuerto getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    public Integer getCantAsientosOfrecidos() {
        return cantAsientosOfrecidos;
    }

    public void setCantAsientosOfrecidos(Integer cantAsientosOfrecidos) {
        this.cantAsientosOfrecidos = cantAsientosOfrecidos;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public List<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(List<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
    }

    public Tripulacion getTripulacion() {
        return tripulacion;
    }

    public void setTripulacion(Tripulacion tripulacion) {
        this.tripulacion = tripulacion;
    }

    public Double capacidadOcupadaPorPasajeros(){
        return (double) (this.cantPasajeros() * 100 / this.avion.cantAsientosOfrecidos());
    }

    public LocalDateTime fechaDeLlegadaAprox(){
        return this.fecha.plusMinutes(this.duracion.longValue());
    }

    public Integer cantPasajeros(){
        return this.pasajeros.size();
    }

    public boolean vueloConDestino(Ciudad ciudad) {
        return (this.aeropuertoDestino.equals(ciudad));
    }
}

package viajes;

import lugares.Aeropuerto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Aerolinea {
    private List<Avion> aviones;
    private String nombre;
    private List<Viaje> viajes;

    public Aerolinea(List<Avion> aviones, String nombre, List<Viaje> viajes) {
        this.aviones = new ArrayList<>();
        this.nombre = nombre;
        this.viajes = new ArrayList<>();
    }

    public void agregarAviones(Avion ... aviones){
        Collections.addAll(this.aviones, aviones);
    }

    public List<Viaje> viajesDelMes(Integer mes, Integer anio){
        return this.viajes
                .stream()
                .filter(v -> v.getFechaDeSalida().getYear() == anio
                && v.getFechaDeSalida().getMonthValue() == mes)
                .collect(Collectors.toList());
    }

    public Integer cantPasajerosTotales(Integer mes, Integer anio){
        return this.viajesDelMes(mes, anio)
                .stream()
                .mapToInt(Viaje::cantPasajerosTotales)
                .sum();

    }
}

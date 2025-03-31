package viajes;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Viaje {
    private List<Vuelo> vuelos;
    private List<Escala> escalas;
    private LocalDate fechaDeSalida;
    private Aerolinea aerolinea;

    public void agregarVuelos(Vuelo ... vuelos) {
        Collections.addAll(this.vuelos, vuelos);
    }

    public void agregarEscalas(Escala ... escalas) {
        Collections.addAll(this.escalas, escalas);
    }

    public Integer cantPasajerosTotales(){
        return this.vuelos
                .stream()
                .mapToInt(Vuelo::cantPasajeros)
                .sum();
    }

    public LocalDate getFechaDeSalida() {
        return fechaDeSalida;
    }

    public void setFechaDeSalida(LocalDate fechaDeSalida) {
        this.fechaDeSalida = fechaDeSalida;
    }

    public Double duracionTotalVueloEnMins(){
        return this.vuelos.stream().mapToDouble(Vuelo::getDuracion).sum();
    }

    public Double duracionTotalEscalaEnMins(){
        return this.escalas.stream().mapToDouble(Escala::getDuracion).sum();
    }

    public Double duracionTotalEnMins(){
        return (double) this.duracionTotalVueloEnMins() + this.duracionTotalEscalaEnMins();
    }
}

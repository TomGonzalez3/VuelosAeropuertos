package personas;

import lugares.Ciudad;
import lugares.Pais;
import viajes.Vuelo;

import java.util.Collections;
import java.util.List;

public class Pasajero extends Persona{
    private List<Vuelo> vuelos;
    private Integer nroPasaporte;
    private Pais nacionalidad;

    public Pasajero(String nombre, String apellido, Integer nroDocumento, List<Vuelo> vuelos, Integer nroPasaporte, Pais nacionalidad) {
        super(nombre, apellido, nroDocumento);
        this.vuelos = vuelos;
        this.nroPasaporte = nroPasaporte;
        this.nacionalidad = nacionalidad;
    }

    public void agregarVuelos(Vuelo ... vuelos){
        Collections.addAll(this.vuelos, vuelos);
    }

    public Integer cantVuelosTotales(){
        return this.vuelos.size();
    }

    public Integer cantVecesQueVisitaste(Ciudad ciudad){
        return (int) this.vuelos
                .stream()
                .filter(v -> v.vueloConDestino(ciudad))
                .count();

    }

}

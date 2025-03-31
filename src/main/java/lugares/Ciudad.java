package lugares;

import viajes.Vuelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ciudad {
    private String nombre;
    private Pais pais;
    private List<Aeropuerto> aeropuertos;

    public Ciudad(String nombre, Pais pais, List<Aeropuerto> aeropuertos) {
        this.nombre = nombre;
        this.pais = pais;
        this.aeropuertos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Aeropuerto> getAeropuertos() {
        return aeropuertos;
    }

    public void setAeropuertos(List<Aeropuerto> aeropuertos) {
        this.aeropuertos = aeropuertos;
    }

    public Integer cantAeropuertos(){
        return this.aeropuertos.size();
    }

    public void agregarAeropuertos(Aeropuerto ... aeropuertos){
        Collections.addAll(this.aeropuertos, aeropuertos);
    }
//HECHO X EL PROFE
    public Integer cantPasajerosQueLlegaronEnElDia(LocalDate dia){
        List<Vuelo> vuelosLlegadosEnElDia = this.aeropuertos
                .stream()
                .flatMap(a -> a.vuelosQueLlegaronEnElDia(dia).stream())
                .toList();

        return vuelosLlegadosEnElDia
                .stream()
                .mapToInt(Vuelo::cantPasajeros)
                .sum();
    }
}

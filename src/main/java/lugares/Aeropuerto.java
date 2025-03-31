package lugares;

import viajes.Vuelo;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Aeropuerto {
    private Ciudad ciudad;
    private List<Vuelo> vuelos;

    public Aeropuerto(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Integer cantVuelosQuePartieronEnElDia(LocalDate dia){
        return (int) this.vuelos
                .stream()
                .filter(v-> v.getFecha().toLocalDate().isEqual(dia))
                .count();

    }

    public List<Vuelo> vuelosQueLlegaronEnElDia(LocalDate dia){
        return this.vuelos
                .stream()
                .filter(v -> v.fechaDeLlegadaAprox().toLocalDate().isEqual(dia))
                .collect(Collectors.toList());
    }

    public Integer cantVuelosQueLlegaronEnElDia(LocalDate dia){
        return this.vuelosQueLlegaronEnElDia(dia).size();
    }

}

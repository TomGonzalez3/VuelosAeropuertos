package personas;

import viajes.Vuelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Tripulacion {
    private String nombre;
    private List<Empleado> empleados;
    private List<Vuelo> vuelos;

    public Tripulacion() {
        this.empleados = new ArrayList<>();
        this.vuelos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void agregarEmpleados(Empleado ... empleados) {
        Collections.addAll(this.empleados, empleados);
    }

    public void agregarVuelos(Vuelo ... vuelos) {
        Collections.addAll(this.vuelos, vuelos);
    }

    public List<Vuelo> vuelosEntre(LocalDate mes1, LocalDate mes2){
        return this.vuelos
                .stream()
                .filter(
                        v -> (v.getFecha().toLocalDate().isAfter(mes1) || v.getFecha().toLocalDate().isEqual(mes1))
                        &&
                                (v.getFecha().toLocalDate().isBefore(mes2) || v.getFecha().toLocalDate().isEqual(mes2))
                )
                .collect(Collectors.toList());
    }

    public Integer cantVuelosTripulacionEntre(LocalDate mes1, LocalDate mes2){
        return this.vuelosEntre(mes1, mes2).size();
    }
}

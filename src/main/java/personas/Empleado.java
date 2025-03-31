package personas;

import viajes.Aerolinea;

public class Empleado extends Persona {
    private Cargo cargo;
    private Aerolinea empleador;

    public Empleado(String nombre, String apellido, Integer nroDocumento) {
        super(nombre, apellido, nroDocumento);
    }
}

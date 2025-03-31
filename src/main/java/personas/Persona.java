package personas;

public abstract class Persona {
    protected String nombre;
    protected String apellido;
    protected TipoDocumento tipoDocumento;
    protected Integer nroDocumento;

    public Persona(String nombre, String apellido, Integer nroDocumento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nroDocumento = nroDocumento;
    }
}

package miPrincipal;

public class Persona {
    private String dni;
    private String nombre;
    private Fecha FechaNacimiento;
    //coloca aquí el código faltante
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Fecha getFechaNacimiento() {
        return FechaNacimiento;
    }
    public void setFechaNacimiento(Fecha fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }
    public Persona(String dni, String nombre, Fecha fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        FechaNacimiento = fechaNacimiento;
    }
    @Override
    public String toString() {
        return "Persona [dni=" + dni + ", nombre=" + nombre + ", FechaNacimiento=" + FechaNacimiento + "]";
    }
    
    



}

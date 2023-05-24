public class Persona {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String DNI;

    public Persona(String nombre, String apellido1, String apellido2, String DNI) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.DNI = DNI;
    }

   

    @Override
    public String toString() {
        return  this.getClass() + ",\n" +
                "nombre = " + nombre + ",\n" +
                "apellido1 = " + apellido1 + ",\n" +
                "apellido2 = " + apellido2 + ",\n" +
                "DNI = " + DNI + ",\n";
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
}

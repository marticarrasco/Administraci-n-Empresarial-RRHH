public class Trabajador extends Persona {
    private String numSeguretatSocial;

    public Trabajador(String nombre, String apellido1, String apellido2, String DNI, String numSeguretatSocial) {
        super(nombre, apellido1, apellido2, DNI);
        this.numSeguretatSocial = numSeguretatSocial;
    }

    public String getNumSeguretatSocial() {
        return numSeguretatSocial;
    }

    public void setNumSeguretatSocial(String numSeguretatSocial) {
        this.numSeguretatSocial = numSeguretatSocial;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "numSeguretatSocial='" + numSeguretatSocial + ",\n";
    
       
    }
}

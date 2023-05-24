public class Directivo extends Empleado {
    private double categoria;

    public Directivo(String nombre, String apellido1, String apellido2, String DNI, String numSeguretatSocial, double sou, double IRPF, double categoria) {
        super(nombre, apellido1, apellido2, DNI, numSeguretatSocial, sou, IRPF);
        this.categoria = categoria;
    }

    public double calcularSouBrut() {
        return this.getSou()*this.getCategoria()/14.0;
    }

    public double calcularSouNet() {
        return (this.getSou()*this.getCategoria())*(1-this.getIRPF()/100)/14.0;
    }

    public double getCategoria() {
        return categoria;
    }

    public void setCategoria(double categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "categoria=" + categoria + ",\n";
    }
}


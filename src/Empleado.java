public class Empleado extends Trabajador {
    private double sou;
    private double IRPF;

    public Empleado(String nombre, String apellido1, String apellido2, String DNI, String numSeguretatSocial, double sou, double IRPF) {
        super(nombre, apellido1, apellido2, DNI, numSeguretatSocial);
        this.sou = sou;
        this.IRPF = IRPF;
    }

    public double calcularSouBrut() {
        return this.getSou()/14.0;
    }

    public double calcularSouNet() {
        return this.getSou()*(1-this.getIRPF()/100)/14.0;
    }

    public double getSou() {
        return sou;
    }

    public void setSou(double sou) {
        this.sou = sou;
    }

    public double getIRPF() {
        return IRPF;
    }

    public void setIRPF(double IRPF) {
        this.IRPF = IRPF;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "numSeguretatSocial='" + getNumSeguretatSocial() + ",\n" +
                "sou=" + sou + ",\n" +
                "IRPF=" + IRPF + ",\n";
            
    }
}


public class ConsultorExterno extends Trabajador {
    private double tarifa;
    private double recuentoHoras;

    public static double IRPF = 3.0;

    public ConsultorExterno(String nombre, String apellido1, String apellido2, String DNI, String numSeguretatSocial, double tarifa, double recuentoHoras) {
        super(nombre, apellido1, apellido2, DNI, numSeguretatSocial);
        this.tarifa = tarifa;
        this.recuentoHoras = recuentoHoras;
    }

    public double aPagarAnualBrut(){
        return this.getRecuentoHoras()*this.getTarifa();
    }

    public double aPagarAnualNet(){
        return this.getRecuentoHoras()*this.getTarifa()*(1-(IRPF/100));
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public double getRecuentoHoras() {
        return recuentoHoras;
    }

    public void setRecuentoHoras(double recuentoHoras) {
        this.recuentoHoras = recuentoHoras;
    }

    @Override
    public String toString() {
        return super.toString() +
                "tarifa=" + tarifa + ",\n" +
                "recuentoHoras=" + recuentoHoras + "\n";
    }
}

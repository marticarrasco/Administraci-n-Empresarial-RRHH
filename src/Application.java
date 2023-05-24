import java.util.Scanner;

public class Application {
    private static final int MAX = 10; // Nombre màxim de treballadors
    private static Trabajador[] trabajadores = new Trabajador[MAX]; // Matriu per emmagatzemar els treballadors
    private static int contadorTrabajadores = 0; // Comptador de treballadors

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creació de l'objecte Scanner per llegir l'entrada de l'usuari
        int opcion;

        do {
            mostrarMenu(); // Mostra el menú d'opcions
            opcion = scanner.nextInt(); // Llegeix l'opció seleccionada
            scanner.nextLine(); // Neteja la línia de l'entrada

            switch (opcion) {
                case 1:
                    altaTrabajador(scanner); // Dona d'alta un nou treballador
                    break;
                case 2:
                    mostrarDatosTrabajadores(); // Mostra les dades dels treballadors
                    break;
                case 3:
                    mostrarSueldosAPagar(); // Mostra els sous a pagar
                    break;
                case 0:
                    System.out.println("Gràcies per utilitzar la aplicació! Fins després!");
                    break;
                default:
                    System.out.println("Opció invàlida. Si us plau, utilitza una opció vàlida.");
                    break;
            }

            System.out.println();
        } while (opcion != 0);

        scanner.close(); // Tanca l'objecte Scanner
    }

    public static void mostrarMenu() {
        System.out.println("===== MENÚ =====");
        System.out.println("1. Alta treballador");
        System.out.println("2. Dades treballadors");
        System.out.println("3. Sous a pagar");
        System.out.println("0. Sortir");
        System.out.print("Selecciona una opció: ");
    }

    public static void altaTrabajador(Scanner scanner) {
        if (contadorTrabajadores < MAX) {
            System.out.println("===== TIPUS DE TREBALLADORS =====");
            System.out.println("1. Empleat");
            System.out.println("2. Directiu");
            System.out.println("3. Consultor extern");
            System.out.print("Selecciona una opció: ");
            int op = scanner.nextInt(); // Llegeix l'opció seleccionada
            if(op > 3){
                System.out.println("\nOpció introduida incorrecte\n");
                altaTrabajador(scanner); // Torna a cridar la funció si l'opció és incorrecta
            }
            scanner.nextLine(); // Neteja la línia de l'entrada

            // Demana les dades del treballador
            System.out.print("\nNom: ");
            String nom = scanner.nextLine();

            System.out.print("Primer cognom: ");
            String primerCognom = scanner.nextLine();

            System.out.print("Segon cognom: ");
            String segonCognom = scanner.nextLine();

            System.out.print("DNI: ");
            String DNI = scanner.nextLine();

            System.out.print("Seguretat social: ");
            String seguretatSocial = scanner.nextLine();

            // Segons l'opció seleccionada, crea l'objecte treballador corresponent
            if(op != 3){
                System.out.print("Sou: ");
                double sou = scanner.nextDouble();

                System.out.print("IRPF: ");
                double IRPF = scanner.nextDouble();

                if(op == 2){
                    System.out.print("Categoria: ");
                    double categoria = scanner.nextDouble();
                    trabajadores[contadorTrabajadores] = new Directivo(nom, primerCognom, segonCognom, DNI, seguretatSocial, sou, IRPF, categoria);
                }else{
                    trabajadores[contadorTrabajadores] = new Empleado(nom, primerCognom, segonCognom, DNI, seguretatSocial, sou, IRPF);
                }
            }else{
                System.out.print("Tarifa: ");
                double tarifa = scanner.nextDouble();

                System.out.print("Hores treballades: ");
                double hores = scanner.nextDouble();

                trabajadores[contadorTrabajadores] = new ConsultorExterno(nom, primerCognom, segonCognom, DNI, seguretatSocial, tarifa, hores);
            }

            System.out.println("\nTreballador donat d'alta correctament.\n");
            contadorTrabajadores++;
        } else {
            System.out.println("\nS'ha arribat al nombre màxim de treballadors. No es pot donar d'alta.\n");
        }
    }

    public static void mostrarDatosTrabajadores() {
        if (contadorTrabajadores > 0) {
            System.out.println("\nDades dels treballadors:");

            // Mostra les dades de tots els treballadors registrats
            for (int i = 0; i < contadorTrabajadores; i++) {
                System.out.println(trabajadores[i].toString());
            }
        } else {
            System.out.println("\nNo hi ha treballadors registrats.\n");
        }
    }

    public static void mostrarSueldosAPagar() {
        if (contadorTrabajadores > 0) {
            System.out.println("\nSous a pagar:\n");

            // Mostra els sous a pagar segons el tipus de treballador
            for (int i = 0; i < contadorTrabajadores; i++) {
                Trabajador trabajador = trabajadores[i];
                String nombreTrabajador = trabajador.getNombre();

                if (trabajador instanceof Empleado) {
                    Empleado empleado = (Empleado) trabajador;
                    double souNet = empleado.calcularSouNet();
                    System.out.println("Sou net del Empleat " + nombreTrabajador + ": " + souNet);
                } else if (trabajador instanceof Directivo) {
                    Directivo directivo = (Directivo) trabajador;
                    double souNet = directivo.calcularSouNet();
                    System.out.println("Sou net del Directiu " + nombreTrabajador + ": " + souNet);
                } else if (trabajador instanceof ConsultorExterno) {
                    ConsultorExterno consultor = (ConsultorExterno) trabajador;
                    double souNet = consultor.aPagarAnualNet();
                    System.out.println("A pagar al Consultor Externo (net) " + nombreTrabajador + ": " + souNet);
                }
            }
        } else {
            System.out.println("\nNo hi ha treballadors registrats.\n");
        }
    }
}

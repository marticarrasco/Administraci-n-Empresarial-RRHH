import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Node;

public class App extends Application {
    private static final int MAX = 10;
    private static Trabajador[] trabajadores = new Trabajador[MAX];
    private static int contadorTrabajadores = 0;
    private static Stage primaryStage;
    private static TableView<Trabajador> tableView;
    private static ObservableList<Trabajador> trabajadorList;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        
        primaryStage = stage;
        primaryStage.setTitle("Treballadors App");

        VBox root = new VBox();
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        

        Node menuBar = createMenuBar();
        root.getChildren().add(menuBar);

        Scene scene = new Scene(root, 300, 500);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        scene.getRoot().setStyle("-fx-background-color: #FFFFFF;");
        primaryStage.show();
    }

    private Node createMenuBar() {
        VBox container = new VBox();
        container.setSpacing(10);
        container.setPadding(new Insets(20));
        container.setAlignment(Pos.CENTER);

        ImageView imageView = new ImageView("image.jpg");
        imageView.setFitWidth(250); // Adjusted width
        imageView.setFitHeight(155); // Adjusted height
        imageView.setPreserveRatio(true);

    
        Button altaButton = new Button("Alta treballador");
        altaButton.getStyleClass().add("menu-button");
        altaButton.setOnAction(event -> altaTrabajador());
    
        Button dadesButton = new Button("Dades treballadors");
        dadesButton.getStyleClass().add("menu-button");
        dadesButton.setOnAction(event -> mostrarDatosTrabajadores());
    
        Button sousButton = new Button("Sous a pagar");
        sousButton.getStyleClass().add("menu-button");
        sousButton.setOnAction(event -> mostrarSueldosAPagar());
    
        Button sortirButton = new Button("Sortir");
        sortirButton.getStyleClass().add("menu-button");
        sortirButton.setOnAction(event -> {
            System.out.println("Gràcies per utilitzar la aplicació! Fins després!");
            System.exit(0);
        });
    
        container.getChildren().addAll(imageView, altaButton, dadesButton, sousButton, sortirButton);
    
        return container;
    }
    

    private void altaTrabajador() {
        if (contadorTrabajadores < MAX) {
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Alta treballador");

            VBox dialogRoot = new VBox();
            dialogRoot.setSpacing(10);
            dialogRoot.setPadding(new Insets(20));
            dialogRoot.setAlignment(Pos.CENTER);

            Label titleLabel = new Label("Selecciona un tipus de treballador:");
            titleLabel.setStyle("-fx-font-weight: bold;");

            Button empleatButton = new Button("Empleat");
            Button directiuButton = new Button("Directiu");
            Button consultorButton = new Button("Consultor extern");

            empleatButton.setOnAction(e -> {
                dialogStage.close();
                showAltaEmpleatDialog();
            });

            directiuButton.setOnAction(e -> {
                dialogStage.close();
                showAltaDirectiuDialog();
            });

            consultorButton.setOnAction(e -> {
                dialogStage.close();
                showAltaConsultorDialog();
            });

            dialogRoot.getChildren().addAll(titleLabel, empleatButton, directiuButton, consultorButton);

            Scene dialogScene = new Scene(dialogRoot, 300, 200);
            dialogStage.setScene(dialogScene);
            dialogStage.show();
        } else {
            showErrorMessage("S'ha arribat al nombre màxim de treballadors. No es pot donar d'alta.");
        }
    }

    private void showAltaEmpleatDialog() {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Alta treballador - Empleat");

        ButtonType createButtonType = new ButtonType("Crear", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(createButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        TextField nomField = new TextField();
        TextField primerCognomField = new TextField();
        TextField segonCognomField = new TextField();
        TextField DNIField = new TextField();
        TextField seguretatSocialField = new TextField();
        TextField souField = new TextField();
        TextField IRPFField = new TextField();

        grid.add(new Label("Nom:"), 0, 0);
        grid.add(nomField, 1, 0);
        grid.add(new Label("Primer cognom:"), 0, 1);
        grid.add(primerCognomField, 1, 1);
        grid.add(new Label("Segon cognom:"), 0, 2);
        grid.add(segonCognomField, 1, 2);
        grid.add(new Label("DNI:"), 0, 3);
        grid.add(DNIField, 1, 3);
        grid.add(new Label("Seguretat social:"), 0, 4);
        grid.add(seguretatSocialField, 1, 4);
        grid.add(new Label("Sou:"), 0, 5);
        grid.add(souField, 1, 5);
        grid.add(new Label("IRPF:"), 0, 6);
        grid.add(IRPFField, 1, 6);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == createButtonType) {
                String nom = nomField.getText();
                String primerCognom = primerCognomField.getText();
                String segonCognom = segonCognomField.getText();
                String DNI = DNIField.getText();
                String seguretatSocial = seguretatSocialField.getText();
                double sou = Double.parseDouble(souField.getText());
                double IRPF = Double.parseDouble(IRPFField.getText());

                trabajadores[contadorTrabajadores] = new Empleado(nom, primerCognom, segonCognom, DNI, seguretatSocial, sou, IRPF);
                contadorTrabajadores++;

                return "created";
            }
            return null;
        });

        dialog.showAndWait();
    }

    private void showAltaDirectiuDialog() {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Alta treballador - Directiu");

        ButtonType createButtonType = new ButtonType("Crear", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(createButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        TextField nomField = new TextField();
        TextField primerCognomField = new TextField();
        TextField segonCognomField = new TextField();
        TextField DNIField = new TextField();
        TextField seguretatSocialField = new TextField();
        TextField souField = new TextField();
        TextField IRPFField = new TextField();
        TextField categoriaField = new TextField();

        grid.add(new Label("Nom:"), 0, 0);
        grid.add(nomField, 1, 0);
        grid.add(new Label("Primer cognom:"), 0, 1);
        grid.add(primerCognomField, 1, 1);
        grid.add(new Label("Segon cognom:"), 0, 2);
        grid.add(segonCognomField, 1, 2);
        grid.add(new Label("DNI:"), 0, 3);
        grid.add(DNIField, 1, 3);
        grid.add(new Label("Seguretat social:"), 0, 4);
        grid.add(seguretatSocialField, 1, 4);
        grid.add(new Label("Sou:"), 0, 5);
        grid.add(souField, 1, 5);
        grid.add(new Label("IRPF:"), 0, 6);
        grid.add(IRPFField, 1, 6);
        grid.add(new Label("Categoria:"), 0, 7);
        grid.add(categoriaField, 1, 7);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == createButtonType) {
                String nom = nomField.getText();
                String primerCognom = primerCognomField.getText();
                String segonCognom = segonCognomField.getText();
                String DNI = DNIField.getText();
                String seguretatSocial = seguretatSocialField.getText();
                double sou = Double.parseDouble(souField.getText());
                double IRPF = Double.parseDouble(IRPFField.getText());
                double categoria = Double.parseDouble(categoriaField.getText());

                trabajadores[contadorTrabajadores] = new Directivo(nom, primerCognom, segonCognom, DNI, seguretatSocial, sou, IRPF, categoria);
                contadorTrabajadores++;

                return "created";
            }
            return null;
        });

        dialog.showAndWait();
    }

    private void showAltaConsultorDialog() {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Alta treballador - Consultor extern");

        ButtonType createButtonType = new ButtonType("Crear", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(createButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        TextField nomField = new TextField();
        TextField primerCognomField = new TextField();
        TextField segonCognomField = new TextField();
        TextField DNIField = new TextField();
        TextField seguretatSocialField = new TextField();
        TextField tarifaField = new TextField();
        TextField horesField = new TextField();

        grid.add(new Label("Nom:"), 0, 0);
        grid.add(nomField, 1, 0);
        grid.add(new Label("Primer cognom:"), 0, 1);
        grid.add(primerCognomField, 1, 1);
        grid.add(new Label("Segon cognom:"), 0, 2);
        grid.add(segonCognomField, 1, 2);
        grid.add(new Label("DNI:"), 0, 3);
        grid.add(DNIField, 1, 3);
        grid.add(new Label("Seguretat social:"), 0, 4);
        grid.add(seguretatSocialField, 1, 4);
        grid.add(new Label("Tarifa:"), 0, 5);
        grid.add(tarifaField, 1, 5);
        grid.add(new Label("Hores treballades:"), 0, 6);
        grid.add(horesField, 1, 6);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == createButtonType) {
                String nom = nomField.getText();
                String primerCognom = primerCognomField.getText();
                String segonCognom = segonCognomField.getText();
                String DNI = DNIField.getText();
                String seguretatSocial = seguretatSocialField.getText();
                double tarifa = Double.parseDouble(tarifaField.getText());
                double hores = Double.parseDouble(horesField.getText());

                trabajadores[contadorTrabajadores] = new ConsultorExterno(nom, primerCognom, segonCognom, DNI, seguretatSocial, tarifa, hores);
                contadorTrabajadores++;

                return "created";
            }
            return null;
        });

        dialog.showAndWait();
    }

    private void mostrarDatosTrabajadores() {
        if (contadorTrabajadores > 0) {
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Dades treballadors");
    
            tableView = new TableView<>();
            trabajadorList = FXCollections.observableArrayList();
    
            TableColumn<Trabajador, String> nomColumn = new TableColumn<>("Nom");
            nomColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    
            TableColumn<Trabajador, String> primerCognomColumn = new TableColumn<>("Primer Cognom");
            primerCognomColumn.setCellValueFactory(data -> new SimpleStringProperty(getPrimerCognom(data.getValue())));
    
            TableColumn<Trabajador, String> segonCognomColumn = new TableColumn<>("Segon Cognom");
            segonCognomColumn.setCellValueFactory(data -> new SimpleStringProperty(getSegonCognom(data.getValue())));
    
            TableColumn<Trabajador, String> DNIColumn = new TableColumn<>("DNI");
            DNIColumn.setCellValueFactory(new PropertyValueFactory<>("DNI"));
    
            TableColumn<Trabajador, String> seguretatSocialColumn = new TableColumn<>("Seguretat Social");
            seguretatSocialColumn.setCellValueFactory(data -> new SimpleStringProperty(getSeguretatSocial(data.getValue())));
    
            TableColumn<Trabajador, String> souColumn = new TableColumn<>("Sou");
            souColumn.setCellValueFactory(data -> new SimpleStringProperty(getSou(data.getValue())));
    
            TableColumn<Trabajador, String> IRPFColumn = new TableColumn<>("IRPF");
            IRPFColumn.setCellValueFactory(data -> new SimpleStringProperty(getIRPF(data.getValue())));
    
            TableColumn<Trabajador, String> categoriaColumn = new TableColumn<>("Categoria");
            categoriaColumn.setCellValueFactory(data -> new SimpleStringProperty(getCategoria(data.getValue())));
    
            TableColumn<Trabajador, String> tarifaColumn = new TableColumn<>("Tarifa");
            tarifaColumn.setCellValueFactory(data -> new SimpleStringProperty(getTarifa(data.getValue())));
    
            TableColumn<Trabajador, String> horesColumn = new TableColumn<>("Hores Treballades");
            horesColumn.setCellValueFactory(data -> new SimpleStringProperty(getHores(data.getValue())));
    
            tableView.getColumns().addAll(nomColumn, primerCognomColumn, segonCognomColumn, DNIColumn,
                    seguretatSocialColumn, souColumn, IRPFColumn, categoriaColumn, tarifaColumn, horesColumn);
    
            for (int i = 0; i < contadorTrabajadores; i++) {
                trabajadorList.add(trabajadores[i]);
            }
    
            tableView.setItems(trabajadorList);
    
            VBox dialogRoot = new VBox();
            dialogRoot.setSpacing(10);
            dialogRoot.setPadding(new Insets(20));
            dialogRoot.setAlignment(Pos.CENTER);
            dialogRoot.getChildren().add(tableView);
    
            Scene dialogScene = new Scene(dialogRoot, 1200, 600);
            dialogStage.setScene(dialogScene);
            dialogStage.show();
        } else {
            showErrorMessage("No hi ha treballadors registrats.");
        }
    }
    
    private String getPrimerCognom(Trabajador trabajador) {
        if (trabajador instanceof Empleado) {
            return ((Empleado) trabajador).getApellido1();
        } else if (trabajador instanceof Directivo) {
            return ((Directivo) trabajador).getApellido1();
        } else if (trabajador instanceof ConsultorExterno) {
            return ((ConsultorExterno) trabajador).getApellido1();
        }
        return "";
    }
    
    private String getSegonCognom(Trabajador trabajador) {
        if (trabajador instanceof Empleado) {
            return ((Empleado) trabajador).getApellido2();
        } else if (trabajador instanceof Directivo) {
            return ((Directivo) trabajador).getApellido2();
        } else if (trabajador instanceof ConsultorExterno) {
            return ((ConsultorExterno) trabajador).getApellido2();
        }
        return "";
    }
    
    private String getSeguretatSocial(Trabajador trabajador) {
        if (trabajador instanceof Empleado) {
            return ((Empleado) trabajador).getNumSeguretatSocial();
        } else if (trabajador instanceof Directivo) {
            return ((Directivo) trabajador).getNumSeguretatSocial();
        } else if (trabajador instanceof ConsultorExterno) {
            return ((ConsultorExterno) trabajador).getNumSeguretatSocial();
        }
        return "";
    }
    
    private String getSou(Trabajador trabajador) {
        if (trabajador instanceof Empleado) {
            return String.valueOf(((Empleado) trabajador).getSou());
        } else if (trabajador instanceof Directivo) {
            return String.valueOf(((Directivo) trabajador).getSou());
        }
        return "";
    }
    
    private String getIRPF(Trabajador trabajador) {
        if (trabajador instanceof Empleado) {
            return String.valueOf(((Empleado) trabajador).getIRPF());
        } else if (trabajador instanceof Directivo) {
            return String.valueOf(((Directivo) trabajador).getIRPF());
        }
        return "";
    }
    
    private String getCategoria(Trabajador trabajador) {
        if (trabajador instanceof Directivo) {
            return String.valueOf(((Directivo) trabajador).getCategoria());
        }
        return "";
    }
    
    private String getTarifa(Trabajador trabajador) {
        if (trabajador instanceof ConsultorExterno) {
            return String.valueOf(((ConsultorExterno) trabajador).getTarifa());
        }
        return "";
    }
    
    private String getHores(Trabajador trabajador) {
        if (trabajador instanceof ConsultorExterno) {
            return String.valueOf(((ConsultorExterno) trabajador).getRecuentoHoras());
        }
        return "";
    }
    
    
      
    
    private void mostrarSueldosAPagar() {
        if (contadorTrabajadores > 0) {
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Sous a pagar");

            tableView = new TableView<>();
            trabajadorList = FXCollections.observableArrayList();

            TableColumn<Trabajador, String> nomColumn = new TableColumn<>("Nom");
            nomColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));

            TableColumn<Trabajador, String> souNetColumn = new TableColumn<>("Sou Net");
            souNetColumn.setCellValueFactory(cellData -> new SimpleStringProperty(formatCurrency(calculateNetSalary(cellData.getValue()))));

            tableView.getColumns().addAll(nomColumn, souNetColumn);

            for (int i = 0; i < contadorTrabajadores; i++) {
                trabajadorList.add(trabajadores[i]);
            }

            tableView.setItems(trabajadorList);

            VBox dialogRoot = new VBox();
            dialogRoot.setSpacing(10);
            dialogRoot.setPadding(new Insets(20));
            dialogRoot.setAlignment(Pos.CENTER);
            dialogRoot.getChildren().add(tableView);

            Scene dialogScene = new Scene(dialogRoot, 400, 300);
            dialogStage.setScene(dialogScene);
            dialogStage.show();
        } else {
            showErrorMessage("No hi ha treballadors registrats.");
        }
    }

    private double calculateNetSalary(Trabajador trabajador) {
        if (trabajador instanceof Empleado) {
            Empleado empleado = (Empleado) trabajador;
            return empleado.calcularSouNet();
        } else if (trabajador instanceof Directivo) {
            Directivo directivo = (Directivo) trabajador;
            return directivo.calcularSouNet();
        } else if (trabajador instanceof ConsultorExterno) {
            ConsultorExterno consultor = (ConsultorExterno) trabajador;
            return consultor.aPagarAnualNet();
        }
        return 0.0;
    }

    private String formatCurrency(double amount) {
        // Implement currency formatting logic here
        return String.format("%.2f", amount);
    }

    private void showErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

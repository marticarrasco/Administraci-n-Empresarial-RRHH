# Administració empresarial — RRHH

Esta es una aplicación JavaFX para gestionar los datos de los empleados. Proporciona funcionalidades para agregar nuevos empleados, ver los datos de los empleados y calcular los salarios netos.

## **Prerrequisitos**

- Kit de desarrollo de Java (JDK)
- JavaFX

## **Ejecución**

Para ejecutar la aplicación, sigue los pasos a continuación:

1. Asegúrate de tener instalado el **[Kit de desarrollo de Java (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)**.
2. Descarga el archivo JAR de la aplicación desde [el repositorio](https://github.com/marticarrasco/Administraci-n-Empresarial-RRHH/releases/tag/untagged-bcc07e779bec49911490).

Ahora puedes ejecutar la aplicación dando dos clicks en el archivo JAR o bien seguir los siguientes pasos.

1. Abre una terminal o línea de comandos en el directorio donde se encuentra el archivo JAR.
2. Ejecuta el siguiente comando para iniciar la aplicación:
    
    ```
    Copy code
    java -jar administracion.empresarial.jar
    ```
    

## **Funcionalidades**

La aplicación proporciona las siguientes características:

### **1. Menú principal**

![Untitled](Administracio%CC%81%20empresarial%20%E2%80%94%20RRHH%203f4b9d74c5604c43814a43f1eb8a8338/Untitled.png)

El menú principal consta de las siguientes opciones:

- "Alta treballador": Permite agregar un nuevo empleado.
- "Dades treballadors": Muestra una tabla con los datos de todos los empleados registrados.
- "Sous a pagar": Muestra una tabla con los salarios netos a pagar a cada empleado.
- "Sortir": Cierra la aplicación.

### **2. Alta de empleado**

Al seleccionar la opción "Alta treballador" del menú principal, puedes elegir el tipo de empleado a agregar:

![Untitled](Administracio%CC%81%20empresarial%20%E2%80%94%20RRHH%203f4b9d74c5604c43814a43f1eb8a8338/Untitled%201.png)

- "Empleat": Permite agregar un empleado.
- "Directiu": Permite agregar un ejecutivo.
- "Consultor extern": Permite agregar un consultor externo.

![Untitled](Administracio%CC%81%20empresarial%20%E2%80%94%20RRHH%203f4b9d74c5604c43814a43f1eb8a8338/Untitled%202.png)

Dependiendo del tipo elegido, se mostrará un diálogo para ingresar los detalles del empleado. La información requerida varía para cada tipo de empleado. 

### **3. Datos de los empleados**

Al seleccionar la opción "Dades treballadors" del menú principal, se mostrará una tabla con los datos de todos los empleados registrados. La tabla incluye las siguientes columnas:

- "Nom": Nombre
- "Primer Cognom": Primer Apellido
- "Segon Cognom": Segundo Apellido
- "DNI"
- "Seguretat Social": Seguridad Social
- "Sou": Salario
- "IRPF"
- "Categoria" (solo aplicable a ejecutivos)
- "Tarifa" (solo aplicable a consultores externos)
- "Hores Treballades" (solo aplicable a consultores externos)

![Untitled](Administracio%CC%81%20empresarial%20%E2%80%94%20RRHH%203f4b9d74c5604c43814a43f1eb8a8338/Untitled%203.png)

### **4. Sous a pagar**

![Untitled](Administracio%CC%81%20empresarial%20%E2%80%94%20RRHH%203f4b9d74c5604c43814a43f1eb8a8338/Untitled%204.png)

La opción "Sous a pagar" del menú principal muestra una tabla con los salarios netos a pagar a cada empleado. La tabla incluye las siguientes columnas:

- "Nom": Nombre
- "Sou Net": Salario Neto

El cálculo del salario neto se basa en el tipo de empleado:

- Para empleados y ejecutivos, el salario neto se calcula en base al salario y el porcentaje de impuesto sobre la renta (IRPF). A los directivos se les aplica un factor multiplicador en función de su categoria.
- Para consultores externos, el salario neto se calcula en base a la tarifa por hora y las horas trabajadas.

## **Licencia**

Este proyecto está licenciado bajo la [**Licencia MIT**](https://github.com/marticarrasco/Administraci-n-Empresarial-RRHH/blob/main/LICENSE).

Siéntete libre de explorar y modificar el código según tus necesidades.

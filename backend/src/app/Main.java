package app;

import java.util.Scanner;

public class Main {
    private static Administrador admin;
    private static Scanner scanner;

    public static void main(String[] args) {
        admin = new Administrador();
        scanner = new Scanner(System.in);

        mostrarMenu();
    }

    private static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n" + "=".repeat(60));
            System.out.println("         SISTEMA DE GESTIÓN DE ESTUDIANTES - ABB");
            System.out.println("=".repeat(60));
            System.out.println("1. Insertar estudiante");
            System.out.println("2. Buscar estudiante");
            System.out.println("3. Eliminar estudiante");
            System.out.println("4. Listar estudiantes");
            System.out.println("5. Salir");
            System.out.println("=".repeat(60));
            System.out.print("Seleccione una opción: ");
            
            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    insertarEstudiante();
                    break;
                case 2:
                    buscarEstudiante();
                    break;
                case 3:
                    eliminarEstudiante();
                    break;
                case 4:
                    admin.listarEstudiantes();
                    break;
                case 5:
                    System.out.println("\n¡Hasta luego!");
                    break;
                default:
                    System.out.println("\n✗ Opción no válida. Intente de nuevo\n");
            }
        } while (opcion != 5);
        scanner.close();
    }

    private static void insertarEstudiante() {
        System.out.println("\n========== INSERTAR ESTUDIANTE ==========");
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine().trim();
        
        System.out.print("DNI: ");
        String dni = scanner.nextLine().trim();
        
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();
        
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine().trim();
        
        System.out.print("Programa: ");
        String programa = scanner.nextLine().trim();
        
        System.out.print("Semestre: ");
        int semestre = leerEntero();
        
        System.out.print("Correo: ");
        String correo = scanner.nextLine().trim();

        Estudiante estudiante = new Estudiante(matricula, dni, nombre, apellido, programa, semestre, correo);
        admin.insertarEstudiante(estudiante);
    }

    private static void buscarEstudiante() {
        System.out.println("\n========== BUSCAR ESTUDIANTE ==========");
        System.out.print("Ingrese DNI a buscar: ");
        String dni = scanner.nextLine().trim();
        admin.buscarEstudiante(dni);
    }

    private static void eliminarEstudiante() {
        System.out.println("\n========== ELIMINAR ESTUDIANTE ==========");
        System.out.print("Ingrese DNI a eliminar: ");
        String dni = scanner.nextLine().trim();
        admin.eliminarEstudiante(dni);
    }

    private static int leerEntero() {
        int numero = 0;
        try {
            numero = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("✗ Debe ingresar un número válido");
        }
        return numero;
    }
    
}

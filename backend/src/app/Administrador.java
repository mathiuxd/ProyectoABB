package app;

import java.util.ArrayList;
import java.util.List;

public class Administrador {
    private ArbolABB arbol;

    public Administrador() {
        this.arbol = new ArbolABB();
    }

    public void insertarEstudiante(Estudiante estudiante) {
        arbol.insertar(estudiante);
        System.out.println("✓ Estudiante insertado correctamente\n");
    }

    public Estudiante buscarEstudiante(String dni) {
        Estudiante encontrado = arbol.buscar(dni);
        if (encontrado != null) {
            System.out.println("\n✓ Estudiante encontrado:");
            System.out.println(encontrado);
        } else {
            System.out.println("\n✗ Estudiante con DNI " + dni + " no encontrado");
        }
        System.out.println();
        return encontrado;
    }

    public void eliminarEstudiante(String dni) {
        Estudiante encontrado = arbol.buscar(dni);
        if (encontrado != null) {
            arbol.eliminar(dni);
            System.out.println("\n✓ Estudiante eliminado correctamente\n");
        } else {
            System.out.println("\n✗ No se puede eliminar: estudiante no encontrado\n");
        }
    }

    public void listarEstudiantes() {
        System.out.println("\n========== LISTA DE ESTUDIANTES (Ordenado por documento) ==========");
        arbol.listar();
        System.out.println("=".repeat(60) + "\n");
    }

    public List<Estudiante> obtenerTodos() {
        List<Estudiante> lista = new ArrayList<>();
        recorridoInorden(arbol.getRaiz(), lista);
        return lista;
    }

    private void recorridoInorden(NodoABB nodo, List<Estudiante> lista) {
        if (nodo != null) {
            recorridoInorden(nodo.getIzquierda(), lista);
            lista.add(nodo.getEstudiante());
            recorridoInorden(nodo.getDerecha(), lista);
        }
    }
}
 


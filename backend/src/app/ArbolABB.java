package app;

public class ArbolABB {
    private NodoABB raiz;

    public ArbolABB() {
        this.raiz = null;
    }

    public void insertar(Estudiante estudiante) {
        raiz = insertarRecursivo(raiz, estudiante);
    }

    private NodoABB insertarRecursivo(NodoABB nodo, Estudiante estudiante) {
        if (nodo == null) {
            return new NodoABB(estudiante);
        }
        // compareTo sitve para comparar dos objectos del mismo tipo
        int comparacion = estudiante.getDni().compareTo(nodo.getEstudiante().getDni());

        if (comparacion < 0) {
            nodo.setIzquierda(insertarRecursivo(nodo.getIzquierda(), estudiante));
        } else if (comparacion > 0) {
            nodo.setDerecha(insertarRecursivo(nodo.getDerecha(), estudiante));
        } else {
            System.out.println("El estudiante con DNI: " + estudiante.getDni() + "ya existe");
        }

        return nodo;
    }

    public Estudiante buscar(String dni) {
        return buscarRecursivo(raiz, dni);
    }

    public Estudiante buscarRecursivo(NodoABB nodo, String dni) {
        if (nodo == null) {
            return null;
        }

        int comparacion = dni.compareTo(nodo.getEstudiante().getDni());

        if (comparacion == 0) {
            return nodo.getEstudiante();
        } else if (comparacion < 0) {
            return buscarRecursivo(nodo.getIzquierda(), dni);
        } else {
            return buscarRecursivo(nodo.getDerecha(), dni);
        }

    }

}

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

}

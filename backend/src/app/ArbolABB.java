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

    public void eliminar(String dni) {
        raiz = eliminarRecursivo(raiz, dni);
    }

    public NodoABB eliminarRecursivo(NodoABB nodo, String dni) {
        if (nodo == null) {
            return null;
        }

        int comparacion = dni.compareTo(nodo.getEstudiante().getDni());

        if (comparacion < 0) {

            nodo.setIzquierda(eliminarRecursivo(nodo.getIzquierda(), dni));
        } else if (comparacion > 0) {

            nodo.setDerecha(eliminarRecursivo(nodo.getDerecha(), dni));
        } else {

            if (nodo.getIzquierda() == null && nodo.getDerecha() == null) {
                return null;
            }
            if (nodo.getIzquierda() == null) {
                return nodo.getDerecha();
            }
            if (nodo.getDerecha() == null) {
                return nodo.getIzquierda();
            }
            NodoABB sucesor = encontrarMinimo(nodo.getDerecha());
            nodo.setEstudiante(sucesor.getEstudiante());
            nodo.setDerecha(eliminarRecursivo(nodo.getDerecha(), sucesor.getEstudiante().getDni()));
        }

        return nodo;
    }

    public NodoABB encontrarMinimo(NodoABB nodo) {
        while (nodo.getIzquierda() != null) {
            nodo = nodo.getIzquierda();
        }
        return nodo;
    }

    public void listar() {
        if (raiz == null) {
            System.out.println("El árbol está vacío");
        } else {
            listarRecursivo(raiz);
        }
    }

    private void listarRecursivo(NodoABB nodo) {
        if (nodo != null) {
            listarRecursivo(nodo.getIzquierda());
            System.out.println(nodo.getEstudiante());
            listarRecursivo(nodo.getDerecha());
        }
    }

    public NodoABB getRaiz() {
        return raiz;
    }
}

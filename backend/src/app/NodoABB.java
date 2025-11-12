package app;

public class NodoABB {
    Estudiante estudiante;
    NodoABB izquierda;
    NodoABB derecha;

    public NodoABB(Estudiante estudiante, NodoABB izquierda, NodoABB derecha) {
        this.estudiante = estudiante;
        this.izquierda = null;
        this.derecha = null;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public NodoABB getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoABB izquierda) {
        this.izquierda = izquierda;
    }

    public NodoABB getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoABB derecha) {
        this.derecha = derecha;
    }

    

}

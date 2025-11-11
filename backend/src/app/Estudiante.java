package app;

public class Estudiante {
    private String matricula;
    private String dni;
    private String nombre;
    private String apellido;
    private String programa;
    private int semestre;
    private String correo;

    public Estudiante(String matricula, String dni, String nombre, String apellido, String programa, int semestre,
            String correo) {
        this.matricula = matricula;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.programa = programa;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public void mostrarInfo() {
        System.out.println("Matrícula: " + matricula);
        System.out.println("DNI: " + dni);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Programa: " + programa);
        System.out.println("Semestre: " + semestre);
        System.out.println("Correo: " + correo);
    }

}

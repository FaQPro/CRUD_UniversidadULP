/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadAPP.Entidades;

/**
 *
 * @author rodrigo
 */
public class MateriasYnotas {
    private int idMateria;
    private String nombre;
    private int nota;

    public MateriasYnotas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public MateriasYnotas(int idMateria, String nombre, int nota) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.nota = nota;
    }
}

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
public class Inscripcion {
    private int idInscripto;
    private double nota;
    private Ealumno alumno;
    private Materia materia;

    public Inscripcion() {
    }

    public Inscripcion(double nota, Ealumno alumno, Materia materia) {
        this.nota = nota;
        this.alumno = alumno;
        this.materia = materia;
    }
    public Inscripcion(double nota,  Materia materia) {
        this.nota = nota;
       
        this.materia = materia;
    }


    public Inscripcion(int idInscripto, double nota, Ealumno alumno, Materia materia) {
        this.idInscripto = idInscripto;
        this.nota = nota;
        this.alumno = alumno;
        this.materia = materia;
    }

    public int getIdInscripto() {
        return idInscripto;
    }

    public void setIdInscripto(int idInscripto) {
        this.idInscripto = idInscripto;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Ealumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Ealumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        //aca traigo todo el alumno y toda la materia, se puede elegir lo que haga falta
        return "Inscripcion{" + "idInscripto=" + idInscripto + ", nota=" + nota + ", alumno=" + alumno + ", materia=" + materia + '}';
    }
    
    
    
}

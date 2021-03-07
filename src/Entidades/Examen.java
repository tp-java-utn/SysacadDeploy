package Entidades;

import java.sql.Date;

public class Examen {

	private float nota;
	private String observacion;
	private tipoExamen tipo;
	private modalidadExamen modalidad;
	String legajo;
	private int idComision;
	private int idExamen;
	private int idMateria;
	Date fecha;
	
	@Override
	public String toString() {
		return "Examen [nota=" + nota + ", observacion=" + observacion + ", tipo=" + tipo + ", modalidad=" + modalidad
				+ ", legajo=" + legajo + ", idComision=" + idComision + ", idExamen=" + idExamen + ", fecha=" + fecha
				+ "]";
	}

	public Examen() {
		//
	}
	
	public Examen(int idExamen,String legajo,int idComision,int idMateria,float nota,String observacion, tipoExamen tipo,modalidadExamen modalidad,Date fecha) {
		this.setNota(nota);
		this.setObservacion(observacion);
		this.setTipo(tipo);
		this.setModalidad(modalidad);
		this.setFecha(fecha);
		this.setLegajo(legajo);
		this.setIdComision(idComision);
		this.setIdExamen(idExamen);
		this.setIdMateria(idMateria);
	}
	
	public enum tipoExamen{
		Parcial,
		Recuperatorio,
		Final
	}
	
	public enum modalidadExamen{
		Multiplechoice,
		Oral,
		Desarrollo
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public tipoExamen getTipo() {
		return tipo;
	}

	public void setTipo(tipoExamen tipo) {
		this.tipo = tipo;
	}

	public modalidadExamen getModalidad() {
		return modalidad;
	}

	public void setModalidad(modalidadExamen modalidad) {
		this.modalidad = modalidad;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public int getIdComision() {
		return idComision;
	}

	public void setIdComision(int idComision) {
		this.idComision = idComision;
	}

	public int getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(int idExamen) {
		this.idExamen = idExamen;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
}
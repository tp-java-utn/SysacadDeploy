package Entidades;
import java.sql.Date;
import java.time.LocalDate;

public class Inscripcion {

	@Override
	public String toString() {
		return "Inscripcion [idInscripcion=" + idInscripcion + ", legajo=" + legajo + ", idDocente=" + idDocente
				+ ", idMateira=" + idMateria + ", idComision=" + idComision + ", fecha=" + fecha + "]";
	}
	private int idInscripcion;
	private String legajo;
	private int idDocente;
	private int idMateria;
	private int idComision;
	private Date fecha;
	private tipoInscripciones tipo;
	
	public enum tipoInscripciones{
		Materia,
		Mesa
	}
	
	public int getIdInscripcion() {
		return idInscripcion;
	}
	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}
	public String getLegajo() {
		return legajo;
	}
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
	public int getIdDocente() {
		return idDocente;
	}
	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}
	public int getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(int idMateira) {
		this.idMateria = idMateira;
	}
	public int getIdComision() {
		return idComision;
	}
	public void setIdComision(int idComision) {
		this.idComision = idComision;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date date) {
		this.fecha = date;
	}
	public tipoInscripciones getTipo() {
		return tipo;
	}
	public void setTipo(tipoInscripciones tipo) {
		this.tipo = tipo;
	}
}

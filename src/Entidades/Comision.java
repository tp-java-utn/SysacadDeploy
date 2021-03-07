package Entidades;

public class Comision {
	
	private int idMateria;
	private int idComision;
	private int idDocente;
	private String legajo;
	private int cantAlumnos;
	private int cantAlumnosMax;
	private turnos turno;
	
	@Override
	public String toString() {
		return "Comision [idMateria=" + idMateria + ", idComision=" + idComision + ", legajo=" + legajo
				+ ", cantAlumnos=" + cantAlumnos + ", cantAlumnosMax=" + cantAlumnosMax + ", turno=" + turno + "]";
	}

	public enum turnos{
		Mañana,
		Tarde,
		Noche
	}

	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	public int getIdComision() {
		return idComision;
	}

	public void setIdComision(int idComision) {
		this.idComision = idComision;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public int getCantAlumnos() {
		return cantAlumnos;
	}

	public void setCantAlumnos(int cantAlumnos) {
		this.cantAlumnos = cantAlumnos;
	}

	public int getCantAlumnosMax() {
		return cantAlumnosMax;
	}

	public void setCantAlumnosMax(int cantAlumnosMax) {
		this.cantAlumnosMax = cantAlumnosMax;
	}

	public turnos getTurno() {
		return turno;
	}

	public void setTurno(turnos turno) {
		this.turno = turno;
	}

	public int getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}
}

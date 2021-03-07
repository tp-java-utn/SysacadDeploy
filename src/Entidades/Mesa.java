package Entidades;

import java.sql.Date;

public class Mesa {	
	
	private int idMesa;
	private Date fecha;
	private int horario;
	private int salon;
	private int idMateria;
	
	public int getIdMesa() {
		return idMesa;
	}
	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getHorario() {
		return horario;
	}
	public void setHorario(int horario) {
		this.horario = horario;
	}
	public int getSalon() {
		return salon;
	}
	public void setSalon(int salon) {
		this.salon = salon;
	}
	public int getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	

}

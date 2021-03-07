package Entidades;



public class EstadoAcademico {
	
	@Override
	public String toString() {
		return "EstadoAcademico [idMateria=" + idMateria + ", legajo=" + legajo + ", estado=" + this.getEstado() + "]";
	}
	
	public enum estadosMateria
	{
		Libre,
		Cursando,
		Regular,
		Aprobada
	}
	
	int idMateria;
	String legajo;
	estadosMateria estado;
	float nota;
	float asistencia;
	
	public float getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(float asistencia) {
		this.asistencia = asistencia;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public EstadoAcademico() {}
	
	public EstadoAcademico(String legajo,int idMateria,estadosMateria estado,float asistencia,float nota) 
	{
		this.setEstado(estado);
		this.setIdMateria(idMateria);
		this.setLegajo(legajo);
		this.setAsistencia(asistencia);
		this.setNota(nota);
	}
	
	public int getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	public String getLegajo() {
		return legajo;
	}
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
	public String getEstado() {
		if(estado == null)
			{return "null";}
		else
			{return estado.toString();}
	}
	public void setEstado(estadosMateria estado) {
		this.estado = estado;
	}
	

}

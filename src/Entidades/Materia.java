package Entidades;

import java.util.ArrayList;

import Data.DataEstadoAcademico;
import Data.DataMateria;
import Entidades.EstadoAcademico.*;

public class Materia {
	
	@Override
	public String toString() {
		if(idMateria>9)
		{return idMateria + " - " + cursado + ", " + nombre + ".";}
		else
		{return idMateria + "  - " + cursado + ", " + nombre + "." ;}
	}
	
	
	
	int idMateria;
	String nombre;
	String descripcion;
	String cursado;
	String año;
	String correlativasRegulares;
	String correlativasAprobadas;
	String correlativasRendir;
	
	
	
	public String getCorrelativasRegulares() {
		return correlativasRegulares;
	}

	public void setCorrelativasRegulares(String correlativasRegulares) {
		this.correlativasRegulares = correlativasRegulares;
	}

	public String getCorrelativasAprobadas() {
		return correlativasAprobadas;
	}

	public void setCorrelativasAprobadas(String correlativasAprobadas) {
		this.correlativasAprobadas = correlativasAprobadas;
	}

	public String getCorrelativasRendir() {
		return correlativasRendir;
	}

	public void setCorrelativasRendir(String correlativasRendir) {
		this.correlativasRendir = correlativasRendir;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
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
	public String getdescripcion() {
		return descripcion;
	}
	public void setdescripcion(String descp) {
		this.descripcion = descp;
	}
	public String getcursado() {
		return cursado;
	}
	public void setcursado(String curs) {
		this.cursado = curs;
	}

	public ArrayList<Integer> getCorrelativasRendirInt()
	{
		DataMateria DM = new DataMateria();
		return DM.getCorrelativasRendir(this.getIdMateria());
	}
	
	public ArrayList<Integer> getCorrelativasRegularesInt()
	{
		DataMateria DM = new DataMateria();
		return DM.getCorrelativasRegular(this.getIdMateria());
	}
	
	public ArrayList<Integer> getCorrelativasAprobadasInt()
	{
		DataMateria DM = new DataMateria();
		return DM.getCorrelativasAprobadas(this.getIdMateria());
	}
	
	public boolean AlumnoPuedeCursar(String legajo)
	{
		//correlativas
		ArrayList<Integer> CorrelativasRegulares = this.getCorrelativasRegularesInt();
		ArrayList<Integer> CorrelativasAprobadas = this.getCorrelativasAprobadasInt();
		
		//Traer estado academico del alumno
		DataEstadoAcademico DEA = new DataEstadoAcademico();
		ArrayList<EstadoAcademico> EA = DEA.getAllEstadosAlumno(legajo);
		
		//checkeo
		int acumRegulares = 0;
		int acumAprobadas = 0;
		int acumAlumnoRegulares = 0;
		int acumAlumnoAprobadas = 0;
		
		for(EstadoAcademico EAs:EA)
		{
			//Regulares
			for(Integer C:CorrelativasRegulares)
			{
				if(EAs.idMateria==C)
				{
					acumRegulares++;
					if(EAs.getEstado().equalsIgnoreCase("Regular") || EAs.getEstado().equalsIgnoreCase("Aprobada"))
					{
						acumAlumnoRegulares++;
						System.out.println(EAs.idMateria +" OK");
					}
					else
					{
						System.out.println(EAs.idMateria +" not OK");
					}
				}
			}
			
			//Aprobadas
			for(Integer C:CorrelativasAprobadas)
			{
				if(EAs.idMateria==C)
				{
					acumAprobadas++;
					if(EAs.getEstado().equalsIgnoreCase("Aprobada"))
					{
						acumAlumnoAprobadas++;
						System.out.println(EAs.idMateria +" OK");
					}
					else
					{
						System.out.println(EAs.idMateria +" not OK");
					}
				}
			}
			
		}
		
		
		if(acumRegulares == acumAlumnoRegulares && acumAprobadas == acumAlumnoAprobadas)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	
	public boolean AlumnoPuedeRendir(String legajo)
	{
		//correlativas
		ArrayList<Integer> CorrelativasRendir = this.getCorrelativasRendirInt();
		
		//Traer estado academico del alumno
		DataEstadoAcademico DEA = new DataEstadoAcademico();
		ArrayList<EstadoAcademico> EA = DEA.getAllEstadosAlumno(legajo);
		
		//checkeo
		int acumRendir = 0;
		int acumAlumnoRendir = 0;
		
		for(EstadoAcademico EAs:EA)
		{
			for(Integer C:CorrelativasRendir)
			{
				if(EAs.idMateria==C)
				{
					acumRendir++;
					if(EAs.getEstado().equalsIgnoreCase("Aprobada"))
					{
						acumAlumnoRendir++;
						System.out.println(EAs.idMateria +" OK");
					}
					else
					{
						System.out.println(EAs.idMateria +" not OK");
					}
				}
			}
		}
		
		EstadoAcademico EstadoAcademicoEstaMateria = DEA.getOne(legajo, this.idMateria);
		if(EstadoAcademicoEstaMateria.getEstado().equalsIgnoreCase("Regular"))
		{
			if(acumAlumnoRendir == acumRendir)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		
	}
}

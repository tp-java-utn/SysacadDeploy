package Entidades;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;

import Data.DataComision;
import Data.DataEstadoAcademico;
import Data.DataInscripcion;
import Data.DataMateria;
import Entidades.Documento.TipoDocumento;
import Entidades.EstadoAcademico.estadosMateria;
import Entidades.Inscripcion.*;

public class Alumno extends Persona {	
	
	private String legajo;
	private double promedio;
	private Carreras carrera;
	
	public enum Carreras{
		Mecanica,
		Electrica,
		Sistemas,
		Civil,
		Quimica
	}
	
	@Override
	public String toString() {
		return "Alumno: "+ getNombre()+", "+getApellido() +
			   "\n Legajo: "+ getLegajo() +
			   "\n E-mail: "+ getEmail() +
			   "\n Telefono: "+ getTelefono() +
			   "\n Contraseña: "+ getContraseña() +
			   "\n Direccion: "+ getDireccion().toString() +
			   "\n Estado: "+ getEstadoPersona() +
			   "\n Documento: "+ getDocumento().getTipo() +": "+ getDocumento().getNumero() +
			   "\n Carrera: "+ getCarrera().toString();
			   
	}

	public Alumno()
	{
	}
	
	public Alumno(String nombre, String apellido, String email,String contraseña,String telefono, Carreras carrera, TipoDocumento tipoDoc,String numeroDoc ,String calle,int numero)
	{
		this.setApellido(apellido);
		this.setNombre(nombre);
		this.setEmail(email);
		this.setContraseña(contraseña);
		this.setTelefono(telefono);
		this.setCarrera(carrera);
		Direccion dir = new Direccion(calle,numero);
		this.setDireccion(dir);	
		Documento Doc = new Documento(tipoDoc,numeroDoc); 
		this.setDocumento(Doc);
	}
	
	public Alumno(String nombre, String apellido, String email,String contraseña,String telefono, Carreras carrera, TipoDocumento tipoDoc,String numeroDoc,String calle,int numero, int piso, String dept)
	{
		this.setApellido(apellido);
		this.setNombre(nombre);
		this.setEmail(email);
		this.setContraseña(contraseña);
		this.setTelefono(telefono);
		this.setCarrera(carrera);
		Direccion dir = new Direccion(calle,numero,piso,dept);
		this.setDireccion(dir);
		Documento Doc = new Documento(tipoDoc,numeroDoc); 
		this.setDocumento(Doc);
	}
	
	public Carreras getCarrera() {
		return carrera;
	}

	public void setCarrera(Carreras carrera) {
		this.carrera = carrera;
	}

	public String getLegajo() {
		return legajo;
	}
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
	public double getPromedio() {
		this.generatePromedio();
		return promedio;
	}

	public void generatePromedio()
	{
		DataEstadoAcademico DEA = new DataEstadoAcademico();
		ArrayList<EstadoAcademico> Estados = DEA.getAllEstadosAlumno(this.legajo);
		int cant = this.catMateriasPorEstado(estadosMateria.Aprobada);
		float acum = 0;
		
		for(EstadoAcademico EA:Estados)
		{
			acum += EA.getNota();
		}

		
		if(acum!=0)
		{
			BigDecimal bigDecimal = new BigDecimal(acum/cant).setScale(2, RoundingMode.UP);
			promedio = Float.valueOf(bigDecimal.toString());
		}
		else
		{
			promedio = 0;
		}
		

	}
	
	public ArrayList<EstadoAcademico> getEstadosAcedemicos(ArrayList<EstadoAcademico> Estados)
	{
		ArrayList<EstadoAcademico> EstadosAcademicos = new ArrayList<EstadoAcademico>();
		
		for(EstadoAcademico EAS:Estados) 
		{
			if(EAS.getLegajo().equals(this.getLegajo()))
			{
				EstadosAcademicos.add(EAS);
			}
		}
		return EstadosAcademicos;
	}
	
	public void startEstadoAcademico() 
	{
		DataEstadoAcademico EA = new DataEstadoAcademico();
		DataMateria DM = new DataMateria();
		
		//si no hay estado academico, creo uno
		if(EA.getOne(this.legajo, 1).getLegajo()==null)
		{
			ArrayList<Materia> Materias = DM.getAll();
	    	for(Materia M:Materias)
	    	{
	    		EA.addEstadoAcademico(this.getLegajo(), M.getIdMateria(), estadosMateria.Libre, 0, 0);
	    	}
		}
		else
		{
			System.out.println("Ya existe");
		}
    	
	}
	
	public void inscripcionComision(int idComision,int idMateria)
	{
		DataComision DC = new DataComision();
		boolean espacio = DC.cantAlumnosOk(idComision, idMateria);
		System.out.println("hay espacio: "+espacio);
		
		if(espacio)
		{
			DataInscripcion DI = new DataInscripcion();
			boolean existe = DI.AlumnoExist(this.legajo, idComision, idMateria);
			System.out.println("Existe: "+existe);
			
			//inscripcion
			Inscripcion I = DI.getOne(this.legajo, idMateria, idComision);
			
			if(!existe || I.getTipo().equals(tipoInscripciones.Mesa))
			{
				//Agergar alumno a la comision
				DC.inscripcion(idComision, idMateria);
				
				//Registrar inscripcion
				long now = System.currentTimeMillis();
		    	Date today = new Date(now);
		    	DI.addInscripciones(this.legajo, idMateria, idComision,today,tipoInscripciones.Materia);
		    	
		    	//Actualizar estado Academico
		    	DataEstadoAcademico DEA = new DataEstadoAcademico();
		    	DEA.setEstado(this.legajo, idMateria,estadosMateria.Cursando);
			}
		}
		
	}
	
	public void inscripcionMesa(int idMesa,int idMateria) {
		
		DataInscripcion DI = new DataInscripcion();
		boolean existe = DI.AlumnoExistMesa(this.legajo,idMateria,idMesa);
		System.out.println("Existe: "+existe);
			
		if(!existe)
		{
			//Registrar inscripcion
			long now = System.currentTimeMillis();
	    	Date today = new Date(now);
	    	//DI.addInscripciones(this.legajo, idMateria, 0, idMesa, today,tipoInscripciones.Mesa);
		}	
	}
	
	
	public int catMateriasPorEstado(estadosMateria estado)
	{
		int count = 0;
		DataEstadoAcademico DEA = new DataEstadoAcademico();
		ArrayList<EstadoAcademico> Estados = DEA.getAllEstadosAlumno(this.legajo);
		for(EstadoAcademico EA:Estados)
		{
			if(EA.getEstado().equals(estado.toString()))
			{
				count++;
			}
		}
		
		return count;
	}
	
	public int restoMaterias(estadosMateria estado)
	{
		int count = 0;
		DataEstadoAcademico DEA = new DataEstadoAcademico();
		ArrayList<EstadoAcademico> Estados = DEA.getAllEstadosAlumno(this.legajo);
		for(EstadoAcademico EA:Estados)
		{
			if(!EA.getEstado().equals(estado.toString()))
			{
				count++;
			}
		}
		
		return count;
	}
	
	
}

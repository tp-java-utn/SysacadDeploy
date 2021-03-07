package Logic;
import java.util.ArrayList;

import Data.*;
import Entidades.*;
import Entidades.Direccion;;

public class Usuario {
	
	
	static DataAlumno DA;
	static DataAdministrador DAdmin;
	static DataDocente DD;
	
	public Usuario() 
	{
		DA = new DataAlumno();
		DAdmin = new DataAdministrador();
		DD = new DataDocente();
	}
	
	public Alumno Validate(String user,String pass)
	{
		Alumno AlumnoValidate = new Alumno();
		ArrayList<Alumno> alumnos = DA.getAll();
		
		for (Alumno A:alumnos) 
		{
			if(user.equals(A.getLegajo()) && pass.equals(A.getContraseña()))
			{
				AlumnoValidate = A;
			}
		}		
		return AlumnoValidate;
	}
	
	
	public Administrador ValidateAdmin(String userAdmin,String pass)
	{
		Administrador AdministradorValidate = new Administrador();
		ArrayList<Administrador> Administradores = DAdmin.getAll();
		
		for (Administrador Admins:Administradores) 
		{
			if(userAdmin.equals(Admins.getLegajo()) && pass.equals(Admins.getContraseña()))
			{
				AdministradorValidate = Admins;
			}
		}		
		return AdministradorValidate;
	}
	

	public Docente ValidateDocente(String user,String pass)
	{
		Docente DocenteValidado = new Docente();
		ArrayList<Docente> Docentes = DD.getAll();
		
		for (Docente D:Docentes) 
		{
			if(user.equals(String.valueOf(D.getIdDocente())) && pass.equals(D.getContraseña()))
			{
				DocenteValidado = D;
			}
		}		
		return DocenteValidado;
	}
}

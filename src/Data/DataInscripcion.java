package Data;

import Entidades.*;
import Entidades.Inscripcion.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataInscripcion {

	PreparedStatement stmt=null;
	ResultSet rs=null;
	
	public Inscripcion getOne(int idInscripcion) 
	{
		Inscripcion I = new Inscripcion();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from Inscripciones where idInscripcion=?");
			stmt.setInt(1, idInscripcion);
			rs   = stmt.executeQuery();
			
			
			if(rs != null) {
				while(rs.next())
				{
				I.setFecha(rs.getDate("fecha"));
				I.setIdComision(rs.getInt("idComision"));
				I.setIdDocente(rs.getInt("idDocente"));
				I.setIdMateria(rs.getInt("idMateria"));
				I.setLegajo(rs.getString("legajo"));
				I.setIdInscripcion(rs.getInt("idInscripcion"));
				I.setTipo(tipoInscripciones.valueOf(rs.getString("tipo")));				
				}
			}
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return I;
	}
	
	public Inscripcion getOne(String legajo,int idMateria,int idComision) 
	{
		Inscripcion I = new Inscripcion();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from Inscripciones where legajo=? and idMateria=? and idComision=?");
			stmt.setString(1, legajo);
			stmt.setInt(2, idMateria);
			stmt.setInt(3, idComision);
			rs   = stmt.executeQuery();
			
			
			if(rs != null) {
				while(rs.next())
				{
				I.setFecha(rs.getDate("fecha"));
				I.setIdComision(rs.getInt("idComision"));
				I.setIdDocente(rs.getInt("idDocente"));
				I.setIdMateria(rs.getInt("idMateria"));
				I.setLegajo(rs.getString("legajo"));
				I.setIdInscripcion(rs.getInt("idInscripcion"));
				I.setTipo(tipoInscripciones.valueOf(rs.getString("tipo")));				
				}
			}
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return I;
	}
	
	public ArrayList<Inscripcion> getAll()
	{
		ArrayList<Inscripcion> Inscripciones = new ArrayList<Inscripcion>();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from Inscripciones");
			rs   = stmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					Inscripcion I = new Inscripcion();
					I.setFecha(rs.getDate("fecha"));
					I.setIdComision(rs.getInt("idComision"));
					I.setIdDocente(rs.getInt("idDocente"));
					I.setIdMateria(rs.getInt("idMateria"));
					I.setLegajo(rs.getString("legajo"));
					I.setIdInscripcion(rs.getInt("idInscripcion"));
					I.setTipo(tipoInscripciones.valueOf(rs.getString("tipo")));	
					
					//Agregar a la lista
					Inscripciones.add(I);
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return Inscripciones;
	}
	
	public Inscripcion addInscripciones(String Legajo,int idMateria, int idComision, Date fehca,tipoInscripciones tipo) 
	{
		//Crear nueva Direccion
		int id = 0;
		Inscripcion I = new Inscripcion();
		I.setFecha(fehca);
		I.setIdComision(idComision);
		I.setIdMateria(idMateria);
		I.setLegajo(Legajo);
		I.setTipo(tipo);	
		
		//taer docente
		DataComision DC = new DataComision();
		Comision C =DC.getOne(idComision, idMateria);
		I.setIdDocente(C.getIdDocente());
		
		try {
			
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into Inscripciones(legajo,idMateria,idDocente,idComision,fecha,tipo) values(?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, I.getLegajo());
			stmt.setInt(2, I.getIdMateria());
			stmt.setInt(3,I.getIdDocente());
			stmt.setInt(4, I.getIdComision());
			stmt.setDate(5, I.getFecha());
			stmt.setString(6, I.getTipo().toString());
			stmt.executeUpdate();
			
			//id 
			ResultSet keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()) {
				id=keyResultSet.getInt(1);
				I.setIdInscripcion(id);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return I;
		
	}
	
	public void delete(int idInscripcion)
	{
		
		try {
			
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("delete from Inscripciones where idInscripcion = ?");
			stmt.setInt(1, idInscripcion);
			stmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public boolean AlumnoExist(String legajo,int idComision,int idMateria) 
	{
		boolean resp = false;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from Inscripciones where legajo=? and idMateria=? and idComision=?");
			stmt.setString(1, legajo);
			stmt.setInt(2, idMateria);
			stmt.setInt(3, idComision);
			rs   = stmt.executeQuery();
	
			if(!rs.isBeforeFirst()) {
				resp = false;
			}
			else
			{
				resp = true;
			}
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resp;
	}
	
	public boolean AlumnoExist(String legajo,int idMateria) 
	{
		boolean resp = false;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from Inscripciones where legajo=? and idMateria=?");
			stmt.setString(1, legajo);
			stmt.setInt(2, idMateria);
			rs   = stmt.executeQuery();
	
			if(!rs.isBeforeFirst()) {
				resp = false;
			}
			else
			{
				resp = true;
			}
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resp;
	}
	
	public boolean AlumnoExistMesa(String legajo,int idMateria, int idMesa) 
	{
		boolean resp = false;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from Inscripciones where legajo=? and idMateria=? and idMesa=?");
			stmt.setString(1, legajo);
			stmt.setInt(2, idMateria);
			stmt.setInt(2, idMesa);
			rs   = stmt.executeQuery();
	
			if(!rs.isBeforeFirst()) {
				resp = false;
			}
			else
			{
				resp = true;
			}
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resp;
	}
}
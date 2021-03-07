package Data;

import Entidades.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import Entidades.Persona.EstadosPersona;

public class DataAdministrador {

	PreparedStatement stmt=null;
	ResultSet rs=null;
	
	public Administrador getOne(int id) 
	{
		Administrador A = new Administrador();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from Administradores where legajo=?");
			stmt.setInt(1, id);
			rs   = stmt.executeQuery();
			
			
			if(rs != null) {
				while(rs.next())
				{
				A.setNombre(rs.getString("nombre"));
				A.setApellido(rs.getString("apellido"));
				A.setContraseña(rs.getString("contraseña"));
				A.setLegajo(rs.getString("legajo"));
				A.setEstadoPersona(EstadosPersona.valueOf(rs.getString("estado")));
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
		
		return A;
	}
	
	public ArrayList<Administrador> getAll()
	{
		ArrayList<Administrador> Administradores = new ArrayList<Administrador>();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from Administradores");
			rs   = stmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					Administrador A = new Administrador();
					A.setNombre(rs.getString("nombre"));
					A.setApellido(rs.getString("apellido"));
					A.setContraseña(rs.getString("contraseña"));
					A.setLegajo(rs.getString("legajo"));
					A.setEstadoPersona(EstadosPersona.valueOf(rs.getString("estado")));
					
					//Agregar a la lista
					Administradores.add(A);
					
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
		
		return Administradores;
	}
	
	public void delete(String legajo)
	{
		
		try {
			
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("delete from Administradores where legajo = ?");
			stmt.setString(1, legajo);
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
}

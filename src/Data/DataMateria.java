package Data;

import Entidades.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataMateria {

	PreparedStatement stmt=null;
	ResultSet rs=null;
	
	public Materia getOne(int id) 
	{
		Materia M = new Materia();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from Materias where idMateria=?");
			stmt.setInt(1, id);
			rs   = stmt.executeQuery();
			
			
			if(rs != null) {
				while(rs.next())
				{
				M.setNombre(rs.getString("nombre"));
				M.setdescripcion(rs.getString("descripcion"));
				M.setIdMateria(rs.getInt("idMateria"));
				M.setcursado(rs.getString("cursado"));
				M.setAño(rs.getString("nivel"));
				M.setCorrelativasAprobadas(rs.getString("correlativasAprobadas"));
				M.setCorrelativasRegulares(rs.getString("correlativasRegulares"));
				M.setCorrelativasRendir(rs.getString("correlativasRendir"));
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
		
		return M;
	}
	
	public ArrayList<Materia> getAll()
	{
		ArrayList<Materia> Materias = new ArrayList<Materia>();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from Materias");
			rs   = stmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					Materia M = new Materia();
					M.setNombre(rs.getString("nombre"));
					M.setdescripcion(rs.getString("descripcion"));
					M.setIdMateria(rs.getInt("idMateria"));
					M.setcursado(rs.getString("cursado"));
					M.setAño(rs.getString("nivel"));
					M.setCorrelativasAprobadas(rs.getString("correlativasAprobadas"));
					M.setCorrelativasRegulares(rs.getString("correlativasRegulares"));
					M.setCorrelativasRendir(rs.getString("correlativasRendir"));
					
					//Agregar a la lista
					Materias.add(M);
					
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
		
		return Materias;
	}
	
	public Materia addMateria(String nombre,String descripcion, String cursado, String año, String correlativasRegulares, String correlativasRendir, String correlativasAprobadas) 
	{
		//Crear nueva Direccion
		int id = 0;
		Materia M = new Materia();
		M.setNombre(nombre);
		M.setdescripcion(descripcion);
		M.setcursado(cursado);
		M.setAño(año);
		M.setCorrelativasAprobadas(correlativasAprobadas);
		M.setCorrelativasRegulares(correlativasRegulares);
		M.setCorrelativasRendir(correlativasRendir);
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into Materias(nombre,descripcion,cursado,nivel,correlativasAprobadas,correlativasRegulares,correlativasRendir) values(?,?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, M.getNombre());
			stmt.setString(2, M.getdescripcion());
			stmt.setString(3, M.getcursado());
			stmt.setString(4, M.getAño());
			stmt.setString(5, M.getCorrelativasAprobadas());
			stmt.setString(6, M.getCorrelativasRegulares());
			stmt.setString(7, M.getCorrelativasRendir());
			stmt.executeUpdate();
			
			//id Direccion
			ResultSet keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()) {
				id=keyResultSet.getInt(1);
				M.setIdMateria(id);
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
		
		return M;
		
	}
	
	public Materia addMateria(String nombre, String cursado, String año, String correlativasRegulares, String correlativasRendir, String correlativasAprobadas) 
	{
		//Crear nueva Direccion
		int id = 0;
		Materia M = new Materia();
		M.setNombre(nombre);
		M.setcursado(cursado);
		M.setAño(año);
		M.setCorrelativasAprobadas(correlativasAprobadas);
		M.setCorrelativasRegulares(correlativasRegulares);
		M.setCorrelativasRendir(correlativasRendir);
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into Materias(nombre,cursado,nivel,correlativasAprobadas,correlativasRegulares,correlativasRendir) values(?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, M.getNombre());
			stmt.setString(2, M.getcursado());
			stmt.setString(3, M.getAño());
			stmt.setString(4, M.getCorrelativasAprobadas());
			stmt.setString(5, M.getCorrelativasRegulares());
			stmt.setString(6, M.getCorrelativasRendir());
			stmt.executeUpdate();
			
			//id Direccion
			ResultSet keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()) {
				id=keyResultSet.getInt(1);
				M.setIdMateria(id);
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
		
		return M;
		
	}
	
	public void delete(int idMateria)
	{
		
		try {
			
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("delete from Materias where idMateria = ?");
			stmt.setInt(1, idMateria);
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
	
	public ArrayList<Integer> getCorrelativasRendir(int idMateria)
	{
		ArrayList<Integer> CorrelativasRendir = new ArrayList<Integer>();

		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select value from string_split((select m.correlativasRendir from Materias m where m.idMateria = ?), '-')");
			stmt.setInt(1, idMateria);
			rs   = stmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					CorrelativasRendir.add(rs.getInt("value"));				
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
		
		return CorrelativasRendir;
	}
	
	public ArrayList<Integer> getCorrelativasRegular(int idMateria)
	{
		ArrayList<Integer> CorrelativasRegular = new ArrayList<Integer>();

		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select value from string_split((select m.correlativasRegulares from Materias m where m.idMateria = ?), '-')");
			stmt.setInt(1, idMateria);
			rs   = stmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					CorrelativasRegular.add(rs.getInt("value"));				
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
		
		return CorrelativasRegular;
	}
	
	public ArrayList<Integer> getCorrelativasAprobadas(int idMateria)
	{
		ArrayList<Integer> CorrelativasAprobadas = new ArrayList<Integer>();

		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select value from string_split((select m.correlativasAprobadas from Materias m where m.idMateria = ?), '-')");
			stmt.setInt(1, idMateria);
			rs   = stmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					CorrelativasAprobadas.add(rs.getInt("value"));				
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
		
		return CorrelativasAprobadas;
	}
	
	public void updateMateria(int idMateria,String nombre, String cursado, String año, String correlativasRegulares, String correlativasRendir, String correlativasAprobadas)
	{
		
		try {
			
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("UPDATE Materias set nombre = ?,cursado = ?, nivel = ?,correlativasRegulares = ?,correlativasRendir = ?,correlativasAprobadas =?  where idMateria = ?");
			stmt.setString(1, nombre);
			stmt.setString(2, cursado);
			stmt.setString(3, año);
			stmt.setString(4, correlativasRegulares);
			stmt.setString(5, correlativasRendir);
			stmt.setString(6, correlativasAprobadas);
			stmt.setInt(7, idMateria);
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

package Data;

import Entidades.*;
import Entidades.Alumno.Carreras;
import Entidades.Documento.TipoDocumento;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataDireccion {

	PreparedStatement stmt=null;
	ResultSet rs=null;
	
	public Direccion getOne(int id) 
	{
		Direccion D = new Direccion();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from Direcciones where idDireccion=?");
			stmt.setInt(1, id);
			rs   = stmt.executeQuery();
			
			
			if(rs != null) {
				while(rs.next())
				{
				D = new Direccion();
				D.setidDireccion(rs.getInt("idDireccion"));
				D.setCalle(rs.getString("calle"));
				D.setNumero(rs.getInt("numero"));
				D.setPiso(rs.getInt("piso"));
				D.setDept(rs.getString("dept"));
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
		
		return D;
	}
	
	public ArrayList<Direccion> getAll()
	{
		ArrayList<Direccion> Direcciones = new ArrayList<Direccion>();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from Direcciones");
			rs   = stmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					Direccion D = new Direccion();
					D.setidDireccion(rs.getInt("idDireccion"));
					D.setCalle(rs.getString("calle"));
					D.setNumero(rs.getInt("numero"));
					D.setPiso(rs.getInt("piso"));
					D.setDept(rs.getString("dept"));
					
					//Agregar a la lista
					Direcciones.add(D);
					
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
		
		return Direcciones;
	}
	
	public int addDireccion(String calle,int numero) 
	{
		//Crear nueva Direccion
		int id = 0;
		Direccion D = new Direccion();
		D.setCalle(calle);
		D.setNumero(numero);
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into Direcciones(calle,numero) values(?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, D.getCalle());
			stmt.setInt(2, D.getNumero());
			stmt.executeUpdate();
			
			//id Direccion
			ResultSet keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()) {
				id=keyResultSet.getInt(1);
				D.setidDireccion(id);
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
		
		return id;
		
	}
	
	public int addDireccion(String calle,int numero,int piso, String dept) 
	{
		//Crear nueva Direccion
		int id = 0;
		Direccion D = new Direccion();
		D.setCalle(calle);
		D.setNumero(numero);
		D.setPiso(piso);
		D.setDept(dept);
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into Direcciones(calle,numero,piso,dept) values(?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, D.getCalle());
			stmt.setInt(2, D.getNumero());
			stmt.setInt(3, D.getPiso());
			stmt.setString(4, D.getDept());
			stmt.executeUpdate();
			
			//id Direccion
			ResultSet keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()) {
				id=keyResultSet.getInt(1);
				D.setidDireccion(id);
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
		
		return id;
		
	}
	
	public void delete(int idDireccion)
	{
		
		try {
			
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("delete from Direcciones where idDireccion = ?");
			stmt.setInt(1, idDireccion);
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
	
	public void updateDireccion(int idDireccion,String calle,int numero) {
		try {
			
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("update Direcciones set calle = ?, numero = ? where idDireccion = ?");
			stmt.setString(1, calle);
			stmt.setInt(2, numero);
			stmt.setInt(3, idDireccion);
			stmt.executeUpdate();
					
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
	
	public void updateDireccion(int idDireccion,String calle,int piso,String dept,int numero) {
		try {
			
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("update Direcciones set calle = ?, numero = ?,piso = ?,dept = ? where idDireccion = ?");
			stmt.setString(1, calle);
			stmt.setInt(2, numero);
			stmt.setInt(3, piso);
			stmt.setString(4, dept);
			stmt.setInt(5, idDireccion);
			stmt.executeUpdate();
					
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

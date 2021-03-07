package Data;

import Data.*;
import Entidades.*;
import Entidades.Alumno.Carreras;
import Entidades.Documento.TipoDocumento;
import Entidades.Persona.EstadosPersona;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataAlumno {
	
	PreparedStatement stmt=null;
	ResultSet rs=null;
	
	public ArrayList<Alumno> getAll()
	{
		ArrayList<Alumno> alumnos= new ArrayList<>();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from Alumnos");
			rs   = stmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					//Alumno
					Alumno A = new Alumno();
					A.setApellido(rs.getString("apellido"));
					A.setNombre(rs.getString("Nombre"));
					A.setTelefono(rs.getString("telefono"));
					A.setEmail(rs.getString("email"));
					A.setContraseña(rs.getString("contraseña"));
					A.setLegajo(rs.getString("legajo"));
					A.setEstadoPersona(EstadosPersona.valueOf(rs.getString("estado")));
					A.setCarrera(Carreras.valueOf(rs.getString("carrera")));
					
					//Documento
					Documento Doc = new Documento();
					Doc.setNumero(rs.getString("documento"));
					Doc.setTipo(TipoDocumento.valueOf(rs.getString("tipoDocumento")));
					A.setDocumento(Doc);
					
					//Direcion
					Direccion D;
					DataDireccion DD = new DataDireccion();;
					D = DD.getOne(rs.getInt("idDireccion"));
					A.setDireccion(D);
					
					//Agregar a la lista
					alumnos.add(A);
					
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
		
		return alumnos;
	}
	
	public String addAlumno(String nombre, String apellido,String telefono,String email,String contraseña,Carreras carrera,TipoDocumento tipoDocumento,String documento,String calle,int numero) {
		
		Alumno A = new Alumno();
		int id = 0;
		try {
		
		//Nuevo alumno
		A.setNombre(nombre);
		A.setApellido(apellido);
		A.setTelefono(telefono);
		A.setEmail(email);
		A.setContraseña(contraseña);
		A.setEstadoPersona(EstadosPersona.Pendiente);
		A.setCarrera(carrera);
		
		//Documento
		Documento Doc = new Documento();
		Doc.setNumero(documento);
		Doc.setTipo(tipoDocumento);
		A.setDocumento(Doc);
		
		//Crear nueva Direccion en caso de que no exista
		stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from Direcciones where calle = ? and numero = ?");
		stmt.setString(1, calle);
		stmt.setInt(2, numero);
		rs   = stmt.executeQuery();
		Direccion D = new Direccion();
		
		if(!rs.isBeforeFirst())
		{
			DataDireccion DD = new DataDireccion();
			D = DD.getOne(DD.addDireccion(calle,numero));
		}
		else
		{
			while(rs.next())
			{
				D.setCalle(rs.getString("calle"));
				D.setNumero(rs.getInt("numero"));
				D.setPiso(rs.getInt("piso"));
				D.setDept(rs.getString("dept"));
				D.setidDireccion(rs.getInt("idDireccion"));
			}
		}
		
		//agregar direccion al alumno
		A.setDireccion(D);
		
		//crear nuevo alumno
		stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into Alumnos(nombre,apellido,email,telefono,contraseña,idDireccion,estado,tipoDocumento,documento,carrera) values(?,?,?,?,?,?,?,?,?,?)");
		stmt.setString(1, A.getNombre());
		stmt.setString(2, A.getApellido());
		stmt.setString(3, A.getEmail());
		stmt.setString(4, A.getTelefono());
		stmt.setString(5, A.getContraseña());
		stmt.setInt(6, A.getDireccion().getidDireccion());
		stmt.setString(7, A.getEstadoPersona());
		stmt.setString(8, A.getDocumento().getTipo().toString());
		stmt.setString(9, A.getDocumento().getNumero());
		stmt.setString(10, A.getCarrera().toString());
		
		stmt.executeUpdate();
		
		//legajo
		ResultSet keyResultSet=stmt.getGeneratedKeys();
		if(keyResultSet!=null && keyResultSet.next()) {
			id = keyResultSet.getInt(1);
			A.setLegajo(Integer.toString(id));
		}
		
		}
		catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return A.getLegajo();

	}
	
	
	public Alumno getOne(String legajo) {
		Alumno A = new Alumno();
		
		try {
			
			//buscar alumno
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from Alumnos where legajo = ?");
			stmt.setString(1, legajo);
			rs   = stmt.executeQuery();
			
			if(rs != null) {
				while(rs.next())
				{
					
				//datos generales
				A.setNombre(rs.getString("nombre"));
				A.setApellido(rs.getString("apellido"));
				A.setEmail(rs.getString("email"));
				A.setContraseña(rs.getString("contraseña"));
				A.setLegajo(rs.getString("legajo"));
				A.setTelefono(rs.getString("telefono"));
				A.setEstadoPersona(EstadosPersona.valueOf(rs.getString("estado")));
				A.setCarrera(Carreras.valueOf(rs.getString("carrera")));
				
				//Documento
				Documento Doc = new Documento();
				Doc.setNumero(rs.getString("documento"));
				Doc.setTipo(TipoDocumento.valueOf(rs.getString("tipoDocumento")));
				A.setDocumento(Doc);
				
				//direccion
				DataDireccion DD = new DataDireccion();
				Direccion D = new Direccion();
				D = DD.getOne(rs.getInt("idDireccion"));
				A.setDireccion(D);
				
				}
			}
			
			}
			catch (SQLException e) {
				e.printStackTrace();
				
			} finally {
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
	
	
	public Alumno getOne(TipoDocumento tipoDocumento, String documento) {
		Alumno A = new Alumno();
		
		try {
			
			//buscar alumno
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from Alumnos where tipoDocumento = ? and documento = ?");
			stmt.setString(1, tipoDocumento.toString());
			stmt.setString(2, documento);
			rs   = stmt.executeQuery();
			
			if(rs != null) {
				while(rs.next())
				{
					
				//datos generales
				A.setNombre(rs.getString("nombre"));
				A.setApellido(rs.getString("apellido"));
				A.setEmail(rs.getString("email"));
				A.setContraseña(rs.getString("contraseña"));
				A.setLegajo(rs.getString("legajo"));
				A.setTelefono(rs.getString("telefono"));
				A.setEstadoPersona(EstadosPersona.valueOf(rs.getString("estado")));
				A.setCarrera(Carreras.valueOf(rs.getString("carrera"))); 
				
				//Documento
				Documento Doc = new Documento();
				Doc.setNumero(rs.getString("documento"));
				Doc.setTipo(TipoDocumento.valueOf(rs.getString("tipoDocumento")));
				A.setDocumento(Doc);
				
				//direccion
				DataDireccion DD = new DataDireccion();
				Direccion D = new Direccion();
				D = DD.getOne(rs.getInt("idDireccion"));
				A.setDireccion(D);
				
				}
			}
			
			}
			catch (SQLException e) {
				e.printStackTrace();
				
			} finally {
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
	
	public void delete(String legajo)
	{
		try {
			
			/* baja fisica
			//borrar su direccion
			DataDireccion DD = new DataDireccion();
			DataAlumno DA = new DataAlumno();
			DD.delete(DA.getOne(legajo).getDireccion().getidDireccion());
			
			//borrar Alumno
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("delete from Alumnos where legajo = ?");
			stmt.setString(1, legajo);
			stmt.executeQuery();
			*/
			
			//baja logica
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("UPDATE Alumnos SET estado = 'Eliminado' where legajo =  ?");
			stmt.setString(1, legajo);
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
		
	public void setEstate(String legajo,EstadosPersona estate)
	{
		try {
			
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("UPDATE Alumnos SET estado = ? where legajo =  ?");
			stmt.setString(1, estate.toString());
			stmt.setString(2, legajo);
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
	
	public void updateAlumno(String legajo,String nombre, String apellido,String telefono,String email,Carreras carrera,TipoDocumento tipoDocumento,String documento) {
		try {
			
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("update Alumnos set nombre = ?, apellido = ?,telefono =? ,tipoDocumento = ?,documento = ?,email = ?,carrera= ? where Alumnos.legajo = ?");
			stmt.setString(1, nombre);
			stmt.setString(2, apellido);
			stmt.setString(3, telefono);
			stmt.setString(4, tipoDocumento.toString());
			stmt.setString(5, documento);
			stmt.setString(6, email);
			stmt.setString(7, carrera.toString());
			stmt.setString(8, legajo);
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

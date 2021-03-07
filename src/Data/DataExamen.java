package Data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.*;
import Entidades.Examen.modalidadExamen;
import Entidades.Examen.tipoExamen;

public class DataExamen {
	PreparedStatement stmt=null;
	ResultSet rs=null;
	
	public Examen getOne(int idExamen) 
	{
		Examen E = new Examen();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from Examenes where idExamen=?");
			stmt.setInt(1, idExamen);
			rs   = stmt.executeQuery();
			
			
			if(rs != null) {
				while(rs.next())
				{
				E.setIdExamen(rs.getInt("idExamen"));
				E.setIdComision(rs.getInt("idComision"));
				E.setLegajo(rs.getString("legajo"));
				E.setNota(rs.getFloat("nota"));
				E.setObservacion(rs.getString("observacion"));
				E.setFecha(rs.getDate("fecha"));
				E.setModalidad(modalidadExamen.valueOf(rs.getString("modalidad")));
				E.setTipo(tipoExamen.valueOf(rs.getString("tipo")));
				E.setIdMateria(rs.getInt("idMateria"));
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
		
		return E;
	}
	
	public Examen getOne(String legajo, int idComision) 
	{
		Examen E = new Examen();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from Examenes where legajo=? and idComision=?");
			stmt.setString(1, legajo);
			stmt.setInt(2, idComision);
			rs   = stmt.executeQuery();
			
			
			if(rs != null) {
				while(rs.next())
				{
				E.setIdExamen(rs.getInt("idExamen"));
				E.setIdComision(rs.getInt("idComision"));
				E.setLegajo(rs.getString("legajo"));
				E.setNota(rs.getFloat("nota"));
				E.setObservacion(rs.getString("observacion"));
				E.setFecha(rs.getDate("fecha"));
				E.setModalidad(modalidadExamen.valueOf(rs.getString("modalidad")));
				E.setTipo(tipoExamen.valueOf(rs.getString("tipo")));
				E.setIdMateria(rs.getInt("idMateria"));
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
		
		return E;
	}
	
	public ArrayList<Examen> getAll()
	{
		ArrayList<Examen> Examenes = new ArrayList<Examen>();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from Examenes");
			rs   = stmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					Examen E = new Examen();
					E.setIdExamen(rs.getInt("idExamen"));
					E.setIdComision(rs.getInt("idComision"));
					E.setLegajo(rs.getString("legajo"));
					E.setNota(rs.getFloat("nota"));
					E.setObservacion(rs.getString("observacion"));
					E.setFecha(rs.getDate("fecha"));
					E.setModalidad(modalidadExamen.valueOf(rs.getString("modalidad")));
					E.setTipo(tipoExamen.valueOf(rs.getString("tipo")));
					E.setIdMateria(rs.getInt("idMateria"));
					
					//Agregar a la lista
					Examenes.add(E);
					
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
		
		return Examenes;
	}
	
	public Examen addExamen(String legajo,int idComision,int idMateria,float nota,String observacion, tipoExamen tipo,modalidadExamen modalidad,Date fecha) 
	{
		//Crear nuevo examen
		Examen E = new Examen();
		E.setIdComision(idComision);
		E.setLegajo(legajo);
		E.setNota(nota);
		E.setObservacion(observacion);
		E.setFecha(fecha);
		E.setModalidad(modalidad);
		E.setTipo(tipo);
		E.setIdMateria(idMateria);
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into Examenes(legajo,idComision,idMateria,nota,observacion,tipo,modalidad,fecha) values(?,?,?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, Integer.parseInt(E.getLegajo()));
			stmt.setInt(2, E.getIdComision());
			stmt.setInt(3, E.getIdMateria());
			stmt.setFloat(4, E.getNota());
			stmt.setString(5, E.getObservacion());
			stmt.setString(6, E.getTipo().toString());
			stmt.setString(7, E.getModalidad().toString());
			stmt.setDate(8, E.getFecha());
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
		
		return E;
		
	}
	
	public void delete(int id)
	{
		
		try {
			
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("delete from Examenes where idExamen = ?");
			stmt.setInt(1, id);
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
	
	public boolean ExamenExist(String legajo,int idComision) 
	{
		boolean resp = false;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from Examenes where legajo=? and idComision=?");
			stmt.setString(1, legajo);
			stmt.setInt(2, idComision);
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
	
	public boolean ExamenExist(String legajo) 
	{
		boolean resp = false;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from Examenes where legajo=?");
			stmt.setString(1, legajo);
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
package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.*;
import Entidades.EstadoAcademico.estadosMateria;
import Entidades.Persona.EstadosPersona;

public class DataEstadoAcademico {
	PreparedStatement stmt=null;
	ResultSet rs=null;
	
	public EstadoAcademico getOne(String legajo,int idMateria) 
	{
		EstadoAcademico EA = new EstadoAcademico();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from EstadosAcademicos where legajo=? and idMateria=?");
			stmt.setString(1, legajo);
			stmt.setInt(2, idMateria);
			rs   = stmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
				EA.setLegajo(rs.getString("legajo"));
				EA.setIdMateria(rs.getInt("idMateria"));	
				EA.setAsistencia(rs.getFloat("asistencia"));
				EA.setNota(rs.getFloat("nota"));
				EA.setEstado(estadosMateria.valueOf(rs.getString("estado")));
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
		
		return EA;
	}
	
	public ArrayList<EstadoAcademico> getAllEstadosAlumno(String legajo) 
	{
		ArrayList<EstadoAcademico> EstadosAcademicos = new ArrayList<EstadoAcademico>();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from EstadosAcademicos EstadosAcademicos where legajo=?");
			stmt.setString(1, legajo);
			rs   = stmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					EstadoAcademico EA = new EstadoAcademico();
					EA.setIdMateria(rs.getInt("idMateria"));
					EA.setLegajo(rs.getString("legajo"));
					EA.setAsistencia(rs.getFloat("asistencia"));
					EA.setNota(rs.getFloat("nota"));
					EA.setEstado(estadosMateria.valueOf(rs.getString("estado")));
					
					//Agregar a la lista
					EstadosAcademicos.add(EA);
					
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
		
		return EstadosAcademicos;
	}
	
	public ArrayList<EstadoAcademico> getAll()
	{
		ArrayList<EstadoAcademico> EstadosAcademicos = new ArrayList<EstadoAcademico>();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from EstadosAcademicos");
			rs   = stmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					EstadoAcademico EA = new EstadoAcademico();
					EA.setIdMateria(rs.getInt("idMateria"));
					EA.setLegajo(rs.getString("legajo"));
					EA.setAsistencia(rs.getFloat("asistencia"));
					EA.setNota(rs.getFloat("nota"));
					EA.setEstado(estadosMateria.valueOf(rs.getString("estado")));
					
					//Agregar a la lista
					EstadosAcademicos.add(EA);
					
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
		
		return EstadosAcademicos;
	}
	
	public void addEstadoAcademico(String legajo,int idMateria, estadosMateria estado,float asistencia,float nota) 
	{
		EstadoAcademico EA = new EstadoAcademico(legajo,idMateria,estado,asistencia,nota);
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into EstadosAcademicos(legajo,idMateria,estado,asistencia,nota) values(?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, EA.getLegajo());
			stmt.setInt(2, EA.getIdMateria());
			stmt.setString(3, EA.getEstado().toString());
			stmt.setFloat(4, EA.getAsistencia());
			stmt.setFloat(5, EA.getNota());
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
	
	public void delete(String legajo,int idMateria)
	{
		
		try {
			
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("delete from EsatdosAcedemicos where legajo=? and idMateria = ?");
			stmt.setString(1, legajo);
			stmt.setInt(2, idMateria);
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
	
	public void setEstado(String legajo,int idMateria,estadosMateria estado) {
		
		try {
			
		stmt = FactoryConexion.getInstancia().getConn().prepareStatement("UPDATE EstadosAcademicos SET estado = ? where legajo =  ? and idMateria =?");
		stmt.setString(1, estado.toString());
		stmt.setString(2, legajo);
		stmt.setInt(3, idMateria);
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

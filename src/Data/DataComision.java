package Data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.Comision;
import Entidades.Comision.turnos;
import Entidades.EstadoAcademico.estadosMateria;
import Entidades.Persona.EstadosPersona;

public class DataComision {
	PreparedStatement stmt=null;
	ResultSet rs=null;
	
	public Comision getOne(int idComision, int idMateria) 
	{
		Comision C = new Comision();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from Comisiones where idComision=? and idMateria=?");
			stmt.setInt(1, idComision);
			stmt.setInt(2, idMateria);
			rs   = stmt.executeQuery();
			
			
			if(rs != null) {
				while(rs.next())
				{
				C.setIdMateria(rs.getInt("idMateria"));
				C.setIdComision(rs.getInt("idComision"));
				C.setCantAlumnos(rs.getInt("cantAlumnos"));	
				C.setCantAlumnosMax(rs.getInt("cantAlumnosMax"));
				C.setIdDocente(rs.getInt("idDocente"));
				C.setTurno(turnos.valueOf(rs.getString("turno")));
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
		
		return C;
	}
	
	public ArrayList<Comision> getAll()
	{
		ArrayList<Comision> Comisiones = new ArrayList<Comision>();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from Comisiones");
			rs   = stmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					Comision C = new Comision();
					C.setIdMateria(rs.getInt("idMateria"));
					C.setIdComision(rs.getInt("idComision"));
					C.setCantAlumnos(rs.getInt("cantAlumnos"));	
					C.setCantAlumnosMax(rs.getInt("cantAlumnosMax"));
					C.setIdDocente(rs.getInt("idDocente"));
					C.setTurno(turnos.valueOf(rs.getString("turno")));
					
					//Agregar a la lista
					Comisiones.add(C);
					
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
		
		return Comisiones;
	}
	
	public Comision addComision(int idComision, int idMateria,int idDocente, int cantAlumnos, int cantAlumnosMax,turnos turno) 
	{
		Comision C = new Comision();
		C.setCantAlumnos(cantAlumnos);
		C.setCantAlumnosMax(cantAlumnosMax);
		C.setIdComision(idComision);
		C.setTurno(turno);
		C.setIdMateria(idMateria);
		C.setIdDocente(idDocente);
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into Comisiones(idComision,idMateria, idDocente,cantAlumnos,cantAlumnosMax,turno) values(?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, C.getIdComision());
			stmt.setInt(2, C.getIdMateria());
			stmt.setInt(3, C.getIdDocente());
			stmt.setInt(4, C.getCantAlumnos());
			stmt.setInt(5, C.getCantAlumnosMax());
			stmt.setString(6, C.getTurno().toString());
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
		
		return C;
		
	}
	
	public void delete(int idComision, int idMateria)
	{
		
		try {
			
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("delete from Comisiones where idComision = ? and idMateria=?");
			stmt.setInt(1, idComision);
			stmt.setInt(2, idMateria);
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
	
	public void inscripcion(int idComision, int idMateria) {
		try {		
			
		//Sumar alumno
		stmt = FactoryConexion.getInstancia().getConn().prepareStatement("UPDATE Comisiones SET cantAlumnos +=1 where idComision=? and idMateria=?");
		stmt.setInt(1, idComision);
		stmt.setInt(2, idMateria);
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
	
	
	public boolean cantAlumnosOk(int idComision, int idMateria) {
		boolean resp = false;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("Select cantAlumnos, cantAlumnosMax from Comisiones where idComision=? and idMateria=?");
			stmt.setInt(1, idComision);
			stmt.setInt(2, idMateria);
			rs = stmt.executeQuery();
			
			if(rs != null)
			{
				while(rs.next())
				{
					if(rs.getInt("cantAlumnos")<rs.getInt("cantAlumnosMax"))
					{
						resp = true;
					}
					else
					{
						resp = false;
					}
					
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
		
		return resp;
	}
	
	public ArrayList<Integer> getAllDocentePorMateria(int idMateria)
	{
		ArrayList<Integer> DocentesIds = new ArrayList<Integer>();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select DISTINCT idDocente from Comisiones where idMateria=?");
			stmt.setInt(1, idMateria);
			rs   = stmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					DocentesIds.add(rs.getInt("idDocente"));
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
		
		return DocentesIds;
	}
	
	public void updateComision(int idComision, int idMateria,int idDocente,int cantAlumnosMax,turnos turno) {
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("UPDATE Comisiones SET  idDocente = ?,cantAlumnosMax = ?,turno = ? where idMateria = ? and idComision = ?");
			stmt.setInt(1, idDocente);
			stmt.setInt(2, cantAlumnosMax);
			stmt.setString(3, turno.toString());
			stmt.setInt(4, idMateria);
			stmt.setInt(5, idComision);
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

package Data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.*;
import Entidades.Examen.modalidadExamen;
import Entidades.Examen.tipoExamen;

public class DataMesa {
	PreparedStatement stmt=null;
	ResultSet rs=null;
	
	public Mesa getOne(int idMesa) 
	{
		Mesa M = new Mesa();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from Mesas where idMesa=?");
			stmt.setInt(1, idMesa);
			rs   = stmt.executeQuery();
			
			
			if(rs != null) {
				while(rs.next())
				{
				M.setIdMateria(rs.getInt("idMateria"));
				M.setHorario(rs.getInt("horario"));
				M.setIdMesa(rs.getInt("idMesa"));
				M.setSalon(rs.getInt("salon"));
				M.setFecha(rs.getDate("fecha"));
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
	
	
	public ArrayList<Mesa> getAll()
	{
		ArrayList<Mesa> Mesas = new ArrayList<Mesa>();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from Mesas");
			rs   = stmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					Mesa M = new Mesa();
					M.setIdMateria(rs.getInt("idMateria"));
					M.setHorario(rs.getInt("horario"));
					M.setIdMesa(rs.getInt("idMesa"));
					M.setSalon(rs.getInt("salon"));
					M.setFecha(rs.getDate("fecha"));
					
					//Agregar a la lista
					Mesas.add(M);
					
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
		
		return Mesas;
	}
	
	public Mesa addMesa(int idMateria,int horario,int salon,Date fecha) 
	{
		//Crear nuevo examen
		Mesa M = new Mesa();
		M.setIdMateria(idMateria);
		M.setHorario(horario);
		M.setSalon(salon);
		M.setFecha(fecha);
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into Mesas(idMateria,horario,salon,fecha) values(?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, M.getIdMateria());
			stmt.setInt(2, M.getHorario());
			stmt.setInt(3, M.getSalon());
			stmt.setDate(4, M.getFecha());

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
		
		return M;
		
	}
	
	public void delete(int id)
	{
		
		try {
			
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("delete from Mesas where idMesa = ?");
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
	
	public boolean MateriaExist(int idMateria) 
	{
		boolean resp = false;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from Mesas where idMateria=?");
			stmt.setInt(1, idMateria);

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
	
	public Mesa updateMesa(int idMesa,int idMateria,int horario,int salon,Date fecha) 
	{
		//Crear nuevo examen
		Mesa M = new Mesa();
		M.setIdMateria(idMateria);
		M.setHorario(horario);
		M.setSalon(salon);
		M.setFecha(fecha);
		M.setIdMesa(idMesa);
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("Update Mesas set idMateria = ?,horario = ?, salon = ?, fecha = ? where idMesa = ?");
			stmt.setInt(1, M.getIdMateria());
			stmt.setInt(2, M.getHorario());
			stmt.setInt(3, M.getSalon());
			stmt.setDate(4, M.getFecha());
			stmt.setInt(5, M.getIdMesa());

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
		
		return M;
		
	}
	
}
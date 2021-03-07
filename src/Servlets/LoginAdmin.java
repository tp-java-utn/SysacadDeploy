package Servlets;


import Entidades.*;
import Entidades.Persona.EstadosPersona;
import Logic.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.sun.corba.se.pept.transport.Connection;

import Data.DataAlumno;
import Data.DataEstadoAcademico;
import Data.FactoryConexion;

import javax.servlet.annotation.WebServlet;
/**
 * Servlet implementation class MiServlet
 */
@WebServlet("/LoginAdmin/*")
public class LoginAdmin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public LoginAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
			
		doPost(req, resp);
			

	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ErrorManager E = new ErrorManager();
		int minpass=4;
		int maxpass=20;
		int minuser=4;
		int maxuser=10;
		String user = req.getParameter("userAdmin");
		String pass = req.getParameter("password");


		//validar formatos
		Validator v = new Validator();
		if(v.stringOk(user, minuser, maxuser) && v.stringOk(pass, minpass, maxpass)) {
			Usuario u = new Usuario();
			Administrador A = u.ValidateAdmin(user, pass);
			
			//existe el alumno
			if (A.getLegajo() == null) {
				E.setTitlle("Usuario incorrecto");
				E.setDescp("El usuario ingresado no existe.");
				E.setPage("LoginAdmin.jsp");
				req.getSession().setAttribute("Error", E);
				req.getRequestDispatcher("/ErrorPage.jsp").forward(req, resp);
			}
			else 
			{
				if(EstadosPersona.valueOf(A.getEstadoPersona()).equals(EstadosPersona.Activo))
				{
					req.getSession().setAttribute("usuario", A);
					req.getSession().setMaxInactiveInterval(10*60);
					resp.setHeader("Refresh", 10*60 + "; ErrorPage.jsp");
					System.out.println(A.toString());
		        	req.getRequestDispatcher("WEB-INF/ADM/MainPageAdmAlumno.jsp").forward(req, resp);
				}
				else
				{
					E.setTitlle("Usuario invalido");
					E.setDescp("El usuario no esta dado de alta.");
					E.setPage("LoginAdmin.jsp");
					req.getSession().setAttribute("Error", E);
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, resp);
				}
				  
			}
		}
		else if(!v.stringOk(user, minuser, maxuser) || !v.stringOk(pass, minpass, maxpass))
		{
			E.setTitlle("Formato incorrecto");
			E.setDescp("El legajo/contraseña no cumple con el formato de datos.");
			E.setPage("LoginAdmin.jsp");
			req.getSession().setAttribute("Error", E);
			req.getRequestDispatcher("/ErrorPage.jsp").forward(req, resp);
		}
		else
		{
			req.getRequestDispatcher("/LoginAdmin.jsp").forward(req, resp);
		}

	}
	

}

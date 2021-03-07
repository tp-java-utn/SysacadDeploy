package Servlets;


import Entidades.*;
import Entidades.Alumno.Carreras;
import Entidades.Documento.TipoDocumento;
import Entidades.Persona.EstadosPersona;
import Logic.EnumHelper;
import Logic.ErrorManager;
import Logic.Formatter;
import Logic.Validator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.pept.transport.Connection;

import Data.DataAlumno;
import Data.FactoryConexion;

import javax.servlet.annotation.WebServlet;
/**
 * Servlet implementation class MiServlet
 */
@WebServlet("/NewAlumno")
public class NewAlumno extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public NewAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void response(HttpServletResponse resp, String msg)
			throws IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<t1>" + msg + "</t1>");
		out.println("</body>");
		out.println("</html>");
	}
    

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException {
		ErrorManager E = new ErrorManager();
		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		String contraseña = req.getParameter("contraseña");
		String contraseña02 = req.getParameter("contraseña02");
		String email = req.getParameter("email");
		String telefono = req.getParameter("telefono");
		String documento = req.getParameter("documento");
		String direccion = req.getParameter("direccion");
		System.out.println(req.getParameter("carrera"));
		String departamento = req.getParameter("departamento");
		int piso = 0;
		int numero = 0;
		
		//enums
		EnumHelper EH = new EnumHelper();
		Carreras carrera = EH.convertToCarreras(req.getParameter("Carrera"));
		TipoDocumento tipoDocumento = EH.convertToTipoDocumento(req.getParameter("tipoDocumento"));
		
		//validar que no esten vacio, para poder hacer la conversion
		if(req.getParameter("numero") != "")
		{
			numero = Integer.parseInt(req.getParameter("numero"));
		}
		
		if(req.getParameter("piso") != "")
		{
			piso = Integer.parseInt(req.getParameter("piso"));	
		}
		
		
		//Aplico formato estandar
		Formatter F = new Formatter();
		nombre = F.upFirstWord(nombre);
		apellido = F.upFirstWord(apellido);
		email = F.downAllWords(email);
		direccion = F.upAllWords(direccion);
		departamento = F.upFirstWord(departamento);
		
	
		//validar datos
		Validator V = new Validator();
		if(contraseña.equals(contraseña02)) //Contraseñas iguales?
		{
			if (
					//Validar minimo, maximo y formato
					V.stringOk(nombre, 4, 20) && 
					V.stringOk(apellido, 4, 20) && 
					V.emailOk(email, 10, 30) && 
					V.numberOk(Integer.parseInt(telefono), 7, 20) &&
					V.stringOk(documento, 4, 20) && 
					V.stringOk(direccion, 4, 20) &&
					V.numberOk(numero, 1, 5) &&
					V.stringOk(contraseña, 4, 20) &&
					V.stringOk(contraseña02, 4, 20)
			   ) 
			{
				//validar que no este registrado
				DataAlumno DA = new DataAlumno();
				if(DA.getOne(tipoDocumento,documento).getDocumento()==null)
				{
					DA.addAlumno(nombre, apellido, telefono, email, contraseña,carrera,tipoDocumento,documento, direccion, numero);
					Alumno A = DA.getOne(tipoDocumento,documento);
					System.out.println(A.toString());
					A.startEstadoAcademico();;
					req.getSession().setAttribute("nombreRegistrado", nombre);
					req.getRequestDispatcher("/PostNewAlumnos.jsp").forward(req, resp);
				}
				else
				{
					E.setTitlle("Usuario ya registrado");
					E.setDescp("Este documento ya ha sido utilizado.");
					E.setPage("NewAlumnos.jsp");
					req.getSession().setAttribute("Error", E);
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, resp);
				}
			} 
			else 
			{
				E.setTitlle("Formato de datos");
				E.setDescp("Los campos han sido llenados con datos incompatibles.");
				E.setPage("NewAlumnos.jsp");
				req.getSession().setAttribute("Error", E);
				req.getRequestDispatcher("/ErrorPage.jsp").forward(req, resp);
			}
		}
		else 
		{
			E.setTitlle("Contraseñas Distintas");
			E.setDescp("Las contraseñas no coinciden.");
			E.setPage("NewAlumnos.jsp");
			req.getSession().setAttribute("Error", E);
			req.getRequestDispatcher("/ErrorPage.jsp").forward(req, resp);
		}

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
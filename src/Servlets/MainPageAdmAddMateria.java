package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.DataAlumno;
import Data.DataComision;
import Data.DataDireccion;
import Data.DataDocente;
import Data.DataMateria;
import Entidades.Alumno;
import Entidades.Alumno.Carreras;
import Entidades.Comision.turnos;
import Entidades.Documento.TipoDocumento;
import Entidades.Persona.EstadosPersona;
import Logic.EnumHelper;
import Logic.ErrorManager;
import Logic.Formatter;
import Logic.Validator;

/**
 * Servlet implementation class MainPageAdm
 */
@WebServlet("/MainPageAdmAddMateria")
public class MainPageAdmAddMateria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageAdmAddMateria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ErrorManager E = new ErrorManager();
		
		DataMateria DM = new DataMateria();

		String nombre= request.getParameter("Nombre");
		String cursado= request.getParameter("Cursado");
		String año= request.getParameter("nivel");
		String descripcion= request.getParameter("Descripcion");
		String correlativasRegulares= request.getParameter("CorrelativasRegulares");
		String correlativasAprobadas= request.getParameter("CorrelativasAprobadas");
		String correlativasRendir= request.getParameter("CorrelativasRendir");
		
		switch (año){
			case "1":
				año = "1° año";
			break;
			
			case "2":
				año = "2° año";
			break;
			
			case "3":
				año = "3° año";
			break;
			
			case "4":
				año = "4° año";
			break;
			
			case "5":
				año = "5° año";
			break;

		}
		
		if(cursado.equals("cuatrimestre1"))
			{cursado = "1° cuatrimestre";}
		else if(cursado.equals("cuatrimestre1"))
			{cursado = "2° cuatrimestre";}

		if(correlativasRegulares == "")
			{correlativasRegulares = null;}
		if(correlativasAprobadas == "")
			{correlativasAprobadas = null;}
		if(correlativasRendir == "")
			{correlativasRendir = null;}
		
		if(descripcion == "")
		{descripcion = null;}
		
		if(nombre != null && cursado != null && año != null)
		{
			Validator V = new Validator();
			//validar datos
			if (
					//Validar minimo, maximo y formato
					V.stringOk(nombre, 4, 40)				
			   )
			{	
				Formatter F = new Formatter();
				nombre = F.upAllWords(nombre);
				
				if(descripcion != null)
					{
					DM.addMateria(nombre, descripcion, cursado, año, correlativasRegulares, correlativasRendir, correlativasAprobadas);
					}
				else 
					{
					DM.addMateria(nombre, cursado, año, correlativasRegulares, correlativasRendir, correlativasAprobadas);
					}
				
				request.getRequestDispatcher("WEB-INF/ADM/MainPageAdmMaterias.jsp").forward(request, response);
			}
			else
			{
				E.setTitlle("Carga invalida");
				E.setDescp("Los campos han sido llenados con datos incompatibles.");
				request.getSession().setAttribute("Error", E);
				request.getRequestDispatcher("/ErrorPageNotReturn.jsp").forward(request, response);
				System.out.println(V.stringOk(nombre, 4, 20));
			}
			
		}
		else
		{
			E.setTitlle("Carga invalida");
			E.setDescp("Faltan cargar campos.");
			request.getSession().setAttribute("Error", E);
			request.getRequestDispatcher("/ErrorPageNotReturn.jsp").forward(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

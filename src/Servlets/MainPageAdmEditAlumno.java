package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.DataAlumno;
import Data.DataDireccion;
import Entidades.Alumno;
import Entidades.Alumno.Carreras;
import Entidades.Documento.TipoDocumento;
import Entidades.Persona.EstadosPersona;
import Logic.EnumHelper;
import Logic.ErrorManager;
import Logic.Formatter;
import Logic.Validator;

/**
 * Servlet implementation class MainPageAdm
 */
@WebServlet("/MainPageAdmEditAlumno")
public class MainPageAdmEditAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageAdmEditAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ErrorManager E = new ErrorManager();
		
		DataAlumno DA = new DataAlumno();
		Alumno A = (Alumno)request.getSession(false).getAttribute("Alumno");
		String legajo = A.getLegajo();
		int idDireccion = A.getDireccion().getidDireccion();
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String documento = request.getParameter("documento");
		
		String calle = request.getParameter("direccion");
		int numero = Integer.valueOf(request.getParameter("numero"));
		int piso = Integer.valueOf(request.getParameter("piso"));
		String dept = request.getParameter("departamento");;
		
		Carreras carrera = Carreras.valueOf(request.getParameter("Carrera"));
		TipoDocumento tipoDocumento = TipoDocumento.valueOf(request.getParameter("tipoDocumento"));
		
		
		if(nombre != null && apellido != null && email != null && tipoDocumento != null && documento != null && telefono != null && carrera != null && calle != null && numero != 0)
		{
			//formato
			Formatter F = new Formatter();
			nombre = F.upFirstWord(nombre);
			apellido = F.upFirstWord(apellido);
			email = F.downAllWords(email);
			dept = F.upAllWords(dept);
			calle = F.upAllWords(calle);
			
			//validar datos
			Validator V = new Validator();
			if (
					//Validar minimo, maximo y formato
					V.stringOk(nombre, 4, 20) && 
					V.stringOk(apellido, 4, 20) && 
					V.emailOk(email, 10, 30) && 
					V.numberOk(Integer.parseInt(telefono), 7, 20) &&
					V.stringOk(documento, 4, 20) &&
					V.numberOk(numero, 1, 5) &&
					V.stringOk(calle, 4, 20)
			   )
			{
				DataDireccion DD = new DataDireccion();
				if(piso != 0 && dept != null)
				{
					DD.updateDireccion(idDireccion, calle, piso, dept, numero);
				}
				else
				{
					DD.updateDireccion(idDireccion, calle, numero);
				}
				
				DA.updateAlumno(legajo, nombre, apellido, telefono, email, carrera, tipoDocumento, documento);
				request.getRequestDispatcher("WEB-INF/ADM/MainPageAdmAlumno.jsp").forward(request, response);
			}
			else
			{
				E.setTitlle("Edicion invalida");
				E.setDescp("Los campos han sido llenados con datos incompatibles.");
				request.getSession().setAttribute("Error", E);
				request.getRequestDispatcher("/ErrorPageNotReturn.jsp").forward(request, response);
			}
			
		}
		else
		{
			E.setTitlle("Edicion invalida");
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

package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.DataAlumno;
import Data.DataDireccion;
import Data.DataDocente;
import Entidades.Alumno;
import Entidades.Alumno.Carreras;
import Entidades.Docente;
import Entidades.Documento.TipoDocumento;
import Entidades.Persona.EstadosPersona;
import Logic.EnumHelper;
import Logic.ErrorManager;
import Logic.Formatter;
import Logic.Validator;

/**
 * Servlet implementation class MainPageAdm
 */
@WebServlet("/MainPageAdmEditDocente")
public class MainPageAdmEditDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageAdmEditDocente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ErrorManager E = new ErrorManager();
		
		DataDocente DD = new DataDocente();
		
		Docente D = (Docente)request.getSession(false).getAttribute("Docente");
		int idDocente = D.getIdDocente();
		int idDireccion = D.getDireccion().getidDireccion();
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		
		String calle = request.getParameter("direccion");
		int numero = Integer.valueOf(request.getParameter("numero"));
		int piso = Integer.valueOf(request.getParameter("piso"));
		String dept = request.getParameter("departamento");;

		
		if(nombre != null && apellido != null && email != null  && telefono != null)
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
					V.numberOk(Integer.parseInt(telefono), 7, 20)


			   )
			{		
				DataDireccion DDir = new DataDireccion();
				if(idDireccion != 0)
				{
					if(piso != 0 && dept != null)
					{
						DDir.updateDireccion(idDireccion, calle, piso, dept, numero);
					}
					else
					{
						DDir.updateDireccion(idDireccion, calle, numero);
					}
				}
				else
				{
					if(piso != 0 && dept != null)
					{
						idDireccion = DDir.addDireccion(calle, numero, piso, dept);
					}
					else
					{
						idDireccion = DDir.addDireccion(calle, numero);
					}				
				}
				
				DD.updateDocente(idDocente, nombre, apellido, email, telefono,idDireccion);
				request.getRequestDispatcher("WEB-INF/ADM/MainPageAdmDocentes.jsp").forward(request, response);
			}
			else
			{
				E.setTitlle("Carga invalida");
				E.setDescp("Los campos han sido llenados con datos incompatibles.");
				request.getSession().setAttribute("Error", E);
				request.getRequestDispatcher("/ErrorPageNotReturn.jsp").forward(request, response);
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

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
@WebServlet("/MainPageAdmAddComision")
public class MainPageAdmAddComision extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageAdmAddComision() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ErrorManager E = new ErrorManager();
		
		DataComision DC = new DataComision();

		int idComision = Integer.valueOf(request.getParameter("Numero"));
		int alumMax = Integer.valueOf(request.getParameter("alumMax"));
		int idDocente = Integer.valueOf(request.getParameter("Docente"));
		int idMateria = Integer.valueOf(request.getParameter("Materia"));
		String turno = request.getParameter("Turno");
		
		if(turno.equals("Manana"))
		{turno = "Mañana";}


		
		if(idComision != 0 && idMateria != 0 && idDocente != 0 && alumMax != 0 && turno != null )
		{
		
			//validar datos
			Validator V = new Validator();
			if (
					//Validar minimo, maximo y formato

					V.numberOk(idComision, 1, 5) &&
					V.numberOk(idMateria, 1, 5) &&
					V.numberOk(idDocente, 1, 5) &&
					V.numberOk(alumMax, 1, 5) &&
					V.stringOk(turno, 4, 20)
			   )
			{				
							
				DC.addComision(idComision, idMateria, idDocente, 0, alumMax, turnos.valueOf(turno));
				request.getRequestDispatcher("WEB-INF/ADM/MainPageAdmComisiones.jsp").forward(request, response);
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

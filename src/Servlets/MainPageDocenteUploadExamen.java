package Servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.DataAlumno;
import Data.DataComision;
import Data.DataExamen;
import Data.DataMateria;
import Entidades.Alumno;
import Entidades.Comision;
import Entidades.Examen.modalidadExamen;
import Entidades.Examen.tipoExamen;
import Entidades.Materia;
import Logic.ErrorManager;
import Logic.MailController;
import Logic.Validator;

/**
 * Servlet implementation class MainPageAdm
 */
@WebServlet("/MainPageDocenteUploadExamen")
public class MainPageDocenteUploadExamen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageDocenteUploadExamen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ErrorManager E = new ErrorManager();
		DataExamen DE = new DataExamen();
		long now = System.currentTimeMillis();
    	Date today = new Date(now);
		
    	//ids
    	Alumno A = (Alumno)request.getSession(false).getAttribute("Alumno");
    	Comision C = (Comision)request.getSession(false).getAttribute("Comision");
    	
    	//Materia
    	DataMateria DM = new DataMateria();
    	Materia M = DM.getOne(C.getIdMateria());
    	
    	//Inputs
		int nota = Integer.valueOf(request.getParameter("Nota"));
		String tipo = request.getParameter("Tipo");
		String modalidad = request.getParameter("Modalidad");
		String observacion = request.getParameter("observacion");

		if(nota != 0 && tipo != "" && modalidad != "")
		{
			Validator V = new Validator();
			//validar datos
			if (
					//Validar minimo, maximo y formato
					V.numberOk(nota, 1, 2)				
			   )
			{	
				DE.addExamen(A.getLegajo(), C.getIdComision(), C.getIdMateria(), nota, observacion, tipoExamen.valueOf(tipo),modalidadExamen.valueOf(modalidad) , today);
				
				//mandar mail
				MailController MC = new MailController();
				MC.enviarConGMail(A.getEmail(), "Nota del Examen "+M.getNombre(),
								  A.getNombre()+", se ha subido la nota del examen de "+M.getNombre()
								  			   +", la misma la podras ver en el Sysacad."
								  			   +"\n \n No responder.");
				
				request.getRequestDispatcher("WEB-INF/Docente/MainPageDocenteComision.jsp").forward(request, response);
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

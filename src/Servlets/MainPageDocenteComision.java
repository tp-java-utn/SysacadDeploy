package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.DataAlumno;
import Data.DataComision;
import Data.DataEstadoAcademico;
import Entidades.Alumno;
import Entidades.Comision;
import Entidades.EstadoAcademico.estadosMateria;

/**
 * Servlet implementation class MainPageAdm
 */
@WebServlet("/MainPageDocenteComision")
public class MainPageDocenteComision extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageDocenteComision() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("Examen"))
		{
			int idComision = Integer.valueOf(request.getParameter("idComision"));
			int idMateria = Integer.valueOf(request.getParameter("idMateria"));
			String legajo = request.getParameter("legajo");
			
			DataAlumno DA = new DataAlumno();
			DataComision DC = new DataComision();
			
			Alumno A = DA.getOne(legajo);
			Comision C= DC.getOne(idComision, idMateria);
			
			request.getSession().setAttribute("Comision",C);
			request.getSession().setAttribute("Alumno",A);
			request.getRequestDispatcher("WEB-INF/Docente/MainPageDocenteUploadExamen.jsp").forward(request, response);
		}else if(action.equalsIgnoreCase("Estado"))
		{
			String estadoAcademico = request.getParameter("estate");
			String legajo = request.getParameter("legajo");
			int idMateria = Integer.valueOf(request.getParameter("idMateria"));

			DataEstadoAcademico DEA = new DataEstadoAcademico();
			DEA.setEstado(legajo, idMateria, estadosMateria.valueOf(estadoAcademico));
			request.getRequestDispatcher("WEB-INF/Docente/MainPageDocenteComision.jsp").forward(request, response);
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

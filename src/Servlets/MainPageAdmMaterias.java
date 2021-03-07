package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.DataAlumno;
import Data.DataDocente;
import Data.DataMateria;
import Entidades.Docente;
import Entidades.Materia;
import Entidades.Persona.EstadosPersona;

/**
 * Servlet implementation class MainPageAdm
 */
@WebServlet("/MainPageAdmMaterias")
public class MainPageAdmMaterias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageAdmMaterias() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("Eliminar"))
		{
			DataMateria DM = new DataMateria();
			int idMateria = Integer.valueOf(request.getParameter("idMateria"));
			DM.delete(idMateria);
			request.getRequestDispatcher("WEB-INF/ADM/MainPageAdmMaterias.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("Editar"))
		{
			DataMateria DM = new DataMateria();
			int idMateria = Integer.valueOf(request.getParameter("idMateria"));
			Materia M = DM.getOne(idMateria);
			request.getSession().setAttribute("Materia",M);
			request.getRequestDispatcher("WEB-INF/ADM/MainPageAdmMateriasEdit.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("Add"))
		{
			
			request.getRequestDispatcher("WEB-INF/ADM/MainPageAdmMateriasAdd.jsp").forward(request, response);
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

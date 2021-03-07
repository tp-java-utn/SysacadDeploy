package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.DataAlumno;
import Data.DataMateria;
import Entidades.Materia;
import Entidades.Persona.EstadosPersona;

/**
 * Servlet implementation class IncribirseMateria
 */
@WebServlet("/InscripcionMateria")
public class InscripcionMateria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscripcionMateria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//resp.getWriter().append("Served at: ").append(req.getContextPath());

		String action = req.getParameter("action");
		
		if(action.equalsIgnoreCase("volver"))
		{
			req.getRequestDispatcher("WEB-INF/MainPage.jsp").forward(req, resp);
		}
		else if(action.equalsIgnoreCase("seleccion"))
		{
			DataMateria DM = new DataMateria();
			int idMateria = Integer.parseInt(req.getParameter("id"));
			Materia M = DM.getOne(idMateria);
			req.getSession().setAttribute("Materia",M);
			req.getRequestDispatcher("WEB-INF/InscripcionComision.jsp").forward(req, resp);
		}



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


	}

}

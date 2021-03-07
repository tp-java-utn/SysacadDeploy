package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.*;
import Entidades.*;

/**
 * Servlet implementation class IncribirseMateria
 */
@WebServlet("/InscripcionComision/*")
public class InscripcionComision extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscripcionComision() {
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
			req.getRequestDispatcher("WEB-INF/ListaMaterias.jsp").forward(req, resp);
		}
		else if(action.equalsIgnoreCase("seleccion"))
		{
			//pasar datos de la comision/materia
			DataMateria DM = new DataMateria();
			DataComision DC = new DataComision();
			int idMateria = Integer.parseInt(req.getParameter("idMateria"));
			Materia M = DM.getOne(idMateria);
			int idComision = Integer.parseInt(req.getParameter("idComision"));
			Comision C = DC.getOne(idComision, idMateria);
			
			req.getSession().setAttribute("Materia",M);
			req.getSession().setAttribute("Comision",C);
			
			//realizar inscripcion
			String legajo = req.getParameter("legajo");
			DataAlumno DA = new DataAlumno();
			Alumno A = DA.getOne(legajo);
			A.inscripcionComision(idComision, idMateria);
			
			//cargar pag
			req.getRequestDispatcher("WEB-INF/PostInscripcionComision.jsp").forward(req, resp);
		}
		
		


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		switch (req.getPathInfo()) {
//		case "/new":
//			req.setAttribute("action", "new");
//			req.getRequestDispatcher("WEB-INF/InscripcionComision.jsp").forward(req, resp);
//		break;
//		
//		default:
//		}
			req.getRequestDispatcher("WEB-INF/InscripcionComision.jsp").forward(req, resp);

	}

}

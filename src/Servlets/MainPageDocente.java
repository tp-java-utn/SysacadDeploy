package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.DataAlumno;
import Data.DataComision;
import Entidades.Comision;

/**
 * Servlet implementation class MainPageAdm
 */
@WebServlet("/MainPageDocente")
public class MainPageDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageDocente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("info"))
		{
			int idComision = Integer.valueOf(request.getParameter("idComision"));
			int idMateria = Integer.valueOf(request.getParameter("idMateria"));
			DataComision DC = new DataComision();
			Comision C= DC.getOne(idComision, idMateria);
			request.getSession().setAttribute("Comision",C);
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

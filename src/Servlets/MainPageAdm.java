package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.DataAlumno;

/**
 * Servlet implementation class MainPageAdm
 */
@WebServlet("/MainPageAdm")
public class MainPageAdm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageAdm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("Alumnos"))
		{
			request.getRequestDispatcher("WEB-INF/ADM/MainPageAdmAlumno.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("Docentes"))
		{
			request.getRequestDispatcher("WEB-INF/ADM/MainPageAdmDocentes.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("Eliminados"))
		{
			request.getRequestDispatcher("WEB-INF/ADM/MainPageAdmEliminados.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("Materias"))
		{
			request.getRequestDispatcher("WEB-INF/ADM/MainPageAdmMaterias.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("Comisiones"))
		{
			request.getRequestDispatcher("WEB-INF/ADM/MainPageAdmComisiones.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("Mesas"))
		{
			request.getRequestDispatcher("WEB-INF/ADM/MainPageAdmMesas.jsp").forward(request, response);
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

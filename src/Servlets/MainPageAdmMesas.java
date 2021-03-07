package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.DataAlumno;
import Data.DataDocente;
import Data.DataMesa;
import Entidades.Docente;
import Entidades.Materia;
import Entidades.Mesa;
import Entidades.Persona.EstadosPersona;

/**
 * Servlet implementation class MainPageAdm
 */
@WebServlet("/MainPageAdmMesas")
public class MainPageAdmMesas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageAdmMesas() {
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
			DataMesa DM = new DataMesa();
			int idMesa = Integer.valueOf(request.getParameter("idMesa"));
			DM.delete(idMesa);
			request.getRequestDispatcher("WEB-INF/ADM/MainPageAdmMesas.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("Editar"))
		{
			DataMesa DM = new DataMesa();
			int idMesa = Integer.valueOf(request.getParameter("idMesa"));
			Mesa M = DM.getOne(idMesa);
			request.getSession().setAttribute("Mesa",M);
			request.getRequestDispatcher("WEB-INF/ADM/MainPageAdmMesasEdit.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("Add"))
		{
			request.getRequestDispatcher("WEB-INF/ADM/MainPageAdmMesasAdd.jsp").forward(request, response);
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

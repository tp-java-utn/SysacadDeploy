package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.DataAlumno;
import Data.DataComision;
import Data.DataDocente;
import Entidades.Comision;
import Entidades.Docente;
import Entidades.Persona.EstadosPersona;

/**
 * Servlet implementation class MainPageAdm
 */
@WebServlet("/MainPageAdmComisiones")
public class MainPageAdmComisiones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageAdmComisiones() {
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
			DataComision DC = new DataComision();
			int idComision = Integer.valueOf(request.getParameter("idComision"));
			int idMateria = Integer.valueOf(request.getParameter("idMateria"));
			DC.delete(idComision,idMateria);	
			request.getRequestDispatcher("WEB-INF/ADM/MainPageAdmComisiones.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("Recuperar"))
		{
			DataDocente DD = new DataDocente();
			String idDocente = request.getParameter("id");
			DD.setEstate(Integer.valueOf(idDocente),EstadosPersona.Activo);	
			request.getRequestDispatcher("WEB-INF/ADM/MainPageAdmDocentes.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("Editar"))
		{
			DataComision DC = new DataComision();
			int idComision = Integer.valueOf(request.getParameter("idComision"));
			int idMateria = Integer.valueOf(request.getParameter("idMateria"));
			Comision C = DC.getOne(idComision, idMateria);
			request.getSession().setAttribute("Comision",C);
			request.getRequestDispatcher("WEB-INF/ADM/MainPageAdmComisionesEdit.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("Add"))
		{
			request.getRequestDispatcher("WEB-INF/ADM/MainPageAdmComisionesAdd.jsp").forward(request, response);
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

package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.*;
import Entidades.*;
import Logic.MailController;

/**
 * Servlet implementation class IncribirseMateria
 */
@WebServlet("/InscripcionMesa")
public class InscripcionMesa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscripcionMesa() {
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
			DataMesa Dmesa = new DataMesa();
			
			//traer claves principales
			int idMateria = Integer.parseInt(req.getParameter("idMateria"));
			int idMesa = Integer.parseInt(req.getParameter("idMesa"));
			
			//traer registros de la base de datos
			Materia M = DM.getOne(idMateria);
			Mesa Mesa = Dmesa.getOne(idMesa);
			
			//inscribir mesa
			DataAlumno DA = new DataAlumno();
			Alumno A = DA.getOne(req.getParameter("legajo"));
			A.inscripcionMesa(idMesa, idMateria);
			
			//mandar mail
			MailController MC = new MailController();
			MC.enviarConGMail(A.getEmail(), "Comprobante inscripcion examen "+M.getNombre(),
							  A.getNombre()+" Te has logrado inscribir en la Mesa "+Mesa.getIdMesa() +"-"+ M.getNombre()+
							  "\n Fecha: "+Mesa.getFecha()+
							  "\n Hora: "+Mesa.getHorario()+":00 hs"+
							  "\n Salon: "+Mesa.getSalon()+
							  "\n \n No responder.");
			
			//guardar entidades
			req.getSession().setAttribute("Materia",M);
			req.getSession().setAttribute("Mesa",Mesa);
			req.getRequestDispatcher("WEB-INF/PostInscripcionMesa.jsp").forward(req, resp);
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		

	}

}

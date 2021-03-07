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
import Data.DataDireccion;
import Data.DataDocente;
import Data.DataMateria;
import Data.DataMesa;
import Entidades.Alumno;
import Entidades.Alumno.Carreras;
import Entidades.Comision.turnos;
import Entidades.Documento.TipoDocumento;
import Entidades.Persona.EstadosPersona;
import Logic.EnumHelper;
import Logic.ErrorManager;
import Logic.Formatter;
import Logic.Validator;

/**
 * Servlet implementation class MainPageAdm
 */
@WebServlet("/MainPageAdmAddMesa")
public class MainPageAdmAddMesa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageAdmAddMesa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ErrorManager E = new ErrorManager();
		
		DataMesa DM = new DataMesa();

		int salon= Integer.valueOf(request.getParameter("Salon"));
		int horario= Integer.valueOf(request.getParameter("Horario"));
		Date fecha= Date.valueOf(request.getParameter("Fecha"));
		int materia= Integer.valueOf(request.getParameter("Materia"));
		

		
		if(salon != 0 && horario != 0 && fecha != null && materia != 0 )
		{
			Validator V = new Validator();
			//validar datos
			if (
					//Validar minimo, maximo y formato
					V.numberOk(salon, 3, 20)				
			   )
			{	
				DM.addMesa(materia, horario, salon, fecha);
				
				request.getRequestDispatcher("WEB-INF/ADM/MainPageAdmMesas.jsp").forward(request, response);
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

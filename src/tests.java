import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import Data.DataAlumno;
import Data.DataComision;
import Data.DataDocente;
import Data.DataEstadoAcademico;
import Data.DataExamen;
import Data.DataInscripcion;
import Data.DataMateria;
import Data.DataMesa;
import Entidades.Alumno;
import Entidades.Alumno.Carreras;
import Entidades.Comision;
import Entidades.Comision.turnos;
import Entidades.Direccion;
import Entidades.Docente;
import Entidades.Documento;
import Entidades.Documento.TipoDocumento;
import Logic.Formatter;
import Logic.MailController;
import Entidades.EstadoAcademico;
import Entidades.Examen;
import Entidades.Materia;
import Entidades.Persona.EstadosPersona;
import Entidades.Examen.*;


public class tests {


	public static Carreras getRandom(Carreras[] array) {
		int idx = new Random().nextInt(array.length);
		Carreras random = (array[idx]);
		return random;
	}

	public static TipoDocumento getRandom(TipoDocumento[] array) {
		int idx = new Random().nextInt(array.length);
		TipoDocumento random = (array[idx]);
		return random;
	}

	
	public static String getRandom(String[] array) {
		int idx = new Random().nextInt(array.length);
		String random = (array[idx]);
		return random;
	}
	public static void main(String[] args) {
		
		//generar Alumnos random
		String[] nombres = {"Federico","Lautaro","Pepe","Franco","Damina","Aleberto","Luis","Jose","Sebastian","Agustin","Alejandro","Facundo","Pedro",
							"Alfonso","Javiar","Emiliano","Julieta","Lucila","Violeta","Ramon","Mauricio","Leila","Agostina","Sofia","Veronica",
							"Diana","Micaela","Camila"};
		
		String[] apellidos = {"Perez","Dante","Ruiz","Vachino","Gonzales","Valdez","Escudero","Torres","kuriguer","Pinacca","Messi","Calamante",
							  "Spip","Gomez","Rotundo","Vallejos","Tisera"};
		
		String[] dominiosMail = {"@outlook.com","@outlook.com.ar","@gmail.com","@hotmail.com","@hotmail.com.ar"};
		
		String[] calles = {"Mendoza","Nicaragua","Oroño","Avellaneda","Brazil","Mexico","Paraguay","Francia","Dorrego","Wilde",
						   "Cordoba","Pellegrini","Torres","Cortada Ruiz","La Rioja","Santa Fe","Corrientes","Entre Rios"};
		
		Carreras[] carreras = {Carreras.Civil,Carreras.Sistemas,Carreras.Electrica,Carreras.Quimica,Carreras.Mecanica};
		
		TipoDocumento[] docs = {TipoDocumento.DNI,TipoDocumento.LibretaCivica,TipoDocumento.LibretaDeEnrolamiento,TipoDocumento.Pasaporte};
//		
//		DataAlumno DA = new DataAlumno();
//		
//		for(int i=0;i<10;i++)
//		{
//			Alumno A = new Alumno();
//			A.setNombre(getRandom(nombres));
//			A.setApellido(getRandom(apellidos));
//			A.setCarrera(getRandom(carreras));
//			int i1 = new Random().nextInt(100);
//			A.setContraseña(A.getApellido()+i1+A.getNombre()+i);
//			A.setEstadoPersona(EstadosPersona.Pendiente);
//			A.setTelefono(String.valueOf(4500000+i1));
//			A.setEmail(A.getNombre()+i1+getRandom(dominiosMail));
//			
//			//documento
//			int doc = 4000000+i1*33;
//			Documento Doc = new Documento();
//			Doc.setNumero(String.valueOf(doc));
//			Doc.setTipo(getRandom(docs));
//			A.setDocumento(Doc);
//			
//			//Direccion
//			Direccion D = new Direccion();
//			D.setCalle(getRandom(calles));
//			D.setNumero(i1+10);
//			A.setDireccion(D);
//			
//			TipoDocumento td = A.getDocumento().getTipo();
//			String docum = A.getDocumento().getNumero();
//			
//			DA.addAlumno(A.getNombre(), A.getApellido(), A.getTelefono(), A.getEmail(), A.getContraseña(), A.getCarrera(), A.getDocumento().getTipo(), A.getDocumento().getNumero(), A.getDireccion().getCalle(), A.getDireccion().getNumero());
//			A = DA.getOne(td,docum);
//			A.startEstadoAcademico();
//			System.out.println(A.toString());
//		}
		
//		//nuevos docentes
//		DataDocente DD = new DataDocente();
//		for(int i=0;i<15;i++)
//		{
//			Docente D = new Docente();
//			D.setNombre(getRandom(nombres));
//			D.setApellido(getRandom(apellidos));
//			D.setEmail(String.valueOf(D.getNombre()+i*7+getRandom(dominiosMail)));
//			D.setContraseña(String.valueOf(D.getApellido()+i+10*9+D.getNombre()+i));
//			D.setTelefono(String.valueOf(4507030+i*37));
//			
//			//Direccion
//			Direccion Dir = new Direccion();
//			Dir.setCalle(getRandom(calles));
//			Dir.setNumero(34*i+253);
//			D.setDireccion(Dir);
//			
//			System.out.println(D.toString());
//			DD.addDocente(D.getNombre(), D.getApellido(), D.getEmail(), D.getTelefono(), D.getContraseña());
//			
//		}

//		DataMateria DM = new DataMateria();
//		ArrayList<Materia> materias = DM.getAll();
//		for(Materia M:materias)
//		{
//			Comision C = new Comision();
//			C.setCantAlumnos(0);
//			C.setCantAlumnosMax(30);
//			C.setIdComision(100);
//			C.setIdDocente(1);
//			C.setIdMateria(M.getIdMateria());
//			C.setTurno(turnos.Mañana);
//		}
//
//		DataComision DC = new DataComision();
//		DataMateria DM = new DataMateria();
//		ArrayList<Materia> materias = DM.getAll();
//		for(int i=1;i<3;i++)
//	    	{
//			for(Materia M:materias)
//				{
//				int idc = 0;
//				int maxAlumnos = new Random().nextInt(25)+20;
//	    		int docente = new Random().nextInt(15)+35;
//	    		if(M.getIdMateria()<=7)
//	    			{idc = 100;}
//	    		else if(M.getIdMateria()>7 && M.getIdMateria() <=16)
//	    			{idc = 200;}
//	    		else if(M.getIdMateria()>16 && M.getIdMateria() <=24)
//	    			{idc = 300;}
//	    		else if(M.getIdMateria()>24 && M.getIdMateria() <=31)
//	    			{idc = 400;}
//	    		else
//	    			{idc = 500;}
//	        	DC.addComision(idc+i, M.getIdMateria(), docente, 0+i*3, maxAlumnos, turnos.Mañana);
//	        	DC.addComision(idc+i+2, M.getIdMateria(), docente, 0+i*2, maxAlumnos, turnos.Tarde);
//	        	if(i<2)
//	        		{DC.addComision(idc+i+4, M.getIdMateria(), docente, 0+i, maxAlumnos, turnos.Noche);}
//				}	
//	    	}
//		for(int i=27;i<=35;i++)
//		{
//			int docente = new Random().nextInt(15)+35;
//			DC.addComision(500, i, docente, 0, 30, turnos.Mañana);
//		}
//		
//		Formatter F = new Formatter();
//		System.out.println(F.upAllWords(" asdASDAadasd DASDdAD   "));
		
//		DataMateria DM = new DataMateria();
//		int i = 3;
//		System.out.println("Regular:"+DM.getOne(32).readCorrelativasRegulares()[i]);
//		System.out.println("Aprobadas:"+DM.getOne(25).readCorrelativasAprobadas()[i]);
//		System.out.println("Rendir:"+DM.getOne(32).readCorrelativasRendir()[i]);
//		System.out.println(DM.getOne(25).AlumnoPuedeCursar("1654604"));
		
//		Materia M = new Materia();
//		Alumno A = new Alumno();
//		A.setLegajo("1654604");
//		M.setIdMateria(11);
//		
//		System.out.println("regulares");
//		ArrayList<Integer> Correlativas1 = M.getCorrelativasRegularesInt();
//		for(Integer C:Correlativas1)
//		{
//			System.out.println(C);
//		}
//		
//		System.out.println("aprobadas");
//		ArrayList<Integer> Correlativas2 = M.getCorrelativasAprobadasInt();
//		for(Integer C:Correlativas2)
//		{
//			System.out.println(C);
//		}
//		
//		System.out.println("Rendir");
//		ArrayList<Integer> Correlativas3 = M.getCorrelativasRendirInt();
//		for(Integer C:Correlativas3)
//		{
//			System.out.println(C);
//		}
//		
//		System.out.println();
//		System.out.println("Cursar");
//		System.out.println(M.AlumnoPuedeCursar(A.getLegajo()));
//		System.out.println();
//		System.out.println("Rendir");
//		System.out.println(M.AlumnoPuedeRendir(A.getLegajo()));
		DataMateria DM = new DataMateria();
		DM.addMateria("nombre", "cursado", "año", null, null, null);
	}







}

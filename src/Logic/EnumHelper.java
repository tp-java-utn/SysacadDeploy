package Logic;

import Entidades.Alumno.Carreras;
import Entidades.Documento.TipoDocumento;

public class EnumHelper {

	public TipoDocumento convertToTipoDocumento(String text)
	{
		TipoDocumento TDreturn = null;
		
		switch(text)
		{
		case "Documento Nacional de Identidad":
			TDreturn = TipoDocumento.DNI;
		break;
		
		case "Pasaporte":
			TDreturn = TipoDocumento.Pasaporte;
		break;
		
		case "Libreta de Enrolamiento":
			TDreturn = TipoDocumento.LibretaDeEnrolamiento;
		break;
		
		case "Libreta Civica":
			TDreturn = TipoDocumento.LibretaCivica;
		break;
		}
		
		return TDreturn;	
	}
	
	public Carreras convertToCarreras(String text)
	{
		Carreras Creturn = null;
		
		switch(text)
		{
		case "Ingenieria Mecanica":
			Creturn = Carreras.Mecanica;
		break;
		
		case "Ingenieria Electrica":
			Creturn = Carreras.Electrica;
		break;

		case "Ingenieria en Sistemas de Informacio":
			Creturn = Carreras.Sistemas;
		break;
		
		case "Ingenieria Civil":
			Creturn = Carreras.Civil;
		break;
		
		case "Ingenieria Qumica":
			Creturn = Carreras.Quimica;
		break;
		}
		
		return Creturn;	
	}
}

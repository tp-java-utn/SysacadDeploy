package Entidades;

public class Documento {
	
	public enum TipoDocumento
	{
		DNI,
		Pasaporte,
		LibretaDeEnrolamiento,
		LibretaCivica,
	}
	
	public Documento(TipoDocumento tipo,String numero)
	{
		this.setNumero(numero);
		this.setTipo(tipo);
	}
	
	public Documento() {
		// TODO Auto-generated constructor stub
	}

	String numero;
	TipoDocumento tipo;
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public TipoDocumento getTipo() {
		return tipo;
	}
	public void setTipo(TipoDocumento tipo) {
		this.tipo = tipo;
	}
}

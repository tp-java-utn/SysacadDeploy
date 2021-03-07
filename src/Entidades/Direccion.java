package Entidades;

public class Direccion {
	
	private int idDireccion;
	private String calle;
	private int numero;
	private int piso;
	private String dept;
	
	@Override
	public String toString() {
		
		if(dept == null || piso == 0)
		{return  idDireccion+": "+ calle + " " + numero;}
		else
		{return  idDireccion+": "+calle + " " + numero + ", Depratamento: " + piso + dept;}
		
	}

	public Direccion() {}	
	
	public Direccion(String calle,int numero) 
	{
		this.setCalle(calle);
		this.setNumero(numero);
	}
	
	public Direccion(String calle,int numero,int piso, String dept)
	{
		this.setCalle(calle);
		this.setNumero(numero);
		this.setPiso(piso);
		this.setDept(dept);
	}
	
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public int getidDireccion() {
		return idDireccion;
	}
	public void setidDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}
	
}
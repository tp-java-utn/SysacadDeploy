package Entidades;

public class Persona {
	private String nombre;
	private String apellido;
	private String email;
	private String contraseña;
	private String telefono;
	private Direccion direccion;
	private Documento documento; 
	private EstadosPersona estado = EstadosPersona.Pendiente;
	
	
	public enum EstadosPersona{
		Activo,
		Pendiente,
		Eliminado
	}
	
	public String getEstadoPersona() {
		if(estado == null)
			{return "null";}
		else
			{return estado.toString();}
	}
	
	public void setEstadoPersona(EstadosPersona estado) {
		this.estado = estado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apelldo) {
		this.apellido = apelldo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
	
}
package Entidades;

public class Docente extends Persona {
	int idDocente;

	@Override
	public String toString() {
		return "Docente [idDocente=" + idDocente + ", getIdDocente()=" + getIdDocente() + ", getEstadoPersona()="
				+ getEstadoPersona() + ", getNombre()=" + getNombre() + ", getApellido()=" + getApellido()
				+ ", getEmail()=" + getEmail() + ", getContraseña()=" + getContraseña() + ", getTelefono()="
				+ getTelefono() + ", getDireccion()=" + getDireccion() + ", getDocumento()=" + getDocumento()
				+ "]";
	}

	public int getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}
	
}

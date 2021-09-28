package sergio_programasiniciales;

public class Personaje_Aventura {
	String nombre;
	int fuerza, destreza, consitucion;
	int carisma, manipulacion, compostura;
	int inteligencia, astucia, aplomo;
	int vida;
	
	public Personaje_Aventura() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Personaje_Aventura(String nombre, int fuerza, int destreza, int consitucion, int carisma, int manipulacion,
			int compostura, int inteligencia, int astucia, int aplomo, int vida) {
		super();
		this.nombre = nombre;
		this.fuerza = fuerza;
		this.destreza = destreza;
		this.consitucion = consitucion;
		this.carisma = carisma;
		this.manipulacion = manipulacion;
		this.compostura = compostura;
		this.inteligencia = inteligencia;
		this.astucia = astucia;
		this.aplomo = aplomo;
		this.vida = 5 + consitucion;
	}
	
	
	
	
	
	
	
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlbumDelMundial implements IAlbumDelMundial {
	private Map<Integer,Usuario> usuarios;
	private Fabrica fabrica;
	
	protected AlbumDelMundial() {
		this.usuarios=new HashMap<Integer,Usuario>();
		this.fabrica=new Fabrica();
	}
	@Override
	public int registrarParticipante(int dni, String nombre, String tipoAlbum) {
		if(this.usuarios.containsKey(dni)) {
			throw new RuntimeException("Error el usuario ya esta registrado");
		}
		if(!Album.existeTipoAlbum(tipoAlbum)) {
			throw new RuntimeException("Error el tipo de album no existe");
		}
		Album album;
		if(tipoAlbum.equals("Tradicional")) {	
			album=fabrica.crearAlbumTradicional();		
		}else if(tipoAlbum.equals("Extendido")) {
			album=fabrica.crearAlbumExtendido();	
		}else {
			album=fabrica.crearAlbumWeb();
		}
		
		Usuario u = new Usuario(dni,nombre,album);
		usuarios.put(dni, u);
		
		return usuarios.get(dni).getCodigoAlbum(); 		
	}

	@Override
	public void comprarFiguritas(int dni) {
		if(!this.usuarios.containsKey(dni)) {
			throw new RuntimeException("Error el usuario no esta registrado");
			}
		this.usuarios.get(dni).agregarColeccion(fabrica.generarSobre(4));	
	}

	@Override
	public void comprarFiguritasTop10(int dni) {
		if(!this.usuarios.containsKey(dni)) {
			throw new RuntimeException("Error el usuario no esta registrado");
			}
		if(!this.usuarios.get(dni).tieneAlbum("Extendido")) {
			throw new RuntimeException("Error el usuario no tiene el tipo de album Extendido");
		}
		this.usuarios.get(dni).agregarColeccion(fabrica.generarSobreTop10(4));	
	}

	@Override
	public void comprarFiguritasConCodigoPromocional(int dni) {
		if(!this.usuarios.containsKey(dni)) {
			throw new RuntimeException("Error el usuario no esta registrado");
			}
		if(!this.usuarios.get(dni).tieneCodigoPromocional()) {
			throw new RuntimeException("El usuario no tiene codigo promocional");
		}
		this.usuarios.get(dni).sacarSobrePromocional();
		this.usuarios.get(dni).agregarColeccion(fabrica.generarSobre(4));
		
	}

	@Override
	public List<String> pegarFiguritas(int dni) {
		return this.usuarios.get(dni).pegarFiguritas();
	}

	@Override
	public boolean llenoAlbum(int dni) {
		return usuarios.get(dni).Albumcompleto();
	}

	@Override
	public String aplicarSorteoInstantaneo(int dni) {
	
		if(!usuarios.containsKey(dni)) {
			throw new RuntimeException("Error no esta el ususario");
		}
		if (!usuarios.get(dni).puedeSolicitarSorteo()) {
			throw new RuntimeException("Error no se puede realizar");
		}
		String premio = fabrica.generarPremiosParaSorteoInstantaneo()[(int)Math.random()*(2 - 0)];
		if(premio.equals("1 Sobre Gratis")) {
			usuarios.get(dni).agregarSobrePromocional();
			System.out.print("obtuviste un sobre promocional");
		}
		return premio;
	}

	@Override
	public int buscarFiguritaRepetida(int dni) {
		return this.usuarios.get(dni).buscarFiguritaRepetida();
	}

	@Override
	public boolean intercambiar(int dni, int codFigurita) {//codfigu lo que tiene
		for(Usuario u:this.usuarios.values()) {
			if(u.getTipoAlbum().equals(this.usuarios.get(dni).getTipoAlbum())&&  !(u.tienePegada(codFigurita) || u.tieneEnColeccion(codFigurita)) ) { // verificamos que el user no tenga la figu del this
				for(Figurita f:u.getColeccion()) {
					if(!usuarios.get(dni).tienePegada(f.getcodigo()) && !usuarios.get(dni).tieneEnColeccion(f.getcodigo()) && f.compareTo(usuarios.get(dni).getFigurita(codFigurita)) <= 0 ) {	 //verificamos si existe una figurita de un user que no tenga el this	
						usuarios.get(dni).agregarColeccion(f);
						u.agregarColeccion(usuarios.get(dni).getFigurita(codFigurita));
						u.quitarColeccion(f);
						usuarios.get(dni).quitarColeccion(usuarios.get(dni).getFigurita(codFigurita));
						return true;
					}
				}
			}
		}
		return false;	
	}

	@Override
	public boolean intercambiarUnaFiguritaRepetida(int dni) {
		return intercambiar(dni,buscarFiguritaRepetida(dni));
	}

	public String darNombre(int dni) {
		if(!usuarios.containsKey(dni)) {
			throw new RuntimeException("Error el usuario no esta registrado");
		}
		return usuarios.get(dni).getNombre();
	}

	@Override
	public String darPremio(int dni) {
		if(!usuarios.containsKey(dni)) {
			throw new RuntimeException("Error el usuario no esta registrado");
		}else if(!usuarios.get(dni).Albumcompleto()) {
			throw new RuntimeException("Error el usuario no completo el album");
		}
		return usuarios.get(dni).getPremio();
	}

	@Override
	public String listadoDeGanadores() {
		StringBuilder salida = new StringBuilder();
		for(Usuario u : this.usuarios.values()) {
			if (usuarios.containsKey(u.getDni()) && u.Albumcompleto()) {
				salida.append(u.getDni()+", "+u.getNombre()+": " + u.getPremio()+". ");
			}
		}
		return salida.toString();
	}

	@Override
	public List<String> participantesQueCompletaronElPais(String nombrePais) {
		ArrayList<String> salida=new ArrayList<>();
		for(Usuario u:this.usuarios.values()) {
			if(u.paisCompleto(nombrePais)) {
				salida.add(u.toString());
			}
		}
		return salida;
	}
	
	
}

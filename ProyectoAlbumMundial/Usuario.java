import java.util.*;


public class Usuario {
	private int dni;
	private Album album;
	private ArrayList<Figurita> coleccionFiguritas;
	private String nombre;
	
	protected Usuario(int dni,String nombre,Album album) {
		
		this.dni=dni;
		this.nombre=nombre;
		this.coleccionFiguritas=new ArrayList<>();
		this.album=album;
		
	}
	
	protected List<String> pegarFiguritas(){
		ArrayList<String> salida= new ArrayList<String>();
		ArrayList<Figurita>pegarAlbum=new ArrayList<Figurita>();
		
		for(Figurita f:this.coleccionFiguritas) {			
				pegarAlbum.add(f);			
		}
		
		pegarAlbum=this.album.agregarFiguritasAlbum(pegarAlbum);
		if(pegarAlbum!=null) {
		for(Figurita f: pegarAlbum) {
			salida.add(f.toString());
			this.coleccionFiguritas.remove(f);	
			}
		}
		return salida;
	}
	
	protected boolean figuritaRepetidaColeccion(int codigo) {
		int cont=0;
		for(Figurita f:this.coleccionFiguritas) {
			if(f.getcodigo()==codigo) {
				cont++;
			}
		}
		return cont>=2?true:false;
	}
	
	protected boolean Albumcompleto() {
		return this.album.albumCompleto();	
	}
	
	protected int getCodigoAlbum() {
		return this.album.getCodigo();
	}
	
	protected void agregarColeccion(List<Figurita> figuritas) {
		for(Figurita f:figuritas) {
			this.coleccionFiguritas.add(f);
		}
	}
	
	protected boolean tieneAlbum(String alb) {
		return this.album.getTipoAlbum().equals(alb)?true:false; 
	}
	
	protected boolean tieneCodigoPromocional() {
		return this.album.tieneCodigoPromocional();
	}
	
	protected boolean puedeSolicitarSorteo() {
		return this.album.puedeSolicitarSorteo();
	}

	protected void agregarSobrePromocional() {
		this.album.agregarSobrePromocional();
	}
	
	protected void sacarSobrePromocional() {
		this.album.sacarSobrePromocional();
	}
	
	@Override
	public String toString() {
		StringBuilder salida=new StringBuilder();
		salida.append(this.dni+" "+this.nombre+" "+this.album.toString());
		return salida.toString();
	}
	
	protected boolean paisCompleto(String nombrePais) {
		return this.album.paisCompleto(nombrePais)?true:false ;
	}

	protected int buscarFiguritaRepetida() {
		for(Figurita f:this.coleccionFiguritas) {
			if( (this.tienePegada(f.getcodigo())&& this.tieneEnColeccion(f.getcodigo()) ) || this.figuritaRepetidaColeccion(f.getcodigo())  ) {
				return f.getcodigo();
			}
		}
		return -1;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getPremio() {
		return album.getPremio();
	}
	
	public int getDni() {
		return this.dni;
	}
	
	public String getTipoAlbum() {
		StringBuilder salida= new StringBuilder();
		salida.append(this.album.getTipoAlbum());
		return salida.toString();
	}
	
	protected ArrayList<Figurita> getColeccion(){
		return (ArrayList<Figurita>) this.coleccionFiguritas.clone();
	}
	
	protected boolean tienePegada(int codigo) {
		return this.album.estaFigurita(codigo);	
	}
	
	protected Figurita getFigurita(int codigo) {
		for(Figurita f:this.coleccionFiguritas) {
			if(f.getcodigo()==codigo) {
				return f;
			}
		}
		return null;
		
	}
	
	protected void agregarColeccion(Figurita f) {
		this.coleccionFiguritas.add(f);
	}

	protected void quitarColeccion(Figurita f) {
		this.coleccionFiguritas.remove(f);	
	}

	
	protected boolean tieneEnColeccion(int codigo) {
		for(Figurita f : coleccionFiguritas) {
			if(f.getcodigo() == codigo) {
				return true;
			}
		}
		return false;
	}
}

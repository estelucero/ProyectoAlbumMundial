import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Album {
	private static int ID = 0;
	private int id;
	private String premio;	
	protected Map<Integer,Figurita> figuritasPegadas;
	protected int figuritasPegadasTotales;
	private int codigoPromocional;
	
	
	protected Album(String premio, HashMap<Integer, Figurita> figuritasPegadas,int cantPaquetesPromocionales) {

		this.premio = premio;
		this.figuritasPegadas = figuritasPegadas;
		this.figuritasPegadasTotales = 0;	
		ID++;
		this.id = ID;
		this.codigoPromocional=cantPaquetesPromocionales;
	}
	
	
	protected abstract ArrayList<Figurita> agregarFiguritasAlbum(ArrayList<Figurita> figusColeccion);
		
	protected abstract boolean albumCompleto();		
		
	
	protected boolean paisCompleto(String nombrePais) {		
		int cont=0;
		for(int i=1;i<=389;i++) {
			if(figuritasPegadas.get(i)!=null&&figuritasPegadas.get(i).getpais().equals(nombrePais)) {
				cont++;
			}
		}		
		return cont==12?true:false;
	}
	
	
	protected boolean estaFigurita(Figurita f) {
		return this.figuritasPegadas.get(f.getcodigo()) == null?false:true;
	}
	
	protected boolean estaFigurita(Integer codigo) {
		return this.figuritasPegadas.containsKey(codigo)?false:true;
	}
	
	protected static boolean existeTipoAlbum(String album1) {
		if(album1.equals("Tradicional")||album1.equals("Extendido")||album1.equals("Web")) {
			return true;
		}
		return false;
	}
	
	protected boolean tieneCodigoPromocional() {
		return this.codigoPromocional>0?true:false;
	}
		
	protected int getCodigo() {
		return this.id;
	}
	
	protected abstract boolean puedeSolicitarSorteo();

	protected void agregarSobrePromocional() {
		this.codigoPromocional++;
	}
	
	protected void sacarSobrePromocional() {
		this.codigoPromocional--;
	}
	
	public String toString() {
		StringBuilder salida=new StringBuilder();
		salida.append("Tipo album:"+this.getClass().toString()+" Codigo:"+this.getCodigo());
		return salida.toString();
	}
	
	protected String getPremio() {
		return this.premio;
	}
	
	protected abstract String getTipoAlbum();
	
	protected List<Figurita> mostrarPegadas(){
		ArrayList<Figurita> salida = new ArrayList<>();
		
		for(Figurita f : figuritasPegadas.values()) {
			salida.add(f);
		}
		return salida;
	}
}

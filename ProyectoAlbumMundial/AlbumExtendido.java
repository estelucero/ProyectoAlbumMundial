import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AlbumExtendido extends Album {
	
	private int sorteo;
	private int figuritasEspacios; 
	private String tipoAlbum;
	private Map<Integer,Figurita> figuritasTop10Pegadas;
	
	protected AlbumExtendido(String premio,HashMap<Integer, Figurita> albumBase,Map<Integer,Figurita> albumExtendido,int cantCodigosPromocionales) {
		super(premio, albumBase,cantCodigosPromocionales);
		this.figuritasTop10Pegadas=albumExtendido;
		this.sorteo=0;
		this.figuritasEspacios = 48+20;//deberia ser albumBase.size + albumExtendido.size
		this.tipoAlbum="Extendido";
	}
	
	
	@Override
	protected boolean puedeSolicitarSorteo() {		
		return false;
	}
	
	@Override
	protected boolean estaFigurita(Figurita f) {
		if(this.figuritasPegadas.get(f.getcodigo())== null || this.figuritasTop10Pegadas.get(f.getcodigo())==null) {
			return false;
			}
		return true;
	}
	
	@Override
	protected ArrayList<Figurita> agregarFiguritasAlbum(ArrayList<Figurita> figusColeccion) {
		
		ArrayList<Figurita> figusPegadas = new ArrayList<Figurita>();
		
		for (Figurita f : figusColeccion) {
			if(f.getTipo().equals("Figurita") ) {
			
			if ( this.figuritasPegadas.containsKey(f.getcodigo())== true && this.figuritasPegadas.get(f.getcodigo())==null) {
			this.figuritasPegadas.replace(f.getcodigo(), f);
			this.figuritasPegadasTotales++;
			
			figusPegadas.add(f);
			}
			}else if(f.getTipo().equals("FiguritaTop10")) {
				if ( this.figuritasTop10Pegadas.containsKey(f.getcodigo())== true && this.figuritasTop10Pegadas.get(f.getcodigo())==null) {
				this.figuritasTop10Pegadas.replace(f.getcodigo(), f);
				this.figuritasPegadasTotales++;
				
				figusPegadas.add(f);
				}
			}
		}
		return figusPegadas;		
	}

	@Override
	protected boolean albumCompleto() {
		return this.figuritasPegadasTotales==figuritasEspacios?true:false; 
	}
	
	protected String getTipoAlbum() {
		return this.tipoAlbum;
	}
}

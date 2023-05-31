import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AlbumWeb extends Album {
	
	private int sorteo;
	private int figuritasEspacios; 
	private String tipoAlbum;
	
	protected AlbumWeb(String premio, HashMap<Integer, Figurita> figuritasPegadas,
			int cantPaquetesPromocionales) {
		super(premio, figuritasPegadas, cantPaquetesPromocionales);
		this.sorteo = 0;
		this.figuritasEspacios = 48; //deberia ser albumBase.size
		this.tipoAlbum="Web";
	}

	
	@Override
	protected ArrayList<Figurita> agregarFiguritasAlbum(ArrayList<Figurita> figusColeccion) {
		
		ArrayList<Figurita> figusPegadas = new ArrayList<Figurita>();
		
		for (Figurita f : figusColeccion) {
			if (super.figuritasPegadas.containsKey(f.getcodigo())== true && super.figuritasPegadas.get(f.getcodigo())==null) {
			super.figuritasPegadas.replace(f.getcodigo(), f);
			super.figuritasPegadasTotales++;			
			figusPegadas.add(f);
			}
		}
		return figusPegadas;		
	}
	
	
	
	@Override
	protected boolean puedeSolicitarSorteo() {		
		return false;
	}

	protected String getTipoAlbum() {
		return this.tipoAlbum;
	}


	@Override
	protected boolean albumCompleto() {
		return super.figuritasPegadasTotales == figuritasEspacios?true:false;
	}
}

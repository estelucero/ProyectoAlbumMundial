import java.util.*;


public class AlbumTradicional extends Album {

	private int sorteo;
	private int figuritasEspacios; 
	private String tipoAlbum;
	protected AlbumTradicional(String premio, HashMap<Integer, Figurita> figuritasPegadas,int cantCodigoPromocional) {
		super(premio, figuritasPegadas,cantCodigoPromocional );
		this.sorteo = 1;
		this.figuritasEspacios = 48;//deberia ser albumBase.size
		this.tipoAlbum="Tradicional";
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
		if(this.sorteo > 0) {
			this.sorteo--;
			return true;
		}		
		return false;
	}
	
	@Override
	protected boolean albumCompleto() {
		return super.figuritasPegadasTotales == figuritasEspacios?true:false;		
	}
	
	protected String getTipoAlbum() {
		return this.tipoAlbum;
	}

}

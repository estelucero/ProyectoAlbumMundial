

public class Figurita implements Comparable<Figurita>{
	
	private String nombre;
	private static int codigoStatic = 1;
	private int codigo;
	private Integer numero;
	private String pais;
	protected double valorBase;
	private String tipoFigurita;
	
	
	protected Figurita(String nombre, String numero, String pais, String valorBase) {
		this.nombre = nombre;
		this.numero = Integer.parseInt(numero);
		this.pais = pais;
		this.valorBase = Integer.parseInt(valorBase);
		this.codigo = codigoStatic;
		Figurita.codigoStatic++;
		this.tipoFigurita="Figurita";
	}
	
	protected Figurita (String nombre,String numero,String pais, int codigoStaticTop10) { //constructor FiguritaTop10
		this.nombre = nombre;
		this.numero = Integer.parseInt(numero);
		this.pais = pais;
		this.codigo=codigoStaticTop10;
		this.tipoFigurita="FiguritaTop10";
	}

	protected Object getpais() {	
		return this.pais;
	}

	protected Integer getnumero() {
		return this.numero;
	}
	
	protected String getTipo() {
		return this.tipoFigurita;
	}
	
	protected String getnombre() {
		return this.nombre;
	}
	
	protected double getValorBase() {
		return this.valorBase;
	}
	
	public int compareTo(Figurita f) {
		if(this.valorBase < f.valorBase) {
			return -1;
		}
		if(this.valorBase > f.valorBase) {
			return 1;
		}
		return 0;
	}
	
	protected int getcodigo() {
		return this.codigo;
	}
	
	@Override
	public String toString() {
		StringBuilder salida=new StringBuilder();
		salida.append(this.nombre+"- Dorsal: "+this.numero + "- Valor base: " + this.valorBase );
		return salida.toString();
	}
	
	@Override
	public int hashCode() {
		return (this.codigo*3)/10;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Figurita other = (Figurita) obj;
		return this.codigo==other.getcodigo();
	}
	
	
}

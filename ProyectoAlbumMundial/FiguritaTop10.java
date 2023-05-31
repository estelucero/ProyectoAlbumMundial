
public class FiguritaTop10 extends Figurita {
	
	private static int codigoStaticTop10 = 1;
	private String paisCede;
	private String anioMundial;
	private String tipoBalon;
	
	
	
	protected FiguritaTop10(String nombre, String numero, String pais, int valorBase, String paisCede, String anioMundial, String tipoBalon) {			
		super(nombre, numero, pais, codigoStaticTop10);	
		this.paisCede= paisCede;
		this.anioMundial= anioMundial;
		this.tipoBalon= tipoBalon;
		codigoStaticTop10++;

		if(tipoBalon.equals("Oro")) {
			this.valorBase = (valorBase*1.20); //Uso otro constructor 
		}else {
			this.valorBase = (valorBase*1.10);
		}
	}	

}

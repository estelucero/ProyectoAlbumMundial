import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Fabrica {


	private Random random;

	private String[] premiosInstantaneos;
	private String[] paisesParticipantes;
	private int lugaresPorPais;
	private String[] listadoDeMundialesTop10;
	private Map<String, String[]> balonYPaisPorMundialTop10;
	private Map<String, Integer> ranking;
	private  HashMap<Integer, Figurita> albumVacio;
	private  HashMap<Integer,Figurita> albumExtendidoVaio;
	private HashMap<Integer,Figurita> figuritas;
	private HashMap<Integer,FiguritaTop10> figuritasTop10;
	private  HashMap<String, String[][]> jugadorPorMundial;
	
	Fabrica() {
		random = new Random(System.currentTimeMillis());
		lugaresPorPais = 12;
		paisesParticipantes = generarPaisesClasificados();
		listadoDeMundialesTop10 = generarListadoDeMundiales();
		balonYPaisPorMundialTop10 = generarPaisesPorMundial();
		ranking = generarRanking();
		premiosInstantaneos = generarPremiosParaSorteoInstantaneo();
		//Agregue
		jugadorPorMundial=this.generarJugadorPorMundial();

		this.figuritas=this.generarFiguritas();
		this.figuritasTop10=this.generarFiguritasTop10();
	}
	
	private HashMap<Integer, FiguritaTop10> generarFiguritasTop10() {
		HashMap<Integer,FiguritaTop10> salida= new HashMap<Integer,FiguritaTop10>();
		int codigo=1;
		for(String mundial:this.listadoDeMundialesTop10) {
			String[] lista=mundial.split(" '");
			int anio=72;
			String l=this.jugadorPorMundial.get(mundial)[0][1];
			FiguritaTop10 f=new FiguritaTop10(this.jugadorPorMundial.get(mundial)[0][0], this.jugadorPorMundial.get(mundial)[0][1], this.jugadorPorMundial.get(mundial)[0][2], this.calcularValorBase(this.jugadorPorMundial.get(mundial)[0][2], Integer.parseInt(this.jugadorPorMundial.get(mundial)[0][1])), lista[0], ""+anio, "Oro");
			salida.put(codigo, f);
			f=null;
			codigo++;
			FiguritaTop10 f2=new FiguritaTop10(this.jugadorPorMundial.get(mundial)[1][0], this.jugadorPorMundial.get(mundial)[1][1], this.jugadorPorMundial.get(mundial)[1][2], this.calcularValorBase(this.jugadorPorMundial.get(mundial)[1][2], Integer.parseInt(this.jugadorPorMundial.get(mundial)[1][1])), lista[0], ""+anio, "Plata");
			salida.put(codigo, f2);
			f2=null;
			codigo++;
			anio+=4;
		}
		return salida;
	}

	private HashMap<Integer,Figurita>  generarFiguritas() {
		String[][] jugadores= {{"Lionel Messi","10","Argentina",""+this.calcularValorBase("Argentina", 10)},{"Paredes","5","Argentina",""+this.calcularValorBase("Argentina", 5)},{"Dibu Martinez","1","Argentina",""+this.calcularValorBase("Argentina", 1)},{"Di Maria","11","Argentina",""+this.calcularValorBase("Argentina", 11)},{"De Paul","7","Argentina",""+this.calcularValorBase("Argentina", 7)},{"Nahuel Molina","26","Argentina",""+this.calcularValorBase("Argentina", 26)},{"Otamendi","19","Argentina",""+this.calcularValorBase("Argentina", 19)},{"Lissandro Martinez","25","Argentina",""+this.calcularValorBase("Argentina", 25)},{"Marcos Acuña","8","Argentina",""+this.calcularValorBase("Argentina", 8)},{"Mac Allister","20","Argentina",""+this.calcularValorBase("Argentina", 20)},{"Lautaro Martinez","22","Argentina",""+this.calcularValorBase("Argentina", 22)},
				{"Julian Alvarez","9","Argentina",""+this.calcularValorBase("Argentina", 9)},{"Saad Al Sheeb","1","Qatar",""+this.calcularValorBase("Qatar", 1)},{"Meshaal Barsham","22","Qatar",""+this.calcularValorBase("Qatar", 22)},{"Homam Ahmed","14","Qatar",""+this.calcularValorBase("Qatar", 14)},{"Basam Arrawi","15","Qatar",""+this.calcularValorBase("Qatar", 15)},{"Abdelkarim Hassan","3","Qatar",""+this.calcularValorBase("Qatar", 3)},{"Karim Boudiaf","12","Qatar",""+this.calcularValorBase("Qatar", 12)},{"Abdulaziz Hatem","6","Qatar",""+this.calcularValorBase("Qatar", 6)},{"Abdulaziz Hatem","6","Qatar",""+this.calcularValorBase("Qatar", 6)},{"Ali Asad","8","Qatar",""+this.calcularValorBase("Qatar", 8)},{"Ahmed Alaaeldin","7","Qatar",""+this.calcularValorBase("Qatar", 7)},{"Almoez Ali","19","Qatar",""+this.calcularValorBase("Qatar", 19)},{"Naif Al-Hadhrami","24","Qatar",""+this.calcularValorBase("Qatar", 24)},{"Allison","1","Brasil",""+this.calcularValorBase("Brasil", 1)},{"Marquinhos","4","Brasil",""+this.calcularValorBase("Brasil", 4)},{"Fred","8","Brasil",""+this.calcularValorBase("Brasil", 8)},{"Vinicius Junior","20","Brasil",""+this.calcularValorBase("Brasil", 20)},{"Neymar","10","Brasil",""+this.calcularValorBase("Brasil", 10)},{"Gabriel Martinelli","26","Brasil",""+this.calcularValorBase("Brasil", 26)},{"Raphinha","11","Brasil",""+this.calcularValorBase("Brasil", 11)},{"Richarlison","9","Brasil",""+this.calcularValorBase("Brasil", 9)},{"Thiago Silva","3","Brasil",""+this.calcularValorBase("Brasil", 3)},{"Eder Militao","14","Brasil",""+this.calcularValorBase("Brasil", 14)},{"Ederson","23","Brasil",""+this.calcularValorBase("Brasil", 23)},{"Dani Alves","13","Brasil",""+this.calcularValorBase("Brasil", 13)},
				{"Jordan Pickford","1","Inglaterra",""+this.calcularValorBase("Inglaterra", 1)},
				{"Harry Maguire","6","Inglaterra",""+this.calcularValorBase("Inglaterra", 6)},
				{"Eric Dier","15","Inglaterra",""+this.calcularValorBase("Inglaterra", 15)},
				{"Alexander Arnold","18","Inglaterra",""+this.calcularValorBase("Inglaterra", 18)},
				{"Kyle Walker","2","Inglaterra",""+this.calcularValorBase("Inglaterra", 2)},
				{"Luke Shaw","3","Inglaterra",""+this.calcularValorBase("Inglaterra", 3)},
				{"Phil Foden","20","Inglaterra",""+this.calcularValorBase("Inglaterra", 20)},
				{"Jordan Henderson","8","Inglaterra",""+this.calcularValorBase("Inglaterra", 8)},
				{"Bukayo Saka","17","Inglaterra",""+this.calcularValorBase("Inglaterra", 17)},
				{"James Madison","25","Inglaterra",""+this.calcularValorBase("Inglaterra", 25)},
				{"Harry Kane","9","Inglaterra",""+this.calcularValorBase("Inglaterra", 9)},
				{"Marcus Rashford","11","Inglaterra",""+this.calcularValorBase("Inglaterra", 11)}};		
		HashMap<Integer,Figurita> salida= new HashMap<Integer,Figurita>();
		for(int fila =0;fila<jugadores.length;fila++) {
			Figurita f=new Figurita(jugadores[fila][0],jugadores[fila][1],jugadores[fila][2],jugadores[fila][3]);
			salida.put(fila, f);
			f=null;
		}
		
		return salida;
		
	}

	private HashMap<Integer, Figurita> generarAlbumExtendidoVacio() {
		
		HashMap<Integer,Figurita> salida= new HashMap<Integer,Figurita>();
		for (int i =1;i<=20;i++) {
			salida.put(i, null);
		}
		return salida;
	}

	private HashMap<Integer, Figurita> generarAlbumVacio() {
		HashMap<Integer,Figurita> jugador=new HashMap<Integer,Figurita>();
		
		
		for(int i=1;i<=389;i++) {
			jugador.put(i, null);
		}
		
		
		return jugador;
	}

	////////////////////////////////////////////////////////////////////////
	// NOTA: Deben implementar los siguientes metodos segun su modelo     //
	//       Aprovechando la informacion referida al mundial facilitada   //
	//       por la catedra.                                              //
	//       Solamente deberian deberan usar las variables de clases      //
	//       y el metodo "calcularValorBase" para saber que valor base    //
	//       tendrá una figurita en particula.                            //
	////////////////////////////////////////////////////////////////////////

	// agregamos variables a los albumTrad vacio y todas figuritas.
	
	
	Album crearAlbumWeb() {
        AlbumWeb album=new AlbumWeb("Codigo promocional", this.generarAlbumVacio(), 1);
		return album;
	}

	Album crearAlbumExtendido() {
		AlbumExtendido album=new AlbumExtendido("Viaje", this.generarAlbumVacio(), this.generarAlbumExtendidoVacio(),0);
		return album;
	}

	Album crearAlbumTradicional() {
		AlbumTradicional album=new AlbumTradicional("Pelota", this.generarAlbumVacio(), 0);
		return album;
	}

	List<Figurita> generarSobre(int cantFigus) {
		ArrayList<Figurita> salida=new ArrayList<Figurita>();
		for(int i=0;i<cantFigus;i++) {
			salida.add(figuritas.get((int)(Math.random()*48)));//Va de 0 a 4 por como lo hicimos 
		}
		return salida;
	}		

	List<Figurita> generarSobreTop10(int cantFigus) {
		ArrayList<Figurita> salida=new ArrayList<Figurita>();
		for(int i=0;i<cantFigus;i++) {			
			salida.add(figuritasTop10.get((int)(Math.random()*20+1)));//Va de 1 a 20 
		}
		return salida;
	}		
	


	///////////////////////////////////////////////////////
	///////////// METODOS FACILITADOS POR LA CATEDRA //////
	///////////////////////////////////////////////////////
	
	// Dado el pais y numero de jugador de una figurita calcula
	// cual es su valor base simbobilo.
	private int calcularValorBase(String pais, int numero) {
		return ranking.get(pais) + numero;
	}

	protected String[] generarPremiosParaSorteoInstantaneo() {
		return new String[]{
				"Una pelota","1 Sobre Gratis", "Una camiseta"
			};
	}

	private String[] generarPaisesClasificados() {
		return new String[]{ 
				"Alemania",   "Arabia Saudí",   "Argentina",          "Australia", 
				"Brasil",     "Bélgica",        "Camerún",            "Canadá", 
				"Costa Rica", "Croacia",        "Dinamarca",          "Ecuador",
				"España",     "Estados Unidos", "Francia",            "Gales",
				"Ghana",      "Inglaterra",     "Irán",               "Japón", 
				"Marruecos",  "México",         "Países Bajos",       "Polonia",
				"Portugal",   "Qatar",          "República de Corea", "Senegal", 
				"Serbia",     "Suiza",          "Túnez",              "Uruguay" 
			};
	}

	private String[] generarListadoDeMundiales() {
		return new String[] { 
				"España '82",    "México '86", "Italia '90",  "Estados Unidos '94",
				"Francia '98",   "Corea del Sur y Japón '02", "Alemania '06", 
				"Sudáfrica '10", "Brasil '14", "Rusia '18" };
	}

	private Map<String, String[]> generarPaisesPorMundial() {
		Map<String, String[]> ret = new HashMap<>();
		ret.put("España '82", new String[] { "Italia", "Brasil" });
		ret.put("México '86", new String[] { "Argentina", "Alemania" });
		ret.put("Italia '90", new String[] { "Italia", "Alemania" });
		ret.put("Estados Unidos '94", new String[] { "Brasil", "Italia" });
		ret.put("Francia '98", new String[] { "Brasil", "Croacia" });
		ret.put("Corea del Sur y Japón '02", new String[] { "Alemania", "Brasil" });
		ret.put("Alemania '06", new String[] { "Francia", "Italia" });
		ret.put("Sudáfrica '10", new String[] { "Uruguay", "Países Bajos" });
		ret.put("Brasil '14", new String[] { "Argentina", "Alemania" });
		ret.put("Rusia '18", new String[] { "Croacia", "Bélgica" });
		return ret;
	}
	
	
	//Agregamos 
	private HashMap<String, String[][]> generarJugadorPorMundial() {
		HashMap<String, String[][]> ret = new HashMap<>();
		ret.put("España '82", new String[][] { {"Paolo Rossi","20","Italia"}, {"Falcao","10","Brasil"}});
		ret.put("México '86", new String[][] { {"Diego Armando Maradonna","10","Argentina"}, {"Harald Schumacher","1","Alemania"}});
		ret.put("Italia '90", new String[][] { {"Salvatore Schillaci","16","Italia"}, {"Lothar Matthäus","4","Alemania"}});
		ret.put("Estados Unidos '94", new String[][] { {"Romario","10","Brasil"}, {"Roberto Baggio","10","Italia"}});
		ret.put("Francia '98", new String[][] { {"Ronaldo Nazario","9","Brasil"}, {"Davor Šuker","9","Croacia"}});
		ret.put("Corea del Sur y Japón '02", new String[][] { {"Oliver Khan","1","Alemania"}, {"Ronaldo Nazario","9","Brasil"}});
		ret.put("Alemania '06", new String[][] { {"Zinedine Zidane","10","Francia"}, {"Fabio Cannavaro","5","Italia"}});
		ret.put("Sudáfrica '10",new String[][] { {"Diego Forlan","10","Uruguay"}, {"Wesley Sneijder","8","Países Bajos"}});
		ret.put("Brasil '14", new String[][] { {"Lionel Andres Messi","10","Argentina"}, {"Thomas Müller","10","Alemania"}});
		ret.put("Rusia '18",  new String[][] { {"Luka Modric","10","Croacia"}, {"Eden Hazard","9","Bélgica"}});
		return ret;
	}
	
	private Map<String, Integer> generarRanking() {
		Map<String, Integer> ret = new HashMap<>();
		ret.put("Brasil",1);
		ret.put("Bélgica",2);
		ret.put("Argentina",3);
		ret.put("Francia",4);
		ret.put("Inglaterra",5);
		ret.put("Italia",6);
		ret.put("España",7);
		ret.put("Países Bajos",8);
		ret.put("Portugal",9);
		ret.put("Dinamarca",10);
		ret.put("Alemania",11);
		ret.put("Croacia",12);
		ret.put("México",13);
		ret.put("Uruguay",14);
		ret.put("Suiza",15);
		ret.put("Estados Unidos",16);
		ret.put("Colombia",17);
		ret.put("Senegal",18);
		ret.put("Gales",19);
		ret.put("Irán",20);
		ret.put("Serbia",21);
		ret.put("Marruecos",22);
		ret.put("Perú",23);
		ret.put("Japón",24);
		ret.put("Suecia",25);
		ret.put("Polonia",26);
		ret.put("Ucrania",27);
		ret.put("República de Corea",28);
		ret.put("Chile",29);
		ret.put("Túnez",30);
		ret.put("Costa Rica",31);
		ret.put("Nigeria",32);
		ret.put("Rusia",33);
		ret.put("Austria",34);
		ret.put("República Checa",35);
		ret.put("Hungría",36);
		ret.put("Argelia",37);
		ret.put("Australia",38);
		ret.put("Egipto",39);
		ret.put("Escocia",40);
		ret.put("Canadá",41);
		ret.put("Noruega",42);
		ret.put("Camerún",43);
		ret.put("Ecuador",44);
		ret.put("Turquía",45);
		ret.put("Mali",46);
		ret.put("Paraguay",47);
		ret.put("Costa de Marfil",48);
		ret.put("República de Irlanda",49);
		ret.put("Qatar",50);
		ret.put("Arabia Saudí",51);
		ret.put("Grecia",52);
		ret.put("Rumanía",53);
		ret.put("Burkina Faso",54);
		ret.put("Eslovaquia",55);
		ret.put("Finlandia",56);
		ret.put("Venezuela",57);
		ret.put("Bosnia y Herzegovina",58);
		ret.put("Irlanda del Norte",59);
		ret.put("Panamá",60);
		ret.put("Ghana",61);
		ret.put("Islandia",62);
		ret.put("Eslovenia",63);
		ret.put("Jamaica",64);
		ret.put("Macedonia del Norte",65);
		ret.put("Albania",66);
		ret.put("Sudáfrica",67);
		ret.put("Irak",68);
		ret.put("Montenegro",69);
		ret.put("Emiratos Árabes Unidos",70);
		ret.put("Cabo Verde",71);
		ret.put("Bulgaria",72);
		ret.put("RD del Congo",73);
		ret.put("El Salvador",74);
		ret.put("Omán",75);
		ret.put("Israel",76);
		ret.put("Uzbekistán",77);
		ret.put("Georgia",78);
		ret.put("RP China",79);
		ret.put("Honduras",80);
		ret.put("Gabón",81);
		ret.put("Bolivia",82);
		ret.put("Guinea",83);
		ret.put("Jordania",84);
		ret.put("Bahréin",85);
		ret.put("Curaçao",86);
		ret.put("Haití",87);
		ret.put("Zambia",88);
		ret.put("Uganda",89);
		ret.put("Siria",90);
		ret.put("Benín",91);
		ret.put("Luxemburgo",92);
		ret.put("Armenia",93);
		ret.put("Palestina",94);
		ret.put("República Kirguisa",95);
		ret.put("Vietnam",96);
		ret.put("Bielorrusia",97);
		ret.put("Guinea Ecuatorial",98);
		ret.put("Líbano",99);
		ret.put("Congo",100);
		ret.put("Kenia",101);
		ret.put("Madagascar",102);
		ret.put("Mauritania",103);
		ret.put("Trinidad y Tobago",104);
		ret.put("Nueva Zelanda",105);
		ret.put("India",106);
		ret.put("Kosovo",107);
		ret.put("Tayikistán",108);
		ret.put("Estonia",109);
		ret.put("Chipre",110);
		ret.put("Tailandia",111);
		ret.put("RDP de Corea",112);
		ret.put("Kazajstán",113);
		ret.put("Mozambique",114);
		ret.put("Namibia",115);
		ret.put("Guinea-Bissáu",116);
		ret.put("Sierra Leona",117);
		ret.put("Guatemala",118);
		ret.put("Angola",119);
		ret.put("Libia",120);
		ret.put("Níger",121);
		ret.put("Islas Feroe",122);
		ret.put("Azerbaiyán",123);
		ret.put("Malaui",124);
		ret.put("Zimbabue",125);
		ret.put("Gambia",126);
		ret.put("Togo",127);
		ret.put("Sudán",128);
		ret.put("Comoras",129);
		ret.put("Tanzania",130);
		ret.put("Antigua y Barbuda",131);
		ret.put("República Centroafricana",132);
		ret.put("Filipinas",133);
		ret.put("Letonia",134);
		ret.put("Turkmenistán",135);
		ret.put("Islas Salomón",136);
		ret.put("Ruanda",137);
		ret.put("Etiopía",138);
		ret.put("Surinam",139);
		ret.put("San Cristóbal y Nieves",140);
		ret.put("Burundi",141);
		ret.put("Nicaragua",142);
		ret.put("Esuatini",143);
		ret.put("Lituania",144);
		ret.put("Hong Kong",145);
		ret.put("Malasia",146);
		ret.put("Lesoto",147);
		ret.put("Botsuana",148);
		ret.put("Kuwait",149);
		ret.put("Liberia",150);
		ret.put("Andorra",151);
		ret.put("Indonesia",152);
		ret.put("República Dominicana",153);
		ret.put("Maldivas",154);
		ret.put("Yemen",155);
		ret.put("Afganistán",156);
		ret.put("Chinese Taipei",157);
		ret.put("Myanmar",158);
		ret.put("Papúa Nueva Guinea",159);
		ret.put("Singapur",160);
		ret.put("Nueva Caledonia",161);
		ret.put("Tahití",162);
		ret.put("Fiyi",163);
		ret.put("Vanuatu",164);
		ret.put("Sudán del Sur",165);
		ret.put("Barbados",166);
		ret.put("Cuba",167);
		ret.put("Malta",168);
		ret.put("Bermudas",169);
		ret.put("Puerto Rico",170);
		ret.put("Guyana",171);
		ret.put("Santa Lucía",172);
		ret.put("Granada",173);
		ret.put("Moldavia",174);
		ret.put("Nepal",175);
		ret.put("Belice",176);
		ret.put("Camboya",177);
		ret.put("San Vicente y las Granadinas",178);
		ret.put("Montserrat",179);
		ret.put("Mauricio",180);
		ret.put("Chad",181);
		ret.put("Macao",182);
		ret.put("Mongolia",183);
		ret.put("Dominica",184);
		ret.put("Bután",185);
		ret.put("Santo Tomé y Príncipe",186);
		ret.put("Laos",187);
		ret.put("Samoa Estadounidense",188);
		ret.put("Islas Cook",189);
		ret.put("Brunéi Darussalam",190);
		ret.put("Samoa",191);
		ret.put("Bangladesh",192);
		ret.put("Yibuti",193);
		ret.put("Pakistán",194);
		ret.put("Islas Caimán",195);
		ret.put("Liechtenstein",196);
		ret.put("Tonga",197);
		ret.put("Timor Oriental",198);
		ret.put("Seychelles",199);
		ret.put("Eritrea",200);
		ret.put("Aruba",201);
		ret.put("Bahamas",202);
		ret.put("Somalia",203);
		ret.put("Gibraltar",204);
		ret.put("Guam",205);
		ret.put("Turcas y Caicos",206);
		ret.put("Sri Lanka",207);
		ret.put("Islas Vírgenes Estadounidenses",208);
		ret.put("Islas Vírgenes Británicas",209);
		ret.put("Anguila",210);
		ret.put("San Marino",211);
		return ret;
	}

}

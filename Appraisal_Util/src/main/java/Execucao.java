import java.util.LinkedHashMap;
import java.util.List;


public class Execucao {
	
	private static final String SQL = "SELECT ip.id, ip.#bd_campo# FROM #bd_database_original#.#bd_table_original# ip where ip.id in ( "
			+ "SELECT t.id FROM #bd_database_alvo#_#bd_database_alvo_percentual#.#bd_table_alvo#_#bd_table_alvo_percentual# t where t.#bd_campo# is null) "
			+ " order by ip.id";
	
	private static final String SQL_2 = "SELECT ip.id, ip.#bd_campo# FROM #bd_database_original#.#bd_table_original# ip where ip.id in ( #idstrain# ) "
			+ " order by ip.id";
	
	private String id_ex;
	private String bd_campo;
	private String bd_database_original;
	private String bd_table_original;
	private String bd_database_alvo;
	private String bd_database_alvo_percentual;
	private String bd_table_alvo;
	private String bd_table_alvo_percentual;
	
	private LinkedHashMap<Long, Double> hashIdValor = new LinkedHashMap<Long, Double>();
	
	public Execucao(String id_ex, String bd_campo, String bd_database_original,
			String bd_table_original, String bd_database_alvo,
			String bd_database_alvo_percentual, String bd_table_alvo,
			String bd_table_alvo_percentual) {
		
		this.id_ex = id_ex;
		this.bd_campo = bd_campo;
		this.bd_database_original = bd_database_original;
		this.bd_table_original = bd_table_original;
		this.bd_database_alvo = bd_database_alvo;
		this.bd_database_alvo_percentual = bd_database_alvo_percentual;
		this.bd_table_alvo = bd_table_alvo;
		this.bd_table_alvo_percentual = bd_table_alvo_percentual;
		
	}
	
	public String getBaseSQL(){
		
		return SQL.replaceAll("#bd_campo#", bd_campo)
				.replaceAll("#bd_database_original#", bd_database_original)
				.replaceAll("#bd_table_original#", bd_table_original)
				.replaceAll("#bd_database_alvo#", bd_database_alvo)
				.replaceAll("#bd_database_alvo_percentual#", bd_database_alvo_percentual)
				.replaceAll("#bd_table_alvo#", bd_table_alvo)
				.replaceAll("#bd_table_alvo_percentual#", bd_table_alvo_percentual);
		
	}
	
	public String getBaseSQL2(List<String> ids){
		
		String idstrain = "";
		
		for(int i = 0; i < ids.size(); i++){
			
			if(i == 0)
				idstrain += ids.get(i);
			
			else
				idstrain += " ," + ids.get(i);
			
		}
		
		return SQL_2.replaceAll("#bd_campo#", bd_campo)
				.replaceAll("#bd_database_original#", bd_database_original)
				.replaceAll("#bd_table_original#", bd_table_original)
				.replaceAll("#idstrain#", idstrain);
		
	}
	
	public String getBd_campo() {
		return bd_campo;
	}
	public void setBd_campo(String bd_campo) {
		this.bd_campo = bd_campo;
	}
	public String getBd_database_original() {
		return bd_database_original;
	}
	public void setBd_database_original(String bd_database_original) {
		this.bd_database_original = bd_database_original;
	}
	public String getBd_table_original() {
		return bd_table_original;
	}
	public void setBd_table_original(String bd_table_original) {
		this.bd_table_original = bd_table_original;
	}
	public String getBd_database_alvo() {
		return bd_database_alvo;
	}
	public void setBd_database_alvo(String bd_database_alvo) {
		this.bd_database_alvo = bd_database_alvo;
	}
	public String getBd_database_alvo_percentual() {
		return bd_database_alvo_percentual;
	}
	public void setBd_database_alvo_percentual(String bd_database_alvo_percentual) {
		this.bd_database_alvo_percentual = bd_database_alvo_percentual;
	}
	public String getBd_table_alvo() {
		return bd_table_alvo;
	}
	public void setBd_table_alvo(String bd_table_alvo) {
		this.bd_table_alvo = bd_table_alvo;
	}
	public String getBd_table_alvo_percentual() {
		return bd_table_alvo_percentual;
	}
	public void setBd_table_alvo_percentual(String bd_table_alvo_percentual) {
		this.bd_table_alvo_percentual = bd_table_alvo_percentual;
	}

	public LinkedHashMap<Long, Double> getHashIdValor() {
		return hashIdValor;
	}

	public void setHashIdValor(LinkedHashMap<Long, Double> hashIdValor) {
		this.hashIdValor = hashIdValor;
	}

	public String getId_ex() {
		return id_ex;
	}

	public void setId_ex(String id_ex) {
		this.id_ex = id_ex;
	}
	
}

package projetoEda;


public class Casos {
	private String date = new String();
	private String state = new String();
	private String city = new String();
	private String place_type = new String() ;
	private int confirmed;
	private int deaths;
	private String order_for_place;
	private boolean is_last;
	private int estimated_population_2019;
	private int estimated_population;
	private int city_ibge_code;
	private double confirmed_per_100k_inhabitants;
	private double death_rate;
	
	
	Casos(){
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	public String getDate() {
		return date;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return state;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	public String getCity() {
		return city;
	}
	
	public void setPlaceType(String place_type) {
		this.place_type = place_type;
	}
	public String getPlaceType() {
		return place_type;
	}
	
	public void setConfirmed(String confirmed) {
		this.confirmed = Integer.parseInt(confirmed);
	}
	public int getConfirmed() {
		return confirmed;
	}
	
	public void setDeaths(String deaths) {
		this.deaths = Integer.parseInt(deaths);
	}
	public int getDeaths() {
		return deaths;
	}
	
	public void setOrderForPlace(String order_for_place) {
		this.order_for_place = order_for_place;
	}
	public String getOrderForPlace() {
		return order_for_place;
	}
	
	public void setIsLast(String is_last) {
		this.is_last = Boolean.parseBoolean(is_last);
	}
	public boolean getIsLast() {
		return is_last;
	}
	
	public void setEstimatedPop(String estimated_population_2019) {
		this.estimated_population_2019 = Integer.parseInt(estimated_population_2019);	
	}
	
	public int getEstimatedPop() {
		return estimated_population_2019;
	}
	
	public void setEstimatedPopNow(String estimated_population) {
		this.estimated_population = Integer.parseInt(estimated_population);
	}
	public int getEstimatedPopNow() {
		return estimated_population;
	}
	
	public void setCityIbgeCode(String city_ibge_code) {
		this.city_ibge_code = Integer.parseInt(city_ibge_code);
	}
	public int getCityIbgeCode() {
		return city_ibge_code;
	}
	
	public void setConfirmedHundred(String confirmed_per_100k_inhabitants) {
		this.confirmed_per_100k_inhabitants = Double.parseDouble(confirmed_per_100k_inhabitants);
	}
	public double getConfirmedHundred() {
		return confirmed_per_100k_inhabitants;
	}
	
	public void setDeathRate(String death_rate) {
		this.death_rate = Double.parseDouble(death_rate);
	}
	public double getDeathRate() {
		return death_rate;
	}
	
	
	public String toString() {
		return this.getDate() + "," + this.getState() + "," + this.getCity() + "," + this.getPlaceType() + "," + this.getConfirmed()
		+ "," + this.getDeaths() + "," + this.getOrderForPlace() + "," + this.getIsLast() + "," + this.getEstimatedPop() + "," 
		+ this.getEstimatedPopNow() + "," + this.getCityIbgeCode() + "," + this.getConfirmedHundred() + "," + this.getDeathRate();
	}
	
}

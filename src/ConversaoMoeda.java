import java.util.Map;

public class ConversaoMoeda {
    private String base_code;
    private Map<String, Double> conversion_rates;

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public Map<String, Double> getTaxasDeCambio() {
        return conversion_rates;
    }

    public void setTaxasDeCambio(Map<String, Double> taxasDeCambio) {
        this.conversion_rates = taxasDeCambio;
    }

}

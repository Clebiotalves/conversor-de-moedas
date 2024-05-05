import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

public class ConversorMoeda {
    private static final String baseURL = "https://v6.exchangerate-api.com/v6/51c7706078aff416524d5e89/";

    private final Gson gson;
    private final Map<String, Double> taxasDeCambio;

    public ConversorMoeda() {
        this.gson = new Gson();
        this.taxasDeCambio = new HashMap<>();
    }

    public void carregarTaxasDeCambio() {
        String json = ConsumoApi.obterDados(baseURL + "latest/BRL");
        ConversaoMoeda conversaoMoeda = gson.fromJson(json, ConversaoMoeda.class);
        taxasDeCambio.putAll(conversaoMoeda.getTaxasDeCambio());
    }

    public void mostrarMoedasDisponiveis() {
        System.out.println(taxasDeCambio.keySet());
    }

    public double converterDeBRLparaUSD(double valor) {
        if (taxasDeCambio.containsKey("USD")) {
            return valor * taxasDeCambio.get("USD");
        } else {
            System.out.println("Moeda USD não encontrada.");
            return -1;
        }
    }

    public double converterDeUSDparaBRL(double valor) {
        if (taxasDeCambio.containsKey("USD")) {
            return valor / taxasDeCambio.get("USD");
        } else {
            System.out.println("Moeda USD não encontrada.");
            return -1;
        }
    }


    public double converterDeBRLparaEUR(double valor) {
        if (taxasDeCambio.containsKey("EUR")) {
            return valor * taxasDeCambio.get("EUR");
        } else {
            System.out.println("Moeda EUR não encontrada.");
            return -1;
        }
    }

    public double converterDeEURparaBRL(double valor) {
        if (taxasDeCambio.containsKey("EUR")) {
            return valor / taxasDeCambio.get("EUR");
        } else {
            System.out.println("Moeda EUR não encontrada.");
            return -1;
        }
    }

    public double converter(double valor, String moedaOrigem, String moedaDestino) {
        if (taxasDeCambio.containsKey(moedaOrigem) && taxasDeCambio.containsKey(moedaDestino)) {
            double taxaOrigem = taxasDeCambio.get(moedaOrigem);
            double taxaDestino = taxasDeCambio.get(moedaDestino);
            return valor * (1 / taxaOrigem) * taxaDestino;
        } else {
            System.out.println("Moeda de origem ou destino não encontrada.");
            return -1;
        }
    }
}


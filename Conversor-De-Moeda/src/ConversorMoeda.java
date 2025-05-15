import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import java.util.Map;

public class ConversorMoeda {

    private static final String API_KEY = "506fcd6b063831195c002e34";

    public static void converter(String moedaOrigem, String moedaDestino, double valor) {
        try {
            String urlStr = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + moedaOrigem;
            URL url = new URL(urlStr);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            StringBuilder resposta = new StringBuilder();
            String linha;
            while ((linha = reader.readLine()) != null) {
                resposta.append(linha);
            }
            reader.close();

            Gson gson = new Gson();
            Map<String, Object> json = gson.fromJson(resposta.toString(), Map.class);

            if ("success".equals(json.get("result"))) {
                Map<String, Double> taxas = (Map<String, Double>) json.get("conversion_rates");
                double taxa = taxas.get(moedaDestino);
                double convertido = valor * taxa;
                System.out.printf(" %.2f %s = %.2f %s\n", valor, moedaOrigem, convertido, moedaDestino);
            } else {
                System.out.println("Erro ao obter taxas de câmbio.");
            }

        } catch (Exception e) {
            System.out.println("Erro na requisição: " + e.getMessage());
        }
    }
}

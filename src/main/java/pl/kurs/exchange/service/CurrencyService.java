package pl.kurs.exchange.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CurrencyService {
    private final ObjectMapper mapper;
    private final String baseUrl = "https://api.nbp.pl/api/exchangerates/rates/";
    private JsonNode node;

    public CurrencyService(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public static void main(String[] args) throws IOException {
        CurrencyService cs = new CurrencyService(new ObjectMapper());
        System.out.println(cs.moreValuedCurrency("eur", "gbp", "2022-08-01", "2022-08-31"));
        System.out.println(cs.highestRatePeriod("gbp", "2022-01-01", "2022-08-31"));
        System.out.println(cs.averagetRatePeriod("gbp", "2022-01-01", "2022-08-31"));
        System.out.println(cs.lowestRatePeriod("gbp", "2022-01-01", "2022-08-31"));
    }


    public String moreValuedCurrency(String currency1, String currency2, String startDate, String endDate) throws IOException {
        URL url1 = new URL(baseUrl + "A/" + currency1 + "/" + startDate + "/" + endDate + "/?format=json");
        URL url2 = new URL(baseUrl + "A/" + currency2 + "/" + startDate + "/" + endDate + "/?format=json");

        node = mapper.readTree(url1);
        double currency1Deviation = node.get("rates").get(node.size()).get("mid").asDouble() - node.get("rates").get(0).get("mid").asDouble();

        node = mapper.readTree(url2);
        double currency2Deviation = node.get("rates").get(node.size()).get("mid").asDouble() - node.get("rates").get(0).get("mid").asDouble();

        return currency1Deviation > currency2Deviation ? currency1 : currency2;
    }


    public String highestRatePeriod(String currency, String startDate, String endDate) throws IOException {
        URL url = new URL(baseUrl + "A/" + currency + "/" + startDate + "/" + endDate + "/?format=json");
        node = mapper.readTree(url);

        return StreamSupport.stream(node.get("rates").spliterator(), false)
                .max(Comparator.comparingDouble(a -> a.get("mid").asDouble()))
                .orElseThrow()
                .get("mid").asText();
    }

    public double averagetRatePeriod(String currency, String startDate, String endDate) throws IOException {
        URL url = new URL(baseUrl + "A/" + currency + "/" + startDate + "/" + endDate + "/?format=json");
        node = mapper.readTree(url);

        return StreamSupport.stream(node.get("rates").spliterator(), false)
                .collect(Collectors.averagingDouble(a -> a.get("mid").asDouble()));
    }

    public String lowestRatePeriod(String currency, String startDate, String endDate) throws IOException {
        URL url = new URL(baseUrl + "A/" + currency + "/" + startDate + "/" + endDate + "/?format=json");
        node = mapper.readTree(url);

        return StreamSupport.stream(node.get("rates").spliterator(), false)
                .min(Comparator.comparingDouble(a -> a.get("mid").asDouble()))
                .orElseThrow()
                .get("mid").asText();
    }
}

//package pl.kurs.exchange.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import sun.jvm.hotspot.oops.ObjArray;
//
//import java.io.IOException;
//import java.io.Reader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.Date;
//
//public class NbpApiController {
//    private final String baseUrl = "http://api.nbp.pl/api/exchangerates/rates";
//    private final Reader streamReader= null;
//
//
//    public String fetchNbpRates(String table, String code) throws IOException {
//        URL url = new URL(baseUrl + "/table" + "/code");
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestMethod("GET");
//
//    }
//
//    public String fetchNbpRates(String table, String code, Date date){
//
//    }
//
//    public String fetchNbpRates(String table, String code, Date startDate, Date endDate){
//
//    }
//
//}

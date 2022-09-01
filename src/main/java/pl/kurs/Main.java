package pl.kurs;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.kurs.model.Auto;
import pl.kurs.model.Car;
import pl.kurs.model.Club;
import pl.kurs.model.DateKeeper;
import pl.kurs.model.Equipment;
import pl.kurs.model.Kid;
import pl.kurs.model.ObjectMapperHolder;
import pl.kurs.model.Person;
import pl.kurs.model.Soundcloud;
import pl.kurs.service.ServiceClub;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static final String PATH = "src/main/resources/";

    public static void main(String[] args) throws IOException {

       // ObjectMapper objectMapper = new ObjectMapper();
        ObjectMapper objectMapper = ObjectMapperHolder.INSTANCE.getMapper();
        // unmarshalling, deserializacja
        // wczytanie obiektu z jsona
        Person adamNowak = objectMapper.readValue(new File(PATH + "adamnowak.json"), Person.class);

        System.out.println(adamNowak);

        // marshalling, serializacja
        // zapisanie obiektu do jsona

        Kid kid1 = new Kid("Jola", "Nowak", 5);
        Kid kid2 = new Kid("Ala", "Nowak", 5);
        Kid kid3 = new Kid("Ola", "Nowak", 5);
        Person person1 = new Person("Krzysztof", "Kowalski", 31,
                true, Arrays.asList("Sport", "Nauka"), Arrays.asList(kid1, kid2, kid3));

        objectMapper.writeValue(new File(PATH + "krzyskowalski.json"), person1);


        new ObjectMapper().writeValue(new File(PATH + "dziecikowalskiego.json"), Arrays.asList(kid1, kid2, kid3));

        List<Kid> kidList3 = objectMapper.readValue(new File(PATH + "dziecikowalskiego.json"), new TypeReference<List<Kid>>() {});
        System.out.println(kidList3.get(2).getAge());


        // zapisanie obiektu java jako jsonowy string
        Kid k2 = new Kid("Franek", "Kwiatkowski", 11);
        String kidJsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(k2);
        System.out.println(k2);
        System.out.println(kidJsonString);

        // utworzenie obiektu na podstawie stringa z jsonem
        String kidJson = "{\"firstName\":\"Franek\",\"lastName\":\"Kwiatkowski\",\"age\":11}";
        Kid kidFromString = objectMapper.readValue(kidJson, Kid.class);

        // https://soundcloud.com/oembed?url=http%3A//soundcloud.com/forss/flickermood&format=json
//        URL url = new URL("https://soundcloud.com/oembed?url=http%3A//soundcloud.com/forss/flickermood&format=json");
//        Soundcloud sc = objectMapper.readValue(url, Soundcloud.class);
//        System.out.println(sc);

        //Stwórz jsona z samochodem, samochod ma marke, model, pojemnosc silnika, info czy ma turbo oraz liste wyposazen
        //wyposazenie ma nazwe i cene
        Equipment equipment1 = new Equipment("Radio", 500.0);
        Equipment equipment2 = new Equipment("GPS", 1500.0);
        Equipment equipment3 = new Equipment("Otwierany dach", 2500.0);
        Equipment equipment4 = new Equipment("skurzane fotele", 5000.0);

        Car car1 =  new Car("VW", "Passat", 1.9, true, Arrays.asList(equipment1,equipment2));
        Car car2 =  new Car("Opel", "Zafira", 1.5, false, Arrays.asList(equipment1,equipment2,equipment3));
        Car car3 =  new Car("Mercedes", "AMG", 3.0, true, Arrays.asList(equipment1,equipment2,equipment3,equipment4));

        objectMapper.writeValue(new File(PATH + "car1.json"), car1);
        objectMapper.writeValue(new File(PATH + "car2.json"), car2);
        objectMapper.writeValue(new File(PATH + "car3.json"), car3);

        List<Car> carList = new ArrayList<>();
        carList.add(objectMapper.readValue(new File(PATH +"car1.json"), Car.class));
        carList.add(objectMapper.readValue(new File(PATH +"car2.json"), Car.class));
        carList.add(objectMapper.readValue(new File(PATH +"car3.json"), Car.class));

        System.out.println(Car.getTheMostExpensiveCar(carList));



        //Stwórz 3 jsony z informacjami o autach, nastepnie wcyztaj je i wrzuc na liste i znajdz najdrozsze auto (na podstawie wyspoazenia)
        //Stwórz obiekt samochod i zapisz go do formatu json

        // https://www.pieknoodreki.pl/api/club1 club2, club3
        // wczytac je jako obiekty i znalezc najstarszy klub  + klasy serwisowe

        URL url1 = new URL(" https://www.pieknoodreki.pl/api/club1");
        URL url2 = new URL(" https://www.pieknoodreki.pl/api/club2");
        URL url3 = new URL(" https://www.pieknoodreki.pl/api/club3");
//
        Club club1 = objectMapper.readValue(url1,Club.class);
        Club club2 = objectMapper.readValue(url2,Club.class);
        Club club3 = objectMapper.readValue(url3,Club.class);

        System.out.println(ServiceClub.getTheOldestClub(Club.getExtensionList()));


        DateKeeper dk = new DateKeeper(new Date(86_400_000L * 19_000L));
        objectMapper.writeValue(new File(PATH+"data.json"), dk);

        // JSON NODE

        // zamiana jsonowego stringa w json node'a
        String json = "{\"firstName\":\"Franek\",\"lastName\":\"Kwiatkowski\",\"age\":11}";
        JsonNode jsonNode = objectMapper.readTree(json);
        System.out.println(jsonNode.get("firstName").asText());
        System.out.println(jsonNode.get("age").asInt());

        System.out.println(jsonNode);
        System.out.println(jsonNode.toPrettyString());

        // zamiana jsn nodea na stringa
        String stringFromJsonNode = jsonNode.toString();
        System.out.println(stringFromJsonNode);

        // zamiana obiektu java na json nodea'
        Kid kid5 = new Kid("Franek", "Krzyskowski", 15);
        JsonNode kidJsonNode = objectMapper.valueToTree(kid5);
        System.out.println(kidJsonNode);

        // zamiana JsonNodea na obiket java
        Kid kidFromJsonNode = objectMapper.treeToValue(kidJsonNode, Kid.class);
        System.out.println(kidFromJsonNode);

        // zapisanie jsonnoda do pliku
        objectMapper.writeValue(new File(PATH+"knode.json"), kidJsonNode);

        Auto auto = new Auto("Polonez", 4);
        objectMapper.writeValue(new File(PATH+"polonez.json"), auto);

        Auto auto1 = objectMapper.readValue(new File(PATH+"polonez.json"), Auto.class);
        System.out.println(auto1);

        /*
            Stworz klase ksiazka ktora ma autora, tytul, kategorie, cene.
            STworz kilka obiektów i zapisz je jako json nody a nastepnie zapisz je jako plik jsonowy.
            Wczytaj nastepnie ktoras ksiazke jako obiekt i wyswietl jej wartosci
         */

        // Stwórz klase Person (name, surname, age) i uzyj serializerow i deserializerow do odczytu i zapisu.
        // name = imie, surname = nazwisko age= wiek

        // http://api.nbp.pl/api/exchangerates/rates/c/usd/2016-04-04/?format=json

        //  http://api.nbp.pl/api/exchangerates/rates/a/gbp/last/10/?format=json

        /*
            napisz srwis dla kursow, przykladowe metody:
            co lepiej byloby kupic od daty do daty (na cyzm bysmy lepiej zarobili, np czy euro czy dolary)
            znalezc najwiekszy kurs w zakresie dat np dla euro czy dolara
            znalezc srednia srednich kursow GBP
            znalezx max i min sredni kurs GBP

            rozwinac apke: )
         */

    }
    
}


package pl.kurs.service;

import pl.kurs.model.Club;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ServiceClub {

    public static Club getTheOldestClub(List<Club> clubList) {
        return Optional.ofNullable(clubList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparingInt(Club::getYear))
                .orElseThrow(() -> new IllegalArgumentException("error"));

    }
}

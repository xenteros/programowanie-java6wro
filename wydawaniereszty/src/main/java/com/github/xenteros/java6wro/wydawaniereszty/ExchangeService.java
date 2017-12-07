package com.github.xenteros.java6wro.wydawaniereszty;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExchangeService {

    public static Map<NominalValue, Integer> getExchange(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amont mustn't be negative");
        }
        NominalValue[] nominalValues = NominalValue.values();
        int i = nominalValues.length - 1;
        List<String> nominalNames = Arrays.stream(nominalValues)
                .map(NominalValue::name)
                .collect(Collectors.toList());

        Map<NominalValue, Integer> result = new EnumMap<NominalValue, Integer>(NominalValue.class);

        while (amount > 0) {
            if (nominalValues[i].getValue() > amount) {
                i--;
            } else {
                if (result.containsKey(nominalValues[i])) {
                    result.put(nominalValues[i], result.get(nominalValues[i]) + 1);
                } else {
                    result.put(nominalValues[i], 1);
                }
                amount -= nominalValues[i].getValue();
            }
        }
        return result;
    }
}

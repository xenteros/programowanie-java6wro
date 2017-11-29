package com.github.xenteros.java6wro.wydawaniereszty;

import java.util.EnumMap;
import java.util.Map;

public class ExchangeService {

    public static Map<NominalValue, Integer> getExchange(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amont mustn't be negative");
        }
        NominalValue[] nominalValues = NominalValue.values();
        int i = nominalValues.length - 1;

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

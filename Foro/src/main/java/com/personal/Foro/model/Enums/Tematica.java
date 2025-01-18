package com.personal.Foro.model.Enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Tematica {
   JAVA,
    HTML,
    CSS,
    JAVASCRIPT,
INSOMNIA,
POSTMAN,
VARIABLES_DE_ENTORNO;

    // Método para convertir List<Enum> a un String separado por comas
    public static String listaAString(List<Tematica> Tematicas) {
        return Tematicas.stream()
                .map(Tematica::name)  // Convierte cada enum a su nombre (String)
                .collect(Collectors.joining(","));  // Une los nombres con una coma
    }

    // Método para convertir String de nuevo a List<Enum>
    public static List<Tematica> stringALista(String TematicasString) {
        return Arrays.stream(TematicasString.split(","))
                .map(Tematica::valueOf)  // Convierte cada nombre a un valor de enum
                .collect(Collectors.toList());
    }
    }


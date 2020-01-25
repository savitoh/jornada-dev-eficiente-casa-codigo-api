package com.savitoh.casacodigoapi.util;

import java.text.Normalizer;
import java.util.Objects;


public final class StringUtils {

    /**
     * Código copiado do GIST https://gist.github.com/rponte/893494
     * @param value String a ser removido os acentos e caracteres especiais.
     * @return String sem acentos e caracteres especiais.
     */
    public static String removeAcentos(final String value) {
        if(Objects.isNull(value)) {
            throw new IllegalArgumentException("");
        }
        return Normalizer
                .normalize(value, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }
}

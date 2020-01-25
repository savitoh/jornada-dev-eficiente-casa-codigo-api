package com.savitoh.casacodigoapi;

import com.savitoh.casacodigoapi.util.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Classe copiada do GIST https://gist.github.com/rponte/893494
 */
public class StringUtilsUnitTest {

    private static final String accents 	= "È,É,Ê,Ë,Û,Ù,Ï,Î,À,Â,Ô,è,é,ê,ë,û,ù,ï,î,à,â,ô,Ç,ç,Ã,ã,Õ,õ";
    private static final String expected	= "E,E,E,E,U,U,I,I,A,A,O,e,e,e,e,u,u,i,i,a,a,o,C,c,A,a,O,o";

    private static final String accents2	= "çÇáéíóúýÁÉÍÓÚÝàèìòùÀÈÌÒÙãõñäëïöüÿÄËÏÖÜÃÕÑâêîôûÂÊÎÔÛ";
    private static final String expected2	= "cCaeiouyAEIOUYaeiouAEIOUaonaeiouyAEIOUAONaeiouAEIOU";

    private static final String accents3	= "Gisele Bündchen da Conceição e Silva foi batizada assim em homenagem à sua conterrânea de Horizontina, RS.";
    private static final String expected3	= "Gisele Bundchen da Conceicao e Silva foi batizada assim em homenagem a sua conterranea de Horizontina, RS.";

    private static final String accents4	= "/Users/rponte/arquivos-portalfcm/Eletron/Atualização_Diária-1.23.40.exe";
    private static final String expected4	= "/Users/rponte/arquivos-portalfcm/Eletron/Atualizacao_Diaria-1.23.40.exe";

    @Test
    public void replacingAllAccents() {
        assertEquals(expected,  StringUtils.removeAcentos(accents));
        assertEquals(expected2, StringUtils.removeAcentos(accents2));
        assertEquals(expected3, StringUtils.removeAcentos(accents3));
        assertEquals(expected4, StringUtils.removeAcentos(accents4));
    }
}

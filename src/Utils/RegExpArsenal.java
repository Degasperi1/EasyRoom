/*
 * ARQUIVO DE CONSTANTES COM REGEXP DISPONÍVEIS
 */
package Utils;

/**
 *
 * @author evand
 */
public abstract class RegExpArsenal {
    // CONSTANTES
    public static final String TIMESTAMP = "[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1]) (2[0-3]|[01][0-9]):[0-5][0-9]:[0-5][0-9]";
    public static final String ERROR_WARN = "\\bERROR|\\bWARN";
    public static final String VALUE_AFTER = " -(.*)$";
    public static final String VALUE_AFTER_ALTERNATE = "(?<=\\ -).*";
}

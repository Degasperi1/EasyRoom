/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author evandro
 */
public class LogUtils {

    // Patterns para as RegExp
    private static Pattern pTimestamp = Pattern.compile(RegExpArsenal.TIMESTAMP);
    private static Pattern pErrorstype = Pattern.compile(RegExpArsenal.ERROR_WARN);
    private static Pattern pMessage = Pattern.compile(RegExpArsenal.VALUE_AFTER_ALTERNATE);

    private static List<String> readFileLines(String fileName) {
        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            list = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<LogData> getLogs(String filename, String criteria) {

        List<String> linhas = LogUtils.readFileLines(filename);
        ArrayList<LogData> retorno = new ArrayList<>();

        for (String linha : linhas) {
            String mensagem = "";
            String errorType = "";
            String timestamp = "";
            Matcher mMessage = pMessage.matcher(linha);
            if (mMessage.find()) {
                mensagem = mMessage.group(0);
            }
            Matcher mErrorsType = pErrorstype.matcher(linha);
            if (mErrorsType.find()) {
                errorType = mErrorsType.group(0);
            }
            Matcher mTimestamp = pTimestamp.matcher(linha);
            if (mTimestamp.find()) {
                timestamp = mTimestamp.group(0);
            }
            if (mensagem.contains(criteria) && !errorType.equals("")
                    && !timestamp.equals("")) {
                LogUtils.LogData log = new LogUtils.LogData();
                log.setMessage(mensagem);
                log.setTimestamp(timestamp);
                log.setType(errorType);

                retorno.add(log);
            }
        }
        return retorno;
    }

    public static ArrayList<LogData> getLogs(String filename, String criteria, String tipoErro, String dataInicial, String dataFinal) {

        List<String> linhas = LogUtils.readFileLines(filename);
        ArrayList<LogData> retorno = new ArrayList<>();

        for (String linha : linhas) {
            //sempre zerando as partes da linha para não replicar
            String mensagem = "";
            String timestamp = "";
            String errorType = "";
            LogUtils.LogData log = new LogUtils.LogData();
            //EXTRAIO TODAS INFORMAÇÕES DA LINHA COM REGEXP
            Matcher mMessage = pMessage.matcher(linha);
            if (mMessage.find()) {
                mensagem = mMessage.group(0);
            }

            Matcher mTimestamp = pTimestamp.matcher(linha);
            if (mTimestamp.find()) {
                timestamp = mTimestamp.group(0);
            }

            Matcher mErrorsType = pErrorstype.matcher(linha);
            if (mErrorsType.find()) {
                errorType = mErrorsType.group(0);
            }

            if (!mensagem.equals("") && !timestamp.equals("") && !errorType.equals("")) {//verifica se a linha está ok, se possui tipo de erro, timestamp, mensagem...
                LocalDate logdate = LocalDate.parse(timestamp.substring(0, timestamp.indexOf(" ")));
                if (!dataInicial.equals("") && dataFinal.equals("")) { // Caso 1
                    LocalDate dInicial = LocalDate.parse(dataInicial);
                    if (mensagem.contains(criteria) && errorType.equals(tipoErro)
                            && logdate.isAfter(dInicial)) { // && VERIFICAR TAMBÉM A DATA
                        log.setType(errorType);
                        log.setTimestamp(timestamp);
                        log.setMessage(mensagem);
                        retorno.add(log);
                    }
                } else if (dataInicial.equals("") && !dataFinal.equals("")) { // Caso 2
                    LocalDate dFinal = LocalDate.parse(dataFinal);
                    if (mensagem.contains(criteria) && errorType.equals(tipoErro)
                            && logdate.isBefore(dFinal)) {// && VERIFICAR TAMBÉM A DATA
                        log.setType(errorType);
                        log.setTimestamp(timestamp);
                        log.setMessage(mensagem);
                        retorno.add(log);
                    }
                } else if (!dataInicial.equals("") && !dataFinal.equals("")) { // Caso 3
                    LocalDate dInicial = LocalDate.parse(dataInicial);
                    LocalDate dFinal = LocalDate.parse(dataFinal);
                    if (mensagem.contains(criteria) && errorType.equals(tipoErro)
                            && DateUtils.isBetween(dInicial, dFinal, logdate)) {// && VERIFICAR TAMBÉM A DATA
                        log.setType(errorType);
                        log.setTimestamp(timestamp);
                        log.setMessage(mensagem);
                        retorno.add(log);
                    }
                } else if (dataInicial.equals("") && dataFinal.equals("")) { // Caso 4
                    if (mensagem.contains(criteria) && errorType.equals(tipoErro)) {
                        log.setType(errorType);
                        log.setTimestamp(timestamp);
                        log.setMessage(mensagem);
                        retorno.add(log);
                    }
                }
            }
        }
        return retorno;
    }

    // PARA REFATORAR O CÓDIGO E DIMINUIR A REPETIÇÃO
    private static LogData montaInfoLog() {
        return null;
    }

    public static class LogData {

        private String type;
        private String timestamp;
        private String message;

        public LogData(String type, String timestamp, String message) {
            this.type = type;
            this.timestamp = timestamp;
            this.message = message;
        }

        public LogData() {
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }
}

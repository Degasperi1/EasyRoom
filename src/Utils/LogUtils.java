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
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author evandro
 */
public class LogUtils {

    private static final int MIN_LINE_SIZE = 80;

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
            if (linha.length() > MIN_LINE_SIZE) { //verifica pra ver se o tamanho bate
                //OBJETO PARA POPULAR
                LogUtils.LogData log = new LogUtils.LogData();
                String[] splitted = linha.trim().split(" ");

                //PREPARANDO A MENSAGEM TÉCNICA
                StringBuilder sb = new StringBuilder("");
                for (int i = 3; i < splitted.length - 10; i++) {
                    sb.append(splitted[i]).append(" ");
                }
                //POSSO TESTAR AGORA PRA VER SE CABE DENTRO DO CRITÉRIO ENVIADO
                if (sb.toString().contains(criteria)) {

                    log.setType(splitted[0]);
                    log.setTimestamp(splitted[1] + " " + splitted[2]);
                    log.setMessage(sb.toString());
                    retorno.add(log);
                }
            }

        }
        return retorno;
    }

    public static ArrayList<LogData> getLogs(String filename, String criteria, String tipoErro) {

        List<String> linhas = LogUtils.readFileLines(filename);
        ArrayList<LogData> retorno = new ArrayList<>();
        for (String linha : linhas) {
            if (linha.length() > MIN_LINE_SIZE) { //verifica pra ver se o tamanho bate
                //OBJETO PARA POPULAR
                LogUtils.LogData log = new LogUtils.LogData();
                String[] splitted = linha.trim().split(" ");

                //PREPARANDO A MENSAGEM TÉCNICA
                StringBuilder sb = new StringBuilder("");
                for (int i = 3; i < splitted.length - 10; i++) {
                    sb.append(splitted[i]).append(" ");
                }
                if (sb.toString().contains(criteria) && splitted[0].equals(tipoErro)) {

                    log.setType(splitted[0]);
                    log.setTimestamp(splitted[1] + " " + splitted[2]);
                    log.setMessage(sb.toString());
                    retorno.add(log);
                }
            }
        }
        return retorno;
    }

    // EM PRODUÇÃO
    public static ArrayList<LogData> getLogs(String filename, String criteria, String tipoErro, String dataInicial, String dataFinal) {

        List<String> linhas = LogUtils.readFileLines(filename);
        ArrayList<LogData> retorno = new ArrayList<>();

        for (String linha : linhas) {
            if (linha.length() > MIN_LINE_SIZE) {
                LogUtils.LogData log = new LogUtils.LogData();
                String[] splitted = linha.trim().split(" ");

                // MENSAGEM TÉCNICA
                StringBuilder sb = new StringBuilder("");
                for (int i = 3; i < splitted.length - 10; i++) {
                    sb.append(splitted[i]).append(" ");
                }

                // A Data do arquivo se encontra em -> splitted[1] <-
                LocalDate logdate = LocalDate.parse(splitted[1]);
                if (!dataInicial.equals("") && dataFinal.equals("")) { // Caso 1
                    LocalDate dInicial = LocalDate.parse(dataInicial);
                    if (sb.toString().contains(criteria) && splitted[0].equals(tipoErro)
                            && logdate.isAfter(dInicial)) { // && VERIFICAR TAMBÉM A DATA
                        log.setType(splitted[0]);
                        log.setTimestamp(splitted[1] + " " + splitted[2]);
                        log.setMessage(sb.toString());
                        retorno.add(log);
                    }
                } else if (dataInicial.equals("") && !dataFinal.equals("")) { // Caso 2
                    LocalDate dFinal = LocalDate.parse(dataFinal);
                    if (sb.toString().contains(criteria) && splitted[0].equals(tipoErro)
                            && logdate.isBefore(dFinal)) {// && VERIFICAR TAMBÉM A DATA
                        log.setType(splitted[0]);
                        log.setTimestamp(splitted[1] + " " + splitted[2]);
                        log.setMessage(sb.toString());
                        retorno.add(log);
                    }
                } else if (!dataInicial.equals("") && !dataFinal.equals("")) { // Caso 3
                    LocalDate dInicial = LocalDate.parse(dataInicial);
                    LocalDate dFinal = LocalDate.parse(dataFinal);
                    if (sb.toString().contains(criteria) && splitted[0].equals(tipoErro)
                            && DateUtils.isBetween(dInicial, dFinal, logdate)) {// && VERIFICAR TAMBÉM A DATA
                        log.setType(splitted[0]);
                        log.setTimestamp(splitted[1] + " " + splitted[2]);
                        log.setMessage(sb.toString());
                        retorno.add(log);
                    }
                } else if (dataInicial.equals("") && dataFinal.equals("")) { // Caso 4
                    if (sb.toString().contains(criteria) && splitted[0].equals(tipoErro)) {
                        log.setType(splitted[0]);
                        log.setTimestamp(splitted[1] + " " + splitted[2]);
                        log.setMessage(sb.toString());
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

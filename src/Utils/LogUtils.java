/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
                //POSSO TESTAR AGORA PRA VER SE CABE DENTRO DO CRITÉRIO ENVIADO
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

//EM PRODUÇÂO
//    public static ArrayList<LogData> getLogsBetweenDates(String filename, String criteria, String date1, String date2) {
//
//        ArrayList<LogUtils.LogData> logs = LogUtils.getLogs(filename, "");//PEGA TODOS OS LOGS
//        ArrayList<LogUtils.LogData> retorno = new ArrayList<>();
//        //MONTA COM APENAS AS DATAS ENTRE date1 e date2
//        for (LogData log : logs) {
//            //Logica
//            //Data do log tem que estar entre date1 e date2
//            String[] splitted = log.getTimestamp().split(" ");
//            Date compara = new Date(splitted[0]);
//            if (compara.after(new Date(date1)) && compara.before(new Date(date2))) { //compara.compareTo(date1) >= 0 && compara.compareTo(date2) <= 0
//                retorno.add(log);
//            }
//        }
//
//        return retorno;
//    }
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

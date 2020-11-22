/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

/**
 *
 * @author Eduardo
 */
public class EnviarEmail {
    
    public void enviar(String caminho, String nome_arquivo, String para, String assunto, String msg) {

        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.gmail.com");
        email.setSslSmtpPort("465");
        email.setStartTLSRequired(true);
        email.setStartTLSEnabled(true);
        email.setSSLOnConnect(true);

        email.setAuthenticator(new DefaultAuthenticator("easyroomtop@gmail.com", "easyroom321"));
        try {

            email.setFrom("easyroomtop@gmail.com");

            //  email.setDebug(true);
            email.setSubject(assunto);
            email.setMsg(msg);
            email.addTo(para);

            //Anexando um arquivo
            EmailAttachment anexo = new EmailAttachment();
            anexo.setPath(caminho);
            anexo.setName(nome_arquivo);
            email.attach(anexo);

            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
    
    public void enviar( String para, String assunto, String msg) {

        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.gmail.com");
        email.setSslSmtpPort("465");
        email.setStartTLSRequired(true);
        email.setStartTLSEnabled(true);
        email.setSSLOnConnect(true);

        email.setAuthenticator(new DefaultAuthenticator("easyroomtop@gmail.com", "easyroom321"));
        try {

            email.setFrom("easyroomtop@gmail.com");

            //  email.setDebug(true);
            email.setSubject(assunto);
            email.setMsg(msg);
            email.addTo(para);


            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}

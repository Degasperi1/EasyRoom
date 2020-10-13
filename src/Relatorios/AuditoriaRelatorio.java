/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Relatorios;

import Entidade.AuditoriaDados;
import Utils.I_Relatorio;
import java.io.InputStream;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author evand
 */
public class AuditoriaRelatorio implements I_Relatorio<AuditoriaDados> {

    @Override
    public void gerarRelatorio(List<AuditoriaDados> list) throws JRException {

        InputStream fonte = AuditoriaRelatorio.class.
                getResourceAsStream("/relatorios/reportAuditoria.jrxml");

        JasperReport report = JasperCompileManager.compileReport(fonte);

        JasperPrint print = JasperFillManager.fillReport(report, null,
                new JRBeanCollectionDataSource(list));
        JasperViewer.viewReport(print, false);

    }

}

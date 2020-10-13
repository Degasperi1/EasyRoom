/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.List;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author evand
 */
public interface I_Relatorio<T> {
    public abstract void gerarRelatorio(List<T> list) throws JRException;
}

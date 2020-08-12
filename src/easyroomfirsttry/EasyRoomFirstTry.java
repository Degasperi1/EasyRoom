/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyroomfirsttry;

import dao.CidadeDAO;
import dao.EstadoDAO;
import entidade.Cidade;
import entidade.Estado;

/**
 *
 * @author evand
 */
public class EasyRoomFirstTry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Estado estado = new Estado();
//        estado.setId_estado(3);
//        estado.setDs_estado("Rio de Janeiro");
//        estado.setIe_estado("RJ");
//        estado.setIe_situacao('A');
//        
        EstadoDAO dao = new EstadoDAO();
//        dao.salvar(estado);
        //System.out.println(dao.findById(1).getDs_estado());
        CidadeDAO cdao = new CidadeDAO();
        Cidade cidade = new Cidade();
        cidade.setId_cidade(0);
        cidade.setId_estado(dao.findById(1));
        cidade.setDs_cidade("Marques de Souza");
        cidade.setId_usuario_cadastro(1);
        cidade.setIe_situacao('A');
        cdao.salvar(cidade);
        System.exit(0);
    }
    
}

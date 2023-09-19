import DAO.AutomovelDAO;
import DAO.ClienteDAO;
import Exceptions.InfoNaoCompativelException;
import model.entity.Automovel;

import model.entity.Cliente;

public class main {
    public static void main (String args[]) throws InfoNaoCompativelException {

        ClienteDAO c = new ClienteDAO();
        Cliente cliente = new Cliente("oi", "123.456.789-10");  
        AutomovelDAO a = new AutomovelDAO();
        Automovel auto = new Automovel("abc1234", "branco", "clio", 2012, 0, cliente);
        //cliente.addAuto(auto);
        //c.inserir(cliente);
        //a.inserir(auto);
        a.deletar(auto);

    }
}
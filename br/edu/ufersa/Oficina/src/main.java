import DAO.ClienteDAO;
import Exceptions.InfoNaoCompativelException;
import model.entity.Automovel;

import model.entity.Cliente;

public class main {
    public static void main (String args[]) throws InfoNaoCompativelException {

        ClienteDAO c = new ClienteDAO();
        Cliente cliente = new Cliente("oi", "123.456.789-10");  
        Automovel a = new Automovel("abc1234", "branco", "clio", 2012, 0, cliente);
        cliente.addAuto(a);
        c.inserir(cliente);

    }
}

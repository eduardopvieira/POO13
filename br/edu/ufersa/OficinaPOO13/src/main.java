import model.entity.*;
import DAO.*;
import Exceptions.*;

public class main {
    public static void main (String args[]) throws InfoNaoCompativelException {

        ClienteDAO c = new ClienteDAO();
        Cliente cliente = new Cliente("oi", "123.456.789-10");  
        AutomovelDAO a = new AutomovelDAO();
        Automovel auto = new Automovel("abc1234", "branco", "clio", 2012, 13, cliente);
        ServicoDAO s = new ServicoDAO();
        Servico serv = new Servico(3, "balanceamento", "Alinhamento de pneus", 30.00);
        PecasDAO p = new PecasDAO();
        Pecas peca = new Pecas(0, null, null, 0, 0, 0);
        OrcamentoDAO o = new OrcamentoDAO();
        Orcamento orc = new Orcamento(cliente, auto, peca, serv);
        //cliente.addAuto(auto);
        //c.inserir(cliente);
        //a.inserir(auto);
        //o.inserir(orc);
        //a.deletar(auto);
        //a.listar();  

    }
}
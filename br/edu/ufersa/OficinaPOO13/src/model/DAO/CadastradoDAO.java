package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exceptions.InfoNaoCompativelException;
import model.VO.Cadastrado;

public class CadastradoDAO extends BaseDAOImpl <Cadastrado>{
    
//===============================LISTAR TODOS DA VIEW===================================================
    public List<Cadastrado> listarView() throws InfoNaoCompativelException
    {
        Connection con = getConnection();
        String sql = "SELECT * FROM vw_clientes_e_funcionarios";
        List<Cadastrado> pc = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
            	Cadastrado usu = new Cadastrado();
                usu.setCPF(rs.getString("CPF"));
                usu.setNome(rs.getString("nome"));
                usu.setEndereco(rs.getString("endereco"));
                usu.setFuncao(rs.getString("funcao"));
                pc.add(usu);

                System.out.println("CPF: " + usu.getCPF());
                System.out.println("Nome: " + usu.getNome());
                System.out.println("Endereco: " + usu.getEndereco());
                System.out.println("Funcao: " + usu.getFuncao());            }
            ps.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {closeConnection();}
        return pc;
    }
    

//=================================================================================================================== 

@Override
public void inserir(Cadastrado entity) throws SQLException {
	// TODO Auto-generated method stub
	
}
@Override
public void deletar(Cadastrado entity) throws SQLException {
	// TODO Auto-generated method stub
	
}
@Override
public Cadastrado alterar(Cadastrado entity) throws SQLException {
	// TODO Auto-generated method stub
	return null;
}
@Override
public ResultSet buscar(Cadastrado entity) throws SQLException {
	// TODO Auto-generated method stub
	return null;
}
@Override
public List<Cadastrado> listar() throws SQLException, InfoNaoCompativelException {
	// TODO Auto-generated method stub
	return null;
}
    
}

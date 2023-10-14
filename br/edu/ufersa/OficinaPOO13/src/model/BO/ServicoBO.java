package model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exceptions.InfoNaoCompativelException;
import Exceptions.InsertException;
import Exceptions.NotFoundException;
import model.DAO.PecasDAO;
import model.DAO.ServicoDAO;
import model.VO.Pecas;
import model.VO.Servico;

public class ServicoBO implements BaseInterBO<Servico>{
    ServicoDAO servDAO = new ServicoDAO();

//======================================CADASTRAR====================================================================
	
	@Override
	public boolean cadastrar(Servico vo) throws InsertException {
	    servDAO.inserir(vo);
	    return true;
}

//======================================BUSCAR POR ID================================================================
	@Override
	public ArrayList<Servico> buscarPorPK(Servico s) throws NotFoundException, InfoNaoCompativelException {
				ResultSet servBuscado = servDAO.buscar(new Servico(s.getServicoId()));
				ArrayList<Servico> servs = new ArrayList<>();		            
				    try {
				    	while(servBuscado.next()) {
						servs.add(new Servico(
						servBuscado.getString("servico_nome"),
						servBuscado.getString("servico_desc"),
						servBuscado.getDouble("servico_preco"),
						servBuscado.getInt("servico_id")));
				    	}
				    } catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
         return servs;
	}
	
//======================================BUSCAR POR NOME================================================================

	public ArrayList<Servico> buscarPorNome(Servico s) throws NotFoundException, InfoNaoCompativelException {
				ResultSet servBuscado = servDAO.buscar(new Servico(s.getServicoNome()));
				ArrayList<Servico> servs = new ArrayList<>();		            
				    try {
				    	while(servBuscado.next()) {
							servs.add(new Servico(
							servBuscado.getString("servico_nome"),
							servBuscado.getString("servico_desc"),
							servBuscado.getDouble("servico_preco"),
							servBuscado.getInt("servico_id")));
					    	}
				    } catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
         return servs;
	}

//======================================ALTERAR=======================================================================

	@Override
	public Servico alterar(Servico vo) throws InsertException {
		try {  
			ResultSet verificarServico = servDAO.buscar(vo);

	            if (!verificarServico.next() || vo.getServicoId() == 0) {
	                throw new InsertException("Peca não encontrada");
	            }

	            return servDAO.alterar(vo);
	            
	        }
	        catch (Exception e) {
	            throw new InsertException(e.getMessage());
	        }
	    }
//=========================================DELETAR===================================================================

	@Override
	public boolean deletar(Servico vo) throws InsertException {
        ResultSet pecaRS = servDAO.buscar(vo);
        try {
        if (pecaRS.next())
        {
            servDAO.deletar(vo);
            return true;
        }
        else
        {
            throw new NotFoundException("ID não encontrado.");
        }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new InsertException("Falha na alteração.");
        } finally {
            if (pecaRS != null) {
                try {
                	pecaRS.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
       }
		
	}
//=============================================LISTAR===================================================================

	public List<Servico> listar() throws SQLException
    {
		ServicoDAO cliDAO = new ServicoDAO();

        return cliDAO.listar();
    }		
}

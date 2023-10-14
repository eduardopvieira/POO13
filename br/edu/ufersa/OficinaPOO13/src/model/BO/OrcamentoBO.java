package model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Exceptions.InfoNaoCompativelException;
import Exceptions.InsertException;
import Exceptions.NotFoundException;
import model.DAO.OrcamentoDAO;
import model.VO.Orcamento;
import model.VO.Servico;

public class OrcamentoBO implements BaseInterBO<Orcamento>{
    OrcamentoDAO orcDAO = new OrcamentoDAO();

//======================================CADASTRAR====================================================================
	
	@Override
	public boolean cadastrar(Orcamento vo) throws InsertException {
	    orcDAO.inserir(vo);
	    return true;
}

//======================================BUSCAR POR ID================================================================
	@Override
	public ArrayList<Orcamento> buscarPorPK(Orcamento orc) throws NotFoundException, InfoNaoCompativelException {
				ResultSet orcBuscado = orcDAO.buscar(new Orcamento(orc.getIdOrcamento()));
				ArrayList<Orcamento> orcs = new ArrayList<>();		            
				    try {
				    	while(orcBuscado.next()) {
				    		Orcamento orcamento = new Orcamento();
				    	    orcamento.setIdOrcamento(orcBuscado.getInt("id_orcamento"));
				    	    orcamento.setCPFClienteOrcamento(orcBuscado.getString("cpf"));
				    	    orcamento.setPlacaOrc(orcBuscado.getString("placa"));
				    	    orcamento.setIdPecaOrcamento(orcBuscado.getInt("id_peca"));
				    	    orcamento.setIdServOrc(orcBuscado.getInt("id_servico"));
				    	    orcamento.setDataOrcamento(orcBuscado.getDate("data_orc"));
				    	    orcamento.setTotalOrcamento(orcBuscado.getDouble("precoTotal"));
				    	    orcamento.setIsPago(orcBuscado.getBoolean("isPago"));
				    	}
				    } catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
         return orcs;
	}
	
//======================================BUSCAR POR NOME================================================================

	public ArrayList<Orcamento> buscarPorCliente(Orcamento orc) throws NotFoundException, InfoNaoCompativelException {
				ResultSet servBuscado = orcDAO.buscarPorCliente(new Orcamento(orc.getCPFClienteOrcamento()));
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



	@Override
	public ArrayList<Servico> listar() throws InsertException {
		try {
            ResultSet servBuscado = servDAO.listar();
            ArrayList<Servico> servs = new ArrayList<>();
            try {
            	while(servBuscado.next()) {
					servs.add(new Servico(
					servBuscado.getString("servico_nome"),
					servBuscado.getString("servico_desc"),
					servBuscado.getDouble("servico_preco"),
					servBuscado.getInt("servico_id")));
			    	}
		    } catch (SQLException e) {            }
            return servs;
        } catch (Exception e) {
            throw new InsertException("erro ao listar serviços");
        }
	}
	
	
	
}

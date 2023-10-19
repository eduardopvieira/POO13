package model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exceptions.InfoNaoCompativelException;
import Exceptions.InsertException;
import Exceptions.NotFoundException;
import javafx.scene.control.Alert.AlertType;
import model.DAO.OrcamentoDAO;
import model.VO.Orcamento;
import view.util.Alerts;

public class OrcamentoBO implements BaseInterBO<Orcamento>{
    OrcamentoDAO orcDAO = new OrcamentoDAO();

//======================================CADASTRAR====================================================================
	
	@Override
	public boolean cadastrar(Orcamento vo) throws InsertException {
	    try {
		orcDAO.inserir(vo);
	    return true;
	    } catch (Exception e) {
	    	Alerts.showAlert("Erro", "Erro no cadastro", "Houve um erro no cadastro do orçamento.", AlertType.ERROR);
	    }
		return false;
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

	public ArrayList<Orcamento> buscarPorNome(Orcamento orc) throws NotFoundException, InfoNaoCompativelException {
				ResultSet orcBuscado = orcDAO.buscarPorCliente(orc);
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
	
//======================================BUSCAR POR PLACA================================================================

		public ArrayList<Orcamento> buscarPorPlaca(Orcamento orc) throws NotFoundException, InfoNaoCompativelException {
					ResultSet orcBuscado = orcDAO.buscarPorPlaca(orc);
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
//======================================ALTERAR=======================================================================

	@Override
	public Orcamento alterar(Orcamento vo) {
		
		try {  
			ResultSet verificarOrcamento = orcDAO.buscar(vo);

	            if (!verificarOrcamento.next()) {
	                throw new InsertException("Orçamento não encontrado");
	            } else {
	        	
	            return orcDAO.alterar(vo);
	            
	            }
	        }
	        catch (Exception e) {
	        	Alerts.showAlert("Erro", "Erro ao alterar", "Houve um erro ao alterar a informação no banco de dados.", AlertType.ERROR);
	        }
			return vo;
	    }

	//======================================ALTERAR IS PAGO=======================================================================

		public void alterarIsPago(Orcamento vo) {
			
			try {  
				ResultSet verificarOrcamento = orcDAO.buscar(vo);

		            if (!verificarOrcamento.next()) {
		                throw new InsertException("Orçamento não encontrado");
		            } else {
		            	orcDAO.alterarIsPago(vo);
		            }
		        }
		        catch (Exception e) {
		        	Alerts.showAlert("Erro", "Erro ao alterar", "Houve um erro ao alterar a informação no banco de dados.", AlertType.ERROR);
		        }
		    }
	
	
	//=========================================DELETAR===================================================================

	@Override
	public boolean deletar(Orcamento vo) throws InsertException {
        ResultSet orcRS = orcDAO.buscar(vo);
        try {
        if (orcRS.next())
        {
            orcDAO.deletar(vo);
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
            if (orcRS != null) {
                try {
                	orcRS.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
       }
		
	}
//=============================================LISTAR===================================================================

	 public List<Orcamento> listar() throws SQLException
	    {
		 OrcamentoDAO cliDAO = new OrcamentoDAO();

	        return cliDAO.listar();
	    }
	 
//===========================================TRADUZIR ID SERVICO=====================================================
	 	
	
}

package model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exceptions.InfoNaoCompativelException;
import Exceptions.InsertException;
import Exceptions.NotFoundException;
import model.DAO.FuncionarioDAO;
import model.DAO.OrcamentoDAO;
import model.VO.Funcionario;
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
	public Orcamento alterar(Orcamento vo) throws InsertException {
		try {  
			ResultSet verificarServico = orcDAO.buscar(vo);

	            if (!verificarServico.next() || vo.getIdOrcamento()== 0) {
	                throw new InsertException("Peca não encontrada");
	            }

	            return orcDAO.alterar(vo);
	            
	        }
	        catch (Exception e) {
	            throw new InsertException(e.getMessage());
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

	
	
	
}

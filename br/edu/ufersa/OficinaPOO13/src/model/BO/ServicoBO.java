package model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exceptions.InfoNaoCompativelException;
import Exceptions.InsertException;
import Exceptions.NotFoundException;
import javafx.scene.control.Alert.AlertType;
import model.DAO.ServicoDAO;
import model.VO.Servico;
import view.util.Alerts;

public class ServicoBO implements BaseInterBO<Servico>{
    ServicoDAO servDAO = new ServicoDAO();

//======================================CADASTRAR====================================================================
	
    @Override
    public boolean cadastrar(Servico vo) throws SQLException {
        try {
            ResultSet rs = servDAO.buscar(vo);
            if (rs.next()) {
                // Serviço já existe
                Alerts.showAlert("Erro", "ID já existe", "O serviço com ID " + vo.getServicoId() + " já está cadastrado.", AlertType.ERROR);
                return false;
            } else {
                // Serviço não existe, cadastre-o
                servDAO.inserir(vo);
                Alerts.showAlert("Sucesso", "Serviço cadastrado com sucesso", "O serviço foi cadastrado com sucesso.", AlertType.INFORMATION);
                return true;
            }
        } catch (SQLException e) {
            // Trate a exceção ou exiba uma mensagem de erro
            e.printStackTrace();
            Alerts.showAlert("Erro", "Erro no cadastro do serviço", "Ocorreu um erro ao cadastrar o serviço.", AlertType.ERROR);
            return false;
        }
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
				ResultSet servBuscado = servDAO.buscarPorNome(new Servico(s.getServicoNome()));
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

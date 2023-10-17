package model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exceptions.InfoNaoCompativelException;
import Exceptions.InsertException;
import Exceptions.NotFoundException;
import javafx.scene.control.Alert.AlertType;
import model.DAO.PecasDAO;
import model.VO.Pecas;
import view.util.Alerts;

public class PecasBO implements BaseInterBO<Pecas>{
	PecasDAO pDAO = new PecasDAO();

//======================================CADASTRAR=====================================================================

	@Override
	public boolean cadastrar(Pecas vo) throws SQLException {
	    try {
	        ResultSet rs = pDAO.buscarPorPK(vo);
	        if (rs.next()) {
	            Alerts.showAlert("Erro", "ID já existe", "A peça com ID " + vo.getIdItem() + " já está cadastrada.", AlertType.ERROR);
	            return false;
	        } else {
	            pDAO.inserir(vo);
	            Alerts.showAlert("Sucesso", "Peça cadastrado com sucesso", "A peça foi cadastrada com sucesso.", AlertType.INFORMATION);
	            return true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        Alerts.showAlert("Erro", "Erro no cadastro da peça", "Ocorreu um erro ao cadastrar a peça.", AlertType.ERROR);
	        return false;
	    }
	}
	
//======================================BUSCAR POR PK=====================================================================

	
	public ArrayList<Pecas> buscarPorNomeOuFab(Pecas p) throws NotFoundException, InfoNaoCompativelException {
				ResultSet pecaBuscada = pDAO.buscar(new Pecas(p.getDescricaoItem()));
				ArrayList<Pecas> pecas = new ArrayList<>();		            
				    try {
				    	while(pecaBuscada.next()) {
						pecas.add(new Pecas(pecaBuscada.getInt("id_peca"),
						pecaBuscada.getString("desc_peca"),
						pecaBuscada.getString("fab_peca"),
						pecaBuscada.getDouble("preco_peca"),
						pecaBuscada.getInt("estoque_peca")));
				    	}
				    } catch (SQLException e) {
						e.printStackTrace();
					}
         return pecas;
	}

//======================================ALTERAR=====================================================================

	@Override
	public Pecas alterar(Pecas vo) throws InsertException {
		try {  
			ResultSet verificarPeca = pDAO.buscarPorPK(vo);

	            if (!verificarPeca.next() || vo.getIdItem() == 0) {
	            	Alerts.showAlert("Erro", "Not Found", "Peça nao encontrada", AlertType.ERROR);
	            }

	            return pDAO.alterar(vo);
	            
	        }
	        catch (Exception e) {
	            throw new InsertException(e.getMessage());
	        }
	    }

//======================================DELETAR=====================================================================

	
	@Override
	public boolean deletar(Pecas vo) throws InsertException {
		PecasDAO pecaDAO = new PecasDAO();
        ResultSet pecaRS = pecaDAO.buscar(vo);
        try {
        if (pecaRS.next())
        {
            pecaDAO.deletar(vo);
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

//======================================LISTAR=====================================================================

	public List<Pecas> listar() throws SQLException
    {
	 PecasDAO cliDAO = new PecasDAO();

        return cliDAO.listar();
    }

@Override
public ArrayList<Pecas> buscarPorPK(Pecas vo) throws NotFoundException, InfoNaoCompativelException {
	return null;
}	
}

package model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Exceptions.InfoNaoCompativelException;
import Exceptions.InsertException;
import Exceptions.NotFoundException;
import model.DAO.AutomovelDAO;
import model.DAO.PecasDAO;
import model.VO.Automovel;
import model.VO.Pecas;

public class PecasBO implements BaseInterBO<Pecas>{
	PecasDAO pDAO = new PecasDAO();

//======================================CADASTRAR=====================================================================

	@Override
	public boolean cadastrar(Pecas vo) throws InsertException {
	    PecasDAO pecaDAO = new PecasDAO();
	    pecaDAO.inserir(vo);
	    return true;
}
	
//======================================BUSCAR POR PK=====================================================================


	@Override
	public ArrayList<Pecas> buscarPorPK(Pecas p) throws NotFoundException, InfoNaoCompativelException {
				ResultSet pecaBuscada = pDAO.buscar(new Pecas(p.getIdItem()));
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
         return pecas;
	}

//======================================BUSCAR POR FAB=====================================================================

	public ArrayList<Pecas> buscarPorFab(Pecas p) throws NotFoundException, InfoNaoCompativelException {
				ResultSet pecaBuscada = pDAO.buscar(new Pecas(p.getFabricante()));
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
         return pecas;
	}

//======================================ALTERAR=====================================================================

	@Override
	public Pecas alterar(Pecas vo) throws InsertException {
		try {  
			ResultSet verificarPeca = pDAO.buscar(vo);

	            if (!verificarPeca.next() || vo.getIdItem() == 0) {
	                throw new InsertException("Peca não encontrada");
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

	@Override
	public ArrayList<Pecas> listar() throws InsertException {
		try {
            ResultSet pecaBuscada = pDAO.listar();
            ArrayList<Pecas	> pecas = new ArrayList<>();
            try {
		    	while(pecaBuscada.next()) {
				pecas.add(new Pecas(pecaBuscada.getInt("id_peca"),
				pecaBuscada.getString("desc_peca"),
				pecaBuscada.getString("fab_peca"),
				pecaBuscada.getDouble("preco_peca"),
				pecaBuscada.getInt("estoque_peca")));
		    	}
		    } catch (SQLException e) {            }
            return pecas;
        } catch (Exception e) {
            throw new InsertException("erro ao listar peças");
        }
	}
	
	
	
}

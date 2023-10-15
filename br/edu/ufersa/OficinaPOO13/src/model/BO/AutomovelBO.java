package model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exceptions.InfoNaoCompativelException;
import Exceptions.InsertException;
import Exceptions.NotFoundException;
import javafx.scene.control.Alert.AlertType;
import model.DAO.AutomovelDAO;
import model.DAO.BaseDAO;
import model.VO.Automovel;
import model.VO.Cliente;
import view.util.Alerts;

public class AutomovelBO implements BaseInterBO<Automovel>{
	
	@Override
    public boolean cadastrar(Automovel vo) throws InsertException{
		try {
		AutomovelDAO autoDAO = new AutomovelDAO();
        ResultSet autoRS = autoDAO.buscar(vo);
        if (autoRS.next()) {
        	//AUTO JA EXISTE
        	 Alerts.showAlert("Erro", "Placa já existe", "O automovel com Placa " + vo.getPlaca() + " já está cadastrado.", AlertType.ERROR);
        	 return false;
        } else {
        	ClienteBO cliBO = new ClienteBO();
        	List<Cliente> lista = cliBO.buscarPorPK(vo.getCPFDono());
              	if (!lista.isEmpty()) {
        		autoDAO.inserir(vo);
              	Alerts.showAlert("Sucesso", "Automovel cadastrado com sucesso", "Automovel foi cadastrado com sucesso.", AlertType.INFORMATION);
	            return true;
              	} else {
              		Alerts.showAlert("Erro", "CPF não existe", "Cadastre um cliente com esse CPF antes de linká-lo a um automóvel.", AlertType.ERROR);
              		return false;
              	}
              	}
            } catch (SQLException e) {
    	        // Trate a exceção ou exiba uma mensagem de erro
    	        e.printStackTrace();
    	        Alerts.showAlert("Erro", "Erro no cadastro do automovel.", "Ocorreu um erro ao cadastrar o auto.", AlertType.ERROR);
    	        return false;
    	    } catch (InfoNaoCompativelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}
	
	
	
//=======================================LISTAR======================================================================
	
	public List<Automovel> listar() throws SQLException, InfoNaoCompativelException
    {
        BaseDAO<Automovel> autoDAO = new AutomovelDAO();

        return autoDAO.listar();
    }


	@Override
	public ArrayList<Automovel> buscarPorPK(Automovel vo) throws NotFoundException, InfoNaoCompativelException {
		        AutomovelDAO autoDAO = new AutomovelDAO();
				ResultSet veiculosBuscados = autoDAO.buscar(new Automovel(vo.getModelo()));
				ArrayList<Automovel> veiculos = new ArrayList<>();		            
				    try {
				    	while(veiculosBuscados.next()) {
						veiculos.add(new Automovel(veiculosBuscados.getString("dono"),
						veiculosBuscados.getString("placa"),
						veiculosBuscados.getString("modelo"),
						veiculosBuscados.getString("marca"),
						veiculosBuscados.getInt("ano"),
						veiculosBuscados.getInt("quilometragem"),
						veiculosBuscados.getString("cor")));
				    	}
				    	
				    } catch (InfoNaoCompativelException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
         return veiculos;
	}

	
	
	public ArrayList<Automovel> buscarPorDono(Automovel vo) throws NotFoundException, InfoNaoCompativelException {
		        AutomovelDAO autoDAO = new AutomovelDAO();
				ResultSet veiculosBuscados = autoDAO.buscar(new Automovel(vo.getModelo()));
				ArrayList<Automovel> veiculos = new ArrayList<>();		            
				    try {
				    	while(veiculosBuscados.next()) {
						veiculos.add(new Automovel(veiculosBuscados.getString("placa"),
						veiculosBuscados.getString("cor"),
						veiculosBuscados.getString("modelo"),
						veiculosBuscados.getString("marca"),
						veiculosBuscados.getInt("ano"),
						veiculosBuscados.getInt("km"),
						veiculosBuscados.getString("cpfDono")));
				    	}
				    } catch (InfoNaoCompativelException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
         return veiculos;
	}
	
	
	public ArrayList<Automovel> buscarPorPlacaOuDono(Automovel vo) throws NotFoundException, InfoNaoCompativelException {
        AutomovelDAO autoDAO = new AutomovelDAO();
		ResultSet veiculosBuscados = autoDAO.buscarPorPlacaOuDono(vo.getModelo());
		ArrayList<Automovel> veiculos = new ArrayList<>();		            
		    try {
		    	while(veiculosBuscados.next()) {
				veiculos.add(new Automovel(veiculosBuscados.getString("placa"),
				veiculosBuscados.getString("cor"),
				veiculosBuscados.getString("modelo"),
				veiculosBuscados.getString("marca"),
				veiculosBuscados.getInt("ano"),
				veiculosBuscados.getInt("quilometragem"),
				veiculosBuscados.getString("dono")));
		    	}
		    } catch (InfoNaoCompativelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 return veiculos;
}

	
	
	
	

	@Override
	public Automovel alterar(Automovel vo) throws InsertException {
		try {
	        AutomovelDAO autoDAO = new AutomovelDAO();    
			ResultSet verificarVeiculo = autoDAO.buscar(vo);

	            if (!verificarVeiculo.next() || vo.getPlaca() == null) {
	                throw new InsertException("Placa não encontrada");
	            } else {
	            return autoDAO.alterar(vo);
	            }
	        }
	        catch (Exception e) {
	            throw new InsertException(e.getMessage());
	        }
	    }


	@Override
	public boolean deletar(Automovel vo) throws InsertException {
		AutomovelDAO autoDAO = new AutomovelDAO();
        ResultSet autoRS = autoDAO.buscar(vo);
        try {
        if (autoRS.next())
        {
        	autoDAO.deletar(vo);
        	return true;
        }
        else
        {
            throw new NotFoundException("Placa não encontrada.");
        }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new InsertException("Falha na alteração.");
        } finally {
            if (autoRS != null) {
                try {
                	autoRS.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
       }
	}
}

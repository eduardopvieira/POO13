package model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Exceptions.InfoNaoCompativelException;
import Exceptions.InsertException;
import Exceptions.NotFoundException;
import model.DAO.AutomovelDAO;
import model.VO.Automovel;

public class AutomovelBO implements BaseInterBO<Automovel>{
	
	@Override
    public boolean cadastrar(Automovel vo) throws InsertException{
        AutomovelDAO autoDAO = new AutomovelDAO();
        ResultSet autoRS = autoDAO.buscar(vo);
        try {
            if (autoRS.next()) {
                throw new InsertException("Placa já cadastrada.");
              	} else {
              	autoDAO.inserir(vo);
              	}
            } catch (SQLException e) {
            	e.printStackTrace();
            }throw new InsertException("Falha no cadastro.");
	}
	
	
	
	public ArrayList<Automovel> listar() throws InsertException {
        try {
        	AutomovelDAO autoDAO = new AutomovelDAO();
            ResultSet veiculosBuscados = autoDAO.listar();
            ArrayList<Automovel> veiculos = new ArrayList<>();
            while(veiculosBuscados.next()) {
                veiculos.add(new Automovel(veiculosBuscados.getString("placa"),
                veiculosBuscados.getString("cor"),
                veiculosBuscados.getString("modelo"),
                veiculosBuscados.getString("marca"),
                veiculosBuscados.getInt("ano"),
                veiculosBuscados.getInt("km"),
                veiculosBuscados.getString("CPFdono")));
            }
            return veiculos;
        } catch (Exception e) {
            throw new InsertException("erro ao buscar veiculos");
        }
    }


	@Override
	public ArrayList<Automovel> buscarPorPK(Automovel vo) throws NotFoundException, InfoNaoCompativelException {
		        AutomovelDAO autoDAO = new AutomovelDAO();
				ResultSet veiculosBuscados = autoDAO.buscar(new Automovel(vo.getPlaca()));
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

	
	
	public ArrayList<Automovel> buscarPorDono(Automovel vo) throws NotFoundException, InfoNaoCompativelException {
		        AutomovelDAO autoDAO = new AutomovelDAO();
				ResultSet veiculosBuscados = autoDAO.buscar(new Automovel(vo.getCPFDono()));
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

	

	@Override
	public Automovel alterar(Automovel vo) throws InsertException {
		try {
	        AutomovelDAO autoDAO = new AutomovelDAO();    
			ResultSet verificarVeiculo = autoDAO.buscar(vo);

	            if (!verificarVeiculo.next() || vo.getPlaca() == null) {
	                throw new InsertException("Usuario não encontrado");
	            }

	            if (!this.validarPlaca(vo.getPlaca())) {
	                throw new InsertException("O formato digitado está errado. Modelo: ABC-1234");
	            }

	            return autoDAO.alterar(vo);
	            
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
	
	
	private boolean validarPlaca(String placa) {
        return placa.matches("[A-Za-z]{3}-\\d{4}");
    }
	
}

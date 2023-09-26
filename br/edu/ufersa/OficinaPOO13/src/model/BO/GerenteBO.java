package model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import model.DAO.GerenteDAO;
import Exceptions.*;
import model.VO.Gerente;

public class GerenteBO {
    static private GerenteDAO gerDAO = new GerenteDAO();

    public Gerente autenticar(Gerente vo) throws LoginFailedException, InfoNaoCompativelException{
		ResultSet rs = gerDAO.buscar(vo);
		try {
			if(rs.next()) {//encontrou gerente
				if(rs.getString("senha_gerente").equals(vo.getSenha())) {
					Gerente res = new Gerente();
					res.setCPF(rs.getString("cpf_gerente"));
					ResultSet resultBusca = gerDAO.buscar(res);
						if(res != null) {//cumprir o protocolo por desencargo de consciência
							return res;
						}
						else throw new LoginFailedException("Login falhou. A");
					}
			    else throw new LoginFailedException("Login falhou. B");
			} else throw new LoginFailedException("Login falhou. C");
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new LoginFailedException("Login Falhou. D");
		}
	}

    public void cadastrar(Gerente vo) throws InfoNaoCompativelException, InfoExistenteException {
		try {
            ResultSet rs = gerDAO.buscar(vo); //ID
			if (rs.next()) {
				throw new InfoExistenteException("Impossível cadastrar, pois já existe responsável com este CPF");
			}
			else {
				gerDAO.inserir(vo);
			}
		}
		catch(SQLException e) {
			throw new InfoExistenteException(e.getMessage());
		}
	}
}
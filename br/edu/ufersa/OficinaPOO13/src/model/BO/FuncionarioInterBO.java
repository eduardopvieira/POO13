package model.BO;

import Exceptions.AutenticationException;
import model.VO.Funcionario;
import Exceptions.InfoNaoCompativelException;

public interface FuncionarioInterBO<VO extends Funcionario> extends BaseInterBO<VO>{
		public VO autenticar (VO vo) throws AutenticationException, InfoNaoCompativelException;     
	}

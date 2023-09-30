package controller;

import Exceptions.InfoNaoCompativelException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.VO.Automovel;
import model.VO.Cliente;
import model.VO.Orcamento;
import model.VO.Pecas;
import model.VO.Servico;

public class VisualizarOrcamentoController {
	@FXML
	private Button visualizar;
	@FXML
	private Button botaoVoltar;
	@FXML
	private static Label lbNome;
	@FXML
	private static Label lbEndereco;
	@FXML
	private static Label lbCPF;
	@FXML
	private static Label valorTotalPecas;
	@FXML
	private static Label descricaoPeca;
	@FXML
	private static Label precoPeca;
	@FXML
	private static Label valorTotalServico;
	@FXML
	private static Label descricaoServico;
	@FXML
	private static Label precoServico;
	
	public void visualizar() throws Exception { // a ideia depois é pegar esse dados, que agora estou inicializando manualmente, no banco de dados  // a ideia é que depois não precissemos do botão "vizualizar"
		Cliente c = new Cliente("Patrick", "06512344410", "Rua da alegria, 75");
		Automovel a = new Automovel();
		Pecas p = new Pecas(1, "Parafuso", "fabricanteXYZ", 1.45, 30, 3);
		Servico s = new Servico(5, "Troca de óleo", "óleo velho não presta", 20);
		double precoOrcamento = p.getPrecoItem() + s.getServicoPreco();
		Orcamento orc = new Orcamento(c, a, p, s);
		lbNome.setText(c.getNome());
		lbEndereco.setText(c.getEndereco());
		lbCPF.setText(c.getCPF());
		valorTotalPecas.setText((String.valueOf(p.getPrecoItem()))); //necessário corrigir, deve se ter o somatório de todas as peças
		descricaoPeca.setText(p.getDescricaoItem());
		precoPeca.setText(String.valueOf(p.getPrecoItem()));
		valorTotalServico.setText(String.valueOf(s.getServicoPreco())); //necessário consertar, deve se ter o somatório de todas as peças
		descricaoServico.setText(s.getServicoDescricao());
		precoServico.setText(String.valueOf(s.getServicoPreco()));
	}
	
	public void voltar() throws Exception{
		
	}
	
}

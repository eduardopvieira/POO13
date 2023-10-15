package controller;

import Exceptions.InfoNaoCompativelException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.BO.PecasBO;
import model.VO.Pecas;
import view.Telas;
import view.util.Alerts;

public class EditarPecasGerenteController {

    @FXML
    private Button botaoCancelar;

    @FXML
    private Button botaoConcluir;

    @FXML
    private TextField textfieldEstoquePeca;

    @FXML
    private TextField textfieldFabricantePeca;

    @FXML
    private TextField textfieldNomePeca;

    @FXML
    private TextField textfieldValorPeca;

    @FXML
    private Label textoID;

    @FXML
    void editarPeca(ActionEvent event) {
    	Pecas peca = new Pecas();
        PecasBO pecaBO = new PecasBO();

        try
        {
            int ID = Integer.parseInt(textoID.getText());
        	peca.setIdItem(ID);
        	
        	double preco = Double.parseDouble(textfieldValorPeca.getText());
        	peca.setPrecoItem(preco);
        	
        	int estoque = Integer.parseInt(textfieldEstoquePeca.getText());
        	peca.setEstoqueItem(estoque);
        	
        	peca.setDescricaoItem(textfieldNomePeca.getText());
            peca.setFabricante(textfieldFabricantePeca.getText());

            pecaBO.alterar(peca);
            
            Telas.telaMenuPecas();
        }
        catch (InfoNaoCompativelException e)
        {
        	Alerts.showAlert("Erro", "Campo vazio", "Nenhum campo pode ser deixado vazio.", AlertType.ERROR);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    void voltar(ActionEvent event) throws Exception{
    	Telas.telaMenuPecas();
    }


	public void Initialize(Pecas p) {
		try {
            textfieldNomePeca.setText(p.getDescricaoItem());
            textfieldFabricantePeca.setText(p.getFabricante());
            textfieldValorPeca.setText(Double.toString(p.getPrecoItem()));
            textfieldEstoquePeca.setText(Integer.toString(p.getEstoqueItem()));
            textoID.setText(Integer.toString(p.getIdItem()));
            } catch (Exception e)
        {
            e.printStackTrace();
            Alerts.showAlert("Erro", "Falha ao carregar", "Não foi possível carregar as informações da peça.", AlertType.ERROR);
        }
	}

}

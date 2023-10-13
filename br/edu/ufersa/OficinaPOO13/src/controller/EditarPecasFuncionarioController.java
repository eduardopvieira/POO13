package controller;

import java.io.IOException;

import Exceptions.InfoNaoCompativelException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.BO.PecasBO;
import model.VO.Pecas;
import view.Telas;

public class EditarPecasFuncionarioController {

    @FXML
    private Button botaoCancelar;

    @FXML
    private Button botaoConcluir;

    @FXML
    private TextField textfieldFabricantePeca;

    @FXML
    private TextField textfieldNomePeca;

    @FXML
    private TextField textfieldValorPeca;

    public void Initialize(Pecas p) throws Exception{
    	 try {
             textfieldNomePeca.setText(p.getDescricaoItem());
             textfieldFabricantePeca.setText(p.getFabricante());
             textfieldValorPeca.setText(String.valueOf(p.getPrecoItem()));
             }catch (Exception e)
         {
             e.printStackTrace();
             //colocar alert "Não foi possível carregar as informações da peça."
         }
    }
    
    
    @FXML
    void editarPeca(ActionEvent event) throws Exception {
            Pecas peca = new Pecas();
            PecasBO pecaBO = new PecasBO();

            try
            {
                peca.setDescricaoItem(textfieldNomePeca.getText());
                peca.setFabricante(textfieldFabricantePeca.getText());
                peca.setPrecoItem(Double.valueOf(textfieldValorPeca.getText()));

                pecaBO.alterar(peca);

                Telas.telaMenuPecas();
            }
            catch (InfoNaoCompativelException e)
            {
            	//alert "nenhum campo pode ser deixado vazio.";
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    @FXML
    void voltar(ActionEvent event) throws Exception {
    	try {
    	Telas.telaMenuPecas();
    	}catch (IOException e){
    		e.printStackTrace();
    	}
    }

}

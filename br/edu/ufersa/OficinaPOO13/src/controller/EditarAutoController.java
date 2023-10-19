package controller;

import Exceptions.InfoNaoCompativelException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.BO.AutomovelBO;
import model.VO.Automovel;
import view.Telas;
import view.util.Alerts;

public class EditarAutoController {

    @FXML
    private Button botaoCancelar;

    @FXML
    private Button botaoConcluir;

    @FXML
    private TextField textfieldAnoAuto;

    @FXML
    private TextField textfieldCorAuto;

    @FXML
    private TextField textfieldKMAuto;

    @FXML
    private TextField textfieldMarcaAuto;

    @FXML
    private TextField textfieldModeloAuto;

    @FXML
    private Label textoCPFDono;

    @FXML
    private Label textoPlaca;

    public void Initialize(Automovel auto) {
   	 try {
         textfieldAnoAuto.setText(Integer.toString(auto.getAno()));
         textfieldCorAuto.setText(auto.getCor());
         textfieldKMAuto.setText(Integer.toString(auto.getKm()));
         textfieldMarcaAuto.setText(auto.getMarca());
         textfieldModeloAuto.setText(auto.getModelo());
         textoPlaca.setText(auto.getPlaca());
         textoCPFDono.setText(auto.getCPFDono());
            } catch (Exception e)
        {
            e.printStackTrace();
            Alerts.showAlert("Erro", "Falha ao carregar", "Não foi possível carregar as informações do automovel.", AlertType.ERROR);
        }
   }
    
    
    @FXML
    void editarAuto(ActionEvent event) {
    	
    	Automovel auto = new Automovel();
    	AutomovelBO autoBO = new AutomovelBO();

        try
        {
            int KM = Integer.parseInt(textfieldKMAuto.getText());
        	auto.setKm(KM);
        	
        	int ano = Integer.parseInt(textfieldAnoAuto.getText());
        	auto.setAno(ano);
        	
        	auto.setCor(textfieldCorAuto.getText());
        	auto.setMarca(textfieldMarcaAuto.getText());
        	auto.setModelo(textfieldModeloAuto.getText());
        	
        	auto.setPlaca(textoPlaca.getText());
        	auto.setCPFDono(textoCPFDono.getText());
        	
            autoBO.alterar(auto);
            
            Alerts.showAlert("Sucesso", "Edição bem sucedida", "Seu automovel foi editado com suceso", AlertType.INFORMATION);
            Telas.telaMenuAutos();
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
    	Telas.telaMenuAutos();
    }

}

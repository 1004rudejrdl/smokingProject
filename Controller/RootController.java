package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController implements Initializable{
	private Stage stage;
	public Stage primaryStage;
	
	@FXML private Button btnLogin;
	@FXML private Button btnCancel;
	@FXML private TextField textId;
	@FXML private TextField textPassword;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//����Ű�� �α���
				textPassword.setOnKeyPressed(event -> {
					if (event.getCode().equals(KeyCode.ENTER)) {
						handleBtnLoginAction();
					}
				});
		
		//�α��ι�ư
		btnLogin.setOnAction((e)->{handleBtnLoginAction();});
		
		//��ҹ�ư
		btnCancel.setOnAction((e)->{handleBtnCancelAction();});
		
		
		
	}
	



	//�α��ι�ư
	private void handleBtnLoginAction() {
	if(!(textId.getText().equals("1") && textPassword.getText().equals("1"))) {
			callAlert("�α��� ���� : ���̵� �н����带 �ٽ� Ȯ�����ּ���.");
			textId.clear();
			textPassword.clear();
			return;
			
		}
		try {
		
			Stage mainStage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/main.fxml"));
			Parent root;
			MainController mainController = loader.getController();
			root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.close();
			mainStage.setScene(scene);
			mainStage.show();
			callAlert("�α��μ��� : ȯ���մϴ�.");
		} catch (IOException e) {
			
		}
		
		
	}
	
	//��ҹ�ư
		private void handleBtnCancelAction() {
			Platform.exit();
			
		}
	
	
	// ��Ÿ:�˸�â (�߰��� : �����ٰ�) ���� : "�������� : ���� ����� �Է����ּ���"
		private void callAlert(String contentText) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("�α���");
			alert.setHeaderText(contentText.substring(0, contentText.lastIndexOf(":"))); // 0�� ������ ":" �տ��ִ� ���� ������
			alert.setContentText(contentText.substring(contentText.lastIndexOf(":") + 1)); // +1�� �ϸ� ":" �ڿ��ִ� ���� ������
			alert.showAndWait();
		}

		
		
}

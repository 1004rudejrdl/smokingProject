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
		//엔터키로 로그인
				textPassword.setOnKeyPressed(event -> {
					if (event.getCode().equals(KeyCode.ENTER)) {
						handleBtnLoginAction();
					}
				});
		
		//로그인버튼
		btnLogin.setOnAction((e)->{handleBtnLoginAction();});
		
		//취소버튼
		btnCancel.setOnAction((e)->{handleBtnCancelAction();});
		
		
		
	}
	



	//로그인버튼
	private void handleBtnLoginAction() {
	if(!(textId.getText().equals("1") && textPassword.getText().equals("1"))) {
			callAlert("로그인 실패 : 아이디나 패스워드를 다시 확인해주세요.");
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
			callAlert("로그인성공 : 환영합니다.");
		} catch (IOException e) {
			
		}
		
		
	}
	
	//취소버튼
		private void handleBtnCancelAction() {
			Platform.exit();
			
		}
	
	
	// 기타:알림창 (중간에 : 적어줄것) 예시 : "오류정보 : 값을 제대로 입력해주세요"
		private void callAlert(String contentText) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("로그인");
			alert.setHeaderText(contentText.substring(0, contentText.lastIndexOf(":"))); // 0을 넣으면 ":" 앞에있는 글을 가져옴
			alert.setContentText(contentText.substring(contentText.lastIndexOf(":") + 1)); // +1을 하면 ":" 뒤에있는 글을 가져옴
			alert.showAndWait();
		}

		
		
}

package Controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import com.sun.javafx.scene.control.skin.LabeledText;

import Model.Smoking;
import Model.SmokingInformation;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainController implements Initializable {
	private Stage mainStage;
	
	@FXML private TextField textSmokeTotal;
	@FXML private TextField textSulTotal;
	@FXML private TextField textPirceTotal;
	@FXML private ListView list1;
	@FXML private ListView list2;
	@FXML private Button t3BtnList1;
	@FXML private Button t3BtnList2;
	
	int iSmoke;
	int iExercise;
	int iDrinking;
	
	String t1SubTxtEa;
	String t1SubTxtIa;
	String strSmoke;
	String strExercise;
	String strDrinking;
	
	ComboBox t1SubCmbSmoke;
	ComboBox t1SubCmbExercise;
	ComboBox t1SubCmbDrinking;
	TextField t1SubTextMemo;
	TextField t1SubTextIa;
	TextField t1SubTextEa;
	DatePicker t1SubDatePicker;
	Button t1SubBtnClose;
	Button t1SubBtnSave;
	Button t1SubBtnEdit;
	
	private int i=0;
	private int j=0;
	private int k=0;
	private int z=0;
	private int x=0;
	private int c=0;
	private int t=0;
	private int i1=0;
	private int j1=0;
	private int k1=0;
	private int z1=0;
	private int x1=0;
	private int c1=0;
	private int m=0;
	private int n=0;
	private int m1=0;
	private int n1=0;
	private int b=0;
	private int ea=0;
	private int ia=0;
	private int s1=0;
	
	@FXML private Button t1BtnRegister;
	@FXML private Button t1BtnCancel;
	@FXML private TableView <Smoking> t1TableView;
	@FXML private Button t1BtnEdit;
	@FXML private Button t1BtnDelete;
	@FXML private DatePicker t1DatePickerSearch;
	@FXML private Button t1BtnSearch;
	@FXML private DatePicker t4DatePickerSmoke;
	@FXML private DatePicker t4DatePickerNoSmoke;
	@FXML private ComboBox t4CmbAvgSmoke;
	
	@FXML private TextField t1TextExercise;
	@FXML private TextField t1TextSwimming;
	@FXML private TextField t1TextClimb;
	@FXML private TextField t1TextSoju;
	@FXML private TextField t1TextMacju;
	@FXML private TextField t1TextMacguli;
	@FXML private TextField t1TextSmoke;
	@FXML private Label t1LabelName;
	@FXML private Label t1LabelMisstion;
	@FXML private Button t4BtnSave;
	@FXML private ImageView t1Img1;
	@FXML private Label t1LabelTimer;
	@FXML private ImageView t4ImgRegister;
	@FXML private ImageView t4Img;
	@FXML private ImageView t4Img2;
	@FXML private ImageView t4Img3;
	
	@FXML private DatePicker t2DatePicker;
	@FXML private ImageView t2ExerciseImg;
	@FXML private ImageView t2DrinkingImg;
	@FXML private ImageView t2Smoke;
	
	HashMap<String, Integer> map = new HashMap<>();
	@FXML private PieChart t2PieChart;
	@FXML private BarChart t2BarChart;
	@FXML private Button t2BtnSearch;
	
	@FXML private Label t2LabelExercise;
	@FXML private Label t2LabelDrinking;
	@FXML private Label t2LabelSmoke;
	@FXML private TextField t4TextName=null;
	@FXML private TextField t4TextMisstion;
	@FXML private TextField t4TextBirth;
	@FXML private TextField t4TextEmail;
	@FXML private ComboBox t4ComboBox;
	@FXML private Button t4BtnClear;
	
	ArrayList<Smoking>dbArrayList;
	ArrayList<SmokingInformation> dbArrayList1;
	ObservableList<SmokingInformation>t4SmokingInformationList=FXCollections.observableArrayList();
	ObservableList<Smoking>t1TableList=FXCollections.observableArrayList(); //테이블뷰 연결리스트
	ObservableList obCmbClimb=FXCollections.observableArrayList();
	ObservableList <String>obList1 = FXCollections.observableArrayList();
	ObservableList <String>obList2 = FXCollections.observableArrayList();
	ObservableList<String>cmbGenderList=FXCollections.observableArrayList();
	ObservableList<String>cmbAvgSmokeList=FXCollections.observableArrayList();
	ObservableList list3=FXCollections.observableArrayList();
	ObservableList list4=FXCollections.observableArrayList();
	ObservableList list5=FXCollections.observableArrayList();

	//등록 콤보박스
	ObservableList obCmbSmokeRegisgter=FXCollections.observableArrayList();
	ObservableList obCmbExerciseRegisgter=FXCollections.observableArrayList();
	ObservableList obCmbDrinkingRegisgter=FXCollections.observableArrayList();
	//수정 콤보박스
	ObservableList obCmbSmokeEdit=FXCollections.observableArrayList();
	ObservableList obCmbExerciseEdit=FXCollections.observableArrayList();
	ObservableList obCmbDrinkingEdit=FXCollections.observableArrayList();

	private Smoking smoking;
	
	private Smoking selectSmoking;
	private int selectSmokingIndex;
	
	private boolean editFlag;
	
	private String t1SubExercise;
	private String t1SubSmoke;
	private String t1SubDrinking;
	
	private String fileName="";
	private File imageDir = new File("C:/images");
	
	private static Smoking t1SubDatePicker1;
	int count=0;
	File selectFile = null;

	private SmokingInformation smokingInformation;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//1. 등록버튼을 클릭하면 등록창이 나온다.
		t1BtnRegister.setOnAction((event) -> {handlerTab1BtnThirdAction();});
		//0. 텍스트가 나오게 해준다
		t1TextSet();
		//2. 나가기버튼을 클릭하면 창이 닫힌다.
		t1BtnCancel.setOnAction((e)->{handleTab1BtnCancelAction();});
		//3. 테이블뷰 연결
		t1Tab1TableView();
		//4. 수정버튼을 클릭하면 창이 나온다.
		t1BtnEdit.setOnAction((e)->{handleTab1BtnEditAction();});	
		//5. 삭제버튼 클릭시 테이블삭제.
		t1BtnDelete.setOnAction((e)->{handleTab1BtnDeleteAction();});
		//6. 날짜검색하면 정보값가져옴.
		t1BtnSearch.setOnAction((e)->{t1DatePickerSearchInformation();});
		//8. 차트 값 가져오기
		t2DatePicker.setOnAction((e)->{handleTab2DatePickerAction();});
		//9 프로필,정보 값 넣기
		t4ProfileInforMationRegister();
		//9-1. 프로필 저장
		t4BtnSave.setOnAction((e)->{handleTab4ProfileAction();});
		//11. Tab1에 현재시간 타이머 주기
		t1LabelTimer();
		//13. Tab3 문서자료링크
		t3BtnList1.setOnAction((e)->{handleTab3BtnListAction();});
		//14. list뷰에 리스트 추가
		t3ListAdd();
		//15. 프로필 저장값을 가져온후 저장한다.
		profileSaveLoad();
		//16. 등록,수정,삭제,종료 비활성화
		editRegisterSetting();
		//17.테이블뷰를 클릭했을시 액션
		t1TableView.setOnMouseClicked((MouseEvent e)-> {handleMouseClickTableView();});
		//18.tab3 문서동영상자료
		t3BtnList2.setOnAction((e)->{handleTab3BtnList2Action();});

	}
	

	//0. 텍스트가 나오게 해준다.
	private void t1TextSet() {
		
		List<Smoking> textList=SmokingDAO.getSmokingTotalData();
		for(Smoking smoking:textList) {
			String text1=smoking.getT1smoke();
			String text2=smoking.getT1drinking();
			String text3=smoking.getT1exercise();
			String text4=smoking.getT1ExpenseAmount();
			String text5=smoking.getT1IncomeAmount();
			
			
			
			String text11=text1.substring(2, 3);
			int b=Integer.parseInt(text11);
			s1=s1+b;
			
			if(text3.substring(0, 2).equals("헬스")) {
				String text33=text3.substring(2,4);
				int c=Integer.parseInt(text33);
				i1=i1+c;
			}
			if(text3.substring(0,2).equals("수영")) {
				String text44=text3.substring(2,4);
				int d=Integer.parseInt(text44);
				j1=j1+d;
			}
			if(text3.substring(0,2).equals("등산")) {
				String text55=text3.substring(2,4);
				int e=Integer.parseInt(text55);
				k1=k1+e;
			}
			if(text2.substring(0,2).equals("소주")) {
				String text66=text2.substring(2,3);
				int f=Integer.parseInt(text66);
				z1=z1+f;
			}
			if(text2.substring(0,2).equals("맥주")) {
				String text77=text2.substring(2,3);
				int g=Integer.parseInt(text77);
				x1=x1+g;
			}
			if(text2.substring(0,3).equals("막걸리")) {
				String text88=text2.substring(3,4);
				int h=Integer.parseInt(text88);
				c1=c1+h;
			}
			
			
				String text99=text5.substring(0,text5.length()-1);
				int i=Integer.parseInt(text99);
				m=m+i;
				
				String text100=text4.substring(0,text4.length()-1);
				int j=Integer.parseInt(text100);
				n=n+j;
			
				
		}
		t1TextExercise.setText(String.valueOf(this.i1).toString()+"분");
		t1TextSwimming.setText(String.valueOf(this.j1).toString()+"분");
		t1TextClimb.setText(String.valueOf(this.k1).toString()+"분");
		t1TextSoju.setText(String.valueOf(this.z1).toString()+"잔");
		t1TextMacju.setText(String.valueOf(this.x1).toString()+"잔");
		t1TextMacguli.setText(String.valueOf(this.c1).toString()+"잔");
		t1TextSmoke.setText(String.valueOf(this.s1).toString()+"개비");
		textSmokeTotal.setText(String.valueOf(this.m).toString()+"원");
		textSulTotal.setText(String.valueOf(this.n).toString()+"원");
		textPirceTotal.setText(String.valueOf(m+n)+"원");
		t2LabelSmoke.setText(String.valueOf((s1)+"개비"));
		t2LabelDrinking.setText(String.valueOf((z1+x1+c1)+"잔"));
		t2LabelExercise.setText(String.valueOf((i1+j1+k1)+"분"));
		
	}

	//1. 등록버튼을 클릭하면 등록창이 나온다.
	private void handlerTab1BtnThirdAction() {

		Parent register = null;
		try {
		
			
			Stage stage = new Stage(StageStyle.UTILITY);
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(mainStage);
			register = FXMLLoader.load(getClass().getResource("../View/register.fxml")); 
			
			//id등록
			t1SubCmbSmoke = (ComboBox)register.lookup("#t1SubCmbSmoke");
			t1SubCmbExercise = (ComboBox)register.lookup("#t1SubCmbExercise");
			t1SubCmbDrinking = (ComboBox)register.lookup("#t1SubCmbDrinking");
			t1SubTextMemo = (TextField)register.lookup("#t1SubTextMemo");
			t1SubTextEa = (TextField)register.lookup("#t1SubTextEa");
			t1SubTextIa = (TextField)register.lookup("#t1SubTextIa");
			t1SubDatePicker = (DatePicker)register.lookup("#t1SubDatePicker");
			t1SubBtnClose = (Button)register.lookup("#t1SubBtnClose");
			t1SubBtnSave = (Button)register.lookup("#t1SubBtnSave");
			t1SubBtnEdit = (Button)register.lookup("#t1SubBtnEdit");

			//콤보박스리스트 (운동)
			
			
			obCmbExerciseRegisgter.add("헬스10분");
			obCmbExerciseRegisgter.add("헬스20분");
			obCmbExerciseRegisgter.add("헬스30분");
			obCmbExerciseRegisgter.add("헬스40분");
			obCmbExerciseRegisgter.add("헬스50분");
			obCmbExerciseRegisgter.add("헬스60분");

			obCmbExerciseRegisgter.add("수영10분");
			obCmbExerciseRegisgter.add("수영20분");
			obCmbExerciseRegisgter.add("수영30분");
			obCmbExerciseRegisgter.add("수영40분");
			obCmbExerciseRegisgter.add("수영50분");
			obCmbExerciseRegisgter.add("수영60분");


			obCmbExerciseRegisgter.add("등산10분");
			obCmbExerciseRegisgter.add("등산20분");
			obCmbExerciseRegisgter.add("등산30분");
			obCmbExerciseRegisgter.add("등산40분");
			obCmbExerciseRegisgter.add("등산50분");
			obCmbExerciseRegisgter.add("등산60분");
	
			
			t1SubCmbExercise.setItems(obCmbExerciseRegisgter);
			
			//콤보박스리스트 음주
			
			obCmbDrinkingRegisgter.add("소주1잔");
			obCmbDrinkingRegisgter.add("소주2잔");
			obCmbDrinkingRegisgter.add("소주3잔");
			obCmbDrinkingRegisgter.add("소주4잔");
			obCmbDrinkingRegisgter.add("소주5잔");
			obCmbDrinkingRegisgter.add("소주6잔");
			obCmbDrinkingRegisgter.add("소주7잔");
		
			obCmbDrinkingRegisgter.add("맥주1잔");
			obCmbDrinkingRegisgter.add("맥주2잔");
			obCmbDrinkingRegisgter.add("맥주3잔");
			obCmbDrinkingRegisgter.add("맥주4잔");
			obCmbDrinkingRegisgter.add("맥주5잔");
			obCmbDrinkingRegisgter.add("맥주6잔");
			obCmbDrinkingRegisgter.add("맥주7잔");
			
			obCmbDrinkingRegisgter.add("막걸리1잔");
			obCmbDrinkingRegisgter.add("막걸리2잔");
			obCmbDrinkingRegisgter.add("막걸리3잔");
			obCmbDrinkingRegisgter.add("막걸리4잔");
			obCmbDrinkingRegisgter.add("막걸리5잔");
			obCmbDrinkingRegisgter.add("막걸리6잔");
			obCmbDrinkingRegisgter.add("막걸리7잔");

		
			t1SubCmbDrinking.setItems(obCmbDrinkingRegisgter);
	
			//콤보박스리스트 흡연한 수량...
			
			obCmbSmokeRegisgter.add("담배1개비");
			obCmbSmokeRegisgter.add("담배2개비");
			obCmbSmokeRegisgter.add("담배3개비");
			obCmbSmokeRegisgter.add("담배4개비");
			obCmbSmokeRegisgter.add("담배5개비");
			obCmbSmokeRegisgter.add("담배6개비");
			obCmbSmokeRegisgter.add("담배7개비");
	
			t1SubCmbSmoke.setItems(obCmbSmokeRegisgter);
			
			
			//저장버튼 누르면 흡연수량 저장 
			t1SubBtnSave.setOnAction((e1)->{
			
					t1SubSmoke=t1SubCmbSmoke.getSelectionModel().getSelectedItem().toString();
					t1SubExercise=t1SubCmbExercise.getSelectionModel().getSelectedItem().toString();
					t1SubDrinking=t1SubCmbDrinking.getSelectionModel().getSelectedItem().toString();
					String t1SubTxtMemo=t1SubTextMemo.getText();
					String t1SubdatePicker =t1SubDatePicker.getValue().toString();
					t1SubTxtEa=t1SubTextEa.getText();
					t1SubTxtIa=t1SubTextIa.getText();
					
					smoking= new Smoking(t1SubSmoke, t1SubExercise, t1SubDrinking, t1SubTxtMemo, 
							t1SubdatePicker, t1SubTxtEa+"원", t1SubTxtIa+"원");
					
					t1TableList.add(smoking);
					
					SmokingDAO.insertSmokingData(smoking);
					//등록버튼을 눌렀을때 i,j,k 헬스,수영,등산 값이 누적됨.
					
					String smokeDB=SmokingDAO.getSmokeDB(t1SubdatePicker);
					String exerciseDB=SmokingDAO.getExerciseDB(t1SubdatePicker);
					String drinkingDB=SmokingDAO.getDrinkingDB(t1SubdatePicker);
					String textSmokeTotalDB=SmokingDAO.gettextSmokeTotalDB(t1SubdatePicker);
					String textSulTotalDB=SmokingDAO.gettextSulTotalDB(t1SubdatePicker);
					
					
					
					
				
					if(exerciseDB.substring(0,2).equals("헬스")) {
						String t1SubExercise1=t1SubExercise.substring(2,4);
						int i=Integer.parseInt(t1SubExercise1);
						this.i1 = Integer.parseInt(t1TextExercise.getText().substring(0, t1TextExercise.getText().length()-1));
						this.i1=i+this.i1;
						t1TextExercise.setText(String.valueOf(this.i1).toString()+"분");
					}
					
					if(exerciseDB.substring(0,2).equals("수영")) {
						String t1SubExercise2=t1SubExercise.substring(2,4);
						int j=Integer.parseInt(t1SubExercise2);
						this.j1 = Integer.parseInt(t1TextSwimming.getText().substring(0, t1TextSwimming.getText().length()-1));
						this.j1=j+this.j1;
						t1TextSwimming.setText(String.valueOf(this.j1).toString()+"분");
					}
					
					if(exerciseDB.substring(0,2).equals("등산")) {
						String t1SubExercise3=t1SubExercise.substring(2,4);
						int k=Integer.parseInt(t1SubExercise3);
						this.k1 = Integer.parseInt(t1TextClimb.getText().substring(0, t1TextClimb.getText().length()-1));
						this.k1=k+this.k1;
						t1TextClimb.setText(String.valueOf(this.k1).toString()+"분");
					}
					
					//등록버튼을 눌렀을때 q,w,e 소주,맥주,막걸리 값이 누적됨.
					if(drinkingDB.substring(0,2).equals("소주")) {
						String t1SubDrinking1=t1SubDrinking.substring(2,3);
						int z=Integer.parseInt(t1SubDrinking1);
						this.z1 = Integer.parseInt(t1TextSoju.getText().substring(0, t1TextSoju.getText().length()-1));
						this.z1=z+this.z1;
						t1TextSoju.setText(String.valueOf(this.z1).toString()+"잔");
					}
					
					if(drinkingDB.substring(0,2).equals("맥주")) {
						String t1SubDrinking2=t1SubDrinking.substring(2,3);
						int x=Integer.parseInt(t1SubDrinking2);
						this.x1 = Integer.parseInt(t1TextMacju.getText().substring(0, t1TextMacju.getText().length()-1));
						this.x1=x+this.x;
						t1TextMacju.setText(String.valueOf(this.x1).toString()+"잔");
					}
					
					if(drinkingDB.substring(0,3).equals("막걸리")) {
						String t1SubDrinking3=t1SubDrinking.substring(3,4);
						int c=Integer.parseInt(t1SubDrinking3);
						this.c1 = Integer.parseInt(t1TextMacguli.getText().substring(0, t1TextMacguli.getText().length()-1));
						this.c1=c+this.c;
						t1TextMacguli.setText(String.valueOf(this.c1).toString()+"잔");
					}
					
					//등록버튼을 눌렀을때 s 흡연 값이 누적됨.
					if(smokeDB.substring(0,2).equals("담배")) { //변수.length -2 
						String t1SubSmoke1=t1SubSmoke.substring(2,3);
						int s=Integer.parseInt(t1SubSmoke1);
						this.s1 = Integer.parseInt(t1TextSmoke.getText().substring(0, t1TextSmoke.getText().length()-2));
						this.s1=s+this.s1;
						t1TextSmoke.setText(String.valueOf(this.s1).toString()+"개비");
					}
				
					
						
						String t1SubEa1=t1SubTxtEa.substring(0);
						int s11=Integer.parseInt(t1SubEa1);
						this.m = Integer.parseInt(textSmokeTotal.getText().substring(0, textSmokeTotal.getText().length()-1));
						this.m=s11+this.m;
						textSmokeTotal.setText(String.valueOf(this.m).toString()+"원");
						
						String t1SubIa1=t1SubTxtIa.substring(0);
						int d11=Integer.parseInt(t1SubIa1);
						this.n = Integer.parseInt(textSulTotal.getText().substring(0, textSulTotal.getText().length()-1));
						this.n=d11+this.n;
						textSulTotal.setText(String.valueOf(this.n).toString()+"원");
						
						textPirceTotal.setText(String.valueOf(this.m+this.n).toString()+"원");
					
					
					//10. Tab2에 라벨에 토탈값 변경
					t2LabelTotal();
				
				
			});
	
			//취소버튼 눌렀을떼 close 됨
			t1SubBtnClose.setOnAction((e) ->{stage.close();});
			
			Scene scene = new Scene(register);
			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e) {}

	}

	//2. 취소버튼을 클릭하면 창이 닫힌다.
	private void handleTab1BtnCancelAction() {
		Platform.exit();
			
	}
	
	//3. 테이블뷰 연결
	private void t1Tab1TableView() {
		
		TableColumn t1smoke=t1TableView.getColumns().get(0);
		t1smoke.setCellValueFactory(new PropertyValueFactory<>("t1smoke"));
		t1smoke.setStyle("-fx-alignment:CENTER;");
		
		TableColumn t1exercise=t1TableView.getColumns().get(1);
		t1exercise.setCellValueFactory(new PropertyValueFactory<>("t1exercise"));
		t1exercise.setStyle("-fx-alignment:CENTER;");
		
		TableColumn t1drinking=t1TableView.getColumns().get(2);
		t1drinking.setCellValueFactory(new PropertyValueFactory<>("t1drinking"));
		t1drinking.setStyle("-fx-alignment:CENTER;");
		
		TableColumn t1memo=t1TableView.getColumns().get(3);
		t1memo.setCellValueFactory(new PropertyValueFactory<>("t1memo"));
		t1memo.setStyle("-fx-alignment:CENTER;");
		
		TableColumn t1datePicker=t1TableView.getColumns().get(4);
		t1datePicker.setCellValueFactory(new PropertyValueFactory<>("t1datePicker"));
		t1datePicker.setStyle("-fx-alignment:CENTER;");
		
		TableColumn t1ExpenseAmount=t1TableView.getColumns().get(5);
		t1ExpenseAmount.setCellValueFactory(new PropertyValueFactory<>("t1ExpenseAmount"));
		t1ExpenseAmount.setStyle("-fx-alignment:CENTER;");
		
		TableColumn t1IncomeAmount=t1TableView.getColumns().get(6);
		t1IncomeAmount.setCellValueFactory(new PropertyValueFactory<>("t1IncomeAmount"));
		t1IncomeAmount.setStyle("-fx-alignment:CENTER;");
		
		t1TableView.setItems(t1TableList);
		
		//테이블뷰에 데이터베이스를 가져와서 등록
		dbArrayList=SmokingDAO.getSmokingTotalData();
		for(Smoking smoking : dbArrayList) {
			t1TableList.add(smoking);
			
		}
		
	}
	
	//4. 수정버튼을 클릭하면 창이 나온다.
	private void handleTab1BtnEditAction() {
		Parent edit = null;
		try {
			
			Stage stage = new Stage(StageStyle.UTILITY);
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(mainStage);
			edit = FXMLLoader.load(getClass().getResource("../View/edit.fxml")); 
			
			//id등록
			
			ComboBox t1SubCmbSmoke = (ComboBox)edit.lookup("#t1SubCmbSmoke");
			ComboBox t1SubCmbExercise = (ComboBox)edit.lookup("#t1SubCmbExercise");
			ComboBox t1SubCmbDrinking = (ComboBox)edit.lookup("#t1SubCmbDrinking");
			TextField t1SubTextMemo = (TextField)edit.lookup("#t1SubTextMemo");
			TextField t1SubTextEa = (TextField)edit.lookup("#t1SubTextEa");
			TextField t1SubTextIa = (TextField)edit.lookup("#t1SubTextIa");
			DatePicker t1SubDatePicker = (DatePicker)edit.lookup("#t1SubDatePicker");
			Button t1SubBtnClose = (Button)edit.lookup("#t1SubBtnClose");
			Button t1SubBtnSave = (Button)edit.lookup("#t1SubBtnSave");
			Button t1SubBtnEdit = (Button)edit.lookup("#t1SubBtnEdit");

			
			
			//콤보박스리스트 음주
			
			obCmbDrinkingEdit.add("소주1잔");
			obCmbDrinkingEdit.add("소주2잔");
			obCmbDrinkingEdit.add("소주3잔");
			obCmbDrinkingEdit.add("소주4잔");
			obCmbDrinkingEdit.add("소주5잔");
			obCmbDrinkingEdit.add("소주6잔");
			obCmbDrinkingEdit.add("소주7잔");
			
			
			obCmbDrinkingEdit.add("맥주1잔");
			obCmbDrinkingEdit.add("맥주2잔");
			obCmbDrinkingEdit.add("맥주3잔");
			obCmbDrinkingEdit.add("맥주4잔");
			obCmbDrinkingEdit.add("맥주5잔");
			obCmbDrinkingEdit.add("맥주6잔");
			obCmbDrinkingEdit.add("맥주7잔");
			
			obCmbDrinkingEdit.add("막걸리1잔");
			obCmbDrinkingEdit.add("막걸리2잔");
			obCmbDrinkingEdit.add("막걸리3잔");
			obCmbDrinkingEdit.add("막걸리4잔");
			obCmbDrinkingEdit.add("막걸리5잔");
			obCmbDrinkingEdit.add("막걸리6잔");
			obCmbDrinkingEdit.add("막걸리7잔");
			
			
			t1SubCmbDrinking.setItems(obCmbDrinkingEdit);
			
			
			//콤보박스리스트 (운동)
			obCmbExerciseEdit.add("헬스10분");
			obCmbExerciseEdit.add("헬스20분");
			obCmbExerciseEdit.add("헬스30분");
			obCmbExerciseEdit.add("헬스40분");
			obCmbExerciseEdit.add("헬스50분");
			obCmbExerciseEdit.add("헬스60분");
			
			obCmbExerciseEdit.add("수영10분");
			obCmbExerciseEdit.add("수영20분");
			obCmbExerciseEdit.add("수영30분");
			obCmbExerciseEdit.add("수영40분");
			obCmbExerciseEdit.add("수영50분");
			obCmbExerciseEdit.add("수영60분");
			
			obCmbExerciseEdit.add("등산10분");
			obCmbExerciseEdit.add("등산20분");
			obCmbExerciseEdit.add("등산30분");
			obCmbExerciseEdit.add("등산40분");
			obCmbExerciseEdit.add("등산50분");
			obCmbExerciseEdit.add("등산60분");
			
			t1SubCmbExercise.setItems(obCmbExerciseEdit);
			
			//콤보박스리스트 흡연한 수량...
			obCmbSmokeEdit.add("담배1개비");
			obCmbSmokeEdit.add("담배2개비");
			obCmbSmokeEdit.add("담배3개비");
			obCmbSmokeEdit.add("담배4개비");
			obCmbSmokeEdit.add("담배5개비");
			obCmbSmokeEdit.add("담배6개비");
			obCmbSmokeEdit.add("담배7개비");
			
			t1SubCmbSmoke.setItems(obCmbSmokeEdit);
		

			// 테이블뷰 정보를 가져옴.
			selectSmoking=t1TableView.getSelectionModel().getSelectedItem();
			t1SubCmbSmoke.getSelectionModel().select(selectSmoking.getT1smoke());
			
			selectSmoking=t1TableView.getSelectionModel().getSelectedItem();
			t1SubCmbExercise.getSelectionModel().select(selectSmoking.getT1exercise());
			
			selectSmoking=t1TableView.getSelectionModel().getSelectedItem();
			t1SubCmbDrinking.getSelectionModel().select(selectSmoking.getT1drinking());
			
			selectSmoking=t1TableView.getSelectionModel().getSelectedItem();
			t1SubTextMemo.setText(selectSmoking.getT1memo());
			
			t1SubDatePicker.setValue(LocalDate.parse(selectSmoking.getT1datePicker()));
			
			selectSmoking=t1TableView.getSelectionModel().getSelectedItem();
			t1SubTextEa.setText(selectSmoking.getT1ExpenseAmount());
			
			selectSmoking=t1TableView.getSelectionModel().getSelectedItem();
			t1SubTextIa.setText(selectSmoking.getT1IncomeAmount());
			
			
			//수정버튼 클릭하면 변경된 값 저장. 
			t1SubBtnEdit.setOnAction((e)->{
				
				t1SubSmoke=t1SubCmbSmoke.getSelectionModel().getSelectedItem().toString();
				t1SubExercise=t1SubCmbExercise.getSelectionModel().getSelectedItem().toString();
				t1SubDrinking=t1SubCmbDrinking.getSelectionModel().getSelectedItem().toString();
				String t1SubTxtMemo=t1SubTextMemo.getText();
				String t1SubdatePicker =t1SubDatePicker.getValue().toString();
				String t1SubTxtEa=t1SubTextEa.getText();
				String t1SubTxtIa=t1SubTextIa.getText();
				
				smoking= new Smoking(t1SubSmoke, t1SubExercise, t1SubDrinking, t1SubTxtMemo, 
						t1SubdatePicker, t1SubTxtEa+"원", t1SubTxtIa+"원");
				
				int t1TableViewInt=t1TableView.getSelectionModel().getSelectedIndex();
				t1TableList.add(t1TableViewInt+1,smoking);
				
				handleTab1BtnDeleteAction();
				
				SmokingDAO.insertSmokingData(smoking);
				
				String smokeDB=SmokingDAO.getSmokeDB(t1SubdatePicker);
				String exerciseDB=SmokingDAO.getExerciseDB(t1SubdatePicker);
				String drinkingDB=SmokingDAO.getDrinkingDB(t1SubdatePicker);
				
				//---------------------------------------------------------------------
				
				if(exerciseDB.substring(0,2).equals("헬스")) {
					String t1SubExercise1=t1SubExercise.substring(2,4);
					int i=Integer.parseInt(t1SubExercise1);
					this.i1 = Integer.parseInt(t1TextExercise.getText().substring(0, t1TextExercise.getText().length()-1));
					this.i1=i+this.i1;
					t1TextExercise.setText(String.valueOf(this.i1).toString()+"분");
				}
				
				if(exerciseDB.substring(0,2).equals("수영")) {
					String t1SubExercise2=t1SubExercise.substring(2,4);
					int j=Integer.parseInt(t1SubExercise2);
					this.j1 = Integer.parseInt(t1TextSwimming.getText().substring(0, t1TextSwimming.getText().length()-1));
					this.j1=j+this.j1;
					t1TextSwimming.setText(String.valueOf(this.j1).toString()+"분");
				}
				
				if(exerciseDB.substring(0,2).equals("등산")) {
					String t1SubExercise3=t1SubExercise.substring(2,4);
					int k=Integer.parseInt(t1SubExercise3);
					this.k1 = Integer.parseInt(t1TextClimb.getText().substring(0, t1TextClimb.getText().length()-1));
					this.k1=k+this.k1;
					t1TextClimb.setText(String.valueOf(this.k1).toString()+"분");
				}
				
				//등록버튼을 눌렀을때 q,w,e 소주,맥주,막걸리 값이 누적됨.
				if(drinkingDB.substring(0,2).equals("소주")) {
					String t1SubDrinking1=t1SubDrinking.substring(2,3);
					int z=Integer.parseInt(t1SubDrinking1);
					this.z1 = Integer.parseInt(t1TextSoju.getText().substring(0, t1TextSoju.getText().length()-1));
					this.z1=z+this.z1;
					t1TextSoju.setText(String.valueOf(this.z1).toString()+"잔");
				}
				
				if(drinkingDB.substring(0,2).equals("맥주")) {
					String t1SubDrinking2=t1SubDrinking.substring(2,3);
					int x=Integer.parseInt(t1SubDrinking2);
					this.x1 = Integer.parseInt(t1TextMacju.getText().substring(0, t1TextMacju.getText().length()-1));
					this.x1=x+this.x;
					t1TextMacju.setText(String.valueOf(this.x1).toString()+"잔");
				}
				
				if(drinkingDB.substring(0,3).equals("막걸리")) {
					String t1SubDrinking3=t1SubDrinking.substring(3,4);
					int c=Integer.parseInt(t1SubDrinking3);
					this.c1 = Integer.parseInt(t1TextMacguli.getText().substring(0, t1TextMacguli.getText().length()-1));
					this.c1=c+this.c;
					t1TextMacguli.setText(String.valueOf(this.c1).toString()+"잔");
				}
				
				//등록버튼을 눌렀을때 s 흡연 값이 누적됨.
				if(smokeDB.substring(0,2).equals("담배")) { //변수.length -2 
					String t1SubSmoke1=t1SubSmoke.substring(2,3);
					int s=Integer.parseInt(t1SubSmoke1);
					this.s1 = Integer.parseInt(t1TextSmoke.getText().substring(0, t1TextSmoke.getText().length()-2));
					this.s1=s+this.s1;
					t1TextSmoke.setText(String.valueOf(this.s1).toString()+"개비");
					
				}
				
				
				String t1 = t1TextExercise.getText().substring(0, t1TextExercise.getText().length()-1);
				int q=Integer.parseInt(t1);
				String t2 = t1TextSwimming.getText().substring(0, t1TextSwimming.getText().length()-1);
				int w=Integer.parseInt(t2);
				String t3 = t1TextClimb.getText().substring(0, t1TextClimb.getText().length()-1);
				int e1=Integer.parseInt(t3);
				t2LabelExercise.setText(String.valueOf(q+w+e1)+"분");
				
				
				
				String t4 = t1TextSoju.getText().substring(0, t1TextSoju.getText().length()-1);
				int r=Integer.parseInt(t4);
				String t5 = t1TextMacju.getText().substring(0, t1TextMacju.getText().length()-1);
				int t=Integer.parseInt(t5);
				String t6 = t1TextMacguli.getText().substring(0, t1TextMacguli.getText().length()-1);
				int y=Integer.parseInt(t6);
				t2LabelDrinking.setText(String.valueOf(r+t+y)+"잔");
				
				String t7 = t1TextSmoke.getText().substring(0, t1TextSmoke.getText().length()-2);
				int u=Integer.parseInt(t7);
				t2LabelSmoke.setText(String.valueOf(u)+"개비");
				
				
				
				
				
				String t1SubEa1=t1SubTxtEa.substring(0);
				int s11=Integer.parseInt(t1SubEa1);
				this.m = Integer.parseInt(textSmokeTotal.getText().substring(0, textSmokeTotal.getText().length()-1));
				this.m=s11+this.m;
				textSmokeTotal.setText(String.valueOf(this.m).toString()+"원");
				
				String t1SubIa1=t1SubTxtIa.substring(0);
				int d11=Integer.parseInt(t1SubIa1);
				this.n = Integer.parseInt(textSulTotal.getText().substring(0, textSulTotal.getText().length()-1));
				this.n=d11+this.n;
				textSulTotal.setText(String.valueOf(this.n).toString()+"원");
				
				textPirceTotal.setText(String.valueOf(this.m+this.n).toString()+"원");
			
						
			});
			
		
			//취소버튼 눌렀을떼 close 됨
			t1SubBtnClose.setOnAction((e) ->{stage.close();});
			
			Scene scene = new Scene(edit);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {}
	}
	
	//5. 삭제버튼 클릭시 테이블삭제.
	private void handleTab1BtnDeleteAction() {
		selectSmoking =t1TableView.getSelectionModel().getSelectedItem();
		selectSmokingIndex=t1TableView.getSelectionModel().getSelectedIndex();
		//t1TableList.remove(selectSmokingIndex);
		
		
		//삭제버튼 눌렀을대 total값에서 선택된 등록값을 뺀다.
		if(selectSmoking.getT1exercise().substring(0,2).equals("헬스")) {
			String t1SubExercise1=selectSmoking.getT1exercise().substring(2,4);
			int i=Integer.parseInt(t1SubExercise1);
			this.i1 = Integer.parseInt(t1TextExercise.getText().substring(0, t1TextExercise.getText().length()-1));
			this.i1=this.i1-i;
			t1TextExercise.setText(String.valueOf(this.i1).toString()+"분");
		}
		if(selectSmoking.getT1exercise().substring(0,2).equals("수영")) {
			String t1SubExercise2=selectSmoking.getT1exercise().substring(2,4);
			int j=Integer.parseInt(t1SubExercise2);
			this.j1 = Integer.parseInt(t1TextSwimming.getText().substring(0, t1TextSwimming.getText().length()-1));
			this.j1=this.j1-j;
			t1TextSwimming.setText(String.valueOf(this.j1).toString()+"분");
		}
		if(selectSmoking.getT1exercise().substring(0,2).equals("등산")) {
			String t1SubExercise3=selectSmoking.getT1exercise().substring(2,4);
			int k=Integer.parseInt(t1SubExercise3);
			this.k1 = Integer.parseInt(t1TextClimb.getText().substring(0, t1TextClimb.getText().length()-1));
			this.k1=this.k1-k;
			t1TextClimb.setText(String.valueOf(this.k1).toString()+"분");
		}
		
//--------------------------------------------------------------------------------------//		
		if(selectSmoking.getT1drinking().substring(0,2).equals("소주")) {
			String t1SubExercise4=selectSmoking.getT1drinking().substring(2,3);
			int z=Integer.parseInt(t1SubExercise4);
			this.z1 = Integer.parseInt(t1TextSoju.getText().substring(0, t1TextSoju.getText().length()-1));
			this.z1=this.z1-z;
			t1TextSoju.setText(String.valueOf(this.z1).toString()+"잔");
		}
		if(selectSmoking.getT1drinking().substring(0,2).equals("맥주")) {
			String t1SubExercise5=selectSmoking.getT1drinking().substring(2,3);
			int x=Integer.parseInt(t1SubExercise5);
			this.x1 = Integer.parseInt(t1TextMacju.getText().substring(0, t1TextMacju.getText().length()-1));
			this.x1=this.x1-x;
			t1TextMacju.setText(String.valueOf(this.x1).toString()+"잔");
		}
		if(selectSmoking.getT1drinking().substring(0,3).equals("막걸리")) {
			String t1SubExercise6=selectSmoking.getT1drinking().substring(3,4);
			int c=Integer.parseInt(t1SubExercise6);
			this.c1 = Integer.parseInt(t1TextMacguli.getText().substring(0, t1TextMacguli.getText().length()-1));
			this.c1=this.c1-c;
			t1TextMacguli.setText(String.valueOf(this.c1).toString()+"잔");
		}
//--------------------------------------------------------------------------------------//	
		
		
		if(selectSmoking.getT1smoke().substring(0,2).equals("담배")) {
			String t1SubExercise7=selectSmoking.getT1smoke().substring(2,3);
			int s=Integer.parseInt(t1SubExercise7);
			this.s1 = Integer.parseInt(t1TextSmoke.getText().substring(0, t1TextSmoke.getText().length()-2));
			this.s1=this.s1-s;
			t1TextSmoke.setText(String.valueOf(this.s1).toString()+"개비");
		}
		 
			String t1SubEa=selectSmoking.getT1ExpenseAmount().substring(0, selectSmoking.getT1ExpenseAmount().length()-1);
			int s=Integer.parseInt(t1SubEa);
			this.ea = Integer.parseInt(textSmokeTotal.getText().substring(0, textSmokeTotal.getText().length()-1));
			this.ea=this.ea-s;
			textSmokeTotal.setText(String.valueOf(this.ea).toString()+"원");
		
			String t1SubIa=selectSmoking.getT1IncomeAmount().substring(0, selectSmoking.getT1IncomeAmount().length()-1);
			int s1=Integer.parseInt(t1SubIa);
			this.ia = Integer.parseInt(textSulTotal.getText().substring(0, textSulTotal.getText().length()-1));
			this.ia=this.ia-s1;
			textSulTotal.setText(String.valueOf(this.ia).toString()+"원");
		
		 
			 String selectPrice=textPirceTotal.getText().substring(0, textPirceTotal.getText().length()-1); 
			 int priceTotalInt=Integer.parseInt(selectPrice);
			
			 
			
			 textPirceTotal.setText(String.valueOf(priceTotalInt-(s+s1)).toString()+"원");
		 
		 
		
//--------------------------------------------------------------------------------------//	
		// DB삭제 
//		System.out.println(smoking.getT1datePicker());
		//selectSmoking=t1TableView.getSelectionModel().getSelectedItem();
		System.out.println(selectSmoking.getT1datePicker());
		int count = SmokingDAO.deleteSmokingData(selectSmoking.getT1datePicker());
		System.out.println(count);
		if(count!=0){
			t1TableList.remove(selectSmokingIndex);
			dbArrayList.remove(selectSmoking);
			//테이블뷰 클릭 - > 플래그 true 때문 다음번에 등록버튼이 나오지 않음.
			editFlag = false;
			
			callAlert("삭제 완료 : 삭제가 완료 되었습니다. ");
			
		}else {
			return;
		}
		
		
		//t2total값 삭제
		String t1 = t1TextExercise.getText().substring(0, t1TextExercise.getText().length()-1);
		int q=Integer.parseInt(t1);
		String t2 = t1TextSwimming.getText().substring(0, t1TextSwimming.getText().length()-1);
		int w=Integer.parseInt(t2);
		String t3 = t1TextClimb.getText().substring(0, t1TextClimb.getText().length()-1);
		int e=Integer.parseInt(t3);
		t2LabelExercise.setText(String.valueOf(q+w+e)+"분");
		
		
		
		String t4 = t1TextSoju.getText().substring(0, t1TextSoju.getText().length()-1);
		int r=Integer.parseInt(t4);
		String t5 = t1TextMacju.getText().substring(0, t1TextMacju.getText().length()-1);
		int t=Integer.parseInt(t5);
		String t6 = t1TextMacguli.getText().substring(0, t1TextMacguli.getText().length()-1);
		int y=Integer.parseInt(t6);
		t2LabelDrinking.setText(String.valueOf(r-t-y)+"잔");
		
		String t7 = t1TextSmoke.getText().substring(0, t1TextSmoke.getText().length()-2);
		int u=Integer.parseInt(t7);
		t2LabelSmoke.setText(String.valueOf(u)+"개비");
		
		
		
		
	}	
	
	//6. 날짜검색하면 정보값가져옴.
	private void t1DatePickerSearchInformation() {
		int i=0;
		for(Smoking smoking : t1TableList) {
			if(t1DatePickerSearch.getValue().toString().equals(smoking.getT1datePicker())) {
				t1TableView.getSelectionModel().select(smoking);
				i=1;
				t1TableView.scrollTo(smoking);
			}
		}
		if(i==0) {
			callAlert("선택한 날짜가 없습니다.다시 선택해주세요.: 오류.");
		}
			
	}
	
	//8. 차트 값 가져오기.
	private void handleTab2DatePickerAction() {
		//8.1 파이차트
		int i=0;
		for(Smoking smoking : t1TableList) {
			if(t2DatePicker.getValue().toString().equals(smoking.getT1datePicker())) {
				t1TableView.getSelectionModel().select(smoking);
				i=1;
				t1TableView.scrollTo(smoking);
			}
		}
		if(i==0) {
			callAlert("선택한 날짜가 없습니다.다시 선택해주세요.: 오류.");
		}
		
		
		//차트값 등록 및 초기화
		int j=0;
		for(Smoking sm : t1TableList) {
			String str=sm.getT1datePicker().toString();
			if(t2DatePicker.getValue().toString().equals(str)) {
				map.clear();
				strSmoke = t1TableView.getSelectionModel().getSelectedItem().getT1smoke().substring(2,3);
				 iSmoke=Integer.parseInt(strSmoke);
				
				strExercise = t1TableView.getSelectionModel().getSelectedItem().getT1exercise().substring(2,4);
				 iExercise=Integer.parseInt(strExercise);
				
				strDrinking = t1TableView.getSelectionModel().getSelectedItem().getT1drinking().substring(t1TableView.getSelectionModel().getSelectedItem().getT1drinking().length()-2,
						t1TableView.getSelectionModel().getSelectedItem().getT1drinking().length()-1);
				 iDrinking=Integer.parseInt(strDrinking);
				
				map.put(t1TableView.getSelectionModel().getSelectedItem().getT1smoke().toString(),
						iSmoke);
				map.put(t1TableView.getSelectionModel().getSelectedItem().getT1exercise().toString(),
						iExercise);
				map.put(t1TableView.getSelectionModel().getSelectedItem().getT1drinking().toString(),
						iDrinking);
				j=1;
				break;
				
			}
			
		}
		
		if(j==0 && t2DatePicker!=null) {
			map.clear();
			t1TableView.getSelectionModel().clearSelection();
		} 
		else if(i==0 && t2DatePicker==null){
			callAlert("선택한 날짜가 없습니다.다시 선택해주세요.: 오류.");
		}
		
		ObservableList list=FXCollections.observableArrayList();
		Set<String> key = map.keySet();
		Iterator<String>iterator=key.iterator();
		while(iterator.hasNext()) {
			String keystr = iterator.next();
			list.add(new PieChart.Data(keystr,map.get(keystr))); //PieChart.Data 는 정적 내부클래스
			
		}
		t2PieChart.setData(list);
		
		//8.2 바 차트
		int k=0;
		for(Smoking smoking : t1TableList) {
			if(t2DatePicker.getValue().toString().equals(smoking.getT1datePicker())) {
				t1TableView.getSelectionModel().select(smoking);
				k=1;
				t1TableView.scrollTo(smoking);
			}
		}
		if(k==0) {
			callAlert("선택한 날짜가 없습니다.다시 선택해주세요.: 오류.");
		}
		
		//차트값 등록 및 초기화
		int l=0;
		list3.clear();
		list4.clear();
		list5.clear();
		
		for(Smoking sm : t1TableList) {
			String str=sm.getT1datePicker().toString();
			if(t2DatePicker.getValue().toString().equals(str)) {
				t2BarChart.getData().clear();
				
				l=1;
				strSmoke = t1TableView.getSelectionModel().getSelectedItem().getT1smoke().substring(2,3);
				int iSmoke=Integer.parseInt(strSmoke);
				
				strExercise = t1TableView.getSelectionModel().getSelectedItem().getT1exercise().substring(2,4);
				int iExercise=Integer.parseInt(strExercise);
				
				strDrinking = t1TableView.getSelectionModel().getSelectedItem().getT1drinking().substring(t1TableView.getSelectionModel().getSelectedItem().getT1drinking().length()-2,
						t1TableView.getSelectionModel().getSelectedItem().getT1drinking().length()-1);
				int iDrinking=Integer.parseInt(strDrinking);
				
				XYChart.Series<String, Integer>series1=new XYChart.Series();
				series1.setName("흡연");
				list3.add(new XYChart.Data<>(strSmoke.toString(),iSmoke));
				series1.setData(list3);
				t2BarChart.getData().add(series1);
			
				t2BarChart.setAnimated(false);
				
				XYChart.Series<String, Integer>series2=new XYChart.Series();
				series2.setName("운동");
				list4.add(new XYChart.Data<>(strExercise.toString(),iExercise));
				series2.setData(list4);
				t2BarChart.getData().add(series2);
				
				t2BarChart.setAnimated(false);
				
				
				
				XYChart.Series<String, Integer>series3=new XYChart.Series();
				series3.setName("음주");
				list5.add(new XYChart.Data<>(strDrinking.toString(),iDrinking));
				series3.setData(list5);
				t2BarChart.getData().add(series3);
			
				t2BarChart.setAnimated(false);
				
				break;
				
			}
			
			
		}
		
		if(j==0 && t2DatePicker!=null) {
			t1TableView.getSelectionModel().clearSelection();
		
			
		} 
		else if(i==0 && t2DatePicker==null){
			callAlert("선택한 날짜가 없습니다.다시 선택해주세요.: 오류.");
		}
			
		
		
		
		
	
		
		
		
	}
	
	//9 프로필,정보 값 넣기
	private void t4ProfileInforMationRegister() {
		//성별
		cmbGenderList.add("남자");
		cmbGenderList.add("여자");
		t4ComboBox.setItems(cmbGenderList);
		
		//평균흡연량
		cmbAvgSmokeList.add("1개비");
		cmbAvgSmokeList.add("2개비");
		cmbAvgSmokeList.add("3개비");
		cmbAvgSmokeList.add("4개비");
		cmbAvgSmokeList.add("5개비");
		t4CmbAvgSmoke.setItems(cmbAvgSmokeList);
		
		
	
		
	}
	
	//9-1. 프로필 저장
	private void handleTab4ProfileAction() {
		
				t4TextName.getText();
				t1LabelName.setText(t4TextName.getText());
				
				//사명서
				t4TextMisstion.getText();
				t1LabelMisstion.setText(t4TextMisstion.getText().toString());
				
				//성별
				t4ComboBox.setItems(cmbGenderList);
				
				//생일
				t4TextBirth.getText();
				
				//이메일
				t4TextEmail.getText();
				
				//흡연시작일
				t4DatePickerSmoke.getValue().toString();
				
				//금연시작일
				t4DatePickerNoSmoke.getValue().toString();
				
				//평균 흡연량
				t4CmbAvgSmoke.setItems(cmbAvgSmokeList);
			
				
					SmokingInformation smokingInformation=new SmokingInformation(t4TextName.getText(), t4TextMisstion.getText(), t4ComboBox.getSelectionModel().getSelectedItem().toString(),
							t4TextBirth.getText(), t4TextEmail.getText(), t4DatePickerSmoke.getValue().toString(), t4DatePickerNoSmoke.getValue().toString(), t4CmbAvgSmoke.getSelectionModel().getSelectedItem().toString());
					SmokingDAO.insertSmokingInformationData(smokingInformation);

		
	}
	

	//10. Tab2에 라벨에 토탈값 변경
	private void t2LabelTotal() {
	
	
		String t1 = t1TextExercise.getText().substring(0, t1TextExercise.getText().length()-1);
		int q=Integer.parseInt(t1);
		String t2 = t1TextSwimming.getText().substring(0, t1TextSwimming.getText().length()-1);
		int w=Integer.parseInt(t2);
		String t3 = t1TextClimb.getText().substring(0, t1TextClimb.getText().length()-1);
		int e=Integer.parseInt(t3);
		t2LabelExercise.setText(String.valueOf(q+w+e)+"분");
		
		
		
		String t4 = t1TextSoju.getText().substring(0, t1TextSoju.getText().length()-1);
		int r=Integer.parseInt(t4);
		String t5 = t1TextMacju.getText().substring(0, t1TextMacju.getText().length()-1);
		int t=Integer.parseInt(t5);
		String t6 = t1TextMacguli.getText().substring(0, t1TextMacguli.getText().length()-1);
		int y=Integer.parseInt(t6);
		t2LabelDrinking.setText(String.valueOf(r+t+y)+"잔");
		
		String t7 = t1TextSmoke.getText().substring(0, t1TextSmoke.getText().length()-2);
		int u=Integer.parseInt(t7);
		t2LabelSmoke.setText(String.valueOf(u)+"개비");
//-------------------------------------------------------------------------------------//
	}

	//11. Tab1에 현재시간 타이머 주기
	private void t1LabelTimer() {
		Task<Void> task =new Task<Void>() {

	         @Override
	         protected Void call() throws Exception {
	            try {
	               count=0;
	               while(true) {
	                  count++;
	                  SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
	                  String strDate = sdf.format(new Date());
	                  Platform.runLater(() -> {
	                     t1LabelTimer.setText(strDate);   
	                  });
	                  Thread.sleep(1000);
	               }
	            } catch (InterruptedException e) {
	               Platform.runLater(() -> {
	               callAlert("문제 : 문제");
	               });
	            }            return null;
	         }
	      };
	      Thread thread = new Thread(task);
	      thread.setDaemon(true);
	      thread.start();
		
	}
	
	//13. Tab3 문서자료링크
	private void handleTab3BtnListAction() {
			Parent link = null;
			try {
				
				Stage stage = new Stage(StageStyle.UTILITY);
				stage.initModality(Modality.WINDOW_MODAL);
				stage.initOwner(mainStage);
				link = FXMLLoader.load(getClass().getResource("../View/dataLink.fxml")); 
				
				 WebView dataLink=(WebView)link.lookup("#dateLink");
				 WebEngine web=dataLink.getEngine();
				 if(list1.getSelectionModel().getSelectedItem().equals("1.(문서)금연에 관한 오해와 명언 5가지")) {
					 web.load("https://blog.naver.com/nosmoking16/221049306567");
					 
				 }
				 if(list1.getSelectionModel().getSelectedItem().equals("2.(문서)금연에 도움이 되는 음식 10가지")) {
					 web.load("https://blog.naver.com/nosmoking16/220996354954");
					 
				 }
				 if(list1.getSelectionModel().getSelectedItem().equals("3.(문서)국내 금연정책")) {
					 web.load("https://blog.naver.com/sigumchi_1/221109526683");
					 
				 }
				 if(list1.getSelectionModel().getSelectedItem().equals("4.(문서)금연의 필요성")) {
					 web.load("https://blog.naver.com/dlwjdals7720/221070205315");
					 
				 }
				 if(list1.getSelectionModel().getSelectedItem().equals("5.(문서)간접흡연 현황")) {
					 web.load("https://blog.naver.com/tjsghk63/221461481297");
					 
				 }
				 if(list1.getSelectionModel().getSelectedItem().equals("6.(문서)흡연율과 흡연 형태2")) {
					 web.load("https://blog.naver.com/nosmoking16/220731506552");
					 
				 }
				 if(list1.getSelectionModel().getSelectedItem().equals("7.(문서)흡연율과 흡연 형태1")) {
					 web.load("https://blog.naver.com/nosmoking16/220719645931");
					 
				 }
			
				 if(list1.getSelectionModel().getSelectedItem().equals("8.(문서)스트레스와 금연2")) {
					 web.load("https://blog.naver.com/nosmoking16/220712706215");
					 
				 }
				 if(list1.getSelectionModel().getSelectedItem().equals("9.(문서)스트레스와 금연1")) {
					 web.load("https://blog.naver.com/nosmoking16/220707560146");
					 
				 }
				 if(list1.getSelectionModel().getSelectedItem().equals("10.(문서)금연 방법 선택하기 - 감연법/단연법-")) {
					 web.load("https://blog.naver.com/nonsmoker2017/221077347807");
					 
				 }
				 if(list1.getSelectionModel().getSelectedItem().equals("11.(문서)금연 후 체중 증가 원인")) {
					 web.load("https://blog.naver.com/1215johj/221107308461");
					 
				 }
				 if(list1.getSelectionModel().getSelectedItem().equals("12.(문서)흡연으로 인한 사망률")) {
					 web.load("https://blog.naver.com/sigumchi_1/221107322295");
					 
				 }
				 if(list1.getSelectionModel().getSelectedItem().equals("13.(문서)금단증상 바로알기")) {
					 web.load("https://blog.naver.com/barokeum/220846278974");
					 
				 }
				 if(list1.getSelectionModel().getSelectedItem().equals("14.(문서)흡연과 질병 - 신경/감각기계")) {
					 web.load("https://blog.naver.com/project_bcd/221358343764");
					 
				 }
				 if(list1.getSelectionModel().getSelectedItem().equals("15.(문서)흡연과 질병 - 순환기계")) {
					 web.load("https://blog.naver.com/suntrol/221236442123");
					 
				 }
				 if(list1.getSelectionModel().getSelectedItem().equals("16.(문서)흡연과 질병 - 호흡기계")) {
					 web.load("https://blog.naver.com/nosmoking16/220671273808");
					 
				 }
				 
	            Scene scene = new Scene(link);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {}
			
	}
	
	//14. list뷰에 리스트 추가
	private void t3ListAdd() {
			obList1.add("1.(문서)금연에 관한 오해와 명언 5가지");
			obList1.add("2.(문서)금연에 도움이 되는 음식 10가지");
			obList1.add("3.(문서)국내 금연정책");
			obList1.add("4.(문서)금연의 필요성");
			obList1.add("5.(문서)간접흡연 현황");
			obList1.add("6.(문서)흡연율과 흡연 형태2");
			obList1.add("7.(문서)흡연율과 흡연 형태1");
			obList1.add("8.(문서)스트레스와 금연2");
			obList1.add("9.(문서)스트레스와 금연1");
			obList1.add("10.(문서)금연 방법 선택하기 - 감연법/단연법-");
			obList1.add("11.(문서)금연 후 체중 증가 원인");
			obList1.add("12.(문서)흡연으로 인한 사망률");
			obList1.add("13.(문서)금단증상 바로알기");
			obList1.add("14.(문서)흡연과 질병 - 신경/감각기계");
			obList1.add("15.(문서)흡연과 질병 - 순환기계");
			obList1.add("16.(문서)흡연과 질병 - 호흡기계");
			
			list1.setItems(obList1);
			
			obList2.add("1.금연시작 전,반드시 체크해야 하는 3가지");
			obList2.add("2.40가지 외국의 금연광고");
			obList2.add("3.담배를 단박에 끊는 놀라운 두 가지 방법");
			obList2.add("4.금연시작하기");
			obList2.add("5.금연 후 체중 증가 원인과 식생활 가이드");
			obList2.add("6.14초의 휴식");
			obList2.add("7.금연시간에 따른 신체적 이득");
			obList2.add("8.금연 방법 선택하기");
			obList2.add("9.금연 생각보다 쉽고 당연히 좋다");
			obList2.add("10.금연성공자인터뷰-전기민님");
			obList2.add("11.금연성공자인터뷰-이만구님");
			obList2.add("12.금연성공자인터뷰-박진우님");
			obList2.add("13.금연성공자인터뷰-이경호님");
			obList2.add("14.7일만에 금연에 성공하는 심리기술 배우기-왓칭상상법");
			obList2.add("15.술자리 대처법");
			obList2.add("16.담배연기없는 대한민국이 되는 그날까지!");
			
			list2.setItems(obList2);
			
	}	
		
	//15. 프로필 저장값을 가져온후 저장한다.
	private void profileSaveLoad() {
		ArrayList<SmokingInformation> dbArrayList=SmokingDAO.getSmokingInformationTotalData();
		int a=0;
		for(SmokingInformation smokingInformation:dbArrayList) {
				String loadName=smokingInformation.getT4TextName();
				String loadMisstion=smokingInformation.getT4TextMisstion();
				String loadComboBox=smokingInformation.getT4ComboBox();
				String loadBirth=smokingInformation.getT4TextBirth();
				String loadEmail=smokingInformation.getT4TextEmail();
				String loadDatePickerSmoke=smokingInformation.getT4DatePickerSmoke();
				String loadDatePickerNoSmoke=smokingInformation.getT4DatePickerNoSmoke();
				String loadCmbAvgSmoke=smokingInformation.getT4CmbAvgSmoke();
				
				if(loadCmbAvgSmoke!=null) {
					t4TextName.setText(loadName);
					t4TextMisstion.setText(loadMisstion);
					t4ComboBox.getSelectionModel().select(loadComboBox);
					t4TextBirth.setText(loadBirth);
					t4TextEmail.setText(loadEmail);
					t4DatePickerSmoke.setValue(LocalDate.parse(loadDatePickerSmoke));
					t4DatePickerNoSmoke.setValue(LocalDate.parse(loadDatePickerNoSmoke));
					t4CmbAvgSmoke.getSelectionModel().select(loadCmbAvgSmoke);
					t1LabelMisstion.setText(t4TextMisstion.getText().toString());
					t1LabelName.setText(t4TextName.getText());
					
					a=1;
				}
				
				
		}
		if(a==0){
			ArrayList<SmokingInformation> smokingDAOLoad=SmokingDAO.getSmokingInformationTotalData();
			if(smokingDAOLoad.isEmpty()) {
				handleTab4ProfileAction();
			}
			
		}
	}	
	
	//16. 등록,수정,삭제,종료 비활성화
	private void editRegisterSetting() {
		if(t1TableView.getSelectionModel().isEmpty()) {
			t1BtnDelete.setDisable(true);
			t1BtnEdit.setDisable(true);
			
			
		}
		
			
	}
	
	//17.테이블뷰를 클릭했을시 액션
	
	private void handleMouseClickTableView() {
		t1BtnDelete.setDisable(false);
		t1BtnEdit.setDisable(false);
			
	}
	
	//18.tab3 문서동영상자료
	private void handleTab3BtnList2Action() {
		Parent link2 = null;
		try {
			
			Stage stage = new Stage(StageStyle.UTILITY);
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(mainStage);
			link2 = FXMLLoader.load(getClass().getResource("../View/videoLink.fxml")); 
			
			 WebView videoLink=(WebView)link2.lookup("#videoLink");
			 WebEngine web=videoLink.getEngine();
			 if(list2.getSelectionModel().getSelectedItem().equals("1.금연시작 전,반드시 체크해야 하는 3가지")) {
				 web.load("https://www.youtube.com/watch?v=kxakLJZex2k");
				 
			 }
			 if(list2.getSelectionModel().getSelectedItem().equals("2.40가지 외국의 금연광고")) {
				 web.load("https://www.youtube.com/watch?v=F-_Erl5DFXY");
				 
			 }
			 if(list2.getSelectionModel().getSelectedItem().equals("3.담배를 단박에 끊는 놀라운 두 가지 방법")) {
				 web.load("https://www.youtube.com/watch?v=N9UEF6S2RXM");
				 
			 }
			 if(list2.getSelectionModel().getSelectedItem().equals("4.금연시작하기")) {
				 web.load("https://www.youtube.com/watch?v=_UICmJOf9XE");
				 
			 }
			 if(list2.getSelectionModel().getSelectedItem().equals("5.금연 후 체중 증가 원인과 식생활 가이드")) {
				 web.load("https://www.youtube.com/watch?v=_T8N02ZOZeA");
				 
			 }
			 if(list2.getSelectionModel().getSelectedItem().equals("6.14초의 휴식")) {
				 web.load("https://www.youtube.com/watch?v=aikAyiRI63Y");
				 
			 }
			 if(list2.getSelectionModel().getSelectedItem().equals("7.금연시간에 따른 신체적 이득")) {
				 web.load("https://www.youtube.com/watch?v=uGSt_LKypcg");
				 
			 }
		
			 if(list2.getSelectionModel().getSelectedItem().equals("8.금연 방법 선택하기")) {
				 web.load("https://www.youtube.com/watch?v=OG1qbaDqzhs");
				 
			 }
			 if(list2.getSelectionModel().getSelectedItem().equals("9.금연 생각보다 쉽고 당연히 좋다")) {
				 web.load("https://www.youtube.com/watch?v=l0vntyobe1I");
				 
			 }
			 if(list2.getSelectionModel().getSelectedItem().equals("10.금연성공자인터뷰-전기민님")) {
				 web.load("https://www.youtube.com/watch?v=P4O5-dNOo8Q");
				 
			 }
			 if(list2.getSelectionModel().getSelectedItem().equals("11.금연성공자인터뷰-이만구님")) {
				 web.load("https://www.youtube.com/watch?v=lDYTgCEXWOc");
				 
			 }
			 if(list2.getSelectionModel().getSelectedItem().equals("12.금연성공자인터뷰-박진우님")) {
				 web.load("https://www.youtube.com/watch?v=6IPTFBYsU8I");
				 
			 }
			 if(list2.getSelectionModel().getSelectedItem().equals("13.금연성공자인터뷰-이경호님")) {
				 web.load("https://www.youtube.com/watch?v=zSs8KyWQKtY");
				 
			 }
			 if(list2.getSelectionModel().getSelectedItem().equals("14.7일만에 금연에 성공하는 심리기술 배우기-왓칭상상법")) {
				 web.load("https://www.youtube.com/watch?v=qjPXMUHb6ck");
				 
			 }
			 if(list2.getSelectionModel().getSelectedItem().equals("15.술자리 대처법")) {
				 web.load("https://www.youtube.com/watch?v=AqYbeJTLI7E");
				 
			 }
			 if(list2.getSelectionModel().getSelectedItem().equals("16.담배연기없는 대한민국이 되는 그날까지!")) {
				 web.load("https://www.youtube.com/watch?v=PFPhkjXsD1w");
				 
			 }
		    Scene scene = new Scene(link2);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {}
		
			
	}
	
	

	// 기타:알림창 (중간에 : 적어줄것) 예시 : "오류정보 : 값을 제대로 입력해주세요"
	public static void callAlert(String contentText) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("알림창");
		alert.setHeaderText(contentText.substring(0, contentText.lastIndexOf(":"))); // 0을 넣으면 ":" 앞에있는 글을 가져옴
		alert.setContentText(contentText.substring(contentText.lastIndexOf(":") + 1)); // +1을 하면 ":" 뒤에있는 글을 가져옴
		alert.showAndWait();
	}
	
	public void setStage(Stage mainStage) {
		this.mainStage = mainStage;
	}

}

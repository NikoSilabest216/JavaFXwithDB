package Drive;//5/31/2021//
import javafx.scene.control.*;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import static javafx.scene.control.TableView.CONSTRAINED_RESIZE_POLICY;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import connect.DatabaseConnect;
import model.modelDatabase;
import model.modelDatabase2;



//Niko Silabest//
//IntelliJ IDEA//
public class Driver extends Application{
    public TableView tblView;
    private Text txtInfo;
    private Label lblTitle,lblData,lblNIM,lblNAMA,lblJURUSAN,lblALAMAT,lblCari,lblWAKTU,lblGambar,lblGambar2,lblUser,lblPass,lblWarn,lblWarn2,lblK,lblK2;
    public TextField txtNIM,txtNAMA,txtJURUSAN,txtALAMAT,txtCARI,txtWAKTU,txtUser;
    public PasswordField txtPass;
    public TableColumn tblColumn1,tblColumn2,tblColumn3,tblColumn4,tblColumn5;
    private SplitPane splitPaneH;
    private VBox panevbox,panevbox2,vBox;
    private AnchorPane pane, pane2;
    private GridPane grid, grid2;
    private HBox panehbox,searchbox,hbox;
    private Button btnAdd,btnUpdate,btnDelete,btnClear,btnClose,btnRefresh,btnLogin,btnBack,btnReg;
    modelDatabase modelDb;
    modelDatabase2 modelDb2;
    ObservableList data = FXCollections.observableArrayList();

    public void initComponent(){
        try {
            //========================================================================
            lblData = new Label("FORM DATA");
            lblTitle = new Label();
            lblNIM = new Label("Matkul");
            lblNAMA = new Label("GKB");
            lblJURUSAN = new Label("Ruangan");
            lblALAMAT = new Label("Dosen");
            lblWAKTU = new Label("Waktu");
            lblCari = new Label("SEARCH DATA :");
            lblGambar = new Label();
            lblGambar2 = new Label();
            lblUser = new Label("Username : ");
            lblPass = new Label("Password : ");
            lblWarn = new Label();
            lblWarn2 = new Label();
            lblK = new Label();
            lblK2 = new Label();
            txtInfo = new Text("No data");
            tblColumn1 = new TableColumn("Matkul");
            tblColumn2 = new TableColumn("GKB");
            tblColumn3 = new TableColumn("Ruangan");
            tblColumn4 = new TableColumn("Dosen");
            tblColumn5 = new TableColumn("Waktu");
            txtNIM = new TextField();
            txtNAMA = new TextField();
            txtJURUSAN = new TextField();
            txtALAMAT = new TextField();
            txtCARI = new TextField();
            txtWAKTU = new TextField();
            txtUser = new TextField();
            txtPass = new PasswordField();
            splitPaneH = new SplitPane();
            pane = new AnchorPane();
            panevbox = new VBox();
            panevbox2 = new VBox();
            grid = new GridPane();
            grid2 = new GridPane();
            panehbox = new HBox(5);
            searchbox = new HBox(5);
            hbox = new HBox(5);
            tblView = new TableView();
            btnAdd = new Button("ADD");
            btnUpdate = new Button("UPDATE");
            btnDelete = new Button("DELETE");
            btnClear = new Button("CLEAR");
            btnClose = new Button("CLOSE");
            btnRefresh = new Button("REFRESH");
            btnLogin = new Button("Login");
            btnBack = new Button("BACK");
            btnReg = new Button("REGISTER");
            //========================================================================
            tblColumn1.setCellValueFactory(new PropertyValueFactory("Nim"));
            tblColumn2.setCellValueFactory(new PropertyValueFactory("Nama"));
            tblColumn3.setCellValueFactory(new PropertyValueFactory("Jurusan"));
            tblColumn4.setCellValueFactory(new PropertyValueFactory("Alamat"));
            tblColumn5.setCellValueFactory(new PropertyValueFactory("Waktu"));

            txtNIM.setPromptText("Masukkan MatKul Anda");
            txtNAMA.setPromptText("Masukkan GKB Anda");
            txtJURUSAN.setPromptText("Masukkan Ruangan Anda");
            txtALAMAT.setPromptText("Masukkan Nama Dosen Anda");
            txtWAKTU.setPromptText("Masukkan Waktu Kuliah");
            txtCARI.setPromptText("Masukkan MatKul yang ingin dicari");
            txtUser.setPromptText("Masukkan UserName");
            txtPass.setPromptText("Masukkan Password");

            lblCari.setPadding(new Insets(10));
            lblCari.setFont(Font.font("ROG FONTS", FontWeight.MEDIUM, 12));
            lblCari.setAlignment(Pos.CENTER);
            lblCari.setUnderline(true);


            lblData.setPadding(new Insets(10));
            lblData.setFont(Font.font("ROG FONTS", FontWeight.MEDIUM, 22));
            lblData.setUnderline(true);
            lblData.setAlignment(Pos.CENTER);
            lblTitle.setText("");
            lblTitle.setUnderline(true);
            lblTitle.setPadding(new Insets(10));
            lblTitle.setFont(Font.font("ROG FONTS", FontWeight.MEDIUM, 22));
            lblTitle.setTextFill(Color.web("White"));
            lblTitle.setAlignment(Pos.CENTER);
            Image img = new Image("Drive/Arin.jpg");
            ImageView view = new ImageView(img);
            Image img2 = new Image("Drive/Logo UMM.png");
            ImageView view2 = new ImageView(img2);
            lblGambar.setGraphic(view);
            lblGambar.setPadding(new Insets(10));
            lblGambar2.setGraphic(view2);
            lblGambar2.setPadding(new Insets(10));

            lblUser.setTextFill(Color.web("Black", 1.0));
            lblNIM.setPrefSize(100, 30);
            lblNAMA.setPrefSize(100, 30);
            lblJURUSAN.setPrefSize(100, 30);
            lblALAMAT.setPrefSize(100, 30);
            lblWAKTU.setPrefSize(100, 30);

            txtNIM.setPrefSize(250, 30);
            txtNAMA.setPrefSize(250, 30);
            txtJURUSAN.setPrefSize(250, 30);
            txtALAMAT.setPrefSize(250, 30);
            txtWAKTU.setPrefSize(250, 30);
            txtCARI.setPrefSize(250, 30);
            txtUser.setPrefSize(250, 30);
            txtPass.setPrefSize(250, 30);

            tblView.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);
            tblView.setPlaceholder(txtInfo);
            tblView.setPadding(new Insets(10));
            tblView.getColumns().addAll(tblColumn1, tblColumn2, tblColumn3, tblColumn4, tblColumn5);
            tblView.setPrefHeight(250);
            tblView.setBackground(new Background(
                    new BackgroundFill(Color.TRANSPARENT, new CornerRadii(15), Insets.EMPTY)));

            panehbox.setAlignment(Pos.CENTER);
            panehbox.setPadding(new Insets(10));
            panehbox.setLayoutX(23);
            panehbox.setLayoutY(250);
            panehbox.getChildren().addAll(btnAdd, btnUpdate, btnDelete, btnClear, btnClose, btnBack,lblWarn2);//
            panehbox.setBackground(new Background(new BackgroundFill(
                    Color.TRANSPARENT, new CornerRadii(10), Insets.EMPTY)));

            searchbox.setAlignment(Pos.CENTER_LEFT);
            searchbox.setPadding(new Insets(5));
            searchbox.getChildren().addAll(lblCari, txtCARI, btnRefresh);
            searchbox.setBackground(new Background(new BackgroundFill(
                    Color.TRANSPARENT, new CornerRadii(10), Insets.EMPTY)));


            grid.setHgap(10);
            grid.setVgap(10);
            grid.setLayoutX(5);
            grid.setLayoutY(5);
            grid.setAlignment(Pos.CENTER);
            grid.setPadding(new Insets(10));
            grid.addRow(0, lblNIM, txtNIM);
            grid.addRow(1, lblNAMA, txtNAMA);
            grid.addRow(2, lblJURUSAN, txtJURUSAN);
            grid.addRow(3, lblALAMAT, txtALAMAT);
            grid.addRow(4, lblWAKTU, txtWAKTU);
            grid.setGridLinesVisible(false);


            grid2.setHgap(10);
            grid2.setVgap(10);
            grid2.setLayoutX(5);
            grid2.setLayoutY(5);
            grid2.setAlignment(Pos.CENTER);
            grid2.setPadding(new Insets(10));
            grid2.addRow(1, lblUser, txtUser);
            grid2.addRow(2, lblPass, txtPass);
            grid2.addRow(3, btnLogin,btnReg);
            grid2.addRow(4, lblWarn);
            grid2.setGridLinesVisible(false);

            pane.setBorder(new Border(new BorderStroke(
                    Color.TRANSPARENT, BorderStrokeStyle.DASHED,
                    new CornerRadii(15), new BorderWidths(5), Insets.EMPTY)));
            pane.setBackground(new Background(new BackgroundFill(
                    Color.TRANSPARENT, new CornerRadii(15), Insets.EMPTY)));
            pane.getChildren().addAll(grid, panehbox);

            panevbox.getChildren().addAll(lblTitle, tblView, searchbox, lblData, pane);
            panevbox.setPadding(new Insets(5));
            panevbox.setSpacing(5);
            panevbox.minWidthProperty().bind(splitPaneH.widthProperty().multiply(0.70));
            panevbox.maxWidthProperty().bind(splitPaneH.widthProperty().multiply(0.70));

            panevbox2.getChildren().addAll( lblGambar2);
            panevbox2.setPadding(new Insets(5));
            panevbox2.setSpacing(5);


            FileInputStream input = new FileInputStream("C:\\Users\\Niko Silabest\\IdeaProjects\\Modenam\\src\\Drive\\Honkai.png");

            Image image = new Image(input);

            BackgroundImage backgroundimage = new BackgroundImage(image,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);

            Background background = new Background(backgroundimage);
            splitPaneH.setOrientation(Orientation.HORIZONTAL);
            splitPaneH.getItems().addAll(panevbox, panevbox2);
            splitPaneH.setPadding(new Insets(2));
            splitPaneH.setBackground(background);
            splitPaneH.setDividerPositions(0.5);

            hbox.getChildren().addAll(grid2);

            hbox.setSpacing(10);

            hbox.setAlignment(Pos.CENTER);
        }
        catch (Exception e)
        {

        }
    }

    private ObservableList loadData(){
        ObservableList listData = FXCollections.observableArrayList();
        try {
            Connection c    = DatabaseConnect.tryConnect();
            String sql1     = "select * from mhs;";
            ResultSet rs1   = c.createStatement().executeQuery(sql1);
            while(rs1.next()){
                modelDb         = new modelDatabase(rs1.getString(1),rs1.getString(2),
                        rs1.getString(3),rs1.getString(4),rs1.getString(5));
                listData.add(modelDb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Drive.Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listData;

    }
    private ObservableList login(){
        ObservableList listData2 = FXCollections.observableArrayList();
        try {
            Connection c    = DatabaseConnect.tryConnect();
            String sql3     = "select * from login;";
            ResultSet rs3   = c.createStatement().executeQuery(sql3);
            while(rs3.next()){
                if (txtUser.getText().equals(rs3.getString(1))&&txtPass.getText().equals(rs3.getString(2)))
                {
                    modelDb2         = new modelDatabase2(rs3.getString(1),
                            rs3.getString(2));
                    listData2.add(modelDb2);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Drive.Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listData2;

    }

    private ObservableList searchByNIM(String n){
        ObservableList listData = FXCollections.observableArrayList();
        try {
            Connection c = DatabaseConnect.tryConnect();
            String sql2 = " select distinct * from mhs where nim like '%"+n+"%';";
            ResultSet rs2 = c.createStatement().executeQuery(sql2);
            while(rs2.next()){
                modelDb         = new modelDatabase(rs2.getString(1),rs2.getString(2),
                        rs2.getString(3),rs2.getString(4), rs2.getString(5));
                listData.add(modelDb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Drive.Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listData;
    }



    private void insert(modelDatabase m){
        Connection c = DatabaseConnect.tryConnect();
        PreparedStatement ps;
        try {
            String sql = "insert into mhs values (?,?,?,?,?);";
            ps  = c.prepareStatement(sql);
            ps.setString(1,m.getNim());
            ps.setString(2,m.getNama());
            ps.setString(3,m.getJurusan());
            ps.setString(4,m.getAlamat());
            ps.setString(5,m.getWaktu());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Drive.Driver.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error");
        }
    }
    private void insert2(modelDatabase2 m){
        Connection c = DatabaseConnect.tryConnect();
        PreparedStatement ps;
        try {
            String sql = "insert into login values (?,?);";
            ps  = c.prepareStatement(sql);
            ps.setString(1,m.getUser());
            ps.setString(2,m.getPass());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Drive.Driver.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error");
        }
    }

    private void delete(modelDatabase m){
        try {
            Connection c = DatabaseConnect.tryConnect();
            PreparedStatement ps;
            String sql = "delete from mhs where nim = ?;";
            ps = c.prepareStatement(sql);
            ps.setString(1, m.getNim());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Drive.Driver.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void update(modelDatabase m){
        try {
            Connection c = DatabaseConnect.tryConnect();
            PreparedStatement ps;
            String sql = "update mhs set nama = ? ,jurusan = ? , alamat = ? , waktu = ? where nim = ? ;";
            ps = c.prepareStatement(sql);
            ps.setString(1, m.getNama());
            ps.setString(2, m.getJurusan());
            ps.setString(3, m.getAlamat());
            ps.setString(4, m.getWaktu());
            ps.setString(5, m.getNim());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Drive.Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //=======================================================================================

    private void selectData(){
        modelDb = (modelDatabase) tblView.getSelectionModel().getSelectedItems().get(0);
        txtNIM.setText(modelDb.getNim());
        txtNAMA.setText(modelDb.getNama());
        txtJURUSAN.setText(modelDb.getJurusan());
        txtALAMAT.setText(modelDb.getAlamat());
        txtWAKTU.setText(modelDb.getWaktu());
        txtNIM.setDisable(true);
    }

    private void deleteData(){
        modelDb = new modelDatabase(txtNIM.getText(), "", "", "", "");
        delete(modelDb);
        clearData();
        showData();
    }

    private void updateData(){
        modelDb = new modelDatabase(txtNIM.getText(),txtNAMA.getText(),
                txtJURUSAN.getText(),txtALAMAT.getText(), txtWAKTU.getText());
        update(modelDb);
        clearData();
        showData();
    }

    private void searchbyNIM(){
        data.clear();
        data = searchByNIM(txtCARI.getText().trim());
        tblView.setItems(data);
        tblView.getSelectionModel().clearSelection();
    }

    private void refresh(){
        showData();
        clearData();
        txtCARI.clear();
    }

    private void showData(){

        data.clear();
        data = loadData();
        tblView.setItems(data);
        tblView.getSelectionModel().clearSelection();
    }

    private void clearData(){
        txtNIM.clear();
        txtNAMA.clear();
        txtJURUSAN.clear();
        txtALAMAT.clear();
        txtWAKTU.clear();
        txtNIM.setDisable(false);
        tblView.getSelectionModel().clearSelection();
    }
    private void addData2(){
        if (txtUser.getText().equals("")||txtPass.getText().equals(""))
        {
            lblWarn.setText("KOSONG GAIS");
        }
        else
        {
            modelDb2 = new modelDatabase2(txtUser.getText(), txtPass.getText());
            insert2(modelDb2);
            lblWarn.setText("REGISTERED");
        }
    }
    private void addData(){
        if (txtNIM.getText().equals("")||txtNAMA.getText().equals("")||txtJURUSAN.getText().equals("")
                ||txtALAMAT.getText().equals("")||txtWAKTU.getText().equals(""))
        {
            lblWarn2.setText("ADA KOSONG KYOK HATIMU LUR");
            lblWarn2.setTextFill(Color.web("white"));
            lblWarn2.setFont(Font.font("ROG FONTS", FontWeight.MEDIUM, 22));
        }
        else {
            modelDb = new modelDatabase(txtNIM.getText(), txtNAMA.getText(),
                    txtJURUSAN.getText(), txtALAMAT.getText(), txtWAKTU.getText());
            insert(modelDb);
            showData();
            clearData();
        }
    }
    //====================================================================================
    @Override
    public void start(Stage primaryStage) {
        try{
            Scene scene1, scene2;
            initComponent();
            showData();



            scene1 = new Scene(hbox, 1000, 700);

            FileInputStream input = new FileInputStream("C:\\Users\\Niko Silabest\\IdeaProjects\\Modenam\\src\\Drive\\Arin (2).jpg");

            Image image = new Image(input);

            BackgroundImage backgroundimage = new BackgroundImage(image,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);

            Background background = new Background(backgroundimage);

            hbox.setBackground(background);
            scene2 = new Scene(splitPaneH, 1250, 700);
            btnLogin.setOnAction((ActionEvent event)->{
                if (login().size()==0){
                    lblWarn.setText("HALAH BOH");
                }
                else {
                    primaryStage.setScene(scene2);
                    lblTitle.setText("Welcome "+modelDb2.getUser());
                }
            });
            btnReg.setOnAction((ActionEvent event)->{
                addData2();
            });
            tblView.setOnMousePressed((MouseEvent event) -> {
                selectData();
            });
            btnAdd.setOnAction((ActionEvent e) -> {
                addData();
            });
            btnClear.setOnAction((ActionEvent e) -> {
                clearData();
            });
            btnClose.setOnAction((ActionEvent e) -> {
                primaryStage.close();
            });
            btnUpdate.setOnAction((ActionEvent e) -> {
                updateData();
            });
            btnDelete.setOnAction((ActionEvent e) -> {
                deleteData();
            });
            btnRefresh.setOnAction((ActionEvent e) -> {
                refresh();
            });
            txtCARI.setOnKeyTyped((KeyEvent ke) -> {
                searchbyNIM();
            });
            btnBack.setOnAction(e -> primaryStage.setScene(scene1));
            primaryStage.setTitle("JavaFX by Niko Silabest");
            primaryStage.getIcons().add(new Image("Drive/Arin.jpg"));
            primaryStage.setScene(scene1);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //====================================================================================

    public static void main(String[] args) {

        launch(args);

    }

}

package studentmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class dashboardController implements Initializable {

    @FXML
    private Button addStudents_addBtn;

    @FXML
    private DatePicker addStudents_birthday;

    @FXML
    private Button addStudents_btn;

    @FXML
    private Button addStudents_clearBtn;

    @FXML
    private TableColumn<StudentData, String> addStudents_col_birthday;

    @FXML
    private TableColumn<StudentData,String> addStudents_col_course;

    @FXML
    private TableColumn<StudentData,String> addStudents_col_firstName;

    @FXML
    private TableColumn<StudentData,String> addStudents_col_gender;

    @FXML
    private TableColumn<StudentData,String> addStudents_col_lastName;

    @FXML
    private TableColumn<StudentData,String> addStudents_col_status;

    @FXML
    private TableColumn<StudentData,String> addStudents_col_studentNum;

    @FXML
    private TableColumn<StudentData,String> addStudents_col_year;

    @FXML
    private ComboBox<?> addStudents_course;

    @FXML
    private Button addStudents_deleteBtn;

    @FXML
    private TextField addStudents_firstName;

    @FXML
    private AnchorPane addStudents_form;

    @FXML
    private ComboBox<?> addStudents_gender;

    @FXML
    private ImageView addStudents_imageView;

    @FXML
    private Button addStudents_insertBtn;

    @FXML
    private TextField addStudents_lastName;

    @FXML
    private TextField addStudents_search;

    @FXML
    private ComboBox<?> addStudents_status;

    @FXML
    private TextField addStudents_studentNum;

    @FXML
    private TableView<StudentData> addStudents_tableView;

    @FXML
    private Button addStudents_updateBtn;

    @FXML
    private ComboBox<?> addStudents_year;

    @FXML
    private Button availableCourse_addBtn;

    @FXML
    private Button availableCourse_btn;

    @FXML
    private Button availableCourse_clearBtn;

    @FXML
    private TableColumn<CourseData,String> availableCourse_col_course;

    @FXML
    private TableColumn<CourseData,String> availableCourse_col_degree;

    @FXML
    private TableColumn<CourseData,String> availableCourse_col_description;

    @FXML
    private TextField availableCourse_course;

    @FXML
    private TextField availableCourse_degree;

    @FXML
    private Button availableCourse_deleteBtn;

    @FXML
    private TextField availableCourse_description;

    @FXML
    private AnchorPane availableCourse_form;

    @FXML
    private TableView<CourseData> availableCourse_tableView;

    @FXML
    private Button availableCourse_updateBtn;

    @FXML
    private Button close;

    @FXML
    private Button home_btn;

    @FXML
    private AnchorPane home_form;

    @FXML
    private Label home_totalEnrolled;

    @FXML
    private BarChart<?, ?> home_totalEnrolledChart;

    @FXML
    private Label home_totalFemale;

    @FXML
    private AreaChart<?, ?> home_totalFemaleChart;

    @FXML
    private Label home_totalMale;

    @FXML
    private LineChart<?, ?> home_totalMaleChart;

    @FXML
    private Button logout;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button minimize;

    @FXML
    private Button studentGrade_btn;

    @FXML
    private Button studentGrade_clearBtn;

    @FXML
    private TableColumn<?, ?> studentGrade_col_course;

    @FXML
    private TableColumn<?, ?> studentGrade_col_final;

    @FXML
    private TableColumn<?, ?> studentGrade_col_firstSem;

    @FXML
    private TableColumn<?, ?> studentGrade_col_secondSem;

    @FXML
    private TableColumn<?, ?> studentGrade_col_studentNum;

    @FXML
    private TableColumn<?, ?> studentGrade_col_year;

    @FXML
    private Label studentGrade_course;

    @FXML
    private TextField studentGrade_firstSem;

    @FXML
    private AnchorPane studentGrade_form;

    @FXML
    private TextField studentGrade_search;

    @FXML
    private TextField studentGrade_secondSem;

    @FXML
    private TextField studentGrade_studentNum;

    @FXML
    private TableView<?> studentGrade_tableView;

    @FXML
    private Button studentGrade_updateBtn;

    @FXML
    private Label studentGrade_year;

    @FXML
    private Label username;


    private double x=0;
    private double y=0;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;
    private Image image;
    private String[] yearList={
            "First year",
            "Second year",
            "Third year",
            "Last year",
    };
    public void addStudentYearList(){
        List<String> yearL=new ArrayList<>();
        for(String data:yearList){
            yearL.add(data);
        }
        ObservableList OBList=FXCollections.observableArrayList(yearL);
        addStudents_year.setItems(OBList);
    }

    public void addStudentGenderList(){
        List<String> genderL=new ArrayList<>();
        genderL.add("Male");
        genderL.add("Female");
        ObservableList OBList=FXCollections.observableArrayList(genderL);
        addStudents_gender.setItems(OBList);
    }

    private String[] addStudent_StatusList= {"Enrolled","Not Enrolled","Inactive"};

    public void addStudentStatusList(){
        List<String> statusL=new ArrayList<>();
        for (String data:addStudent_StatusList){
            statusL.add(data);
        }
        ObservableList OBList=FXCollections.observableArrayList(statusL);
        addStudents_status.setItems(OBList);
    }

    public void addStudentSelect(){
        StudentData studentD=addStudents_tableView.getSelectionModel().getSelectedItem();
        int num=addStudents_tableView.getSelectionModel().getSelectedIndex();

        if (num-1<-1) return;
        addStudents_studentNum.setText(String.valueOf(studentD.getStudentNum()));
        addStudents_firstName.setText(studentD.getFirstName());
        addStudents_lastName.setText(studentD.getLastName());
        String url_image="file:"+studentD.getImage();

        image =new Image(url_image,120,149,false,true);
        addStudents_imageView.setImage(image);
    }

//Show Students List
    public ObservableList<StudentData> addStudentListData(){
        ObservableList<StudentData> listStudents= FXCollections.observableArrayList();
        String sql="SELECT * FROM student";
        connection=DBUtils.connectDB();
        try {
            StudentData studentData;
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();

            while(resultSet.next()){
                studentData=new StudentData(
                        resultSet.getInt("studentNum"),
                        resultSet.getString("year"),
                        resultSet.getString("course"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("gender"),
                        resultSet.getDate("birthday"),
                        resultSet.getString("status"),
                        resultSet.getString("image")
                        );
                listStudents.add(studentData);
            }
        }catch (Exception e){e.printStackTrace();}
        return listStudents;
    }

    private ObservableList<StudentData> addStudentListD;
    public void addStudentShowListData(){
        addStudentListD=addStudentListData();
        addStudents_col_studentNum.setCellValueFactory(new PropertyValueFactory<>("studentNum"));
        addStudents_col_year.setCellValueFactory(new PropertyValueFactory<>("year"));
        addStudents_col_course.setCellValueFactory(new PropertyValueFactory<>("course"));
        addStudents_col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        addStudents_col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        addStudents_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        addStudents_col_birthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        addStudents_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        addStudents_tableView.setItems(addStudentListD);
    }

//Show Available course

    public void avaiableCourseSelect(){
        CourseData courseD=availableCourse_tableView.getSelectionModel().getSelectedItem();
        int num=availableCourse_tableView.getSelectionModel().getSelectedIndex();

        if (num-1<-1) return;
        availableCourse_course.setText(String.valueOf(courseD.getCourse()));
        availableCourse_description.setText(String.valueOf(courseD.getDescription()));
        availableCourse_degree.setText(String.valueOf(courseD.getDegree()));

    }

    //Show Students List
    public ObservableList<CourseData> availableCourseListData(){
        ObservableList<CourseData> listCourses= FXCollections.observableArrayList();
        String sql="SELECT * FROM course";
        connection=DBUtils.connectDB();
        try {
            CourseData courseData;
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();

            while(resultSet.next()){
                courseData=new CourseData(
                        resultSet.getString("course"),
                        resultSet.getString("description"),
                        resultSet.getString("degree")
                );
                listCourses.add(courseData);
            }
        }catch (Exception e){e.printStackTrace();}
        return listCourses;
    }

    private ObservableList<CourseData> availableCourseListD;
    public void availableCourseShowListData(){
        availableCourseListD=availableCourseListData();
        availableCourse_col_course.setCellValueFactory(new PropertyValueFactory<>("course"));
        availableCourse_col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        availableCourse_col_degree.setCellValueFactory(new PropertyValueFactory<>("degree"));

        availableCourse_tableView.setItems(availableCourseListD);
    }

    public void availableCourseAdd(){
        String insertData="INSERT INTO course(course,description,degree) VALUES(?,?,?)";
        connection=DBUtils.connectDB();
        try {
            Alert alert;
            if (availableCourse_course.getText().isEmpty()||availableCourse_description.getText().isEmpty()||availableCourse_degree.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please enter all the fields correctly");
                alert.showAndWait();
            }
            else {
//        Check if data exist
                String checkData="SELECT * FROM course WHERE course='"+availableCourse_course.getText()+"'";
                statement=connection.prepareStatement(checkData);
                resultSet=statement.executeQuery(checkData);
                if (resultSet.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Course"+availableCourse_course.getText()+" already exist");
                    alert.showAndWait();
                }else{
                    preparedStatement=connection.prepareStatement(insertData);
                    preparedStatement.setString(1,availableCourse_course.getText());
                    preparedStatement.setString(2,availableCourse_description.getText());
                    preparedStatement.setString(3,availableCourse_degree.getText());
                    preparedStatement.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText(null);
                    alert.setContentText("added "+availableCourse_course.getText()+"successfully");
                    alert.showAndWait();

                    availableCourseShowListData();
                }

            }
        }catch (Exception e){e.printStackTrace();}
    }

    public void availableCourseClear(){
        availableCourse_course.clear();
        availableCourse_description.clear();
        availableCourse_degree.clear();
    }

    public void logout(){
        try {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout?");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure to logout?");

        Optional <ButtonType> option=alert.showAndWait();

        if (option.get().equals(ButtonType.OK)){
            logout.getScene().getWindow().hide();

            Parent root= FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Stage stage=new Stage();
            Scene scene=new Scene(root);

            stage.initStyle(StageStyle.TRANSPARENT);
            root.setOnMousePressed((MouseEvent event)->{
                x=event.getSceneX();
                y=event.getSceneY();
            });
            root.setOnMouseDragged((MouseEvent event)->{
                stage.setX(event.getScreenX()-x);
                stage.setY(event.getScreenY()-y);

                stage.setOpacity(.8);
            });
            root.setOnMouseReleased((MouseEvent event)->{
                stage.setOpacity(1);
            });
            stage.setScene(scene);
            stage.show();

        }else return;

        }catch (Exception e){e.printStackTrace();}
    }

    public void close(){
        System.exit(0);
    }
    public void minimize(){
        Stage stage=(Stage)main_form.getScene().getWindow();
        stage.setIconified(true);
    }

    public void hideAllForms() {
        home_form.setVisible(false);
        home_btn.setStyle("-fx-background-color: TRANSPARENT");
        addStudents_form.setVisible(false);
        addStudents_btn.setStyle("-fx-background-color: TRANSPARENT");
        availableCourse_form.setVisible(false);
        availableCourse_btn.setStyle("-fx-background-color: TRANSPARENT");
        studentGrade_form.setVisible(false);
        studentGrade_btn.setStyle("-fx-background-color: TRANSPARENT");
    }
    @FXML
    public void switchForm(javafx.event.ActionEvent event) {
        // Hide all forms first
        hideAllForms();

        // Show the selected form
        if (event.getSource() == home_btn) {
            home_form.setVisible(true);
            home_btn.setStyle("-fx-background-color: linear-gradient(to bottom right,#3f82ae,#26bf7d);");
        } else if (event.getSource() == addStudents_btn) {
            addStudents_form.setVisible(true);
            addStudents_btn.setStyle("-fx-background-color: linear-gradient(to bottom right,#3f82ae,#26bf7d);");
//show Student list when clicked
            addStudentShowListData();
            addStudentYearList();
            addStudentGenderList();
            addStudentStatusList();
        } else if (event.getSource() == availableCourse_btn) {
            availableCourse_form.setVisible(true);
            availableCourse_btn.setStyle("-fx-background-color: linear-gradient(to bottom right,#3f82ae,#26bf7d);");
            availableCourseShowListData();
        } else if (event.getSource() == studentGrade_btn) {
            studentGrade_form.setVisible(true);
            studentGrade_btn.setStyle("-fx-background-color: linear-gradient(to bottom right,#3f82ae,#26bf7d);");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hideAllForms();
        home_form.setVisible(true);
        home_btn.setStyle("-fx-background-color: linear-gradient(to bottom right,#3f82ae,#26bf7d);");
    }

    }

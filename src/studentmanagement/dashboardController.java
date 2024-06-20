package studentmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ResourceBundle;

public class dashboardController implements Initializable {

    @FXML
    private Button addStudents_addBtn;

    @FXML
    private DatePicker addStudents_birth;

    @FXML
    private Button addStudents_btn;

    @FXML
    private Button addStudents_clearBtn;

    @FXML
    private TableColumn<?, ?> addStudents_col_birth;

    @FXML
    private TableColumn<?, ?> addStudents_col_course;

    @FXML
    private TableColumn<?, ?> addStudents_col_firstName;

    @FXML
    private TableColumn<?, ?> addStudents_col_gender;

    @FXML
    private TableColumn<?, ?> addStudents_col_lastName;

    @FXML
    private TableColumn<?, ?> addStudents_col_status;

    @FXML
    private TableColumn<?, ?> addStudents_col_studentNum;

    @FXML
    private TableColumn<?, ?> addStudents_col_year;

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
    private TableView<?> addStudents_tableView;

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
    private TableColumn<?, ?> availableCourse_col_course;

    @FXML
    private TableColumn<?, ?> availableCourse_col_degree;

    @FXML
    private TableColumn<?, ?> availableCourse_col_description;

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
    private TableView<?> availableCourse_tableView;

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

    public void close(){
        System.exit(0);
    }
    public void minimize(){
        Stage stage=(Stage)main_form.getScene().getWindow();
        stage.setIconified(true);
    }
    public void switchForm(){

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

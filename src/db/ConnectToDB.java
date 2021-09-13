package db;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class ConnectToDB {
    private static final String url = "jdbc:mysql://192.168.100.245:3306/hmmr_mu";
    private static final String user = "логин к БД";
    private static final String password = "пароль к БД";
    public static Connection con;

    public ConnectToDB() {

    }
    /*****************************************
     * Подключаемся к БД MySQL				 *
     *****************************************/
    public void ConToDb()
    {
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            AlertDialog(e.getMessage(), "Внимание! Ошибка подключения к БД.");
        }
    }

    public Connection ConToDb1()
    {
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            AlertDialog(e.getMessage(), "Внимание! Ошибка подключения к БД.");
        }
        return con;
    }

    /**
     * Вызов диалогового окна без надписи в титле
     * @param str - Сообщение которое выведет диалоговое окно
     * @param str1 - Сообщение которое будет в титле
     */
    private void AlertDialog(String str, String str1)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(str1);

        alert.setHeaderText(str);

        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == null) {

        } else if (option.get() == ButtonType.OK) {

        } else if (option.get() == ButtonType.CANCEL) {

        }
    }

}

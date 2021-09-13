package db;

import dialog.DialogAlert;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {
    private static final String url = "jdbc:mysql://192.168.100.245:3306/hmmr_mu";
    private static final String user = "логин к БД";
    private static final String password = "пароль к БД";
    public static Connection con;
    DialogAlert dialogAlert = new DialogAlert();

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
            dialogAlert.createDialog("Ошибка!", "Внимание! Ошибка подключения к БД.", true).setVisible(true);
        }
    }

    public Connection ConToDb1()
    {
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            dialogAlert.createDialog("Ошибка!", "Внимание! Ошибка подключения к БД.", true).setVisible(true);
        }
        return con;
    }
}

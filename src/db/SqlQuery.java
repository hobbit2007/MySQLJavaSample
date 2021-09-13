package db;

import Entity.Users;
import dialog.DialogAlert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Класс содержащий SQL запросы к БД
 */
public class SqlQuery {

    ConnectToDB connectToDB = new ConnectToDB();
    private Statement stmt;
    private ResultSet rs;
    private List<Users> userList;
    Users users = new Users();
    DialogAlert dialogAlert = new DialogAlert();

    public SqlQuery() {

    }

    /**
     * Получаем логин, пароль и права пользователя из таблицы users при авторизации. Будем
     * использовать эту информацию на протяжении всего времени выполнения
     * программы
     * @param login - Логин пользователя введенный им при регистрации
     * @return - id - id пользователя, passwd -пароль пользователя, role -
     * 			 права пользователя на определенные действия в программе.
     */
    @SuppressWarnings("static-access")
    public List<Users> checkLogin(String login)
    {
        try {
            String query = "select id, passwd, role from users where login = "+"'"+login+"'"+";";

            connectToDB.ConToDb();
            stmt = ConnectToDB.con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                users.setId(rs.getLong(1));
                users.setPasswd(rs.getString(2));
                users.setRole(rs.getString(3));

                userList.add(users);
            }
        }
        catch (SQLException e) {
            dialogAlert.createDialog(" Ошибка!", e.getMessage(), true).setVisible(true);
        } finally {

            try { connectToDB.con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        return userList;
    }

    /**
     * Метод записывающий данные в таблицу users
     * @param login - логин пользователя
     * @param passwd - пароль пользователя
     * @param role - роль пользователя
     */
    @SuppressWarnings("static-access")
    public void insertIntoTable(String login, String passwd, String role)
    {
        String query = "INSERT INTO users (login, passwd, role) " +
                "VALUES ("+"'"+login+"'"+","+ "'"+passwd+"'"+","+"'"+role+"'"+");";

        try {
            connectToDB.ConToDb();
            stmt = connectToDB.con.createStatement();
            stmt.executeUpdate(query);

        } catch (SQLException e) {
            dialogAlert.createDialog(" Ошибка!", e.getMessage(), true).setVisible(true);
        }
        finally {
            //close connection ,stmt and resultset here
            try { connectToDB.con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }

    /**
     * Метод обновляющий данные в таблице users
     * @param id - id пользователя
     * @param role - роль пользователя
     * @param passwd - пароль пользователя
     */
    @SuppressWarnings("static-access")
    public void updateTable(String id, String role, String passwd)
    {
        String query = "UPDATE users SET passwd = "+"'"+passwd+"'"+","+"'"+role +"'"+" WHERE id = "+"'"+id+"'"+";";

        try {
            connectToDB.ConToDb();
            stmt = connectToDB.con.createStatement();
            stmt.executeUpdate(query);

        } catch (SQLException e) {
            dialogAlert.createDialog(" Ошибка!", e.getMessage(), true).setVisible(true);
        }
        finally {
            //close connection ,stmt and resultset here
            try { connectToDB.con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }


}

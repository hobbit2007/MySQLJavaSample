import Entity.Users;
import db.SqlQuery;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Основной класс приложения
 */
public class Main{

    public static void main(String args[]) {
        SqlQuery sqlQuery = new SqlQuery();

        JFrame a = new JFrame("example");
        JTextField b = new JTextField("Введите логин:");
        JButton button = new JButton("Нажми меня");

        //Обработчик нажатия на кнопку
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Получили из БД данные по пользователю
                List<Users> userList = sqlQuery.checkLogin(b.getText());
                //Вставили в текстовое поле роль пользователя
                b.setText(userList.get(0).getRole());
            }
        });

        b.setBounds(50,100,200,30);
        a.add(b);
        a.setSize(300,300);
        a.setLayout(null);
        a.setVisible(true);
    }
}

import Entity.Users;
import db.ConnectToDB;
import db.SqlQuery;
import dialog.DialogAlert;

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
        DialogAlert dialogAlert = new DialogAlert();

        JFrame a = new JFrame("example");
        JTextField b = new JTextField();
        b.setToolTipText("Введите логин:");
        JButton button = new JButton("Нажми меня");

        //Обработчик нажатия на кнопку
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!b.getText().isEmpty()) {
                    //Получили из БД данные по пользователю
                    List<Users> userList = sqlQuery.checkLogin(b.getText());
                    //Вставили в текстовое поле роль пользователя
                    b.setText(userList.get(0).getRole());
                }
                else
                   dialogAlert.createDialog("Ошибка!", "Внимание! Введите логин.", true).setVisible(true);
            }
        });

        b.setBounds(50,100,200,30);
        button.setBounds(300,100,150,30);
        a.add(b);
        a.add(button);
        a.setSize(500,300);
        a.setLayout(null);
        a.setVisible(true);
    }
}

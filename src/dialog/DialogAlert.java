package dialog;
import javax.swing.*;

/**
 * Класс создания диалогового окна
 */
public class DialogAlert extends JFrame
{
    private static final long serialVersionUID = 1L;
    public DialogAlert() {
        super("DialogWindows");

    }
    /** метод создания диалогового окна.
     * @param title - заголовок окна
     * @param errorMessage - сообщение о ошибке
     * @param modal - флаг модальности
     */
    public JDialog createDialog(String title, String errorMessage, boolean modal)
    {
        JDialog dialog = new JDialog(this, title, modal);
        JTextField error = new JTextField(errorMessage);
        dialog.add(error);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(290, 90);
        return dialog;
    }
}
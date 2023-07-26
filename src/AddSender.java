import javax.swing.*;
import java.awt.*;

public class AddSender extends JFrame {
    AddSender() {
        MassageObservable massageObservable = MassageObservable.getInstance();
        setTitle("ADD Sender");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(400, 200);
        setLayout(null);
        setLocationRelativeTo(null);

        final JLabel titleLabel = new JLabel("Add Sender");
        titleLabel.setFont(new Font("", Font.BOLD, 35));
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBounds(0, 0, 400, 60);
        titleLabel.setBackground(new Color(47, 79, 79));
        titleLabel.setForeground(Color.white);
        titleLabel.setOpaque(true);

        JLabel lblName = new JLabel("Sender Name");
        lblName.setBounds(50, 80, 100, 50);
        JTextField txt = new JTextField();
        txt.setBounds(150, 90, 200, 30);
        txt.addActionListener(e-> massageObservable.addMassageCom(new MassageComponent(txt.getText())));
        add(titleLabel);
        add(lblName);
        add(txt);
    }



}

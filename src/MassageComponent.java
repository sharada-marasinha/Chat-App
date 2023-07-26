import javax.swing.*;
import java.awt.*;


public class MassageComponent extends JFrame implements MassageObserver {
    private JTextArea txtArea;
    String title;
    MassageComponent(String title) {
        MassageObservable massageObservable = MassageObservable.getInstance();
        setTitle(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(400, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        this.title=title;

        final JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("", Font.BOLD, 35));
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBounds(0, 0, 400, 60);
        titleLabel.setBackground(new Color(47, 79, 79));
        titleLabel.setForeground(Color.white);
        titleLabel.setOpaque(true);


        JTextField txt = new JTextField();
        txt.setBounds(5, 315, 290, 30);

        txt.addActionListener(e -> {
            if (txt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, title + " Please type a Massage!");
            }else {
                massageObservable.getMassage(title,txt.getText() + "\n");
                txt.setText("");
            }
        });

        txtArea = new JTextArea();
        txtArea.setBounds(5, 70, 375, 230);
        txtArea.setEditable(false);
        txtArea.setFont(new Font("", Font.BOLD, 15));

        JButton btn = new JButton("Send >");
        btn.setBounds(300, 315, 80, 30);
        btn.addActionListener(e -> {

            if (txt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, title + " Please type a Massage!");
            } else {
                massageObservable.getMassage(title , txt.getText() + "\n");
                txt.setText("");
            }


        });

        JButton addSenderBtn = new JButton("+");
        addSenderBtn.setBounds(320,5,50,50);
        addSenderBtn.setBackground(new Color(47, 79, 79));
        addSenderBtn.setFont(new Font("", Font.BOLD, 20));
        addSenderBtn.setFocusable(false);
        addSenderBtn.setForeground(Color.white);
        addSenderBtn.addActionListener(e->{
            new AddSender().setVisible(true);
        });

        add(addSenderBtn);
        add(titleLabel);
        add(txt);
        add(txtArea);
        add(btn);


        setVisible(true);


    }


    @Override
    public void update(String txt,String title) {
        if(this.title==title){
            txtArea.append("Me  : "+txt + "\n");
        }else{
            txtArea.append(title+" : "+txt + "\n");
        }


    }
}

package Lab_Project;

import java.awt.event.*;
import javax.swing.*;

public class OnlineTest extends JFrame implements ActionListener {

    JLabel l;
    JRadioButton jb[] = new JRadioButton[5];
    JButton b1, b2;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];

    OnlineTest(String s) {
        super(s);
        l = new JLabel();
        add(l);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            jb[i] = new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1 = new JButton("Next");
        b2 = new JButton("Bookmark");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);
        add(b2);
        set();
        l.setBounds(30, 40, 450, 20);
        jb[0].setBounds(50, 80, 100, 20);
        jb[1].setBounds(50, 110, 100, 20);
        jb[2].setBounds(50, 140, 100, 20);
        jb[3].setBounds(50, 170, 100, 20);
        b1.setBounds(100, 240, 100, 30);
        b2.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (check()) {
                count = count + 1;
            }
            current++;
            set();
            if (current == 9) {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }
        if (e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 9) {
                b2.setText("Result");
            }
            setVisible(false);
            setVisible(true);
        }
        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (check()) {
                    count = count + 1;
                }
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }

        if (e.getActionCommand().equals("Result")) {
            if (check()) {
                count = count + 1;
            }
            current++;

            JOptionPane.showMessageDialog(this, "Correct Answer: " + count);
            System.exit(0);
        }
    }

    void set() {
        jb[4].setSelected(true);
        if (current == 0) {
            l.setText("Question 1: What is the capital of Bangladesh?");
            jb[0].setText("Dhaka");
            jb[1].setText("Narail");
            jb[2].setText("Jashore");
            jb[3].setText("Khulna");
        }
        if (current == 1) {
            l.setText("Question 2: How many districts are there in Bangladesh?");
            jb[0].setText("78");
            jb[1].setText("120");
            jb[2].setText("64");
            jb[3].setText("12");
        }
        if (current == 2) {
            l.setText("Question 3: Who is the Prime Minister of Bangladesh?");
            jb[0].setText("Shadman Sakib Ayan");
            jb[1].setText("Israt Jahan Meem");
            jb[2].setText("Sabbir Hossain Shoikot");
            jb[3].setText("Sheikh Hasina");
        }
        if (current == 3) {
            l.setText("Que4: How many countries in the world?");
            jb[0].setText("100");
            jb[1].setText("200");
            jb[2].setText("195");
            jb[3].setText("150");
        }
        if (current == 4) {
            l.setText("Que5:How many private universities are there in Bangladesh?");
            jb[0].setText("12");
            jb[1].setText("50");
            jb[2].setText("103");
            jb[3].setText("150");
        }
        if (current == 5) {
            l.setText("Que6: How many cities in bangladesh?");
            jb[0].setText("10");
            jb[1].setText("11");
            jb[2].setText("12");
            jb[3].setText("13");
        }
        if (current == 6) {
            l.setText("Que7: Which is the first private university in Bangladesh");
            jb[0].setText("ULAB");
            jb[1].setText("NSU");
            jb[2].setText("BRAC");
            jb[3].setText("IUB");
        }
        if (current == 7) {
            l.setText("Que8: How many bones in human body?");
            jb[0].setText("100");
            jb[1].setText("206");
            jb[2].setText("213");
            jb[3].setText("150");
        }
        if (current == 8) {
            l.setText("Que9: What is the most peaceful country in the world?");
            jb[0].setText("Japan");
            jb[1].setText("Switzerland");
            jb[2].setText("Bangladesh");
            jb[3].setText("Nepal");
        }
        if (current == 9) {
            l.setText("Que10: How many states in America?");
            jb[0].setText("100");
            jb[1].setText("90");
            jb[2].setText("50");
            jb[3].setText("40");
        }
        l.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++) {
            jb[j].setBounds(50, 80 + i, 200, 20);
        }
    }

    boolean check() {
        if (current == 0) {
            return (jb[0].isSelected());
        }
        if (current == 1) {
            return (jb[2].isSelected());
        }
        if (current == 2) {
            return (jb[3].isSelected());
        }
        if (current == 3) {
            return (jb[2].isSelected());
        }
        if (current == 4) {
            return (jb[2].isSelected());
        }
        if (current == 5) {
            return (jb[1].isSelected());
        }
        if (current == 6) {
            return (jb[0].isSelected());
        }
        if (current == 7) {
            return (jb[1].isSelected());
        }
        if (current == 8) {
            return (jb[1].isSelected());
        }
        if (current == 9) {
            return (jb[2].isSelected());
        }
        return false;
    }

    public static void main(String s[]) {
        new OnlineTest("Online Test Of Java");

    }
}
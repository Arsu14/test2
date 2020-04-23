package com.company.GUI;
import DBmanager.Database;
import com.mysql.jdbc.log.Log;
import entity.User;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.SQLException;

public class MYFITST extends JFrame{

    JLabel Authorization = new JLabel("Authorization:");
    JLabel alogin = new JLabel("login:");
    JTextField log = new JTextField("");
    JLabel apassword = new JLabel("password:");
    JTextField pass = new JTextField("");
    JButton auth = new JButton("");


    JLabel Registration = new JLabel("Registration:");
    JLabel rlogin = new JLabel("login:");
    JTextField login = new JTextField("");
    JLabel name = new JLabel("name:");
    JTextField rname = new JTextField("");
    JLabel rpassword = new JLabel("password:");
    JTextField password = new JTextField("");
    JLabel repass = new JLabel("repeat password:");
    JTextField repassword = new JTextField("");
    JButton reg = new JButton("LOG IN");


    public MYFITST() {
        setLayout(null);
        setLocation(500, 100);
        setSize(570, 300);
        setTitle("Login or registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Authorization.setBounds(70, 15, 200, 30);
        add(Authorization);

        alogin.setBounds(30, 50, 80, 20);
        add(alogin);
        log.setBounds(100, 50, 100, 20);
        add(log);

        apassword.setBounds(30, 80, 80, 20);
        add(apassword);
        pass.setBounds(100, 80, 100, 20);
        add(pass);

        auth.setBounds(55, 110, 120, 20);
        auth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String l = log.getText() ;
                String p = pass.getText() ;
                Database database = new Database();
                boolean check = false;
                try {
                     check = database.authorization(l , p);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if(check){//true
                    LoginGUI loginGUI = null;
                    try {
                        loginGUI = new LoginGUI();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    loginGUI.setVisible(true);
                    setVisible(false);
                }
            }
        });

        auth.setText("login");
        add(auth);



        Registration.setBounds(350, 15, 200, 30);
        add(Registration);

        rlogin.setBounds(310, 50, 80, 20);
        add(rlogin);
        login.setBounds(420, 50, 100, 20);
        add(login);

        name.setBounds(310, 80, 80, 20);
        add(name);
        rname.setBounds(420, 80, 100, 20);
        add(rname);

        rpassword.setBounds(310, 110, 80, 20);
        add(rpassword);
        password.setBounds(420, 110, 100, 20);
        add(password);

        repass.setBounds(310, 140, 100, 20);
        add(repass);
        repassword.setBounds(420, 140, 100, 20);
        add(repassword);

        reg.setBounds(360, 170, 100, 20);
        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String log = login.getText();
                String pa = password.getText();
                String repa = repassword.getText();
                String na = rname.getText();
                System.out.println(log + " " + pa + " " + repa + " " + na);
                if(pa.compareTo(repa) == 0){
                    User user = new User( 1, log , pa, na);
                    Database database = new Database();
                    try {
                        database.registration(user);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                login.setText("");
                password.setText("");
                repassword.setText("");
                rname.setText("");
            }
        });
        reg.setText("login");
        add(reg);

    }
}

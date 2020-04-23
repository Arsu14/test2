    package com.company.GUI;

    import DBmanager.Database;

    import javax.swing.*;
    import javax.swing.table.DefaultTableModel;
    import java.awt.event.*;
    import java.awt.*;
    import java.sql.SQLException;
    import java.util.ArrayList;
    import java.util.List;

    public class LoginGUI extends JFrame {

        JLabel label ;
        JTable table = new JTable();
        JComboBox comboBox ;
        JScrollPane scrollPane;
        ImageIcon imageIcon ;

        public LoginGUI() throws SQLException, ClassNotFoundException {
            setLayout(null);
            setLocation(500, 100);
            setSize(570, 300);
            setTitle("Login or registration");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            Database database = new Database();
            List<String> arrayList = database.getImageNegri();

            imageIcon = new ImageIcon(arrayList.get(1));
            label = new JLabel(imageIcon);
            label.setBounds(10 , 10 , 500 , 500);
            add(label);



        }
    }

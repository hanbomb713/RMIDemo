/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StudentServerInterfaceClient extends JFrame {

    // Declare a Student instance

    private StudentServerInterface student;

    private JButton jbtGetScore = new JButton("Get Score");
    private JTextField jtfName = new JTextField();
    private JTextField jtfScore = new JTextField();

    public StudentServerInterfaceClient() {
        // Initialize RMI
        initializeRMI();

        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(new GridLayout(2, 2));
        jPanel1.add(new JLabel("Name"));
        jPanel1.add(jtfName);
        jPanel1.add(new JLabel("Score"));
        jPanel1.add(jtfScore);

        add(jbtGetScore, BorderLayout.SOUTH);
        add(jPanel1, BorderLayout.CENTER);

        jbtGetScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                getScore();
            }
        });
        
        setTitle("StudentServerInterfaceClient");
        setSize(250, 150);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(3);
    }

    private void getScore() {
        try {
            // Get student score
            double score = student.findScore(jtfName.getText().trim());

            // Display the result
            if (score < 0) {
                jtfScore.setText("Not found");
            } else {
                jtfScore.setText(new Double(score).toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Initialize RMI
     */
    protected void initializeRMI() { 
        String host = "localhost";

        try {
            Registry registry = LocateRegistry.getRegistry(host);
            student = (StudentServerInterface) registry.lookup("StudentServerInterfaceImpl");
            System.out.println("Server object " + student + " found");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        StudentServerInterfaceClient frame = new StudentServerInterfaceClient();
        
        
    }
}

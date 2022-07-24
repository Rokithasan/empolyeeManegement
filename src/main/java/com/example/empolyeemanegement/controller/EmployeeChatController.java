
package com.example.empolyeemanegement.controller;

import com.example.empolyeemanegement.model.Employee;
import com.example.empolyeemanegement.repository.EmployeeDAO;
import com.example.empolyeemanegement.utils.ServerUtil;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class EmployeeChatController implements Initializable {
    @FXML
    public TextArea viewTxtAreaID;

    @FXML
    public TextField sentTxtFld;

    // chat
    private static DataInputStream dis;
    private static DataOutputStream dos;
    public static final String USER_NAME = "Employee";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // create client far from main application thread
        Thread thread = new Thread(() -> {
            try {
                createClient();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

    private void createClient() throws IOException {

        // getting localhost ip
        InetAddress ip = InetAddress.getByName("localhost");

        // establish the connection
        Socket s = new Socket(ip, ServerUtil.SERVER_PORT_NUM);

        // obtaining input and out streams
        dis = new DataInputStream(s.getInputStream());
        dos = new DataOutputStream(s.getOutputStream());

        // push user name
        dos.writeUTF(USER_NAME + "#" + "::" + "#" + "Employee");
        addText(USER_NAME + " Connected to the server at: " + ServerUtil.getCurrentDateTime());

        // readMessage thread
        Thread readMessage = new Thread(() -> {
            while (true) {
                try {
                    // read the message sent to this client
                    String msg = dis.readUTF();
                    addText(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        readMessage.start();
    }

    // add text in server chat box
    private void addText(String text) {
        String oldTxt = viewTxtAreaID.getText();
        if (viewTxtAreaID.getText().equals("")) {
            viewTxtAreaID.setText(text);
        } else {
            viewTxtAreaID.setText(oldTxt + "\n\n" + text);
        }
    }

    @FXML
    public void sentBtnOnAction(ActionEvent event) {
        // sendMessage thread
        Thread sendMessage = new Thread(() -> {
            try {
                // write on the output stream
                addText(USER_NAME + ": " + sentTxtFld.getText());
                String msg = USER_NAME + "#" + sentTxtFld.getText() + "#" + AdminChatController.USER_NAME;
                sentTxtFld.setText("");
                dos.writeUTF(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        sendMessage.start();
    }
}

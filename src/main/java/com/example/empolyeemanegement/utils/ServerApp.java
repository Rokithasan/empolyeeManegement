package com.example.empolyeemanegement.utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class ServerApp{

    private static final String TITLE = "Employee - Admin TCP Server";
    private static ArrayList<ClientHandler> clientArr;

    // constructor
    public ServerApp() {
        // init client array
        clientArr = new ArrayList<>();
        start();
    }

    // application starter
    public void start(){

        // create server far from main application thread
        Thread thread = new Thread(() -> {
            try {
                createServer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

    public void stop() throws Exception {
        System.exit(0);
    }

    // create the server for our chat application
    private void createServer() throws IOException {

        // server is listening on port 7878
        ServerSocket serverSocket = new ServerSocket(ServerUtil.SERVER_PORT_NUM);
        Socket socket;

        // start notification
        addText(TITLE + " Started at: " + ServerUtil.getCurrentDateTime());

        // join all connections
        while (true) {
            socket = serverSocket.accept();

            // obtain input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // notify in GUI
            addText(String.format("Connection from %s at %s", socket.toString(), ServerUtil.getCurrentDateTime()));

            // Create a new handler object for handling this request.
            String[] data = dis.readUTF().split("#");
            System.out.println(Arrays.toString(data));
            ClientHandler match = new ClientHandler(socket, data[0], dis, dos);

            // Create a new Thread with this object.
            Thread thread = new Thread(match);

            // add this client to active clients list
            clientArr.add(match);

            // start the thread.
            thread.start();
        }
    }

    // add text in server chat box
    private static void addText(String text) {
        System.out.println(text);
    }

    // ClientHandler class
    public static class ClientHandler implements Runnable {

        private final String name;
        private final DataInputStream dis;
        private final DataOutputStream dos;
        private Socket socket;

        // constructor
        public ClientHandler(Socket socket, String name,
                             DataInputStream dis, DataOutputStream dos) {
            this.dis = dis;
            this.dos = dos;
            this.name = name;
            this.socket = socket;
        }

        @Override
        public void run() {

            String received;
            while (true) {
                try {
                    // receive the string
                    received = dis.readUTF();
                    System.out.println(received);
                    // break the string into message and recipient part
                    StringTokenizer st = new StringTokenizer(received, "#");
                    String senderName = st.nextToken().trim();// skip username
                    String MsgToSend = st.nextToken().trim();
                    String recipient = st.nextToken().trim();

                    System.out.println(senderName+"::senderName");
                    System.out.println(recipient+"::recipient");

                    // add message to gui
                    addText(name + ": " + MsgToSend);

                    // search for the recipient in the connected devices list.
                    // ar is the vector storing client of active users
                    for (ClientHandler mc : ServerApp.clientArr) {
                        // if the recipient is found, write on its
                        // output stream
                        if (mc.name.equals(recipient)) {
                            mc.dos.writeUTF(senderName + ": " + MsgToSend);
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

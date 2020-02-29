package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {

        for (Map.Entry<String, Connection> e : connectionMap.entrySet()) {
            try {
                e.getValue().send(message);
            } catch (IOException ex) {
                ConsoleHelper.writeMessage("Возникла ошибка - сообщение не было отправлено пользователю " + e.getKey());
            }
        }

    }

    public static void main(String[] args) {
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Сервер запущен");
            while (true) {
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка на сервере");
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if (message.getType() == MessageType.USER_NAME
                        && message.getData() != null
                        && !message.getData().equals("")
                        && !connectionMap.containsKey(message.getData())) {
                    connectionMap.put(message.getData(), connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED));
                    return message.getData();
                } else continue;
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> e : connectionMap.entrySet()) {
                if (!e.getKey().equals(userName))
                    connection.send(new Message(MessageType.USER_ADDED, e.getKey()));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                Message newMessage = null;
                if (message.getType() == MessageType.TEXT) {
                    newMessage = new Message(MessageType.TEXT, userName + ": " + message.getData());
                    sendBroadcastMessage(newMessage);
                } else
                    ConsoleHelper.writeMessage("Ошибка типа входящего сообщения(не ТЕХТ)");
            }
        }


        @Override
        public void run() {
            if (socket != null && socket.getRemoteSocketAddress() != null) {
                ConsoleHelper.writeMessage("Установлено новое соединение с удаленным сокетом по адресу: " + socket.getRemoteSocketAddress());
            }
            String userName = null;
            try (Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED,userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с пользователем");
            } finally {
                if (userName != null) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED,userName));
                }
                ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");
            }
        }
    }


}

package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BotClient extends Client {
    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random() * 100 % 100);
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    public class BotSocketThread extends Client.SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            if (message != null) {
                ConsoleHelper.writeMessage(message);
                if (message.contains(": ") && message.split(": ").length>1) {
                    String text = message.split(": ")[1];
                    String user = message.split(": ")[0];
                    SimpleDateFormat format = null;
                    String request;
                    switch (text) {
                        case "дата":
                            format = new SimpleDateFormat("d.MM.YYYY");
                            break;
                        case "день":
                            format = new SimpleDateFormat("d");
                            break;
                        case "месяц":
                            format = new SimpleDateFormat("MMMM");
                            break;
                        case "год":
                            format = new SimpleDateFormat("YYYY");
                            break;
                        case "время":
                            format = new SimpleDateFormat("H:mm:ss");
                            break;
                        case "час":
                            format = new SimpleDateFormat("H");
                            break;
                        case "минуты":
                            format = new SimpleDateFormat("m");
                            break;
                        case "секунды":
                            format = new SimpleDateFormat("s");
                            break;
                    }
                    if (format != null) {
                        sendTextMessage(String.format("Информация для %s: %s", user, format.format(new Date())));
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        new BotClient().run();
    }
}

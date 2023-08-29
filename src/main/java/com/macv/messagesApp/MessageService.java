package com.macv.messagesApp;

import java.util.List;
import java.util.Scanner;

public class MessageService {
    public static void postMessage(){
        int response = 0;
        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("----------------------------------------");
            System.out.println("Let's create a new message:");
            System.out.println("Type your message: ");
            String getMessage = sc.nextLine();
            System.out.println("Type the author: ");
            String getAuthor = sc.nextLine();
            System.out.println();
            System.out.println("Please confirm your message and author");
            System.out.println("Message: " + getMessage);
            System.out.println("Author: " + getAuthor);
            System.out.println();
            System.out.println("Is it correct?");
            System.out.println("1. Yes, create message");
            System.out.println("0. No, create again");
            response = Integer.parseInt(sc.nextLine());

            if (response == 1){
                System.out.println("Llamar MessageDaoImpl");
                Message message = new Message(getMessage, getAuthor);
                MessageDaoImpl.postMessageDB(message);
            } else if (response != 0) {
                System.out.println("Please select a valid option");
                response = 0;
            }

        } while (response == 0);
    }

    public static void getMessages(){
        List<Message> messageList = MessageDaoImpl.getMessagesDB();
        System.out.println("-------------------------------");
        System.out.println("Messages List:");
        for (Message ms: messageList) {
            System.out.println();
            System.out.println("Id: " + ms.getIdMessage());
            System.out.println("Message: " + ms.getMessage());
            System.out.println("Author: " + ms.getMessageAuthor());
            System.out.println("Date: " + ms.getMessageDate());
        }
    }
}

package com.macv.messagesApp;

import java.sql.SQLException;
import java.util.InputMismatchException;
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
            System.out.println("0. No, create again");
            System.out.println("1. Yes, create message");
            System.out.println("2. Go to main menu");

            response = Integer.parseInt(sc.nextLine());

            switch (response){
                case 1:
                    Message message = new Message(getMessage, getAuthor);
                    MessageDaoImpl.postMessageDB(message);
                    break;
                case 2:
                    UIMenu.showMenu();
                    response = 1;
                    break;
                default:
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
        UIMenu.showMenu();
    }

    public static void deleteMessage(){
        int response = 0;
        do {
            try{
                Scanner sc = new Scanner(System.in);
                System.out.println("-------------------------------");
                System.out.println("Type 0 to return to main menu.");
                System.out.println("Please type de message ID that you want to delete:");
                int messageId = Integer.parseInt(sc.nextLine());
                response = messageId;
                if (response == 0){
                    UIMenu.showMenu();
                    break;
                }
                int result = MessageDaoImpl.deleteMessageDB(response);
                if(result == 0){
                    System.out.println("Message ID not found, please type an existing ID");
                    response = 0;
                } else {
                    UIMenu.showMenu();
                }
            }catch (NumberFormatException e){
                System.out.println("Invalid answer, please type a number");
            }

        }while (response == 0);
    }

    public static void updateMessage(){
        int response = 0;
        do {
            try {
                System.out.println("-------------------------------");
                System.out.println("Type 0 to return to main menu.");
                System.out.println("Please type the message ID that you want to update:");

                Scanner sc = new Scanner(System.in);
                response = sc.nextInt();

                if (response == 0){
                    UIMenu.showMenu();
                    break;
                }

                List<Message> messageToUpdate = MessageDaoImpl.getMessagesDB(response);

                if (messageToUpdate.size() == 0){
                    System.out.println("Message Id not found, please type an existing ID");
                    response = 0;
                } else {
                    System.out.println("-------------------------------");
                    System.out.println("Is this the message you want to update?");
                    for (Message ms: messageToUpdate) {
                        System.out.println();
                        System.out.println("Id: " + ms.getIdMessage());
                        System.out.println("Message: " + ms.getMessage());
                        System.out.println("Author: " + ms.getMessageAuthor());
                        System.out.println("Date: " + ms.getMessageDate());
                    }
                    System.out.println();
                    System.out.println("1. Yes");
                    System.out.println("0. No");
                    response = sc.nextInt();

                    if (response == 1){
                        int responseConfirmUpdate = 0;
                        do{
                            Scanner scanner = new Scanner(System.in);
                            System.out.println("----------------------------------------");
                            System.out.println("Let's update the message:");
                            System.out.println("Type your message: ");
                            String getMessage = scanner.nextLine();
                            System.out.println("Type the author: ");
                            String getAuthor = scanner.nextLine();
                            System.out.println();
                            System.out.println("Please confirm your message and author");
                            System.out.println("Message: " + getMessage);
                            System.out.println("Author: " + getAuthor);
                            System.out.println();
                            System.out.println("Is it correct?");
                            System.out.println("0. No, type again");
                            System.out.println("1. Yes, update message");
                            System.out.println("2. Go to main menu");
                            responseConfirmUpdate = Integer.parseInt(scanner.nextLine());

                            if (responseConfirmUpdate == 2){
                                UIMenu.showMenu();
                                break;
                            }

                            if (responseConfirmUpdate == 1){
                                Message message = new Message(getMessage, getAuthor);
                                int result = MessageDaoImpl.
                                        updateMessageDB(
                                                messageToUpdate.
                                                        get(0).getIdMessage(), message
                                        );
                                System.out.println(result + " messages updated successfully");
                                UIMenu.showMenu();
                            } else if (responseConfirmUpdate != 0) {
                                System.out.println("Please select a valid option");
                                responseConfirmUpdate = 0;
                            }

                        } while (responseConfirmUpdate == 0);

                    } else{
                        response = 0;
                    }
                }
            } catch (InputMismatchException e){
                System.out.println("Invalid answer, please type a number message ID");
                response = 0;
            }
        } while (response == 0);

    }
}

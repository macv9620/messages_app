package com.macv.messagesApp;

import java.util.Scanner;

public class UIMenu {
    public static void showMenu(){
        int response = 0;
        do {
            System.out.println("Welcome to MessageApp, what do you wan to to do?");
            System.out.println("1. Create a message");
            System.out.println("2. Show created messages");
            System.out.println("3. Edit message");
            System.out.println("4. Delete message");
            System.out.println("5. Exit");

            Scanner sc = new Scanner(System.in);
            response = Integer.parseInt(sc.nextLine());

            switch (response){
                case 1:
                    MessageService.postMessage();
                    response = 5;
                    break;
                case 2:
                    MessageService.getMessages();
                    response = 5;
                    break;
                case 3:
                    System.out.println("Llamar servicio editar mensajes");
                    break;
                case 4:
                    System.out.println("Llamar servicio eliminar mensaje");
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
            }

        } while (response != 5);


    }
}

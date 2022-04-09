package monopolybanking;
import java.util.Scanner;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/**
 * April 2022
 * @author davinpwk
 */

public class MonopolyBanking {
    
    static HashMap<String,Integer> account = new HashMap<>();
    static boolean loop = true;
    
    public static void main(String[] args) {
        int playerAmount;
        
        // Setup
        Scanner scan = new Scanner(System.in);
        System.out.print("number of player (2-4) : ");
        playerAmount = scan.nextInt();
        
        for(int i = 1 ; i <= playerAmount ; i++){
            System.out.print("Player"+i+" name : ");
            Scanner PA = new Scanner(System.in);
            String name = PA.nextLine();
            account.put(name, 1500);
        }
        // End of Setup
        
        // Menu
        while(loop == true){  
            menu();
        }
        // End of Menu
        
        
    }
    
    public static void menu(){
        System.out.println("\n=================================");
        System.out.println("Menu: ");
        System.out.println("1. Income \n2. Taxes \n3. Transfer \n4. GO! (+$200) \n*'end' to terminate\n.......");
        System.out.print("option : ");
        Scanner menu = new Scanner(System.in);
        String option = menu.nextLine();
        System.out.println("=================================");
        
        Scanner Ptrans = new Scanner(System.in);
        if(option.equals("1")){
            System.out.print("input Player Name: ");
            String Player = Ptrans.nextLine();
            income(Player);
        }
        else if(option.equals("2")){
            System.out.print("input Player Name: ");
            String Player = Ptrans.nextLine();
            taxes(Player);
        }
        else if(option.equals("3")){
            System.out.print("From: ");
            String Sender = Ptrans.nextLine();
            System.out.print("To: ");
            String Receiver = Ptrans.nextLine();
            transfer(Sender, Receiver);
        }
        else if(option.equals("4")){
            System.out.print("input Player Name: ");
            String Player = Ptrans.nextLine();
            GO(Player);
        }
        else if(option.equals("end")){
            loop = false;
        }
    }
    
    public static void income(String Player){
        Scanner income = new Scanner(System.in);
        System.out.print("Input Income Amount: ");
        int incAmount = income.nextInt();
        System.out.println("=================================");
        account.put(Player, account.get(Player) + incAmount);
        System.out.println(Player+"'s balance : $"+account.get(Player));
        System.out.println("=================================");
        wait(2000);
    }
    
    public static void taxes(String Player){
        Scanner tax = new Scanner(System.in);
        System.out.print("Input Tax Amount: ");
        int incAmount = tax.nextInt();
        System.out.println("=================================");
        account.put(Player, account.get(Player) - incAmount);
        System.out.println(Player+"'s balance : $"+account.get(Player));
        System.out.println("=================================");
        wait(2000);
    }
    
    public static void transfer(String Sender, String Receiver){
        Scanner trf = new Scanner(System.in);
        System.out.print("Input Transfer Amount: ");
        int trfAmount = trf.nextInt();
        System.out.println("=================================");
        account.put(Sender, account.get(Sender) - trfAmount);
        account.put(Receiver, account.get(Receiver) + trfAmount);
        System.out.println(Sender+"'s balance : $"+account.get(Sender));
        System.out.println(Receiver+"'s balance : $"+account.get(Receiver));
        System.out.println("=================================");
        wait(4000);
    }
    
    public static void GO(String Player){
        account.put(Player, account.get(Player) + 200);
        System.out.println("=================================");
        System.out.println(Player+"'s balance : $"+account.get(Player));
        System.out.println("=================================");
        wait(2000);
    }
    
    public static void wait(int ms){
        try{
            Thread.sleep(ms);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
}

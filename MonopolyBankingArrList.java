package monopolybankingarrlist;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author davinpwk
 */
public class MonopolyBankingArrList {
    static int playerAmount;
    static ArrayList<String> AccountName = new ArrayList();
    static ArrayList<Integer> AccountBalance = new ArrayList();
    static boolean loop = true ; 
    
    public static void main(String[] args){
        
        // Setup
        Scanner scan = new Scanner(System.in);
        System.out.print("number of player (2-4) : ");
        playerAmount = scan.nextInt();
        
        for(int i = 1 ; i <= playerAmount ; i++){
            System.out.print("Player"+i+" name : ");
            Scanner PA = new Scanner(System.in);
            String name = PA.nextLine();
            AccountName.add(name);
            AccountBalance.add(1500);
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
        System.out.println("1. Income \n2. Taxes \n3. Transfer \n4. GO! (+$200) \n*'bal' to check Balance \n*'end' to terminate\n.......");
        System.out.print("option : ");
        Scanner menu = new Scanner(System.in);
        String option = menu.nextLine();
        System.out.println("=================================");
        
        Scanner Ptrans = new Scanner(System.in);
        if(option.equals("1")){
            boolean loop1 = false;
            while(loop1 == false){
                try{
                    System.out.print("input Player Name: ");
                    String Player = Ptrans.nextLine();
                    income(Player);
                    loop1 = true;
                }catch(Exception e){
                    System.out.println("Account not found!");
                }
            }
            
        }
        else if(option.equals("2")){
            boolean loop1 = false;
            while(loop1 == false){
                try{
                    System.out.print("input Player Name: ");
                    String Player = Ptrans.nextLine();
                    taxes(Player);
                    loop1 = true;
                }catch(Exception e){
                    System.out.println("Account not found!");
                }
            }
        }
        else if(option.equals("3")){
            boolean loop1 = false;
            while(loop1 == false){
                try{
                    System.out.print("From: ");
                    String Sender = Ptrans.nextLine();
                    System.out.print("To: ");
                    String Receiver = Ptrans.nextLine();
                    transfer(Sender, Receiver);
                    loop1 = true;
                }catch(Exception e){
                    System.out.println("Account not found!");
                }
            }
        }
        else if(option.equals("4")){
            boolean loop1 = false;
            while(loop1 == false){
                try{
                    System.out.print("input Player Name: ");
                    String Player = Ptrans.nextLine();
                    GO(Player);
                    loop1 = true;
                }catch(Exception e){
                    System.out.println("Account not found!");
                }
            }
        }
        else if(option.equals("bal")){
            checkBalance();
        }
        else if(option.equals("end")){
            loop = false;
        }
    }
    
    public static void checkBalance(){
        System.out.println("========PLAYERS' BALANCE=========");
        for(int i = 0 ; i < playerAmount ; i++){
            System.out.println(AccountName.get(i)+"\t: $"+AccountBalance.get(i));
        }
        System.out.println("=================================");
        wait(5000);
    }
    
    public static void income(String Player){
        Scanner income = new Scanner(System.in);
        System.out.print("Input Income Amount: ");
        int incAmount = income.nextInt();
        int index = AccountName.indexOf(Player);
        AccountBalance.set(index, (AccountBalance.get(index) + incAmount));
        
        System.out.println("=================================");
        System.out.println(Player+"'s balance : $"+AccountBalance.get(index));
        System.out.println("=================================");
        
        wait(2000);
    }
    public static void taxes(String Player){
        Scanner taxes = new Scanner(System.in);
        System.out.print("Input Income Amount: ");
        int taxAmount = taxes.nextInt();
        int index = AccountName.indexOf(Player);
        AccountBalance.set(index, (AccountBalance.get(index) - taxAmount));
        
        System.out.println("=================================");
        System.out.println(Player+"'s balance : $"+AccountBalance.get(index));
        System.out.println("=================================");
        
        wait(2000);
    }    
    public static void transfer(String sender, String receiver){
        Scanner transfer = new Scanner(System.in);
        System.out.print("Input Income Amount: ");
        int trfAmount = transfer.nextInt();
        int iSend = AccountName.indexOf(sender);
        AccountBalance.set(iSend, (AccountBalance.get(iSend) - trfAmount));
        int iRecv = AccountName.indexOf(receiver);
        AccountBalance.set(iRecv, (AccountBalance.get(iRecv) - trfAmount));
        
        System.out.println("=================================");
        System.out.println(sender+"'s balance : $"+AccountBalance.get(iSend));
        System.out.println(receiver+"'s balance : $"+AccountBalance.get(iRecv));
        System.out.println("=================================");
        
        wait(4000);
    }    
    public static void GO(String Player){
        int index = AccountName.indexOf(Player);
        AccountBalance.set(index, (AccountBalance.get(index) + 200));
        
        System.out.println("=================================");
        System.out.println(Player+"'s balance : $"+AccountBalance.get(index));
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


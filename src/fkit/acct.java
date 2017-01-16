/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fkit;

import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Meg
 */
public class acct implements java.io.Serializable
{
    //stuff in accts 
    private double bal; 
    private int now;
    protected String holder; 
    
    //getters and setters
    
    protected void balupdate (int temp)
    {
        //interest stuff here
        double nest=(.05/365);
        double daydif;
        if(temp>now)
        {
            //all good
            daydif=temp-now;
            bal=bal+(bal*(nest*daydif));
            now=temp;
        }
        else
            //nope
            System.out.println("Nope.");
            
       
        
    }
    protected void withdraw ()
    {
        //pull money out after interesst
          int month, day; 
        
        System.out.println("Enter the month:MM");
        Scanner what= new Scanner(System.in);
        month=what.nextInt();
        System.out.println("Enter the day:DD");
        day=what.nextInt();
       // System.out.println("Enter the year:YYYY");
       // yr=what.nextInt();
       
            GregorianCalendar gc = new GregorianCalendar();
            gc.set(GregorianCalendar.DAY_OF_MONTH,day);
            gc.set(GregorianCalendar.MONTH, month);
           // gc.set(GregorianCalendar.YEAR, yr);
            int numberofDays=gc.get(GregorianCalendar.DAY_OF_YEAR);
            balupdate(numberofDays);
            System.out.println("Enter amount to withdraw:");
        double money=what.nextDouble();
        if(money<bal)
        {
            bal-=money;
            System.out.println("New Balance: "+bal);
        }
        else
            System.out.println("Nope.");
       
    }
    protected void deposit ()
    {
        //put money in after interest
        int month, day; 
        
        System.out.println("Enter the month:MM");
        Scanner what= new Scanner(System.in);
        month=what.nextInt();
        System.out.println("Enter the day:DD");
        day=what.nextInt();
       // System.out.println("Enter the year:YYYY");
       // yr=what.nextInt();
       
            GregorianCalendar gc = new GregorianCalendar();
            gc.set(GregorianCalendar.DAY_OF_MONTH,day);
            gc.set(GregorianCalendar.MONTH, month-1);
           // gc.set(GregorianCalendar.YEAR, yr);
            int numberofDays=gc.get(GregorianCalendar.DAY_OF_YEAR);
            System.out.println(numberofDays);
            balupdate(numberofDays);
        System.out.println("Enter amount to deposit:");
        double money=what.nextDouble();
        bal+=money;
        System.out.println("New Balance: "+bal);
    }
    protected void chkbal ()
    {
        //see balance
        int month, day; 
        
        System.out.println("Enter the month:MM");
        Scanner what= new Scanner(System.in);
        month=what.nextInt();
        System.out.println("Enter the day:DD");
        day=what.nextInt();
       // System.out.println("Enter the year:YYYY");
       // yr=what.nextInt();
       
            GregorianCalendar gc = new GregorianCalendar();
            gc.set(GregorianCalendar.DAY_OF_MONTH,day);
            gc.set(GregorianCalendar.MONTH, month-1);
           // gc.set(GregorianCalendar.YEAR, yr);
            int numberofDays=gc.get(GregorianCalendar.DAY_OF_YEAR);
            System.out.println(numberofDays);
            balupdate(numberofDays);
            System.out.println(bal);
        
        
       
     
        
    }    
    
    public void menu ()
    {
        // show options 
        int imput=0;
        while(imput!=4)
        {
            System.out.println("Make your selection: \n1: Deposit\n2: Withdraw\n3:Check Balance\n4:Exit");
            Scanner sc= new Scanner(System.in);
            imput=sc.nextInt();
            switch (imput) {
            //deposit
                case 1:
                    deposit();
                    break;
            //withdraw
                case 2:
                    withdraw();
                    break;
            // check balance
                case 3:
                    chkbal();
                    break;
            // exit        
                case 4:
                    System.out.println("Thank you!");// save?
                    break;
                default:
                    System.out.println("Invalid response try again");
                    break;
            }
            
                    
        }
        
        
    }
    public acct (String name)
    {
        //contruct with name 
        holder=name;
        bal=100;
        
    }
    public acct ()
    {
        //contruct with nothing 
        bal=100;
       System.out.println("Account holder name?");
       Scanner sc= new Scanner(System.in);
       holder=sc.next();
        
    }
}

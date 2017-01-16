/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fkit;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Meg
 */
public class Fkit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int ans;
        String name;
        acct[] bank=new acct[3];
        System.out.println("Do you want to load accounts? Press 1 for YES or 2 for NO.");
        Scanner sc= new Scanner(System.in);
        ans=sc.nextInt();
        if (ans== 1)
        {
          bank=readAccts();
        }
        else
        {
          System.out.println("Do you have account holders names? Press 1 for YES or 2 for NO");
          ans=sc.nextInt();
          if (ans==1)
          {
              for (int z =0; z<3;z++)
              {
                  System.out.println("Please enter name for account "+(z+1));
                  name = sc.next();
                bank[z]=new acct(name);
              }
          }
          else
          {
            for (int i=0; i<3;i++)
            {
                bank[i] =new acct(); 
            
            
            }
          }
        }
        
        //testing 
       
        
        
        
        
        
        
        
        saveAccts(bank);    
                
        
    }
    
    
  public static void saveAccts (acct[] savey)
  {
      try
		{
        		FileOutputStream fos = new FileOutputStream("file.txt");
        		ObjectOutputStream oos = new ObjectOutputStream(fos);
        		
			oos.writeObject(savey);
        		oos.flush();
        		fos.close();
        	}
        	catch (Throwable e)
		{
        		System.err.println(e);
        	}
  }
  
  public static acct[] readAccts ()
  {
     	     acct cat[]=null; 
		try
		{
			FileInputStream fis = new FileInputStream("file.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
                         
                             cat = (acct[])ois.readObject();
                         
			fis.close();
                        
		}
		catch (Throwable e)
		{
			System.err.println(e);
		}
                               
                return cat;
               
  }
}

package linkedlist;

import java.util.LinkedList;

public class TestClass4 {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		System.out.println("        CSE222 - HW3");
		System.out.println("Welcome to Social Media Software");
		System.out.println();
		
		/****Step1: Create 10 accounts****/
		System.out.println("Step 1... Creating accounts");
		   
		  LinkedList<Account> accounts = new LinkedList();
		
		   Account gizemsungu = new Account(1, "gizemsungu", "13.01.1993", "Ankara", accounts);
		     accounts.add(gizemsungu);
		   Account sibelgulmez = new Account(2, "sibelgulmez", "10.03.1995", "Istanbul",accounts);  
		     accounts.add(sibelgulmez);
		   Account gokhankaya = new Account(3, "gokhankaya", "17.07.1990", "Bursa", accounts);  
		     accounts.add(gokhankaya);
		   Account defnekara = new Account(4,"defnekara","15.08.1994","Ankara", accounts);   
		     accounts.add(defnekara);
		   Account alibatmaz = new Account(5, "alibatmaz", "12.04.1889", "Edirne", accounts);  
		     accounts.add(alibatmaz);
		   Account ozanbudak = new Account(6, "ozanbudak", "25.06.1991", "Bursa", accounts);
		     accounts.add(ozanbudak);
		   Account mervedalan = new Account(7, "mervedalan", "19.05.1993", "Ankara", accounts);
		     accounts.add(mervedalan);
		   Account arasdevin = new Account(8, "arasdevin", "23.09.1994", "Mersin", accounts);
		     accounts.add(arasdevin);
		   Account cansuelzem = new Account(9, "cansuelzem", "04.10.1990", "Antalya", accounts);
		   	 accounts.add(cansuelzem);
		   Account umutmumcu = new Account(10, "umutmumcu", "08.12.1991", "Ankara", accounts);
		     accounts.add(umutmumcu);  
		   
		System.out.println("  An account with username "+ gizemsungu.getUsername()+" has been created.");
		System.out.println("  An account with username "+ sibelgulmez.getUsername()+" has been created.");
		System.out.println("  An account with username "+ gokhankaya.getUsername()+" has been created.");
		System.out.println("  An account with username "+ defnekara.getUsername()+" has been created.");
		System.out.println("  An account with username "+ alibatmaz.getUsername()+" has been created.");
		System.out.println("  An account with username "+ ozanbudak.getUsername()+" has been created.");
		System.out.println("  An account with username "+ mervedalan.getUsername()+" has been created.");
		System.out.println("  An account with username "+ arasdevin.getUsername()+" has been created.");
		System.out.println("  An account with username "+ cansuelzem.getUsername()+" has been created.");
		System.out.println("  An account with username "+ umutmumcu.getUsername()+" has been created.");
		
		
		System.out.println("\nStep 2... Logging into an account (username: sibelgulmez)");
		   sibelgulmez.login();
		System.out.println("\nStep 3... Sharing two post");
		System.out.println("  "+sibelgulmez.getUsername()+" shared two posts.");
		   sibelgulmez.addPost(1, "I like Java.");
		   sibelgulmez.addPost(2, "Java the coffee...");
	    System.out.println("\nStep 4... Following other accounts");
		   sibelgulmez.follow(gizemsungu);
		   sibelgulmez.follow(gokhankaya);
		   sibelgulmez.follow(umutmumcu);
		   sibelgulmez.follow(mervedalan);
		   sibelgulmez.follow(cansuelzem);
		System.out.println("\nStep 5... Logging out from account 'sibelgulmez'");   
		  sibelgulmez.logout();
		  
		  
		System.out.println("\nStep 6... Logging into an account (username: cansuelzem)");
		   cansuelzem.login();		   
		System.out.println("\nStep 7... Following other accounts");
		   cansuelzem.follow(sibelgulmez);
		   cansuelzem.follow(defnekara);
		   cansuelzem.follow(ozanbudak);   
		System.out.println("\nStep 8... Adding a comment on a post of sibelgulmez");
		   cansuelzem.comment(1, sibelgulmez, 1, "Helloo");      
		System.out.println("\nStep 9... Viewing own profile");
		   cansuelzem.viewProfile(cansuelzem);
		System.out.println("\nStep 10... Showing own history");
		   cansuelzem.showHistory();
		System.out.println("\nStep 11... Unfollow accounts ozanbudak and sibelgulmez");
		   cansuelzem.unfollow(ozanbudak);	
		   cansuelzem.unfollow(sibelgulmez);
		System.out.println("\nStep 12... Viewing own profile");
		   cansuelzem.viewProfile(cansuelzem);
		System.out.println("\nStep 13... Showing own history");
		   cansuelzem.showHistory();  
		System.out.println("\nStep 14... Logging out from account 'cansuelzem'");
		   cansuelzem.logout();
		   
		   
		System.out.println("\nStep 15... Logging into an account (username: arasdevin)"); 
		   arasdevin.login();
		System.out.println("\nStep 16... Following other accounts");
		   arasdevin.follow(sibelgulmez);
		   arasdevin.follow(ozanbudak);
		   arasdevin.follow(gokhankaya);
		   arasdevin.follow(mervedalan);
		System.out.println("\nStep 17... Liking a post of sibelgulmez");
		   arasdevin.like(1, sibelgulmez, 1);
		System.out.println("\nStep 18... Adding a comments on a post of sibelgulmez");
		   arasdevin.comment(1, sibelgulmez, 1, "I don't like Java");
		   arasdevin.comment(2, sibelgulmez, 1, "But I like C");
		System.out.println("\nStep 19... Viewing own profile");
		   arasdevin.viewProfile(arasdevin);
		System.out.println("\nStep 20... Showing own history");
		   arasdevin.showHistory();
		System.out.println("\nStep 21... Viewing post interactions of sibelgulmez");
		   arasdevin.viewInteraction(sibelgulmez);
		System.out.println("\nStep 22... Uncommenting to second comment of sibelgulmez's post 1");   
		   arasdevin.uncomment(2, sibelgulmez, 1);
		System.out.println("\nStep 23... Viewing post interactions of sibelgulmez");
		   arasdevin.viewInteraction(sibelgulmez);
		System.out.println("\nStep 24... Unfollow account mervedalan");
		   arasdevin.unfollow(mervedalan);
		System.out.println("\nStep 25... Showing own history");   
		   arasdevin.showHistory();
		System.out.println("\nStep 26... Logging out from account 'arasdevin'");
		   arasdevin.logout();
		   
		System.out.println("\nStep 27... alibatmaz login and liking of sibelgulmez post 2");
		   alibatmaz.login();
		   alibatmaz.follow(sibelgulmez);
		   alibatmaz.like(1, sibelgulmez, 2);
		System.out.println("\nStep 28... Viewing post interactions of sibelgulmez");
		   alibatmaz.viewInteraction(sibelgulmez);
		System.out.println("\nStep 29... alibatmaz unlike sibelgulmez's post id 2 and view post interactions");
		   alibatmaz.unlike(sibelgulmez, 2);
		   alibatmaz.viewInteraction(sibelgulmez);
		   alibatmaz.logout();
		   
		System.out.println("\nStep 30... Loggin into an account 'umutmumcu'");
		   umutmumcu.login();
		System.out.println("\nStep 31... Sharing two posts");
		System.out.println("  "+umutmumcu.getUsername()+" shared two posts.");
		   umutmumcu.addPost(1, "I want a holidayy.");
		   umutmumcu.addPost(2, "I don't want to work any more..."); 
		System.out.println("\nStep 32... Following other accounts");
		   umutmumcu.follow(gokhankaya);
		   umutmumcu.follow(ozanbudak);
		   umutmumcu.follow(mervedalan);   
		   umutmumcu.follow(defnekara);
		System.out.println("\nStep 33... Logging out from account 'umutmumcu'");
		   umutmumcu.logout();
		 
		System.out.println("\nStep 34... gizemsungu login and like umutmumcu's post id 1");
		   gizemsungu.login();
		   gizemsungu.like(1, umutmumcu, 1);
		   gizemsungu.logout();
		   
	    System.out.println("\nStep 35... defnekara login and like, comment umutmumcu's post id 1");
	       defnekara.login();
	       defnekara.follow(umutmumcu);
	       defnekara.like(1, umutmumcu, 1);
	       defnekara.comment(1, umutmumcu, 1, "Me too");
	       defnekara.logout();
	       
	    System.out.println("\nStep 36... gokhankaya login and like umutmumcu's post id 1");
		   gokhankaya.login();
		   gokhankaya.like(1, umutmumcu, 1);
		System.out.println("\nStep 37... gokhankaya viewing post interaction of umutmumcu");
		   gokhankaya.viewInteraction(umutmumcu);
		System.out.println("\nStep 38... gokhankaya unlike umutmumcu's post id 1");
		   gokhankaya.unlike(umutmumcu, 1);
		System.out.println("\nStep 39... gokhankaya viewing post interaction of umutmumcu");
		   gokhankaya.viewInteraction(umutmumcu);
		   gokhankaya.logout();
		   
	    System.out.println("\nStep 40... umutmumcu login, view own profile and block defnekara");
	       umutmumcu.login();
	       umutmumcu.viewProfile(umutmumcu);
	       umutmumcu.viewProfile(defnekara);
	       umutmumcu.block(defnekara);
	    System.out.println("\nStep 41... umutmumcu view own profile and posts interactions");
	       umutmumcu.viewProfile(umutmumcu);
	       umutmumcu.viewInteraction(umutmumcu);
	       umutmumcu.logout();
	       
	    System.out.println("\nStep 42... defnekara try viewing profile umutmumcu");
	       defnekara.login();
	       defnekara.viewProfile(umutmumcu);
	       defnekara.logout();
	       
	    System.out.println("\nStep 43... umutmumcu enter defnekara profile and unblocked of defnekara");
	       umutmumcu.login();
	       umutmumcu.viewProfile(defnekara);
	       umutmumcu.unblock(defnekara);
	    System.out.println("\nStep 44... umutmumcu show own history");   
	       umutmumcu.showHistory();
	       umutmumcu.logout();
	       
	    System.out.println("\nStep 45... defnekara login, view own profile and try view umutmumcu profile");
	       defnekara.login();
	       defnekara.viewProfile(defnekara);
	       defnekara.viewProfile(umutmumcu);
	       defnekara.logout();
	       
	       System.out.println("\nStep 46... arasdevin login and comments of sibelgulmez post 1");
		      arasdevin.login();
		      arasdevin.comment(2, sibelgulmez,1, "Hi");
		      arasdevin.comment(3, sibelgulmez, 1, "I don't");
		      arasdevin.comment(4, sibelgulmez, 1, "Yeap");
		      arasdevin.viewInteraction(sibelgulmez);
		      arasdevin.uncomment(2, sibelgulmez, 1);
		      arasdevin.uncomment(3, sibelgulmez, 1); 
		      arasdevin.viewInteraction(sibelgulmez);
		      arasdevin.logout();
		      
		   System.out.println("\nStep 47... alibatmaz login, follow and unfollow accounts");
		      alibatmaz.login();
		      alibatmaz.follow(ozanbudak);
		      alibatmaz.follow(cansuelzem);
		      alibatmaz.follow(defnekara);
		      alibatmaz.viewProfile(alibatmaz);
		      alibatmaz.unfollow(ozanbudak);
		      alibatmaz.viewProfile(alibatmaz);
		      alibatmaz.unfollow(cansuelzem);
		      alibatmaz.viewProfile(alibatmaz);
		      alibatmaz.showHistory();   
		      
		      long end = System.currentTimeMillis();
				float sec = (end - start) / 1000F;
				//System.out.println(" -> "+sec + " seconds");
			
	          
	}	
}

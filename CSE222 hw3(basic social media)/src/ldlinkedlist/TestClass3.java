package ldlinkedlist;

public class TestClass3 {

	   public static void main(String[] args) {
		   
		   long start = System.currentTimeMillis();
			
			System.out.println("        CSE222 - HW3");
			System.out.println("Welcome to Social Media Software");
			System.out.println("****** This is Test Scenario 3 *******");
			System.out.println();
			
			System.out.println("=================================Actions in the test scenario 1=================================");
			/****Step1: Create 3 accounts****/
			System.out.println("Step 1... Creating accounts");
			
			   LDLinkedList<Account> accounts = new LDLinkedList();
			
			   Account gizemsungu = new Account(1, "gizemsungu", "13.01.1993", "Ankara", accounts);
			     accounts.add(gizemsungu);
			   Account sibelgulmez = new Account(2, "sibelgulmez", "10.03.1995", "Istanbul",accounts);  
			     accounts.add(sibelgulmez);
			   Account gokhankaya = new Account(3, "gokhankaya", "17.07.1990", "Bursa", accounts);  
			     accounts.add(gokhankaya);
			 
			System.out.println("  An account with username "+ gizemsungu.getUsername()+" has been created.");
			System.out.println("  An account with username "+ sibelgulmez.getUsername()+" has been created.");
			System.out.println("  An account with username "+ gokhankaya.getUsername()+" has been created.");
			
			/****Step2: Login to the account with username sibelgulmez****/
			System.out.println("\nStep 2... Logging into an account (username: sibelgulmez)");
			
			   sibelgulmez.login();
			
			/****Step3: Share two posts****/
			System.out.println("\nStep 3... Sharing two post");
			System.out.println("  "+sibelgulmez.getUsername()+" shared two posts.");
			
			   sibelgulmez.addPost(1, "I like Java.");
			   sibelgulmez.addPost(2, "Java the coffee...");
			
			/****Step4: Follow gizemsungu and gokhankaya****/
			System.out.println("\nStep 4... Following gizemsungu and gokhankaya");
			   sibelgulmez.follow(gizemsungu);
			   sibelgulmez.follow(gokhankaya);
			     //System.out.println("\n ***Control of another account in follow function 'gizemsungu.follow(sibelgulmez)' ");
			     //gizemsungu.follow(sibelgulmez);
			
			/****Step5: Log out from the account****/
			System.out.println("\nStep 5... Logging out from account 'sibelgulmez'");
			   sibelgulmez.logout();
			
			/****Step6: Login to the account with username gokhankaya****/
			System.out.println("\nStep 6... Logging into another account (username: gokhankaya)");
			   gokhankaya.login();
			   
			/****Step7: View "sibelgulmez"s profile****/
			System.out.println("\nStep 7... Viewing sibelgulmez's profile");
			   gokhankaya.viewProfile(sibelgulmez);
			   
			/****Step8: View "sibelgulmez"s posts****/
			System.out.println("\nStep 8... Viewing sibelgulmez's posts");
			   gokhankaya.viewPosts(sibelgulmez);
			   
			/****Step9: Like a post of "sibelgulmez"****/
			System.out.println("\nStep 9... Liking a post of sibelgulmez");
			   gokhankaya.like(1, sibelgulmez, 1);
			   
			/****Step10: Comment on a post of sibelgulmez****/
			System.out.println("\nStep 10... Adding a comment on a post of sibelgulmez");
			   gokhankaya.comment(1, sibelgulmez, 1, "me too!");
			   
			/****Step11: Follow "sibelgulmez" and "gizemsungu"****/
			System.out.println("\nStep 11... Following sibelgulmez and gizemsungu");
				gokhankaya.follow(sibelgulmez);
				gokhankaya.follow(gizemsungu);
				
			/****Step12: Send a message to gizemsungu****/
			System.out.println("\nStep 12... Sending a message to gizemsungu");
			   gokhankaya.sendMessage(1, gizemsungu, "This homework is too easy!");
			   
			/****Step13: Log out from the account****/
			System.out.println("\nStep 13: Logging out from account 'gokhankaya' ");
			   gokhankaya.logout();
			   
			/****Step14: Login to the account with username gizemsungu****/
			System.out.println("\nStep 14... Logging into another account (username: gizemsungu)");   
				gizemsungu.login();
				
			/****Step15: Check the number of messages in the outbox****/
			System.out.println("\nStep 15... Checking number of messages in outbox");
			    gizemsungu.checkOutbox();
			    
			/****Step16: Check the number of messages in the inbox****/
			System.out.println("\nStep 16... Checking number of messages in inbox");
			   gizemsungu.checkInbox();
			   
			/****Step17: View the messages in the inbox****/
			System.out.println("\nStep 17... Viewing inbox");
			   gizemsungu.viewInbox();
			   
			/****Step18: View "sibelgulmez"s profile****/
			System.out.println("\nStep 18... Viewing sibelgulmez's profile");
			   gizemsungu.viewProfile(sibelgulmez);
			   
			/****Step19: View "sibelgulmez"s posts****/
			System.out.println("\nStep19... Viewing sibelgulmez's posts");
			   gizemsungu.viewPosts(sibelgulmez);
			   
			/****Step20: View "sibelgulmez"s posts interactions****/
			System.out.println("\nStep 20... Viewing sibelgulmez's posts' interactions");
			   gizemsungu.viewInteraction(sibelgulmez);
			   
			/****Step21: Like "sibelgulmez"s posts****/
			System.out.println("\nStep 21... Liking sibelgulmez's posts");
			   gizemsungu.like(2, sibelgulmez, 1);
			   gizemsungu.like(3, sibelgulmez, 2);
			   
			/****Step22: View "sibelgulmez"s posts interactions****/
			System.out.println("\nStep22... Viewing sibelgulmez's posts' interactions");
			   gizemsungu.viewInteraction(sibelgulmez);
			   
			System.out.println("\n==============================End of the actions in the test scenario 1==============================");   
			   
	/***************************************************************************************************************************************
	***************************************************************************************************************************************/
			  		   
			System.out.println("\n===========================================Test Scenario 3===========================================");  
			
			/****Step3.1: Login to the account with username gizemsungu*****/
			System.out.println("\nStep 1... Logging into an account (username: gizemsungu)");
			   gizemsungu.login();
			   
			/****Step3.2: Blocks to the account sibelgulmez****/
			System.out.println("\nStep2... Blocking to the account of sibelgulmez");   
			    gizemsungu.viewProfile(sibelgulmez);
				gizemsungu.block(sibelgulmez);
				
			/****Step3.3: Log out from the account****/
			System.out.println("\nStep 3... Logging out from account 'gizemsungu'");
			   gizemsungu.logout();
			  
			/****Step3.4: Login to the account with username sibelgulmez*****/
		    System.out.println("\nStep 4... Logging into an account (username: sibelgulmez)");
			   sibelgulmez.login();  
			 
			/****Step3.5: View "gizemsungu"s profile****/
			System.out.println("\nStep 5... Viewing gizemsungu's profile");
			   sibelgulmez.viewProfile(gizemsungu);  
			   
			/****Step3.6: Send a message to gizemsungu****/
			System.out.println("\nStep 6... Sending a message to gizemsungu");
			   sibelgulmez.sendMessage(1, gizemsungu, "Helloo!");  
			 
			   long end = System.currentTimeMillis();
				float sec = (end - start) / 1000F;
				//System.out.println(" -> "+sec + " seconds");
		}
}

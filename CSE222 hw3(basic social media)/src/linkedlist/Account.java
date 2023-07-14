package linkedlist;

import java.util.LinkedList;


/**
 * <p>
 * Account class
 * </p>
 * This class includes accounts to be created in a simple social media design, features that are in every account,
 * and functions that an account can do.
 *
 */
public class Account {

		private int accountId;
		private String username;
		private String birthdate;
		private String location;
		private String content;
		
		private LinkedList<Post> posts = new LinkedList();
		private LinkedList<Message> inbox = new LinkedList();
		private LinkedList<Message> outbox = new LinkedList();
		private LinkedList<Account> following = new LinkedList();
		private LinkedList<Account> followers = new LinkedList();
		private LinkedList<Account> blocked = new LinkedList();
		private LinkedList<String> history = new LinkedList();
		
		
		/**
		 * <p>
		 * loginControl
		 * </p>
		 * It is used to check whether an account is logged in or not
		 */
		private boolean loginControl = false;
		
		/**
		 * <p>
		 * viewProfile
		 * </p>
		 * It is used to prevent viewing the posts of an account without viewing its profile.
		 */
		private boolean viewProfile = false;
		
		public Account(int accountId, String username, String birthdate, String location) {
			this.accountId = accountId;
			this.username = username;
			this.birthdate = birthdate;
			this.location = location;
		}
		
		//Used for the case that checks if the username is taken.
		public Account(int accountId, String username, String birthdate, String location, LinkedList<Account> accounts) {
		
			int flag = 0;
			for(int i=0; i<accounts.size(); i++) {
				if(accounts.get(i).username== username) {
					System.out.println("  ! This username has been taken, you can't get it again.");
					flag = 1;
				}
			}
			if(flag==0) {
				this.accountId = accountId;
				this.username = username;
				this.birthdate = birthdate;
				this.location = location;
			}
		}
		
		/**
		 * This method is used to access the user name of the account.
		 * @return Returns the username of the account
		 */
		public String getUsername() {
			return username;
		}
		
		/**
		 * This method allows logging into the account and checking the login.
		 */
		public void login() {
			
			if(loginControl==true) {
				System.out.println("  ! You are already logged into your account.");
			}
			else {
				loginControl = true;
				System.out.println("  "+this.username+" has logged into account");
			}
		}
		
		/**
		 * This method allows logging out of the account and checking the login.
		 */
		public void logout() {
			
			if(loginControl!=false) {
				System.out.println("  "+this.username+" logged out of account");
				loginControl = false;
				
			}
			else {
				System.out.println("  ! You are not already logged into your account");
			}
		}
		
		/**
		 * This method allows post sharing on the user's account.
		 * In order to share a post, it is necessary to log in to the account.
		 * @param postId 
		 * @param content The content of the post to be added
		 */
		public void addPost(int postId, String content) {
			
			if(this.loginControl==false) {
				System.out.println("  ! You must be logged in to your account to share a post.");			
			}
			else {
				Post post1 = new Post(postId, this, content);
				posts.add(post1);
				System.out.print("     ");
				posts.get(postId-1).printPost();
				
				content = "You added post (postId: "+ postId+")";
				history.add(content);
			}
		}
		
		/**
		 * <p>
		 * This method allows the users to follow other accounts.
		 * </p>
		 * If the account is logged in and an account that has not been followed 
		 * before is wanted to be followed, the follow-up process is performed.
		 * @param act User account to be followed
		 */
		public void follow(Account act) {
			
			int flag = 0;					//Used to check if the account is already being followed.
			
			if(this.loginControl==true) {
				for(int i=0; i<following.size(); i++) {
					if(following.get(i).username==act.username) {
						System.out.println("  ! You are already following this account.");
						flag=1;
					}
				}
				if(flag==0) {
					this.following.add(act);
					System.out.println("  "+this.username+" followed "+following.get(following.size()-1).username);
					act.followers.add(this);
					
					content = "You followed "+ act.username;
					history.add(content);
				}
			}
			else {
				System.out.println("  Before you can follow an account, you must log in to your account.");
			}
			
		}
		
		public void unfollow(Account act) {
			
			int flag = 0;
			
			if(this.loginControl==true) {
								
					for(int i=0; i<following.size(); i++) {
						if(following.get(i).username==act.username) {
							flag=1;
						}
					}
					if(flag==0) {
						System.out.println(" ! You are not already followed this account");
					}
					else {
						this.following.remove(act);
						System.out.println("  "+this.username+" unfollow this account "+act.username);
						act.followers.remove(this);
						
						content = "You unfollowed "+act.username;
						history.add(content);
					}
				
			}
			else {
				System.out.println("  ! You must log in to the account to unfollow other accounts");
			}
			
		}
		
		
		/**
		 * <p>
		 * This method is used to display the information of an account.
		 * </p>
		 *  If the account is logged in and the account to be viewed has not
		 *  blocked this account, the display is performed.
		 * @param act User account to be view
		 */
		public void viewProfile(Account act) {
			int flag = 0;						//used to check blocking situation
			if(this.loginControl == false) {
				//System.out.println("  ! You must be logged in to your account to viewing the profile of another account.");
				flag=2;
			}
			for(int i=0; i<act.blocked.size(); i++) {
				if(this.username==act.blocked.get(i).username) {
					flag=1;
				}
			}
			if(flag==1) {
				System.out.println("  ! You have been blocked by "+act.username);
			}
			else if(flag==2) {
				System.out.println("  ! You must be logged in to your account to viewing the profile of another account.");
			}
			else {
				
				act.viewProfile = true;						//To control the display of posts
				System.out.println("  -------------------------------------------------------------");
				System.out.println("  UserId: "+act.accountId);
				System.out.println("  Username: "+act.username);
				System.out.println("  Location: "+act.location);
				System.out.println("  Birthdate: "+act.birthdate);
				System.out.println("  "+act.username+" is following "+act.following.size()+" account(s) and has "+act.followers.size()+" follower(s).");
				if(act.followers.size()!=0) {
					System.out.print("  The followers of "+act.username+" are: ");
					act.printFollowers();
				}
				if(act.following.size()!=0) {
					System.out.print("  "+act.username+" is following: ");
					act.printFollowing();
				}
				System.out.println("  "+ act.username+" has "+act.posts.size()+" posts.");
				System.out.println("  -------------------------------------------------------------");
				
			}
					
		}
		
		/**
		 * <p>
		 * This method allows to view the posts in the account's profile.
		 * </p>
		 * The profile of the account must be viewed before the posts can be viewed.
		 * @param act User account to be view posts
		 */
		public void viewPosts(Account act) {
			if(act.viewProfile == false) {
				System.out.println(" ! To view the posts, you must first view the user's profile");
			}
			else {
					for(int i=0; i<act.posts.size(); i++) {
						System.out.print("  ");
						act.posts.get(i).printPost();
					}
					act.viewProfile = false;
			}
		}
		
		/**
		 * This method allows you to like posts. You must be logged into the account to like.
		 * @param interactionId
		 * @param act Account of the post to like
		 * @param postId postId to like
		 */
		public void like(int interactionId, Account act, int postId) {
			
			if(this.loginControl==false) {
				System.out.println("  ! You must log in to the account to like the post");
			}
			/*if(act.viewProfile == false) {
				System.out.println(" ! To like the posts, you must first view the user's profile and posts");
			}*/
			else {
				if(act.posts.size()<postId) {
					System.out.println("  ! There is no such post");
				}
				else {
					Like like1 = new Like(interactionId,this,postId);
					act.posts.get(postId-1).addLike(interactionId, like1);	
					System.out.println("  "+this.username+" liked post"+postId+" of "+act.username);
					
					content = "You liked "+act.username+"' post id : "+postId;
					history.add(content);
				}
				
			}
			
			
		}
		
		public void unlike(Account act, int postId) {
			
			if(this.loginControl==false) {
				System.out.println("  ! You must log in to the account to like the post");
			}
			
			else {
				if(act.posts.size()<postId) {
					System.out.println("  ! There is no such post");
				}
				else {
					act.posts.get(postId-1).removeLike();
					System.out.println("  "+this.username+" unliked post"+postId+" of "+act.username);
					
					content = "You unlike "+act.username+"' post id: "+postId;
					history.add(content);
				}
				
			}
		}
			
		/**
		 * This method allows you to comment on the post. You must be logged into the account to comment.
		 * @param interactionId
		 * @param act Account where comments will be made
		 * @param postId
		 * @param content
		 */
		public void comment(int interactionId, Account act, int postId, String content) {
			
			if(this.loginControl==false) {
				System.out.println("  ! You must log in to the account to write a comment the post");
			}
			else {
				if(act.posts.size()<postId) {
					System.out.println("  ! There is no such post");
				}
				else {
					Comment comment1 = new Comment(interactionId, this, postId, content);
					act.posts.get(postId-1).addComment(interactionId, comment1);
					System.out.println("  "+this.username+" wrote a comment for post"+postId+" of "+act.username);
					
					content = "You commented "+act.username+"' post id: "+postId;
					history.add(content);
				}
				
			}
			
		}
		
		public void uncomment(int interactionId, Account act, int postId) {
			
			if(this.loginControl==false) {
				System.out.println("  ! You must log in to the account to write a comment the post");
			}
			else {
				if(act.posts.size()<postId) {
					System.out.println("  ! There is no such post");
				}
				else {
					act.posts.get(postId-1).removeComment(interactionId);
					System.out.println("  "+this.username+" remove a comment for post"+postId+" of "+act.username);
					
					content = "You uncommented "+act.username+"' post id: "+postId;
					history.add(content);
				}
				
			}
		}
		
		/**
		 * <p>
		 * This method provide sending messages to another account.
		 *</p>
		 * @param id message number
		 * @param act the account to which the message will be sent
		 * @param msg content of the message
		 */
         public void sendMessage(int id,Account act,String msg) {
			
			int flag = 0;		//to check the follower list
			int flag2 = 0;		//to check the blocking situation
			if(this.loginControl==false) {
				System.out.println("  ! You must log in to your account to send a message.");
			}
			else {
				for(int i=0; i<act.blocked.size(); i++) {
					if(this.username==act.blocked.get(i).username) {
						flag=1;
					}
				}
				if(flag==1) {
					System.out.println("  ! You have been blocked by "+act.username);
				}
				else {
					for(int i=0; i<this.following.size(); i++) {
						if(following.get(i) == act) {
							flag2 = 1;						//The user is following the account.
						}
					}
					if(flag2==0) {
						System.out.println("  ! You must follow this account to be able to send a message");
					}
					else {
						Message message1 = new Message(id,this,act, msg);
						act.inbox.add(message1);
						this.outbox.add(message1);
						System.out.println("  "+this.username+" sent message to "+act.username);
						
						content = "You sended message to "+act.username;
						history.add(content);
					}
				}
				
			}
			
		}
		
		/**
		 * This methods shows number of messages in outbox.
		 */
		public void checkOutbox() {
			System.out.println("  There is/are "+outbox.size()+" message(s) in outbox.");
		}
		
		/**
		 * This methods shows number of messages in inbox
		 */
		public void checkInbox() {
			System.out.println("  There is/are "+inbox.size()+" message(s) in inbox.");
		}
		
		/**
		 * This method shows the messages  in the inbox.
		 */
		public void viewInbox() {
			if(this.loginControl==false) {
				System.out.println(" ! You must log in to view your message box");
			}
			else {
				for(int i=0; i<inbox.size(); i++) {
					if(inbox.get(i)!=null) {
						inbox.get(i).printInbox();
					}
				}
			}
		}
		
		/**
		 * This method shows the messages  in the outbox.
		 */
		public void viewOutbox() {
			if(this.loginControl==false) {
				System.out.println(" ! You must log in to view your message box");
			}
			else {
				for(int i=0; i<outbox.size(); i++) {
					if(outbox.get(i)!=null) {
						outbox.get(i).printOutbox();
					}
				}
			}
		}
		
		
		/**
		 * This method displays the interaction information (like, comment) of the account's posts.
		 * @param act The account where the post interactions will be displayed
		 */
		public void viewInteraction(Account act) {
			for(int i=0; i<act.posts.size(); i++) {
				if(act.posts.get(i)!=null) {
					if(i==0) {
						System.out.println("  -----------------------------------------------------------------");
					}
					System.out.print("  ");
					act.posts.get(i).printPost();
					act.posts.get(i).printInteraction(i+1);
					System.out.println("  -----------------------------------------------------------------");
					
					//content = "You viewed posts interaction of "+act.username;
					//history.add(content);
				}
			}
			
		}
		
		/**
		 * This method provide to block an account.
		 * @param act Account to be blocked
		 */
		public void block(Account act) {
			
			if(this.loginControl==true) {
				if(act.viewProfile==false) {
					System.out.println(" ! You first must view profile to block other account");
				}
				else {
					this.blocked.add(act);
					this.following.remove(act);
					act.followers.remove(this);
					this.followers.remove(act);
					act.following.remove(this);
					System.out.println("  "+this.username+" blocked "+act.username);
					
					content = "You blocked "+act.username;
					history.add(content);
					
					for(int i=0; i<posts.size(); i++) {
						posts.get(i).blockLike(act);
						posts.get(i).blockComment(act);
					}
					act.viewProfile=false;
				}
			}
			else {
				System.out.println(" ! You must log in to block other account");
			}
		}
		
		public void unblock(Account act) {
			
			int flag = 0;
			
			if(this.loginControl==true) {
				if(act.viewProfile==false) {
					System.out.println(" ! You first view profile to unblock other account");
				}
				
				else {
					for(int i=0; i<this.blocked.size(); i++) {
						if(this.blocked.get(i).username == act.username) {
							flag = 1;
						}
					}
					if(flag == 0) {
						System.out.println(" ! You are not already blocked this account");
					}
					else {
						this.blocked.remove(act);
						System.out.println("  You are unblocked of "+act.username);
						
						content = "You unblocked "+act.username;
						history.add(content);
					}
				}
			}
			else {
				System.out.println(" ! You must log in to unblock other account");
			}
			
		}
		
		
		private void printFollowing() {
			for(int i=0; i<following.size(); i++) {
				if(i==following.size()-1) {
					System.out.println(following.get(i).username+".");
				}
				else {
					System.out.print(following.get(i).username+", ");
				}
				
			}
		}
		
		private void printFollowers() {
			for(int i=0; i<followers.size(); i++) {
				if(i==followers.size()-1) {
					System.out.println(followers.get(i).username+".");
				}
				else {
					System.out.print(followers.get(i).username+", ");
				}
			}
		}
		
		public void showHistory() {
			
			if(this.loginControl==true) {
				System.out.println("  -------------Your action history-------------");
				
				for(int i=0; i<history.size(); i++) {
					System.out.print("  ");
					System.out.println(history.get(i));
				}
				System.out.println("  ---------------------------------------------");
			}
			
			else {
				System.out.println("! You must log in to show your history");
			}
		}
				
		
}

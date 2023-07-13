package homework1;

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
	private Post[] posts = new Post[10];
	private Message[] inbox = new Message[10];
	private Message[] outbox = new Message[10];
	
	private Account[] following = new Account[10];
	private Account[] followers = new Account[10];
	private Account[] blocked = new Account[10];
	
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
	public Account(int accountId, String username, String birthdate, String location, Account[] accounts) {
	
		int flag = 0;
		for(int i=0; i<getIndexOfArray(accounts); i++) {
			if(accounts[i].username== username) {
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
			posts[postId-1] = post1;
			System.out.print("     ");
			posts[postId-1].printPost();
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
			for(int i=0; i<getIndexOfArray(following); i++) {
				if(following[i].username==act.username) {
					System.out.println("  ! You are already following this account.");
					flag=1;
				}
			}
			if(flag==0) {
				this.following[getIndexOfArray(following)] = act;
				System.out.println("  "+this.username+" followed "+following[getIndexOfArray(following)-1].username);
				act.followers[act.getIndexOfArray(act.followers)]=this;
			}
		}
		else {
			System.out.println("  Before you can follow an account, you must log in to your account.");
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
		for(int i=0; i<getIndexOfArray(act.blocked); i++) {
			if(this.username==act.blocked[i].username) {
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
			System.out.println("  "+act.username+" is following "+getIndexOfArray(act.following)+" account(s) and has "+getIndexOfArray(act.followers)+" follower(s).");
			if(getIndexOfArray(act.followers)!=0) {
				System.out.print("  The followers of "+act.username+" are: ");
				act.printFollowers();
			}
			if(getIndexOfArray(act.following)!=0) {
				System.out.print("  "+act.username+" is following: ");
				act.printFollowing();
			}
			System.out.println("  "+ act.username+" has "+act.numberOfPost()+" posts.");
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
				for(int i=0; i<act.numberOfPost(); i++) {
					System.out.print("  ");
					act.posts[i].printPost();
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
			if(act.numberOfPost()<postId) {
				System.out.println("  ! There is no such post");
			}
			else {
				Like like1 = new Like(interactionId,this,postId);
				act.posts[postId-1].addLike(interactionId, like1);	
				System.out.println("  "+this.username+" liked post"+postId+" of "+act.username);
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
			if(act.numberOfPost()<postId) {
				System.out.println("  ! There is no such post");
			}
			else {
				Comment comment1 = new Comment(interactionId, this, postId, content);
				act.posts[postId-1].addComment(interactionId, comment1);
				System.out.println("  "+this.username+" wrote a comment for post"+postId+" of "+act.username);
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
			for(int i=0; i<getIndexOfArray(this.following); i++) {
				if(following[i] == act) {
					flag = 1;						//The user is following the account.
				}
			}
			if(flag==0) {
				System.out.println("  ! You must follow this account to be able to send a message");
			}
			else {
				for(int i=0; i<getIndexOfArray(act.blocked); i++) {
					if(this.username==act.blocked[i].username) {
						flag2=1;
					}
				}
				if(flag2==1) {
					System.out.println("  ! You have been blocked by "+act.username);
				}
				else {
					Message message1 = new Message(id,this,act, msg);
					act.inbox[id-1] = message1;
					this.outbox[id-1]= message1;
					System.out.println("  "+this.username+" sent message to "+act.username);
				}
			}
			
		}
		
	}
	
	/**
	 * This methods shows number of messages in outbox.
	 */
	public void checkOutbox() {
		int count = 0;
		for(int i=0; i<outbox.length; i++) {
			if(outbox[i]!=null) {
				count++;
			}
		}
		System.out.println("  There is/are "+count+" message(s) in outbox.");
	}
	
	/**
	 * This methods shows number of messages in inbox
	 */
	public void checkInbox() {
		int count=0;
		for(int i=0; i<inbox.length; i++) {
			if(inbox[i]!=null) {
				count++;
			}	
		}
		System.out.println("  There is/are "+count+" message(s) in inbox.");
	}
	
	/**
	 * This method shows the messages  in the inbox.
	 */
	public void viewInbox() {
		if(this.loginControl==false) {
			System.out.println(" ! You must log in to view your message box");
		}
		else {
			for(int i=0; i<inbox.length; i++) {
				if(inbox[i]!=null) {
					inbox[i].printInbox();
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
			for(int i=0; i<outbox.length; i++) {
				if(outbox[i]!=null) {
					outbox[i].printOutbox();
				}
			}
		}
	}
	/**
	 * This method displays the interaction information (like, comment) of the account's posts.
	 * @param act The account where the post interactions will be displayed
	 */
	public void viewInteraction(Account act) {
		for(int i=0; i<act.posts.length; i++) {
			if(act.posts[i]!=null) {
				if(i==0) {
					System.out.println("  -----------------------------------------------------------------");
				}
				System.out.print("  ");
				act.posts[i].printPost();
				act.posts[i].printInteraction(i+1);
				System.out.println("  -----------------------------------------------------------------");
			}
		}
		
	}
		
	/**
	 * This method provide to block an account.
	 * @param act Account to be blocked
	 */
	public void block(Account act) {
		this.blocked[getIndexOfArray(blocked)] = act;
		System.out.println("  "+this.username+" blocked "+act.username);
	}
	
	/**
	 * This method is used to find the number of elements of an Account array
	 * @param array 
	 * @return the number of the elements in the array
	 */
	private int getIndexOfArray(Account[] array) {
		int count = 0;
		for(int i=0; i<array.length; i++) {
			if(array[i]!=null) {
				count++;
			}
		}
		return count;
	}
	
	private void printFollowing() {
		for(int i=0; i<getIndexOfArray(following); i++) {
			if(i==getIndexOfArray(following)-1) {
				System.out.println(following[i].username+".");
			}
			else {
				System.out.print(following[i].username+", ");
			}
			
		}
	}
	
	private void printFollowers() {
		for(int i=0; i<getIndexOfArray(followers); i++) {
			if(i==getIndexOfArray(followers)-1) {
				System.out.println(followers[i].username+".");
			}
			else {
				System.out.print(followers[i].username+", ");
			}
		}
	}
	
	private int numberOfPost() {
		int count = 0;
		for(int i=0; i<posts.length; i++) {
			if(posts[i]!=null) {
				count++;
			}
		}
		return count;
	}
	
	
}

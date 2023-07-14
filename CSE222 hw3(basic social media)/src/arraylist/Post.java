package arraylist;

import java.util.ArrayList;

/**
 * <p>
 * Post class
 * </p>
 * This class contains the post information of the accounts.
 *
 */
public class Post {

	private int postId;
	private Account accountId;
	private ArrayList<Like> likes = new ArrayList();
	private ArrayList<Comment> comments = new ArrayList();
	private String content = null;
	
	
	public Post(int postId, Account accountId, String content) {
		this.postId = postId;
		this.accountId = accountId;
		this.content = content;
	}
	
	public void printPost() {
		System.out.println("(PostId: "+postId+") "+accountId.getUsername()+": "+ content);	
	}
		
	public void addLike(int interactionId,Like like) {
		likes.add(like);
				
	}
	
	public void removeLike() {
		likes.remove(likes.size()-1);
	}
	
	public void addComment(int interactionId, Comment comment) {
		comments.add(comment);
	}
	
	public void removeComment(int i) {
		comments.remove(i);
	}
	
	public void blockLike(Account act) {
		
		for(int i=0; i<this.likes.size(); i++) {
			if(this.likes.get(i).accountId.getUsername() == act.getUsername()) {
				likes.remove(i);
			}
		}
	}
	
	public void blockComment(Account act) {
		
		for(int i=0; i<this.comments.size(); i++) {
			if(this.comments.get(i).accountId.getUsername() == act.getUsername()) {
				comments.remove(i);
			}
		}
	}
	/**
	 * This method is used to print the account's post interactions.
	 * @param in interactionId
	 */
	public void printInteraction(int in) {
		
		int flag = 0;
		
		for(int i = 0; i<likes.size(); i++) {
			if(likes.get(i)!=null) {
				if(likes.get(i).postId==in) {
					if(flag==0) {
						System.out.print("  The post was like by the following account(s): ");
					}
					System.out.print(likes.get(i).accountId.getUsername()+", ");
					flag = 1;
				}
			}
		}
	
		if(flag==0) {
			System.out.println("  The post has no likes.");
		}
		else {
			System.out.println();
		}
		flag = 0;
		
		for(int i = 0; i<comments.size(); i++) {
			if(comments.get(i)!=null) {
				if(comments.get(i).postId==in) {
					if(flag==0) {
						System.out.println("  The post has "+this.numberOfComment()+" comment(s)...");
					}
					System.out.println("     Comment "+(i+1)+" : '"+ comments.get(i).accountId.getUsername()+"' said '"+ comments.get(i).getContent()+"'");
					flag = 1;
				}
			}
		}
		if(flag==0) {
			System.out.println("  The post has no comment.");
		}
		
	}
	
	/**
	 * This method is used to calculate number of comments in post.
	 * @return number of comments
	 */
	private int numberOfComment() {
		return comments.size();
	}
	
	/**
	 * This method is used to calculate number of likes in post.
	 * @return number of likes
	 */
	private int numberOfLikes() {
		return likes.size();
	}
	
	
	
	
}	



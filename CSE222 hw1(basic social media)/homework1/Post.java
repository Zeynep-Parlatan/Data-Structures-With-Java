package homework1;

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
	private Like[] likes = new Like[10];
	private Comment[] comments = new Comment[10];
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
		likes[interactionId-1] = like;
		
	}
	
	public void addComment(int interactionId, Comment comment) {
		comments[interactionId-1] = comment;
	}
	
	/**
	 * This method is used to print the account's post interactions.
	 * @param in interactionId
	 */
	public void printInteraction(int in) {
		
		int flag = 0;
		
		for(int i = 0; i<likes.length; i++) {
			if(likes[i]!=null) {
				if(likes[i].postId==in) {
					if(flag==0) {
						System.out.print("  The post was like by the following account(s): ");
					}
					System.out.print(likes[i].accountId.getUsername()+", ");
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
		
		for(int i = 0; i<comments.length; i++) {
			if(comments[i]!=null) {
				if(comments[i].postId==in) {
					if(flag==0) {
						System.out.println("  The post has "+this.numberOfComment()+" comment(s)...");
					}
					System.out.println("     Comment "+(i+1)+" : '"+ comments[i].accountId.getUsername()+"' said '"+ comments[i].getContent()+"'");
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
		int count = 0;
		for(int i=0; i<this.comments.length; i++) {
			if(comments[i]!=null) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * This method is used to calculate number of likes in post.
	 * @return number of likes
	 */
	private int numberOfLikes() {
		int count = 0;
		for(int i=0; i<this.likes.length; i++) {
			if(likes[i]!=null) {
				count++;
			}
		}
		return count;
	}
	
}

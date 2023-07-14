package arraylist;

/**
 * <p>
 * Comment class
 * </p>
 * This class contains information of comments made on posts in a simple social media design. 
 * 
 */
public class Comment extends Interaction{

	private String content = null;
	
	public Comment(int interactionId, Account accountId, int postId, String content) {
		super(interactionId,accountId,postId);
		this.content = content;
	}
	
	/**
	 * It is written to be able to access the content of the comment from other classes.
	 * @return Returns the content of the message
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * It is written to be able to access the interactionId of comment from other classes.
	 * @return Returns the interactionId of comment
	 */
	public int getinteractionId() {
		return interactionId;
	}
	
}

package linkedlist;

/**
 * <p>
 * Interaction class
 * </p>
 * This class contains interaction information for posts in a simple social media design.
 *
 */
public class Interaction {

	protected int interactionId;
	protected Account accountId;
	protected int postId;
	
	public Interaction(int interactionId, Account accountId, int postId) {
		this.interactionId = interactionId;
		this.accountId = accountId;
		this.postId = postId;	
	}
}
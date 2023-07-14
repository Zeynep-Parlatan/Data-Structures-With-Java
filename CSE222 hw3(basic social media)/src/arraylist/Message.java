package arraylist;

/**
 * <p>
 * Message class
 * </p>
 * This class contains message information that accounts send to each other.
 *
 */
public class Message {

	private int messageId;
	private Account senderId;
	private Account receiverId;
	private String content = null;
	
	
	public Message(int messageId, Account senderId, Account receiverId, String content) {
		this.messageId = messageId;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.content = content;
	}
    
	/**
	 * This method is used to access the messageId of the message.
	 * @return messageId
	 */
	public int getId() {
		return messageId;
	}

	/**
	 * 
	 * @return the account that sent the message
	 */
	public Account getSenderId() {
		return senderId;
	}
	
	/**
	 * 
	 * @return the account that received the message
	 */
	public Account getReceiverId() {
		return receiverId;
	}
	
	public void printInbox() {
		System.out.println("  ------------------------------------");
		System.out.println("  Message Id: "+messageId);
		System.out.println("  From: "+senderId.getUsername());
		System.out.println("  To: "+ receiverId.getUsername());
		System.out.println("  Message: "+content);
		System.out.println("  ------------------------------------");
	}
	
	public void printOutbox() {
		System.out.println("  --------------------------");
		System.out.println("  Message Id: "+messageId);
		System.out.println("  From: "+receiverId);
		System.out.println("  To: "+ senderId);
		System.out.println("  Message: "+content);
		System.out.println("  --------------------------");
	}
}

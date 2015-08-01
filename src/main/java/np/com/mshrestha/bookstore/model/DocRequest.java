package np.com.mshrestha.bookstore.model;

public class DocRequest {
	
	String authToken;
	String isCount;
	int startPage;
	int numOfEntries;
	Book book;
	
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public String getIsCount() {
		return isCount;
	}
	public void setIsCount(String isCount) {
		this.isCount = isCount;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getNumOfEntries() {
		return numOfEntries;
	}
	public void setNumOfEntries(int numOfEntries) {
		this.numOfEntries = numOfEntries;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
}

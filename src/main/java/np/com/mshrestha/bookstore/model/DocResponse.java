package np.com.mshrestha.bookstore.model;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import np.com.mshrestha.bookstore.model.Book;

//@JsonInclude(Include.NON_NULL)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class DocResponse {
	
	private int code;
	private Book book;
	private Error error;
	
	private List<Book> books;
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}	

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}
	
	
	public class Error{		
		private String field;
		private String message;
		
		public String getField() {
			return field;
		}
		public void setField(String field) {
			this.field = field;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
	}


	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}





	

}

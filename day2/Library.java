package week1.day2;

public class Library {
	
	// Prints Book added message and returns book title
	public String addBook(String bookTitle) {
		System.out.println("Book added successfully");
		return bookTitle;
	}

	// Prints Book issued message
	public void issueBook() {
		System.out.println("Book issued successfully");
	}

	public static void main(String[] args) {
		Library obj = new Library();
		obj.addBook("Harry Potter and the Philosopher's Stone");
		obj.issueBook();

	}

}

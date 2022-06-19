package SearchDocument.SearchDocument.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class DocumentDTO {
	
	private String title;
	
	private String author;
	
	private String fileName;
	
	private Float totalWij;

	public DocumentDTO(String title, String author, String fileName, Float totalWij) {
		super();
		this.title = title;
		this.author = author;
		this.fileName = fileName;
		this.totalWij = totalWij;
	}

	public DocumentDTO() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Float getTotalWij() {
		return totalWij;
	}

	public void setTotalWij(Float totalWij) {
		this.totalWij = totalWij;
	}
	
	
	
}

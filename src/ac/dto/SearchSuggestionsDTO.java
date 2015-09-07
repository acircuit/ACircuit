package ac.dto;

public class SearchSuggestionsDTO {
	
	private int id;
	private String word;
	private int hits;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
}

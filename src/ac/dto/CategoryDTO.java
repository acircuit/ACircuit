package ac.dto;

public class CategoryDTO {
	private int advisorId;
    private String category;
    private int catId;
    private String subcategory;
    private int subcatId;
    private String[] skills;
    private SubCategoryDTO sub;
    
	public SubCategoryDTO getSub() {
		return sub;
	}
	public void setSub(SubCategoryDTO sub) {
		this.sub = sub;
	}
	public String[] getSkills() {
		return skills;
	}
	public void setSkills(String[] skills) {
		this.skills = skills;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public int getSubcatId() {
		return subcatId;
	}
	public void setSubcatId(int subcatId) {
		this.subcatId = subcatId;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public int getAdvisorId() {
		return advisorId;
	}
	public void setAdvisorId(int advisorId) {
		this.advisorId = advisorId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}

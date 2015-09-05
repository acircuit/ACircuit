package ac.dto;

import java.io.Serializable;
import java.util.List;

public class AdvisorDTO implements Serializable {
	
	private int id;
	private String name;
	private String gender;
	private String industry;
	private int age;
	private String phoneNo;
	private String email;
	private String city;
	private String languagesKnown;
	private String linkedIn;
	private String intro;
	private String experience;
	private String image;
	private Boolean phone; 
	private Boolean video;
	private List<EducationDTO> education;
	private List<ProfessionalBackgroundDTO> profession;
	private List<CategoryDTO> categories;
	private List<SubCategoryDTO> subCategories;
	
	public List<EducationDTO> getEducation() {
		return education;
	}
	public void setEducation(List<EducationDTO> education) {
		this.education = education;
	}
	public List<ProfessionalBackgroundDTO> getProfession() {
		return profession;
	}
	public void setProfession(List<ProfessionalBackgroundDTO> profession) {
		this.profession = profession;
	}
	public List<CategoryDTO> getCategories() {
		return categories;
	}
	public void setCategories(List<CategoryDTO> categories) {
		this.categories = categories;
	}
	public List<SubCategoryDTO> getSubCategories() {
		return subCategories;
	}
	public void setSubCategories(List<SubCategoryDTO> subCategories) {
		this.subCategories = subCategories;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLanguagesKnown() {
		return languagesKnown;
	}
	public void setLanguagesKnown(String languagesKnown) {
		this.languagesKnown = languagesKnown;
	}
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Boolean getPhone() {
		return phone;
	}
	public void setPhone(Boolean phone) {
		this.phone = phone;
	}
	public Boolean getVideo() {
		return video;
	}
	public void setVideo(Boolean video) {
		this.video = video;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
}
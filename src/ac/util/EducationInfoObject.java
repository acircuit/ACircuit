package ac.util;

import java.util.ArrayList;
import java.util.List;

import ac.dto.EducationDTO;


public class EducationInfoObject {

	public List<EducationDTO> getEducationInfoObject(String[] course, String[] institution,String[] duration,String[] type){
		List<EducationDTO> list = new ArrayList<EducationDTO>();
		try{
			if(course.length > 0 && institution.length > 0 && duration.length >0 && type.length > 0){
				int arrayLength = course.length; 
				for(int i=0 ; i< arrayLength ; i++){
					EducationDTO eduObject = new EducationDTO();
					if(!course[i].equals("") && !institution[i].equals("") && !duration[i].equals("") && !type[i].equals("")){
						eduObject.setCourse(course[i]);
						eduObject.setDuration(duration[i]);
						eduObject.setInstitution(institution[i]);
						eduObject.setType(type[i]);
						list.add(eduObject);
					}
				}		
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}

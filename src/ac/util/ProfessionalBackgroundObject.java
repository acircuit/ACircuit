package ac.util;

import java.util.ArrayList;
import java.util.List;

import ac.dto.ProfessionalBackgroundDTO;


public class ProfessionalBackgroundObject {
	
	public List<ProfessionalBackgroundDTO> getProfessionalBackgroundObject(String[] company, String[] designation,String[] duration,String[] isCurrent ){
		List<ProfessionalBackgroundDTO> list = new ArrayList<ProfessionalBackgroundDTO>();
		try{
			if(company.length > 0 && designation.length > 0 && duration.length >0 && isCurrent.length > 0){
				int arrayLength = company.length; 
				for(int i=0 ; i< arrayLength ; i++){
					ProfessionalBackgroundDTO professionalBackgroundObject = new ProfessionalBackgroundDTO();
					if(!company[i].equals("") && !designation[i].equals("") && !duration[i].equals("")){
						professionalBackgroundObject.setCompany(company[i]);
						professionalBackgroundObject.setDesignation(designation[i]);
						professionalBackgroundObject.setDuration(duration[i]);
						if(isCurrent[i] != null && isCurrent[i].equals("true")){
							professionalBackgroundObject.setIsCurrent(true);

						}else{
							professionalBackgroundObject.setIsCurrent(false);
						}
						list.add(professionalBackgroundObject);
					}
				}		
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	
	}


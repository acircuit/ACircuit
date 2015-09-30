package ac.util;

import java.util.List;

import ac.dao.AdvisorNotificationDAO;

public class SendNotificationToAdvisor extends Thread{

	
	private String comment;
	private String href;
	private List<Integer> list;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public List<Integer> getList() {
		return list;
	}
	public void setList(List<Integer> list) {
		this.list = list;
	}
	public SendNotificationToAdvisor(String comment, String href,
			List<Integer> list) {
		super();
		this.comment = comment;
		this.href = href;
		this.list = list;
	}
	
	public void run() {
		
		
		for(int id :list){
			//Notification for Advisor
				AdvisorNotificationDAO notify = new AdvisorNotificationDAO();
				notify.InsertNotification(comment,String.valueOf(id),href);
		}
	}
}

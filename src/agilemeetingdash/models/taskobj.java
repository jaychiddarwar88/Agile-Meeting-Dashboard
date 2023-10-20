package agilemeetingdash.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class taskobj {
	private String sqlnote ;
	private boolean hasnotes;
	private ArrayList<String> tasklist = new ArrayList<String>();
	
	public ArrayList<String> getTasklist() {
		return tasklist;
	}
	public void setTasklist(ArrayList<String> tasklist) {
		this.tasklist = tasklist;
	}
	public String getSqlnote() {
		return sqlnote;
	}
	public void setSqlnote(String sqlnote) {
		this.sqlnote = sqlnote;
	}
	public boolean isHasnotes() {
		return hasnotes;
	}
	public void setHasnotes(boolean hasnotes) {
		this.hasnotes = hasnotes;
	}
	
	
}

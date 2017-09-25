package ojs.db;

import ojs.domain.db.Submissions;

import java.util.List;

public interface Submission {
	
	int save(Submissions submissions);
	void update(Submissions submission);
	List<Submissions> getSubmissions();

}

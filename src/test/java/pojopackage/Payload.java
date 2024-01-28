package pojopackage;

public class Payload {
	
	String summary;
	String description;
	IssueType issueType;
	Projects project;
	TestJSON tjson;

	public Payload(String summary, String description, IssueType issueType, Projects project, TestJSON tjson) {

		this.project = project;
		this.summary = summary;
		this.description = description;
		this.issueType = issueType;
		this.tjson = tjson;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public IssueType getIssue() {
		return issueType;
	}

	public void setIssue(IssueType issueType) {
		this.issueType = issueType;
	}

	public Projects getProj() {
		return project;
	}

	public void setProj(Projects proj) {
		this.project = proj;
	}

	public TestJSON getTjson() {
		return tjson;
	}

	public void setTjson(TestJSON tjson) {
		this.tjson = tjson;
	}
	
	
}

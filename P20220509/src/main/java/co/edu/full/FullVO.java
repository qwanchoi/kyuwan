package co.edu.full;

/**
 * @author admin
 *
 */
public class FullVO {
    private String title;
    private String startDate;
    private String endDate;
    
    public FullVO() {
    }
    
    public FullVO(String title, String startDate, String endDate) {
	super();
	this.title = title;
	this.startDate = startDate;
	this.endDate = endDate;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    
    @Override
    public String toString() {
	return "fullVO [title=" + title + ", startDate=" + startDate + ", endDate=" + endDate + "]";
    }

    
}

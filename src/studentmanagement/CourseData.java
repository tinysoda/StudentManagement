package studentmanagement;

public class CourseData {
    private String course;
    private String description;
    private String degree;

    public CourseData() {
    }
    public CourseData(String course, String description, String degree) {
        this.course = course;
        this.description = description;
        this.degree = degree;
    }


    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}

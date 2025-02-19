 
package ac.za.subjectservlet;

 
public class Subject {

    private  String subjectname;
 
    private  int level;

    public Subject(String subjectname,int level) {
        this.subjectname = subjectname;
 
        this.level = level;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

 

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    
}

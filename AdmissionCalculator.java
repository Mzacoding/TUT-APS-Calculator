package ac.zaa.admissioncalculator;

import ac.za.subjectservlet.Subject;
import java.util.HashSet;

public class AdmissionCalculator {

    private HashSet<Subject> subjectList;
    private int mathCountor;
    private int englishCountor;
    private int scoreAPS;
    private boolean isMandatorySubjectsAvailable;

    public AdmissionCalculator() {

        this.mathCountor = 0;
        this.englishCountor = 0;
        this.scoreAPS = 0;
    }

    public AdmissionCalculator(HashSet<Subject> subjectList) {
        this.subjectList = subjectList;
        this.scoreAPS = calculateScore();
        this.isMandatorySubjectsAvailable = mandatorySubjects();
    }

    private boolean mandatorySubjects() {

        subjectList.forEach((list) -> {
            if (list.getSubjectname().equalsIgnoreCase("Mathematics")) {
                this.mathCountor++;
            } else if (list.getSubjectname().equalsIgnoreCase("English")) {
                this.englishCountor++;
            }
        });

        return mathCountor > 0 && englishCountor > 0;
    }

    private int calculateScore() {

        int score = 0;
        for (Subject list : subjectList) {

            String subject = list.getSubjectname();

            String languageType = languageType(subject);

            if (languageType.equalsIgnoreCase("Science")) {
                score += list.getLevel() + 5;
            } else if (languageType.equalsIgnoreCase("Language")) {
                score += list.getLevel() + 3;
            } 
        }

        return score;

    }

    private String languageType(String subject) {

        String languageType;

        switch (subject.toLowerCase()) {
            case "english":
            case "siswati":
            case "xitsonga":
            case "isindebele":
            case "setswna":
            case "sesotho":
            case "tshivenda":
            case "isixhosa":
            case "sepedi":
            case "isiszulu":
            case "afrikaans":
                languageType = "Language";
                break;
            case "life sciences":
            case "physical science":
            case "mathematics":
            case "geography":
                languageType = "Science";
                break;
            default:
                languageType = "other";
                break;
        }

        return languageType;

    }

    public String getAdmissionStatus() {

        if (isMandatorySubjectsAvailable && scoreAPS >= 20) {

            return " Your Aps Score is " + scoreAPS + " And you Qualify for Adminssion in the institution ";
        } else if (!isMandatorySubjectsAvailable) {
            return "You  don't Qualify for Adminssion in the institution due to Mandatory Subjects Not Available ";
        }
        return " Your Aps Score is " + scoreAPS + " And you  don't Qualify for Adminssion in the institution ";

    }

}

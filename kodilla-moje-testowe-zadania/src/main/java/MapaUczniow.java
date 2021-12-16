import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

interface Student {

    double Average();
}

class Students {
    String firstName;
    String lastName;
    String studentId;

    public Students(String firstName, String lastName, String studentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
    }
    @Override
    public boolean equals(Object o){
        Students s=(Students)o;
        return (this.firstName == s.firstName) && (this.lastName == s.lastName) && (this.studentId == s.studentId);
    }

    @Override
    public int hashCode(){
        // return Integer.parseInt(studentId.substring(0, 2));
        return Objects.hash(firstName, lastName, studentId);
    }

    public String toString(){
        return firstName + " " + lastName + " (" + studentId + ")";
    }
}

class StudentJournal implements Student {

    Double mathGrade;
    Double bioGrade;
    Double chemGrade;
    Double itGrade;
    Double peGrade;
    Double relGrade;

    public StudentJournal(Double mathGrade, Double bioGrade, Double chemGrade, Double itGrade, Double peGrade, Double relGrade) {
        this.mathGrade = mathGrade;
        this.bioGrade = bioGrade;
        this.chemGrade = chemGrade;
        this.itGrade = itGrade;
        this.peGrade = peGrade;
        this.relGrade = relGrade;
    }

    public String toString() {
        return "Math " + mathGrade + ", Bio " + bioGrade + ", Chem " + chemGrade + ", IT " + itGrade + ", P.E. " + peGrade + ", Rel " + relGrade;
    }

    @Override
    public double Average() {
        return (mathGrade + bioGrade + chemGrade + itGrade + peGrade + relGrade) / 6;
    }

}

class HashMapAndLoopTest {

    public static void main(String[] args) throws java.lang.Exception {

        Students student1 = new Students("Jakub", "Dudek", "1");
        Students student2 = new Students("Adam", "Kaczmarek", "2");
        Students student3 = new Students("Jakub", "Zieliński", "3");
        Students student4 = new Students("Marek", "Mocek", "4");
        Students student5 = new Students("Zenek", "Martyniuk", "5");
        Students student6 = new Students("Stefan", "Omieliańczuk", "6");
        Students student7 = new Students("Dawid", "Makosz", "7");
        Students student8 = new Students("Patrycja", "Zielarek", "8");
        Students student9 = new Students("Natalia", "Marchwińska", "9");
        Students student10 = new Students("Dominika", "Nowak", "10");

        StudentJournal grades1 = new StudentJournal(5.0, 4.0, 3.5, 4.5, 5.0, 2.0);
        StudentJournal grades2 = new StudentJournal(3.0, 4.0, 2.5, 3.5, 3.0, 2.5);
        StudentJournal grades3 = new StudentJournal(5.0, 4.0, 3.5, 4.5, 5.0, 2.5);
        StudentJournal grades4 = new StudentJournal(2.0, 1.5, 3.5, 4.0, 3.0, 5.0);
        StudentJournal grades5 = new StudentJournal(2.0, 5.0, 5.5, 5.5, 4.5, 3.5);
        StudentJournal grades6 = new StudentJournal(3.0, 3.0, 2.5, 3.5, 3.0, 6.0);
        StudentJournal grades7 = new StudentJournal(3.0, 4.0, 3.5, 4.5, 5.0, 4.5);
        StudentJournal grades8 = new StudentJournal(5.0, 4.0, 3.5, 4.5, 5.0, 4.0);
        StudentJournal grades9 = new StudentJournal(6.0, 4.0, 3.0, 4.5, 4.0, 4.0);
        StudentJournal grades10 = new StudentJournal(6.0, 4.5, 2.5, 4.5, 4.5, 5.0);

        HashMap<Students, StudentJournal> studentsGrades = new HashMap<Students, StudentJournal>();

        studentsGrades.put(student1, grades1);
        studentsGrades.put(student2, grades2);
        studentsGrades.put(student3, grades3);
        studentsGrades.put(student4, grades4);
        studentsGrades.put(student4, grades4);
        studentsGrades.put(student5, grades5);
        studentsGrades.put(student6, grades6);
        studentsGrades.put(student7, grades7);
        studentsGrades.put(student8, grades8);
        studentsGrades.put(student9, grades9);
        studentsGrades.put(student10, grades10);


        for(Map.Entry<Students, StudentJournal> entry: studentsGrades.entrySet()) {
            System.out.println("Grades of " + entry.getKey() + " equals " + entry.getValue() + ". Average grade: " + entry.getValue().Average());
        }
    }
}

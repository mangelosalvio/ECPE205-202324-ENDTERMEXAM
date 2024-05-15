import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class EnrolledTableModel extends AbstractTableModel {
    ArrayList<EnrolledCourse> enrolledCourses;

    public EnrolledTableModel() {
        enrolledCourses = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return enrolledCourses.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        String[] columns = new String[]{"Code","Name","Enrollees"};
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        EnrolledCourse enrolledCourse = enrolledCourses.get(rowIndex);
        if ( columnIndex == 0 ) {
            return enrolledCourse.getCourse().getCourseCode();
        } else if ( columnIndex == 1 )  {
            return enrolledCourse.getCourse().getName();
        } else {
            return enrolledCourse.studentsToString();
        }
    }
    public EnrolledCourse getEnrollee(int index) {return enrolledCourses.get(index);}
    public void addEnrollee(EnrolledCourse enrollee){enrolledCourses.add(enrollee);}
}


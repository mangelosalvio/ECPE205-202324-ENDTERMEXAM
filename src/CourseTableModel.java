import javax.swing.table.AbstractTableModel;
import java.sql.Array;
import java.util.ArrayList;

public class CourseTableModel extends AbstractTableModel {

    public ArrayList<Course> list= new ArrayList<>();


    public CourseTableModel() {
        list = new ArrayList<>();
    }

    public void addCourse(Course course) {
        list.add(course);
    }

    public Course getCourse (int index)
    {
        return list.get(index);
    }
    public void removeCourse( int index ) {
        list.remove(index);
    }


    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int column) {
        String[] columns = new String[]{"Course Code","Name"};
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Course course = list.get(rowIndex);
        if ( columnIndex == 0 ) {
            return course.getCourseCode();
        } else {
            return course.getName();
        }
    }
}
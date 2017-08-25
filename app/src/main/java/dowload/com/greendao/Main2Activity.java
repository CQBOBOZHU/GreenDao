package dowload.com.greendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import dowload.com.greendao.gen.StudentBeanDao;
import dowload.com.greendao.gen.TeacherBeanDao;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        studentBeanDao = MyApplication.daoSession.getStudentBeanDao();
        teacherBeanDao = MyApplication.daoSession.getTeacherBeanDao();
    }
    TeacherBeanDao teacherBeanDao;
    StudentBeanDao studentBeanDao;
    public void onAddStudent(View view) {
        StudentBean studentBean = new StudentBean();
        studentBean.setName("王大妈");
        studentBean.setNumber("100001");
        studentBean.set_id((long) 100);
         studentBeanDao = MyApplication.daoSession.getStudentBeanDao();
        studentBeanDao.insert(studentBean);
        TeacherBean teacherBean = new TeacherBean();
        teacherBean.setName("teacher朱");
        teacherBean.setTId((long) 100);
        teacherBean.setId(null);
        teacherBeanDao = MyApplication.daoSession.getTeacherBeanDao();
        teacherBeanDao .insert(teacherBean);
    }

    public void onAddTeacher(View view) {
        StudentBean studentBean = new StudentBean();
        studentBean.setName("王大妈");
        studentBean.setNumber("100001");
        studentBean.set_id((long) 100);
        studentBeanDao = MyApplication.daoSession.getStudentBeanDao();
        studentBeanDao.insert(studentBean);
        TeacherBean teacherBean = new TeacherBean();
        teacherBean.setName("teacher朱");
        teacherBean.setTId((long) 100);
        teacherBean.setId(null);
        teacherBeanDao = MyApplication.daoSession.getTeacherBeanDao();
        teacherBeanDao .insert(teacherBean);
    }

    public void onFindStudent(View view) {
        if (teacherBeanDao==null)
            teacherBeanDao = MyApplication.daoSession.getTeacherBeanDao();
        List<TeacherBean> teacherBeen = teacherBeanDao.loadAll();
        for (TeacherBean bean : teacherBeen) {
            StudentBean student = bean.getStudent();
            if (student!=null){
                Toast.makeText(this, student.getName(), Toast.LENGTH_SHORT).show();
            }else
                Toast.makeText(this, "数据为null", Toast.LENGTH_SHORT).show();
        }
    }

    public void onFindTeacher(View view) {
        if (teacherBeanDao==null)
            teacherBeanDao = MyApplication.daoSession.getTeacherBeanDao();
        List<TeacherBean> teacherBeen = teacherBeanDao.loadAll();
        for (TeacherBean bean : teacherBeen) {
            StudentBean student = bean.getStudent();
            if (student!=null){
                Toast.makeText(this, student.getName(), Toast.LENGTH_SHORT).show();
            }else
                Toast.makeText(this, "数据为null", Toast.LENGTH_SHORT).show();
        }
    }


}

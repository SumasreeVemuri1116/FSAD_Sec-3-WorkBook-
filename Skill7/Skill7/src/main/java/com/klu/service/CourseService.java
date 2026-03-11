
package com.klu.service;

import com.klu.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private List<Course> courseList = new ArrayList<>();

    public Course addCourse(Course course){
        courseList.add(course);
        return course;
    }

    public List<Course> getAllCourses(){
        return courseList;
    }

    public Course getCourseById(int id){
        for(Course c:courseList){
            if(c.getCourseId()==id)
                return c;
        }
        return null;
    }

    public Course updateCourse(int id, Course newCourse){
        for(Course c:courseList){
            if(c.getCourseId()==id){
                c.setTitle(newCourse.getTitle());
                c.setDuration(newCourse.getDuration());
                c.setFee(newCourse.getFee());
                return c;
            }
        }
        return null;
    }

    public boolean deleteCourse(int id){
        return courseList.removeIf(c -> c.getCourseId()==id);
    }

    public List<Course> searchByTitle(String title){
        List<Course> result = new ArrayList<>();
        for(Course c:courseList){
            if(c.getTitle().equalsIgnoreCase(title)){
                result.add(c);
            }
        }
        return result;
    }
}

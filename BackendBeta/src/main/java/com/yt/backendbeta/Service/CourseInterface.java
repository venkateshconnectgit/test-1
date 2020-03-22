package com.yt.backendbeta.Service;


import org.hibernate.SessionFactory;

import com.yt.backendbeta.Entity.Course;

public interface CourseInterface {
    public void addCourse(Course course);
    public int getCourseId(String course);
    public Course getCourseObject(String course);
}

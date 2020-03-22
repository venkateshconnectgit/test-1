package com.yt.backendbeta.Service;

import java.util.List;

import com.yt.backendbeta.Entity.Faculty;

public interface FacultyInterface {

	public void addFaculty(Faculty faculty);
	public Faculty getFacultyId(String facultyId);
	public List<Faculty> getFacultyName(String name);
}

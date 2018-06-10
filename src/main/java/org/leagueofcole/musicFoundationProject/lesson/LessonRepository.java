package org.leagueofcole.musicFoundationProject.lesson;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.leagueofcole.musicFoundationProject.teacher.Teacher;

public interface LessonRepository extends CrudRepository<Lesson , Long > {
	public List<Lesson> findByTeacher(Teacher optional);
}

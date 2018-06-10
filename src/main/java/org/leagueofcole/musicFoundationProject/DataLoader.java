package org.leagueofcole.musicFoundationProject;

import javax.annotation.PostConstruct;

import org.leagueofcole.musicFoundationProject.lesson.LessonRepository;
import org.leagueofcole.musicFoundationProject.role.Role;
import org.leagueofcole.musicFoundationProject.role.RoleRepository;
import org.leagueofcole.musicFoundationProject.rooms.Room;
import org.leagueofcole.musicFoundationProject.rooms.RoomRepository;
import org.leagueofcole.musicFoundationProject.teacher.Teacher;
import org.leagueofcole.musicFoundationProject.teacher.TeacherRepository;
import org.leagueofcole.musicFoundationProject.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataLoader {
	@SuppressWarnings("unused")
	private LessonRepository lessonRepo;
	private RoomRepository roomRepo;
	@SuppressWarnings("unused")
	private TeacherRepository teacherRepo;
	private TeacherService teacherService;
	
	private RoleRepository roleRepository;
	

	@Autowired
	public DataLoader(LessonRepository lessonRepo, RoomRepository roomRepo, TeacherRepository teacherRepo, TeacherService teacherService, RoleRepository roleRepository) {
		super();
		this.lessonRepo = lessonRepo;
		this.roomRepo = roomRepo;
		this.teacherRepo = teacherRepo;
		this.teacherService = teacherService;
		this.roleRepository = roleRepository;
	}

	@PostConstruct
	private void loadData() {
		teacherService.save(new Teacher("Ian","12345", "12345"));
		//lessonRepo.save(new Lesson(new Teacher("Ian","12345"), new Date(), new Time()));
		Room a = new Room("A", "General");
		roomRepo.save(a);
		roleRepository.save(new Role("ADMIN"));
		roleRepository.save(new Role("TEACHER"));
		//		Teacher t = new Teacher("wow", "pwd");
//		teacherRepo.save(t);
		//lessonRepo.save(new Lesson(t, new Date(), new Time(new Date().getTime()), new Time(new Date().getTime() + (1000 * 60 * 30)), a, 1));
	}
}

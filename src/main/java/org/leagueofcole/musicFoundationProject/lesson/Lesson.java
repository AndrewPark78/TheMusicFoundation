package org.leagueofcole.musicFoundationProject.lesson;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.leagueofcole.musicFoundationProject.rooms.Room;
import org.leagueofcole.musicFoundationProject.teacher.Teacher;

@Entity
public class Lesson {
	@Id
	@GeneratedValue
	private Long id;
	@OneToOne
	private Teacher teacher;
	private long date;
	private long duration;
	
	@ManyToOne
	private Room room;
	private int numStudents;
	private String type;

	public Lesson(Teacher teacher, long date, long duration, Room room, int numStudents, String type) {
		this.teacher = teacher;
		this.date = date;
		this.duration = duration;
		this.room = room;
		this.numStudents = numStudents;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public Long getId() {
		return id;
	}


	public Teacher getTeacher() {
		return teacher;
	}

	public long getDate() {
		return date;
	}
	
	public String getStringDate() {
		return new Date(date).toString();
	}


	public long getDuration() {
		return duration;
	}


	public Room getRoom() {
		return room;
	}


	public int getNumStudents() {
		return numStudents;
	}


	Lesson(){
		
	}
}

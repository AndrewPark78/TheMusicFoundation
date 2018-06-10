package org.leagueofcole.musicFoundationProject.service;

import java.util.HashSet;
import java.util.Set;

import org.leagueofcole.musicFoundationProject.role.Role;
import org.leagueofcole.musicFoundationProject.teacher.Teacher;
import org.leagueofcole.musicFoundationProject.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TeacherDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Teacher teacher = teacherRepository.findByUserName(userName);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (Role role : teacher.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return new org.springframework.security.core.userdetails.User(teacher.getUserName(), teacher.getPassword(),
				grantedAuthorities);
	}

}
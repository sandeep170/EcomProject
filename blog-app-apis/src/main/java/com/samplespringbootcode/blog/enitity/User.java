package com.samplespringbootcode.blog.enitity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "user_name", nullable = false, length = 100)
	private String name ;
	
	@Column(name = "user_email", length = 100)
	private String email;
	@Column(name = "user_password", length = 100)
	private String password;
	@Lob
	@Column(name = "about")
	private String about;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Post> posts =new ArrayList<>();

}

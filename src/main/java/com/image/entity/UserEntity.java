package com.image.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_detail")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;

	@Column(name = "user_name")
	private String name;
	@Column(unique = true, name = "user_email")
	private String email;

	@Column(name = "user_password")
	private Long password;

	@Size(min = 1, max = 15)
	@Column(name = "user_phone")
	private Long phoneNo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "image_no", referencedColumnName = "user_id")
	private UserImage userImage;

}

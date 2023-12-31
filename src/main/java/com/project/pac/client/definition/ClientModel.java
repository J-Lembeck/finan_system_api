package com.project.pac.client.definition;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "clientes", schema = "public")
public class ClientModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_client")
	private Long id;

	@Column(name = "id_user")
	private Long idUser;

	@Column(name = "cnpj")
	private String cnpj;

	@Column(name = "name")
	private String name;

	@Column(name = "phone")
	private String phone;
}

package com.sqlite.repository;

import com.sqlite.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class Repository {

	private NamedParameterJdbcTemplate jdbcTemplate;


	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}



	public void insertList(List<User> listUser) {
		String sql = "insert into User (firstName, lastName) VALUES (:firstName, :lastName)";

		SqlParameterSource[] params = new SqlParameterSource[listUser.size()];

		int i = 0;

		for (User user : listUser) {
			MapSqlParameterSource p = new MapSqlParameterSource();
			p.addValue("firstName", user.getFirstName());
			p.addValue("lastName", user.getLastName());
			params[i] = p;
			i++;
		}

		jdbcTemplate.batchUpdate(sql, params);
	}

}

package com.example.helloworld.database;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface ManagerDAO {
	@SqlUpdate("create table if not exists Managers (id int default not null auto_increment primary key, name varchar(255), email varchar(255), password varchar(255));")
	void createManagerTable();

	@SqlUpdate("insert into Managers (name,email,password) values (:name,:email,:password)")
	void insert(@BindBean Manager manager);

	@SqlUpdate("select * from Managers;")
	List<Manager> getAll();

	@SqlQuery("select * from Managers where id = :id")
	Manager findById(@Bind("id") int id);

	@SqlUpdate("update Managers set name= u.name, email=u.email, password=u.password where id = :id")
	void update(@BindBean("u") Manager manager, @Bind("id") int id);

	@SqlUpdate("delete from Managers where id = :it")
	void deleteById(@Bind int id);

	@SqlUpdate("delete from Managers where email = :it")
	void deleteByEmail(@Bind String email);

}

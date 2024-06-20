1. positional parameters[?] (insert,search)
2. NamedParameterJdbcTemplate
	2.1. By Using Map directly. (update)
	2.2. By using SqlParameterSource interface.(delete)


==========================================
1.

In Spring JDBC Applications, we will use positional parameters[?] also in sql queries which we are
providing along with JdbcTemplate class provided query execution methods.
If we provide positional parameters in sql queries then JdbcTemplate class will use
"PreparedStatement" internally to execute sql query instead of Statement.
To provide values to the Positional parameters in SQL Queries we have to use Object[] with
values as parametyer to all JdbcTemplate class provided query execution methods.
public int update(String query, Object[] param_Values)
public int queryForInt(String query, Object[] param_Values)
public long queryForLong(String query, Object[] param_Values)
public Object queryForObject(String query, Object[] param_Values, RowMapper rm)
-----
-----
-----
Ex:
String query = "insert into student values(?,?,?)";
int rowCount = jdbcTemplate.update(query, new Object[]{"S-111", "AAA", "Hyd"});

=======================================================
2.

NamedParameterJdbcTemplate class is same as JdbcTemplate class , but,
NamedParameterJdbcTemplate class is able to define and run sql queries with Named
Parameters instead of positional parameters.
EX:
String query = "insert into student values(:sid, :sname, :saddr)";
Where :sid, :sname, :saddr are named parameters for which we have to provide values.
In case of NamedParameterJdbcTemplate , we are able to provide values to the named
parameters in the following two approaches.
1.By Using Map directly.
2.By using SqlParameterSource interface.
-----------------------------------------------
2.1 By Using Map directly.


String query = "insert into student values(:sid, :sname, :saddr)";
Map map = new HashMap();
map.put("sid", "S-111");
map.put("sname", "AAA");
map.put("saddr", "Hyd");
namedParameterJdbcTemplate.update(query, map);

----------------------------------------------------------
2.2 By using SqlParameterSource interface.

To provide values to the Named parameters Spring has provided the following two implementation
classes for SqlParameterSoure interface.
 2.2.a)MapSqlParameterSource
 2.2.b)BeanPropertySqlParameterSource
 
2.2.a) MapSqlParameterSource
To provide values to the named parameters if we want to use MapSqlParameterSource then first
we have to create object for MapSqlParameterSource and we have to use the following method to
add values to the named parameters.
public MapSqlParameterSource addValue(String name, Object val)
EX:
String query = "insert into student values(:sid, :sname, :saddr)";
SqlParameterSource param_Source = new MapSqlParameterSource("sid", "S-111");
param_Source = param_Source.addValue("sname", "AAA");
param_Source = param_Source.addValue("saddr", "Hyd");
namedParameterJdbcTemplate.update(query, param_Source);

2.2.b) BeanPropertySqlParameterSource

To provide values to the named parameters if we want to use BeanPropertySqlParameterSource
then first we have to create bean object with data then we have to create Object for
BeanPropertySqlParameterSource with the generated Bean reference then provide
BeanPropertySqlParameterSource object to query methods.
EX:
String query = "insert into student values(:sid, :sname, :saddr)";
Student std = new Student();
std.setSid("S-111");
std.setSname("AAA");
std.setSaddr("Hyd");
SqlParameterSource param_Source = new BeanPropertySqlParameterSource(std );
namedParameterJdbcTemplate.update(query, param_Source);
Note: JdbcTemplate is allowing DataSource object injection through setter method, but,
NamedParameterJdbcTemplate class is allowing DataSource object injection through Constructor
Dependency Injection.


JDBC TEMPLATE


JdbcTemplate class is providing basic environment to interact with Database like Loading Driver
class, Getting Connection between Java application and DB, Creating Statement ,
PreparedStatement and CallableStatement and closing the connection with the help of the
provided Datasource and JdbcTemplate class has provided the following methods to execute SQL
Queries.
1)For Non Select sql queries and DML SQL queries
 public int update(String query)
2)For DDL Sql Queries
 public void execute(String query)
3)For Select sql queries
 public int queryForInt(String query)
 public int queryForLong(String query)
 public String queryForString(String query)
 public Object queryForObject(String query)
 public List query(String query)
 public List queryForList(String query)
 public Map queryForMap(String query)
 public RowSet queryForRowSet(String query)
While performing retrival operations to convert data from ResultSet object[records] to Bean
objects Spring Framework has provided a predefined interface in the form of
"org.springframework.jdbc.core.RowMapper" which contains the following method .
public Object mapRow(ResultSet rs, int rowCount)
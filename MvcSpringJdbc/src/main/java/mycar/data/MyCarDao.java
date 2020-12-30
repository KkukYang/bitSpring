package mycar.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class MyCarDao extends JdbcDaoSupport {

	class CarMapper implements RowMapper<MyCarDto> {

		@Override
		public MyCarDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			MyCarDto dto = new MyCarDto();
			dto.setNum(rs.getString("num"));
			dto.setCarname(rs.getString("carname"));
			dto.setCarcolor(rs.getString("carcolor"));
			dto.setCarprice(rs.getInt("carprice"));
			dto.setCarguip(rs.getString("carguip"));

			return dto;
		}
	}

	public List<MyCarDto> getAllDatas() {
		String sql = "select * from mycar order by num asc";
		List<MyCarDto> list = getJdbcTemplate().query(sql, new CarMapper());

		return list;
	}

	public void insertCar(MyCarDto dto) {
		String sql = "insert into mycar(carname, carcolor,carprice,carguip) " + " values (?,?,?,?)";
		getJdbcTemplate().update(sql,
				new Object[] { dto.getCarname(), dto.getCarcolor(), dto.getCarprice(), dto.getCarguip() });
	}

	public MyCarDto getData(String num) {
		MyCarDto dto = null;
		String sql = "select * from mycar where num=?";
		dto = getJdbcTemplate().queryForObject(sql, new Object[] { num }, new CarMapper());

		return dto;
	}

	public void updateCar(MyCarDto dto) {
		String sql = "update mycar set carname=?, carcolor=?, carprice=?, carguip=? where num=?";
		getJdbcTemplate().update(sql, new Object[] { dto.getCarname(), dto.getCarcolor(), dto.getCarprice(),
				dto.getCarguip(), dto.getNum() });
	}

	public void deleteCar(String num) {
		String sql = "delete from mycar where num=?";
		getJdbcTemplate().update(sql, new Object[] { num });
	}

}

package com.springexample.jdbc.dao;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JdbcVehicleDao implements VehicleDao {
	
	private JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	} 
	
    public void insert(Vehicle vehicle) {
        String sql = "INSERT INTO VEHICLE (VEHICLE_NO, COLOR, WHEEL, SEAT) " + "VALUES (:vehicleNo, :color, :wheel, :seat)";
       // SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(vehicle);
        template.update(sql, new Object[] {vehicle.getVehicleNo(),vehicle.getColor(),vehicle.getWheel(),vehicle.getSeat()});
      //  getSimpleJdbcTemplate().update(sql, parameterSource);
    }
    
    public void insertBatch(List<Vehicle> vehicleList) {
    	String sql = "INSERT INTO VEHICLE (VEHICLE_NO, COLOR, WHEEL, SEAT) " + "VALUES (:vehicleNo, :color, :wheel, :seat)";
    	
    	template.batchUpdate(sql, new BatchPreparedStatementSetter() {

    	    @Override
    	    public void setValues(PreparedStatement ps, int i) throws SQLException {
    	    	Vehicle vehicle = vehicleList.get(i);
    	    	ps.setString(1, vehicle.getVehicleNo());
    	    	ps.setString(2, vehicle.getColor());
    	    	ps.setInt(3,vehicle.getWheel());
    	    	ps.setInt(4,vehicle.getSeat());
    	    }

    	    @Override
    	    public int getBatchSize() {
    	        return vehicleList.size();
    	    }
    	  });
    }

                                                                                       
    public Vehicle findByVehicleNo(String vehicleNo) {
        String sql = "SELECT * FROM VEHICLE WHERE VEHICLE_NO = ?";

        BeanPropertyRowMapper<Vehicle> vehicleRowMapper = BeanPropertyRowMapper.newInstance(Vehicle.class);

        Vehicle vehicle = template.queryForObject(sql, vehicleRowMapper, vehicleNo);

        return vehicle;
    }

    public void update(Vehicle vehicle) {
        String sql = "UPDATE VEHICLE SET COLOR = :color, WHEEL = :wheel, SEAT=:seat WHERE VEHICLE_NO=:vehicleNo";
       // SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(vehicle);
        //template.update(sql, parameterSource);
        template.update(sql, new Object[] {vehicle.getColor(),vehicle.getWheel(),vehicle.getSeat(), vehicle.getVehicleNo()});
    }

    public void delete(Vehicle vehicle) {
    	if(vehicle==null) return;
//        Map<String, Object> args = new HashMap<String, Object>();
//        args.put("vehicleNo", vehicle.getVehicleNo());

        String sql = "DELETE FROM VEHICLE WHERE VEHICLE_NO = :vehicleNo";
        template.update(sql, new Object[] {vehicle.getVehicleNo()});
    }

    public List<Vehicle> findAll() {
        String sql = "SELECT * FROM VEHICLE";
        RowMapper<Vehicle> rm = ParameterizedBeanPropertyRowMapper.newInstance(Vehicle.class);
        List<Vehicle> vehicles = template.query(sql, rm);

        return vehicles;
    }

    public String getColor(String vehicleNo) {
        String sql = "SELECT COLOR FROM VEHICLE WHERE VEHICLE_NO = ?";

        String color = template.queryForObject(sql, String.class, vehicleNo);

        return color;
    }

    public int countAll() {
        String sql = "SELECT COUNT(*) FROM VEHICLE";

        //int count = template.queryForInt(sql);
        int count=template.queryForObject(sql, Integer.class);
        return count;
    }
}

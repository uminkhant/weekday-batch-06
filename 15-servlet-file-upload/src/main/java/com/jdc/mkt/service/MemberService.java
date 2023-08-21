package com.jdc.mkt.service;

import com.jdc.mkt.entity.Member;
import static com.jdc.mkt.service.MySqlConnection.getConnection;

public class MemberService {

	public void saveMember(Member m) {
		String sql = "insert into member (name,loginId,password,role,email,image) values (?,?,?,?,?,?)";
		try(var con = getConnection();
				var stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, m.getName());
			stmt.setString(2, m.getLoginId());
			stmt.setString(3, m.getPassword());
			stmt.setString(4, m.getRole().name());
			stmt.setString(5, m.getEmail());
			stmt.setString(6, m.getImage());
			
			stmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package vn.iostar.models;

import java.io.Serializable;
import java.sql.Date;

public class UserModel {
	@SuppressWarnings("serial")
	public class User implements Serializable {
	private int id;
	private String email;
	private String userName;
	private String fullName;
	private String passWord;
	private String avatar;
	private int roleid;
	private String phone;
	private Date createdDate;
}

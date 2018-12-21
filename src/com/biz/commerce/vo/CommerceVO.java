package com.biz.commerce.vo;

public class CommerceVO {
	
	private String strDate;
	private String strIO;
	private String strName;
	private String strCode;
	private int intDan;
	private int intQuan;
	private int intIprice;
	private int intOprice;
	
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}

	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	public String getStrIO() {
		return strIO;
	}
	public void setStrIO(String strIO) {
		this.strIO = strIO;
	}
	
	public String getStrCode() {
		return strCode;
	}
	public void setStrCode(String strCode) {
		this.strCode = strCode;
	}
	public int getIntDan() {
		return intDan;
	}
	public void setIntDan(int intDan) {
		this.intDan = intDan;
	}
	public int getIntQuan() {
		return intQuan;
	}
	public void setIntQuan(int intQuan) {
		this.intQuan = intQuan;
	}
	public int getIntIprice() {
		return intIprice;
	}
	public void setIntIprice(int intIprice) {
		this.intIprice = intIprice;
	}
	public int getIntOprice() {
		return intOprice;
	}
	public void setIntOprice(int intOprice) {
		this.intOprice = intOprice;
	}
	@Override
	public String toString() {
		return "CommerceVO [strDate=" + strDate + ", strIO=" + strIO + ", strName=" + strName + ", strCode=" + strCode
				+ ", intDan=" + intDan + ", intQuan=" + intQuan + ", intIprice=" + intIprice + ", intOprice="
				+ intOprice + "]";
	}
	
	
	
	
}

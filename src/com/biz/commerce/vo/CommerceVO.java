package com.biz.commerce.vo;

/*
 * 데이터를 읽어서 List를 만들 때
 * 사용할 데이터클래스(VO)선언
 */
public class CommerceVO {
	/*
	 * 거래일자:상품코드:거래구분:단가:수량 형식의
	 * 데이터를 읽어서 각 Member 변수에 저장
	 * 
	 * 각 Member 변수는 정보은닉과 캡슐화를 하기 위해
	 * private으로 선언한다.
	 */
	private String strDate; // 거래일자
	private String strIO;   // 거래구분
	private String strName; // 상품명
	private String strCode; // 상품코드
	private int intDan;     // 단가
	private int intQuan;    // 수량
	private int intIprice;	// 매입금액
	private int intOprice;	// 매출금액
	
	/*
	 * private으로 선언된 member 변수에
	 * 접근(저장, 읽기)를 수행할 getter, setter 선언
	 */
	
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
	
	/*
	 * VO에 데이터를 저장한 후
	 * 데이터를 확인하는 디버깅용 메서드를 재정의 한다.
	 */
	@Override
	public String toString() {
		return "CommerceVO [strDate=" + strDate + ", strIO=" + strIO + ", strName=" + strName + ", strCode=" + strCode
				+ ", intDan=" + intDan + ", intQuan=" + intQuan + ", intIprice=" + intIprice + ", intOprice="
				+ intOprice + "]";
	}
	
	
	
	
}

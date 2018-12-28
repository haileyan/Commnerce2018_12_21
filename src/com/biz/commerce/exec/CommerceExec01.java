package com.biz.commerce.exec;

import com.biz.commerce.service.CommerceService;
/*
 * 지금부터 CommExec01이라는 클래스를 시작한다
 */
public class CommerceExec01 {

	/*
	 * 만약 JVM에서 이 프로젝트를 실행할 때,
	 * CommExec01클래스에서 진입점 메서드를 호출 할 텐데 네가 응답하렴
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Service클래스를 객체로 선언하여 매입매출 업무를 수행할 준비
		 */
		CommerceService cs = new CommerceService();
		
		// 매입매출정보.txt를 읽어서 ioList에 저장하는 메서드 호출(실행)
		cs.readFileInout();
		
		// 상품정보.txt를 읽어서 cList에 저장하는 메서드 호출(실행)
		cs.readFilePInfo();
		
		// 두개의 리스트에 담긴 코드를 맞춰서 일치시키고 해당 상품명을 찾고, 매입/매출을 구분하여 변수에 저장하는 
		// 메서드 호출(실행)
		cs.checkCode();
		
		// 저장된 데이터를 바탕으로 파일을 생성하는 메서드 호출(생성)
		cs.printFile();
	}

}

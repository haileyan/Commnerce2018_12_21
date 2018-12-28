package com.biz.commerce.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.biz.commerce.vo.CommerceVO;
/*
 * 매입매출 관련 처리를 위한 클래스를 선언
 */
public class CommerceService {
	/*
	 * 각 데이터를 관리할 List변수들 선언
	 */
	List<CommerceVO> ioList;  // 매입매출데이터 테이블
	List<CommerceVO> cList;   // 상품정보 테이블
	String strFile;  		  // 매입매출정보 파일
	
	/*
	 *IoService 클래스로 객체를 생성할 때 호출되는 생성자를 선언 
	 *
	 *이 클래스는 Text파일을 읽어서 매입매출관련 업무를 수행할 것이므로
	 *생성자에서는 Text파일의 경로정보를 매개변수로 받아서 변수에 저장하는 코드를 수행한다.
	 */
	public CommerceService() {
		// 매입매출정보의 list를 담을 iolist를 초기화한다
		ioList = new ArrayList();
		
		//  상품정보의 list를 담을 cList를 초기화한다.
		cList = new ArrayList();
		
		// 매입매출정보 파일을 생성할 위치 설정(초기화)
		strFile = "src/com/biz/commerce/";
	}
	
	
	// 매입매출데이터 파일을 읽어서 분해하여 ioList에 저장하는 메소드
	public void readFileInout() {
		
		// FileReader를 이용하여 읽을 파일을 담은 변수 선언(매입매출데이터)
		String strFileName1 = "src/com/biz/commerce/매입매출데이터.txt";
		
		// Text 파일을 읽기 위한 FileReader 객체 선언
		FileReader fr;
		
		// FileReader로 읽은 내용에서 문자열을 쉽게 추출할수 있도록 연결되는 Buffer 객체 선언
		BufferedReader buffer;
		
		/*
		 * 생성자에서 값이 할당된 strFileName1의 내용을 참조하여 파일을 읽기 위하여 open하는 코드
		 * 
		 * 이 코드는 작동되는 과정에서 불가항력적인 문제가 발생할 소지가 있으므로 
		 * 반드시 try..catch문으로 감싸 주어야 한다.
		 */
		try {
			fr = new FileReader(strFileName1);
			/*
			 * FileReader로 open된 파일 정보를 Buffer에 연결하여 준다. 
			 * 이 코드가 실행되면 BufferedReader는 일단 파일을 읽어서 메모리의 Buffer영역에 저장해 둔다.
			 */
			buffer = new BufferedReader(fr);
			
			// 무한반복문을 이용해서 Buffer에 저장된 파일내용에서 한줄씩 (문자열로)읽어서 처리한다.
			while(true) {
				// buffer에서 한줄을 읽어서 read변수에 저장
				String read = buffer.readLine();
				// 만약 reader에 저장된 값이 null이면 모든 문자열을 다 읽었다는 것이므로 반복문을 종료한다.
				if(read == null) break;
				
				/*
				 * read 문자열을 콜론(:)으로 분리해서 CommerceVO에 담고 ioList에 추가하는 부분
				 */
				
				// String.split() 메서드를 사용해서 문자열 분해하고, r 문자열 배열에 저장
				String[] r = read.split(":");
				
				// 새로운 c 를 생성(선언과 초기화)
				CommerceVO c = new CommerceVO();
				
				// c의 각 member변수에 값을 저장(할당)				
				c.setStrDate(r[0]);
				c.setStrCode(r[1]);
				c.setStrIO(r[2]);
				
				// c.intDan는 int형 변수이므로 문자열을 int로 먼저 변환한다.
				c.setIntDan(Integer.valueOf(r[3]));
				c.setIntQuan(Integer.valueOf(r[4]));
				
				// member변수가 setting된 c를 ioList에 추가
				ioList.add(c);
			} 
			// 파일을 모두 사용(읽기)했으므로 안전하게 닫아 준다
			buffer.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// 상품정보 파일을 읽어서 분해하여 cList에 저장하는 메소드
	public void readFilePInfo() {
		
		// FileReader를 이용하여 읽을 파일을 담은 변수 선언(상품정보)
		String strFileName2 = "src/com/biz/commerce/상품정보.txt";
		
		// Text 파일을 읽기 위한 FileReader 객체 선언
		FileReader fr;
		// FileReader로 읽은 내용에서 문자열을 쉽게 추출할수 있도록 연결되는 Buffer 객체 선언
		BufferedReader buffer;
		
		/*
		 * 생성자에서 값이 할당된 strFileName2의 내용을 참조하여 파일을 읽기 위하여 open하는 코드
		 * 
		 * 이 코드는 작동되는 과정에서 불가항력적인 문제가 발생할 소지가 있으므로 
		 * 반드시 try..catch문으로 감싸 주어야 한다.
		 */
		try {
			fr = new FileReader(strFileName2);
			/*
			 * FileReader로 open된 파일 정보를 Buffer에 연결하여 준다. 
			 * 이 코드가 실행되면 BufferedReader는 일단 파일을 읽어서 메모리의 Buffer영역에 저장해 둔다.
			 */
			buffer = new BufferedReader(fr);
			// 무한반복문을 이용해서 Buffer에 저장된 파일내용에서 한줄씩 (문자열로)읽어서 처리한다.
			while(true) {
				// buffer에서 한줄을 읽어서 read변수에 저장
				String read = buffer.readLine();
				
				// 만약 reader에 저장된 값이 null이면 모든 문자열을 다 읽었다는 것이므로 반복문을 종료한다.
				if(read == null) break;
				
				/*
				 * read 문자열을 콜론(:)으로 분리해서 CommerceVO에 담고 cList에 추가하는 부분
				 */
				
				// String.split() 메서드를 사용해서 문자열 분해하고, r 문자열 배열에 저장
				String[] r = read.split(":");
				// 새로운 c 를 생성(선언과 초기화)
				CommerceVO c = new CommerceVO();
				
				// c의 각 member변수에 값을 저장(할당)		
				c.setStrCode(r[0]);
				c.setStrName(r[1]);
				// c.intDan는 int형 변수이므로 문자열을 int로 먼저 변환한다.
				c.setIntIprice(Integer.valueOf(r[3]));
				c.setIntOprice(Integer.valueOf(r[4]));
				
				// member변수가 setting된 c를 cList에 추가
				cList.add(c);
			}
			// 파일을 모두 사용(읽기)했으므로 안전하게 닫아 준다
			buffer.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	// 매입매출데이터 정보가 담긴 ioList와 상품정보 정보가 담긴 cList에서 동일한 상품코드를 찾아서
	// 매치 시킨후, 해당하는 상품명을 찾아 변수에 저장하고, 매출과 매입을 구분하여 변수에 저장하는 메서드
	public void checkCode() {
		
		// 최종적으로 매입매출데이터에 통합하기 위해 ioList를 먼저 for문에 담아준다.
		// ioList에 담긴 변수를 사용하기 위해서 io 변수를 선언하고 전체 데이터 값을 읽기 위해 for문에 담는다
		for(CommerceVO io: ioList) {
			// 상품정보가 담긴 cList를 사용하기 위해서 c 변수를 선언하고 데이터 값을 읽기 위해 for문에 담는다
			for(CommerceVO c : cList) {
				// cList에 담긴 상품코드와 ioList에 담긴 상품코드가 일치하고, "1"이면(=매입 데이터일 경우)
				if(c.getStrCode().equals(io.getStrCode()) && io.getStrIO().equals("1")) {
					// 상품코드에 해당하는 상품명을 상품명변수에 저장
					io.setStrName(c.getStrName());
					
					io.setStrIO("매입");
					
					// 매입가격은 매입가*수량으로 계산하여 저장
					io.setIntIprice(io.getIntDan()*io.getIntQuan());
					
					// 매입데이터에 해당하기 때문에 매출가는 O으로 저장
					io.setIntOprice(0);
					
				// cList에 담긴 상품코드와 ioList에 담긴 상품코드가 일치하고, "2"이면(=매출 데이터일 경우)
				} else if(c.getStrCode().equals(io.getStrCode()) && io.getStrIO().equals("2")) {
					// 상품코드에 해당하는 상품명을 상품명변수에 저장
					io.setStrName(c.getStrName());
					
					io.setStrIO("매출");
					
					// 매출데이터에 해당하기 때문에 매입가는 O으로 저장
					io.setIntIprice(0);
					
					// 매출가격은 매출가*수량으로 계산하여 저장
					io.setIntOprice(io.getIntDan()*io.getIntQuan());
				}
			}
		}
	}
	
	// 저장한 데이터를 바탕으로 매입매출정보가 담긴 파일을 생성하는 메서드
	public void printFile() {
		
		// 저장한 파일을 읽기 위해서 FileWriter 변수 선언
		FileWriter fw;
		
		// 읽어들인 내용을 바탕으로 정보를 파일에 기록하기 위해서 PrintWriter 변수선언
		PrintWriter pw;
		
		/*	 
		 * 이 코드는 작동되는 과정에서 불가항력적인 문제가 발생할 소지가 있으므로 
		 * 반드시 try..catch문으로 감싸 주어야 한다.
		 */
		try {
			// strFile변수에 저장된 주소에 파일명을 더해 파일 생성
			fw = new FileWriter(strFile + "매입매출정보.txt");
			// fw로 읽어들인 정보로 파일을 생성하기 위해 연결
			pw = new PrintWriter(fw);
		
			// 전체 데이터가 담긴 ioList를 읽어 파일 생성 
			for(CommerceVO c : ioList) {
				pw.print(c.getStrDate() + ":"); // 거래일자
				pw.print(c.getStrIO() + ":");	// 매입매출구분
				pw.print(c.getStrCode() + ":");	// 상품코드
				pw.print(c.getStrName() + ":");	// 상품명
				pw.print(c.getIntDan() + ":");  // 매입or매출단가
				pw.print(c.getIntQuan() + ":"); // 수량
				pw.print(c.getIntIprice() + ":"); // 매입금액
				pw.println(c.getIntOprice()); 	  // 매출금액
			}
			// 파일을 모두 기록 했으므로 안전하게 닫아 준다
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 파일이 생성되었음을 가시적으로 확인하기 위해서 콘솔에 'saved!'를 표시한다.
		System.out.println("SAVED!");
		
		
	}
	
}

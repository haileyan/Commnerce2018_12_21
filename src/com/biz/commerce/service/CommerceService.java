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

public class CommerceService {

	List<CommerceVO> ioList;  // 매입매출데이터
	List<CommerceVO> cList;   // 상품정보
	String strFile;
	
	public CommerceService() {
		ioList = new ArrayList();
		cList = new ArrayList();
		strFile = "src/com/biz/commerce/";
	}
	
	public void readFileInout() {
		
		String strFileName1 = "src/com/biz/commerce/매입매출데이터.txt";
		
		FileReader fr;
		BufferedReader buffer;
		
		try {
			fr = new FileReader(strFileName1);
			buffer = new BufferedReader(fr);
			while(true) {
				String read = buffer.readLine();
				if(read == null) break;
				String[] r = read.split(":");
				CommerceVO c = new CommerceVO();
				c.setStrDate(r[0]);
				c.setStrCode(r[1]);
				c.setStrIO(r[2]);
				c.setIntDan(Integer.valueOf(r[3]));
				c.setIntQuan(Integer.valueOf(r[4]));
				ioList.add(c);
			}
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
	
	public void readFilePInfo() {
		
		String strFileName2 = "src/com/biz/commerce/상품정보.txt";
		
		FileReader fr;
		BufferedReader buffer;
		
		try {
			fr = new FileReader(strFileName2);
			buffer = new BufferedReader(fr);
			while(true) {
				String read = buffer.readLine();
				if(read == null) break;
				String[] r = read.split(":");
				CommerceVO c = new CommerceVO();
				c.setStrCode(r[0]);
				c.setStrName(r[1]);
				c.setIntIprice(Integer.valueOf(r[3]));
				c.setIntOprice(Integer.valueOf(r[4]));
				cList.add(c);
			}
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
	
	public void checkCode() {
		for(CommerceVO io: ioList) {
			for(CommerceVO c : cList) {
				if(c.getStrCode().equals(io.getStrCode()) && io.getStrIO().equals("1")) {
					io.setStrName(c.getStrName());
					io.setStrIO("매입");
					io.setIntIprice(c.getIntIprice());
					io.setIntOprice(0);
				} else if(c.getStrCode().equals(io.getStrCode()) && io.getStrIO().equals("2")) {
					io.setStrName(c.getStrName());
					io.setStrIO("매출");
					io.setIntIprice(0);
					io.setIntOprice(c.getIntOprice());
				}
			}
		}
	}
	
	public void printFile() {
		
		FileWriter fw;
		PrintWriter pw;
		
		try {
			fw = new FileWriter(strFile + "매입매출정보.txt");
			pw = new PrintWriter(fw);
		
			for(CommerceVO c : ioList) {
				pw.print(c.getStrDate() + ":");
				pw.print(c.getStrIO() + ":");
				pw.print(c.getStrCode() + ":");
				pw.print(c.getStrName() + ":");
				pw.print(c.getIntDan() + ":");
				pw.print(c.getIntQuan() + ":");
				pw.print(c.getIntIprice() + ":");
				pw.println(c.getIntOprice());
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("SAVED!");
		
		
	}
	
}

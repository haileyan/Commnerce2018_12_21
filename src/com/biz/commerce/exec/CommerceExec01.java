package com.biz.commerce.exec;

import com.biz.commerce.service.CommerceService;

public class CommerceExec01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommerceService cs = new CommerceService();
		cs.readFileInout();
		cs.readFilePInfo();
		cs.checkCode();
		cs.printFile();
	}

}

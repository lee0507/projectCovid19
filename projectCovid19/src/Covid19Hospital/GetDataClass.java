package Covid19Hospital;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class GetDataClass {
	
	// 국민안심병원, 임시진료소 데이터 받아오기
	public String[][] getDataHospital(String filename) throws IOException {
		ArrayList<String> cHospital = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader(filename));

		String line;
		int cnt = 0;
		while((line = reader.readLine()) != null) {
			if(cnt >= 3) { // 맨 앞 3줄은 필요없는 데이터
				cHospital.add(line);
			}
			cnt++;
		}
		
		String[][] cHosp = new String[cHospital.size()][];
		for(int i = 0; i < cHospital.size(); i++) {
			cHosp[i] = cHospital.get(i).split(",");
		}
		
		return cHosp;
	}
	
	// 선별진료소 데이터 받기
	public String[][] getDataCCS(String filename) throws IOException {
		ArrayList<String> CCS = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader(filename));

		String line;
		int cnt = 0;
		while((line = reader.readLine()) != null) {
			if(cnt > 2) { // 맨 앞 1줄은 필요없는 데이터
				CCS.add(line);
			}
			cnt++;
		}
		
		String[][] ccs = new String[CCS.size()][]; // 코로나 선별검사소. covid-19 checkup station 의 약자
		for(int i = 0; i < CCS.size(); i++) {
			ccs[i] = CCS.get(i).split(",");
		}
		
		return ccs;
	}
}

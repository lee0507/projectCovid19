package Covid19Hospital;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class GetDataClass {
	
	// ���ξȽɺ���, �ӽ������ ������ �޾ƿ���
	public String[][] getDataHospital(String filename) throws IOException {
		ArrayList<String> cHospital = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader(filename));

		String line;
		int cnt = 0;
		while((line = reader.readLine()) != null) {
			if(cnt >= 3) { // �� �� 3���� �ʿ���� ������
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
	
	// ��������� ������ �ޱ�
	public String[][] getDataCCS(String filename) throws IOException {
		ArrayList<String> CCS = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader(filename));

		String line;
		int cnt = 0;
		while((line = reader.readLine()) != null) {
			if(cnt > 2) { // �� �� 1���� �ʿ���� ������
				CCS.add(line);
			}
			cnt++;
		}
		
		String[][] ccs = new String[CCS.size()][]; // �ڷγ� �����˻��. covid-19 checkup station �� ����
		for(int i = 0; i < CCS.size(); i++) {
			ccs[i] = CCS.get(i).split(",");
		}
		
		return ccs;
	}
}

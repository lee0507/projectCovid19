package Covid19Hospital;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class GetChoices {
	public Scanner scan = new Scanner(System.in); // get choices from user : scanner
	
	public String getFunc() {
		String name = "";
		
		System.out.println("0. ������");
		System.out.println("====����� �������ּ���.====");
		System.out.println("1. ���ξȽɺ���");
		System.out.println("2. ���������");
		System.out.println("3. �ӽü����˻��");
		System.out.println("(�ӽü����˻�Ҵ� �����������̰ų� �������� ��� �̿��Ͻ� �� �����ϴ�.)");
		int func = scan.nextInt();
		
		if (func == 0) {
			name = "0";
		} else if(func == 1) {
			name = "D:\\corona\\���ξȽɺ���_20210513153037.csv";
		} else if(func == 2) {
			name = "D:\\corona\\���������_20210513153046.csv";
		} else if(func == 3) {
			name = "D:\\corona\\�ӽ������.csv";
		} else {
			System.out.println("�����Ͱ� �����ϴ�. �ٽ� �������ּ���.");
		}
		
		return name;
	}
	
	public String getCity(String[][] cHos, int num) {
		HashSet<String> City = new HashSet<String>();
		
		if(num == 1) {
			for (int i = 0; i < cHos.length; i++) {
				City.add(cHos[i][1]);
			}
		} if (num == 2) {
			for (int i = 0; i < cHos.length; i++) {
				City.add(cHos[i][2]);
			}
		} if (num == 3) {
			for (int i = 0; i < cHos.length; i++) {
				City.add(cHos[i][1]);
			}
		}
			
		ArrayList<String> city = new ArrayList<String>(City); // change to ArrayList
		Collections.sort(city);
		
		String str;
		
		if(num == 1) {
			System.out.println("====�� ��ó �ڷγ� ���� ã��====");
		} else if(num == 2) {
			System.out.println("====�� ��ó �ڷγ� ��������� ã��====");
		} else if(num == 3) {
			System.out.println("====�� ��ó �ڷγ� �ӽ������ ã��====");
		}
		
		System.out.println("====���ø� �������ּ���====");
		for (int i = 0; i < city.size(); i++) {
			System.out.println((i+1) + "." + city.get(i));
		}
		
		int choice = scan.nextInt();
		str = city.get(choice - 1);
		return str;
	}
	
	public String getDist(String[][] cHos, String str, int num) {
		HashSet<String> District = new HashSet<String>();
		
		if(num == 1 || num == 3) {
			for (int i = 0; i < cHos.length; i++) {
				if(cHos[i][1].equals(str)) District.add(cHos[i][2]);
			}
		} if (num == 2) {
			for (int i = 0; i < cHos.length; i++) {
				if(cHos[i][2].equals(str)) District.add(cHos[i][3]);
			}
		}
			
		ArrayList<String> dist = new ArrayList<String>(District); // change to ArrayList
		Collections.sort(dist);
		String str1;
		for (int i = 0; i < dist.size(); i++) {
			System.out.println((i+1) + "." + dist.get(i));
		}
		
		int choice = scan.nextInt();
		str1 = dist.get(choice - 1);
		
		return str1;
	}
	
	public void printData(String[][] cHos, String str, String str1, String filename) {
		ArrayList<String> hospital = new ArrayList<String>(); 
		
		if(filename.contains("����")) { // ���ξȽɺ��� ������ �μ�
			for(int i = 0; i < cHos.length; i++) {
				if(cHos[i][5].equals("A")) {
					cHos[i][5] = "�ܷ�����";
				} else if(cHos[i][5].equals("B")) {
					cHos[i][5] = "�ܷ����� �� �Կ�";
				}
			}
			
			for(int i = 0; i < cHos.length; i++) {
				if(cHos[i][1].contains(str) && cHos[i][2].contains(str1)) {
					String printdata = cHos[i][3] + " / " + cHos[i][4] + " / " + cHos[i][5] + " / " + cHos[i][6];
					hospital.add(printdata);
				}
			}
		
			for (int i = 0; i < hospital.size(); i++) {
					System.out.println(hospital.get(i));
			}
			
		} else if(filename.contains("�ӽ�")) { // �ӽ������ ������ �μ�
			for (int i = 0; i < cHos.length; i++) {
				if(cHos[i][1].contains(str) && cHos[i][2].contains(str1)) {
					String printdata = cHos[i][3] + " / " + cHos[i][4];
					hospital.add(printdata);
				}
			}
		
			for (int i = 0; i < hospital.size(); i++) {
				System.out.println(hospital.get(i));
			}
			
		} else if(filename.contains("����")) {
			
			
			for (int i = 0; i < cHos.length; i++) {
				if(cHos[i][2].contains(str) && cHos[i][3].contains(str1)) {
					String printdata = cHos[i][4] + " / " + cHos[i][5] + " / " + cHos[i][6] + " / " + cHos[i][7] + " / " + cHos[i][8] + " / " + cHos[i][9];
					hospital.add(printdata);
				}
			}
			
			for (int i = 0; i < hospital.size(); i++) {
				System.out.println(hospital.get(i));
			}		
		}
	}
	
	public void getRunTime(String[][] cHos, String str, String str1, String filename) {
		ArrayList<String> CCS = new ArrayList<String>(); 
		String[] runTime; 
		
		if(filename.contains("����")) {
			for(int i = 0; i < cHos.length; i++) {
				if(cHos[i][2].contains(str) && cHos[i][3].contains(str1)) {
					CCS.add(cHos[i][4] + "&" + cHos[i][6] + "&" + cHos[i][7] + "&" + cHos[i][8]);
				}
			}
			
			for(int i = 0; i < CCS.size(); i++) {
				runTime = CCS.get(i).split("&");
				
				System.out.printf("==[%s]==\n", runTime[0]);
				System.out.printf("���� ��ð� : %s\n����� ��ð� : %s\n�Ͽ���, ������ ��ð� : %s\n", runTime[1], runTime[2], runTime[3]);
			}
		} else if(filename.contains("�ӽ�")) {
			for(int i = 0; i < cHos.length; i++) {
				runTime = cHos[i][5].split("&&");
				
				System.out.printf("==[%s]==\n", runTime[0]);
				System.out.printf("���� ��ð� : %s\n����� ��ð� : %s\n�Ͽ���, ������ ��ð� : %s\n", runTime[1], runTime[2], runTime[3]);
			}	
		}
	}
}
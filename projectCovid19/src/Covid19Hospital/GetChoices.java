package Covid19Hospital;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class GetChoices {
	public Scanner scan = new Scanner(System.in); // get choices from user : scanner
	
	public String getFunc() {
		String name = "";
		
		System.out.println("0. 나가기");
		System.out.println("====기능을 선택해주세요.====");
		System.out.println("1. 국민안심병원");
		System.out.println("2. 선별진료소");
		System.out.println("3. 임시선별검사소");
		System.out.println("(임시선별검사소는 밀접접촉자이거나 유증상인 경우 이용하실 수 없습니다.)");
		int func = scan.nextInt();
		
		if (func == 0) {
			name = "0";
		} else if(func == 1) {
			name = "D:\\corona\\국민안심병원_20210513153037.csv";
		} else if(func == 2) {
			name = "D:\\corona\\선별진료소_20210513153046.csv";
		} else if(func == 3) {
			name = "D:\\corona\\임시진료소.csv";
		} else {
			System.out.println("데이터가 없습니다. 다시 선택해주세요.");
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
			System.out.println("====집 근처 코로나 병원 찾기====");
		} else if(num == 2) {
			System.out.println("====집 근처 코로나 선별진료소 찾기====");
		} else if(num == 3) {
			System.out.println("====집 근처 코로나 임시진료소 찾기====");
		}
		
		System.out.println("====도시를 선택해주세요====");
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
		
		if(filename.contains("병원")) { // 국민안심병원 데이터 인쇄
			for(int i = 0; i < cHos.length; i++) {
				if(cHos[i][5].equals("A")) {
					cHos[i][5] = "외래진료";
				} else if(cHos[i][5].equals("B")) {
					cHos[i][5] = "외래진료 및 입원";
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
			
		} else if(filename.contains("임시")) { // 임시진료소 데이터 인쇄
			for (int i = 0; i < cHos.length; i++) {
				if(cHos[i][1].contains(str) && cHos[i][2].contains(str1)) {
					String printdata = cHos[i][3] + " / " + cHos[i][4];
					hospital.add(printdata);
				}
			}
		
			for (int i = 0; i < hospital.size(); i++) {
				System.out.println(hospital.get(i));
			}
			
		} else if(filename.contains("선별")) {
			
			
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
		
		if(filename.contains("선별")) {
			for(int i = 0; i < cHos.length; i++) {
				if(cHos[i][2].contains(str) && cHos[i][3].contains(str1)) {
					CCS.add(cHos[i][4] + "&" + cHos[i][6] + "&" + cHos[i][7] + "&" + cHos[i][8]);
				}
			}
			
			for(int i = 0; i < CCS.size(); i++) {
				runTime = CCS.get(i).split("&");
				
				System.out.printf("==[%s]==\n", runTime[0]);
				System.out.printf("평일 운영시간 : %s\n토요일 운영시간 : %s\n일요일, 공휴일 운영시간 : %s\n", runTime[1], runTime[2], runTime[3]);
			}
		} else if(filename.contains("임시")) {
			for(int i = 0; i < cHos.length; i++) {
				runTime = cHos[i][5].split("&&");
				
				System.out.printf("==[%s]==\n", runTime[0]);
				System.out.printf("평일 운영시간 : %s\n토요일 운영시간 : %s\n일요일, 공휴일 운영시간 : %s\n", runTime[1], runTime[2], runTime[3]);
			}	
		}
	}
}
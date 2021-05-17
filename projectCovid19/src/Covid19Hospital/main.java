package Covid19Hospital;

import java.io.IOException;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		GetDataClass gd = new GetDataClass();
		GetChoices c = new GetChoices();
		
		while(true) {
			String[][] datas = null;
			String filename = c.getFunc();
			int code = 0;
			
			// 기능선택하기
			if(filename.contains("병원")) {
				datas = gd.getDataHospital(filename);
				code = 1;
			} else if(filename.contains("선별")) {
				datas = gd.getDataCCS(filename);
				code = 2;
			} else if(filename.contains("임시")) {
				datas = gd.getDataHospital(filename);
				code = 3;
			}  else if(filename.equals("0")) {
				break;
			}
			
			String city = c.getCity(datas, code);
			String dist = c.getDist(datas, city, code);
			
			c.printData(datas, city, dist, filename);
			}
		}
	}



import java.io.FileWriter;
import java.io.IOException;

public class SaveArraytoTxt {
	public static void SaveArray01(double[][] strArray, String filePath) {
		FileWriter fw = null;
		try {
			// fw = new FileWriter("d://test.txt",true);
			fw = new FileWriter(filePath, true);
			int rowLength = strArray.length;// �г���
			int colLength = strArray[0].length;// �г��ȡ�

			fw.write("primary data"+ "\r\n");
			fw.write("4"+ "\r\n");
			fw.write("X"+ "\r\n");
			fw.write("Y"+ "\r\n");
			fw.write("Z"+ "\r\n");
			fw.write("VAL"+ "\r\n");					
			
			for (int i = 0; i < rowLength; i++) {
				// for (int i =rowLength-1 ; i >=0; i--) {
				String rowTemp = "";
				for (int j = 0; j < colLength; j++) {
					rowTemp = rowTemp +  strArray[i][j] + " ";
				}
				String c = rowTemp + "\r\n";
				fw.write(c);
			}

			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("");
			System.exit(-1);
		}
	}

}

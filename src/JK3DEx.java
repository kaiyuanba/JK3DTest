import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import de.onlinehome.geomath.jk3d.jk3d;

public class JK3DEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		linearStretch();
		String path = "D:/GitHub/JK3DTest/jk3d.par";// 第一个文件的路径
		jk3d j = new jk3d(path);

		System.out.println("插值完成");
	}



	public static void linearStretch() {
		String filePath = "D:/GitHub/JK3DTest/testdata-iw3d-3D.dat";

		@SuppressWarnings("unused")
		String[][] BeforeArray;
		BeforeArray = readTxtFile(filePath);
	public float maxValue;
	public float minValue;
	
	
	
	}

	public static String[][] readTxtFile(String filePath) {
		try {

			// filePath="C:/Users/zhaohuihui/workspace/MatrixToImage/MatrixData01.txt";
			String encoding = "GBK";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // �ж��ļ��Ƿ����
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// ���ǵ������ʽ
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				String[][] ValueMatrix = new String[100][100];

				String[] lineValues = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					if (!lineTxt.startsWith("*") && !lineTxt.startsWith("#")) {
						lineValues = lineTxt.trim().split("\\s+");// �Զ���ո�ָ�
						// int vL = lineValues.length;
						// for (int s = 0; s < vL; s++) {
						// for (int i = 0; i < ValueMatrix.length; i++) {
						// for (int j = 0; j < ValueMatrix[0].length; j++) {
						//
						// //
						//
						// ValueMatrix[i][j] = lineValues[s];
						// //
						// //
						// System.out.println("lineValues[j]"+j+":"+lineValues[j]);
						// //
						// System.out.println("ValueMatrix[s][j]"+s+":"+j+":"+lineValues[j]);
						// }
						// }
						// }
						// System.out.println(lineTxt);
						// i++;

					}

				}

				int vL = lineValues.length;
				// for (int s = 0; s < vL; s++) {
				for (int i = 0; i < ValueMatrix.length; i++) {
					for (int j = 0; j < ValueMatrix[0].length; j++) {

						//

						ValueMatrix[i][j] = lineValues[i * 100 + j];
						//
						// System.out.println("lineValues[j]"+j+":"+lineValues[j]);
						// System.out.println("ValueMatrix[s][j]"+s+":"+j+":"+lineValues[j]);
						// System.out.println(s+":"+lineValues[s]);
					}
				}
				// }

				read.close();
				return ValueMatrix;

			} else {
				System.out.println("");
			}

		} catch (

		Exception e) {
			System.out.println("");
			e.printStackTrace();
		}
		return null;

	}

}

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

	public static float maxX = -180;
	public static float minX = 180;
	public static float maxY = -90;
	public static float minY = 90;
	public static float maxZ = -20000;
	public static float minZ = 20000;
	public static float maxV = 0;
	public static float minV = 100;

	public static void linearStretch() {
		String importPath = "D:/GitHub/JK3DTest/outTemp.txt";
		String outputPath = "D:/GitHub/JK3DTest/testdata-iw3d-3D.dat";
		@SuppressWarnings("unused")
		double[][] BeforeArray;
		BeforeArray = readTxtFile(importPath);

		SaveArraytoTxt.SaveArray01(BeforeArray, outputPath);

	}

	public static double[][] readTxtFile(String filePath) {
		try {
			String encoding = "GBK";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // �ж��ļ��Ƿ����
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// ���ǵ������ʽ
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				int n = 0;//
				bufferedReader.mark((int) file.length());
				while ((lineTxt = bufferedReader.readLine()) != null) {
					// if (!lineTxt.startsWith("*") && !lineTxt.startsWith("#"))
					// {
					// n++;
					// // if(maxValue<)
					//
					// }

					if (!lineTxt.startsWith("*") && !lineTxt.startsWith("#")) {
						String[] lineValues = lineTxt.trim().split("\\s+");// �Զ���ո�ָ�
						// int vL = lineValues.length;
						if (lineValues.length == 4) {
							for (int j = 0; j < 4; j++) {
								if (maxX < Float.parseFloat(lineValues[0])) {
									maxX = Float.parseFloat(lineValues[0]);
								}
								if (minX > Float.parseFloat(lineValues[0])) {
									minX = Float.parseFloat(lineValues[0]);
								}
								if (maxY < Float.parseFloat(lineValues[1])) {
									maxY = Float.parseFloat(lineValues[1]);
								}
								if (minY > Float.parseFloat(lineValues[1])) {
									minY = Float.parseFloat(lineValues[1]);
								}
								if (maxZ < Float.parseFloat(lineValues[2])) {
									maxZ = Float.parseFloat(lineValues[2]);
								}
								if (minZ > Float.parseFloat(lineValues[2])) {
									minZ = Float.parseFloat(lineValues[2]);
								}
								if (maxV < Float.parseFloat(lineValues[3])) {
									maxV = Float.parseFloat(lineValues[3]);
								}
								if (minV > Float.parseFloat(lineValues[3])) {
									minV = Float.parseFloat(lineValues[3]);
								}

							}

							System.out.println(lineTxt);
							n++;
						}

					}
				}

				double[][] stretched = new double[n][4];
				read.close();

				read = new InputStreamReader(new FileInputStream(file), encoding);// ���ǵ������ʽ
				bufferedReader = new BufferedReader(read);
				int i = 0;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					if (!lineTxt.startsWith("*") && !lineTxt.startsWith("#")) {
						String[] lineValues = lineTxt.trim().split("\\s+");// �Զ���ո�ָ�
						// int vL = lineValues.length;
						if (lineValues.length == 4) {
							for (int j = 0; j < 4; j++) {
								stretched[i][0] = 0
										+ (1.1 - 0) * (Float.parseFloat(lineValues[0]) - minX) / (maxX - minX);
								stretched[i][1] = 0
										+ (1.1 - 0) * (Float.parseFloat(lineValues[1]) - minY) / (maxY - minY);
								stretched[i][2] = 0
										+ (1.1 - 0) * (Float.parseFloat(lineValues[2]) - minZ) / (maxZ - minZ);
								stretched[i][3] = 0.25
										+ (0.75 - 0.25) * (Float.parseFloat(lineValues[3]) - minV) / (maxV - minV);
							}
							System.out.println(stretched[i][0] + "  " + stretched[i][1] + "  " + stretched[i][2] + "  "
									+ stretched[i][3]);
							i++;

						}

					}

				}
				read.close();
				return stretched;

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


public class MatrixMultiplyThread extends Thread {
	private int rowNum, columnNum;
	private int firstMatrix[][], secondMatrix[][];

	MatrixMultiplyThread( int[][] firstMatrix, int[][] secondMatrix, int rowNum, int columnNum) {
		this.firstMatrix = firstMatrix;
		this.secondMatrix = secondMatrix;
		this.rowNum = rowNum;
		this.columnNum = columnNum;
	}

	public void run() {
		int sum = 0;
		for (int i = rowNum; i < Main.size; i++) {
			for (int j = columnNum; j < Main.size; j++) {
				for (int k = 0; k < Main.size; k++) {
					sum += firstMatrix[i][k] * secondMatrix[k][j];
					Main.resultMatrix[i][j] = sum;

				}
			}
		}
		

	}

}
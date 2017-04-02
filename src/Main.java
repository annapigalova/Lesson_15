import java.util.Random;
import java.util.Scanner;

public class Main {
	public static int[][] resultMatrix;
	public static int size;

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter matrix size: ");

		size = sc.nextInt();
		sc.close();

		int[][] firstMatrix = new int[size][size];
		enterMatrix(firstMatrix);
		printMatrix(firstMatrix);

		int[][] secondMatrix = new int[size][size];
		enterMatrix(secondMatrix);
		printMatrix(secondMatrix);
		resultMatrix = new int[size][size];

		MatrixMultiplyThread[] multiplyArrayses = new MatrixMultiplyThread[size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				multiplyArrayses[i] = new MatrixMultiplyThread(firstMatrix, secondMatrix, i, j);
				multiplyArrayses[i].start();
				// resultMatrix[i][j] = result;
			}
		}

		try {
			for (MatrixMultiplyThread multiplyArrays : multiplyArrayses) {
				multiplyArrays.join();
			}
		} catch (InterruptedException e) {
			System.out.println("InterruptedExeption");
		}

		printMatrix(resultMatrix);

	}

	public static void enterMatrix(int[][] matrix) {

		Random rand = new Random();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = rand.nextInt(20);
			}
		}
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + "   ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

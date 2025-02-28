import java.util.Scanner;

public class MatrixOperations {

    // Method to add two matrices
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    // Method to subtract two matrices
    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    // Method to multiply two matrices
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;
        
        // Check if multiplication is possible (cols of matrix1 must be equal to rows of matrix2)
        if (cols1 != rows2) {
            System.out.println("Matrix multiplication is not possible. The number of columns of matrix1 must be equal to the number of rows of matrix2.");
            return null;
        }
        
        int[][] result = new int[rows1][cols2];
        
        // Perform multiplication
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    // Method to display a matrix
    public static void displayMatrix(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the dimensions and elements for matrix 1
        System.out.println("Enter the number of rows and columns for matrix 1:");
        int rows1 = scanner.nextInt();
        int cols1 = scanner.nextInt();
        int[][] matrix1 = new int[rows1][cols1];
        
        System.out.println("Enter the elements of matrix 1:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        // Input the dimensions and elements for matrix 2
        System.out.println("Enter the number of rows and columns for matrix 2:");
        int rows2 = scanner.nextInt();
        int cols2 = scanner.nextInt();
        int[][] matrix2 = new int[rows2][cols2];
        
        System.out.println("Enter the elements of matrix 2:");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        // Check if addition or subtraction is possible
        if (rows1 == rows2 && cols1 == cols2) {
            System.out.println("\nAddition of matrices:");
            int[][] addedMatrix = addMatrices(matrix1, matrix2);
            displayMatrix(addedMatrix);

            System.out.println("\nSubtraction of matrices:");
            int[][] subtractedMatrix = subtractMatrices(matrix1, matrix2);
            displayMatrix(subtractedMatrix);
        } else {
            System.out.println("Matrix addition and subtraction are not possible due to incompatible dimensions.");
        }

        // Check if multiplication is possible
        if (cols1 == rows2) {
            System.out.println("\nMultiplication of matrices:");
            int[][] multipliedMatrix = multiplyMatrices(matrix1, matrix2);
            displayMatrix(multipliedMatrix);
        } else {
            System.out.println("Matrix multiplication is not possible due to incompatible dimensions.");
        }

        scanner.close();
    }
}

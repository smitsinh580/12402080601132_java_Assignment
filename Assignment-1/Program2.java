
class Matrix {
    int rows, cols;
    int[][] mat;

    // Constructor
    Matrix(int r, int c) {
        rows = r;
        cols = c;
        mat = new int[rows][cols];
    }

    // Method to set values
    void setData(int[][] data) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = data[i][j];
            }
        }
    }

    // Display Matrix
    void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Transpose
    Matrix transpose() {
        Matrix t = new Matrix(cols, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                t.mat[j][i] = mat[i][j];
            }
        }
        return t;
    }

    // Multiplication
    Matrix multiply(Matrix m2) {
        if (this.cols != m2.rows) {
            System.out.println("Multiplication not possible!");
            return null;
        }

        Matrix result = new Matrix(this.rows, m2.cols);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < m2.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    result.mat[i][j] += this.mat[i][k] * m2.mat[k][j];
                }
            }
        }
        return result;
    }
}

public class Program2 {
    public static void main(String[] args) {

        // Matrix 1
        int[][] data1 = {
            {1, 2, 3},
            {4, 5, 6}
        };

        // Matrix 2
        int[][] data2 = {
            {7, 8},
            {9, 10},
            {11, 12}
        };

        Matrix m1 = new Matrix(2, 3);
        Matrix m2 = new Matrix(3, 2);

        m1.setData(data1);
        m2.setData(data2);

        System.out.println("\n Matrix 1:");
        m1.display();

        System.out.println("\n Matrix 2:");
        m2.display();

        // Transpose
        System.out.println("Transpose of Matrix 1:");
        Matrix t = m1.transpose();
        t.display();

        // Multiplication
        System.out.println("Multiplication Result:");
        Matrix result = m1.multiply(m2);
        if (result != null) {
            result.display();
        }
    }
}

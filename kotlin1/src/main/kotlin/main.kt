import Matrix
import Complex

fun main(args: Array<String>) {
    val data1 = arrayOf (
        arrayOf(Complex(1.0, 0.0), Complex(2.0, 0.0), Complex(3.0, 0.0)),
        arrayOf(Complex(4.0, 0.0), Complex(5.0, 0.0), Complex(6.0, 0.0))
    )
    val data2 = arrayOf (
        arrayOf(Complex(0.0, 0.0), Complex(1.0, 0.0), Complex(2.0, 0.0)),
        arrayOf(Complex(2.0, 0.0), Complex(1.0, 0.0), Complex(0.0, 0.0))
    )

    val matrix1 = Matrix(2, 3, data1)
    println("matrix1:")
    println(matrix1)

    val matrix2 = Matrix(2,3, data2)
    println("matrix2:")
    println(matrix2)

    val matrix_transpose = matrix1.transpose()
    println("Transpose matrix1:")
    println(matrix_transpose)

    val matrix_plus = matrix1 + matrix2
    println("Matrix1 + matrix2:")
    println(matrix_plus)

    val matrix_times = matrix1 * matrix_transpose
    println("Matrix1 * matrix_transpose:")
    println(matrix_times)

}
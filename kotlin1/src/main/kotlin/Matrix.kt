class Matrix (rows : Int, columns : Int) {

    var rows : Int
    var columns : Int
    var data : Array<Array<Complex>>

    init {
        this.rows = rows
        this.columns = columns
        this.data = Array(rows) { Array(columns) { Complex(0.0, 0.0) } }
    }
    constructor(rows : Int, columns : Int, data : Array<Array<Complex>>) : this (rows, columns) {
        this.data = data
    }
    operator fun get(row : Int, col : Int): Complex {
        return data[row][col]
    }

    operator fun set(row : Int, col : Int, value: Complex) {
        data[row][col] = value
    }

    fun transpose(): Matrix {
        val result = Matrix(columns, rows)
        for (i in 0 until rows) {
            for (j in 0 until columns) {
                result[j, i] = this[i, j]
            }
        }
        return result
    }

    operator fun plus( matrix2: Matrix): Matrix {
        if (rows != matrix2.rows || columns != matrix2.columns) {
            throw MyException("Error: Not equal number of rows or columns")
        }
        val result = Matrix(rows, columns)
        for (i in 0 until rows) {
            for (j in 0 until columns) {
                result[i, j] = this[i, j] + matrix2[i, j]
            }
        }
        return result
    }

    operator fun times( matrix2 : Matrix): Matrix {
        if (rows != matrix2.columns || columns != matrix2.rows) {
            throw MyException("Error: Not equal number of rows or columns")
        }
        val result = Matrix(rows, matrix2.columns)
        for (i in 0 until rows) {
            for (j in 0 until matrix2.columns) {
                for (k in 0 until columns) {
                    result[i, j] += this[i, k] * matrix2[k, j]
                }
            }
        }
        return result
    }

    override fun toString(): String {
        val result = StringBuilder()
        for (i in 0 until rows) {
            for (j in 0 until columns) {
                result.append(data[i][j].toString() + " ")
            }
            result.append("\n")
        }
        return result.toString()
    }
}

class MyException(message:String): Exception(message)
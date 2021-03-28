class Complex constructor(re : Double, im : Double) {

    var re : Double
    var im : Double

    init {
        this.re = re
        this.im = im
    }

    operator fun plus(value: Complex): Complex {
        return Complex(re + value.re, im + value.im)
    }

    operator fun plus(value: Double): Complex {
        return Complex(re + value, im)
    }

    operator fun minus(value: Complex): Complex {
        return Complex(re - value.re, im - value.im)
    }

    operator fun minus(value: Double): Complex {
        return Complex(re - value, im)
    }

    operator fun times(value: Complex): Complex {
        return Complex(re * value.re - im * value.im,
            re * value.im + im * value.re)
    }

    operator fun times(value: Double): Complex {
        return Complex(re * value,  im * value)
    }

    override fun toString() : String {
        var result = "$re"
        if (im == 0.0) {
            return result
        }
        if (im > 0){
            result += "+$im"
        }
        else {
            result += "-" + (-im).toString()
        }
        result += "*i"
        return result
    }
}
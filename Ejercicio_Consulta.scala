object SimpsonIntegracion {


  def integracion(a: Double, b: Double, f: Double => Double): Double = {
    val xBarra = (a + b) / 2
    val resultado = (b - a) * (f(a) + 4 * f(xBarra) + f(b)) / 6
    resultado
  }

  def calcularError(valorEsperado: Double, valorObtenido: Double): Double = {
    math.abs(valorEsperado - valorObtenido)
  }

  def main(args: Array[String]): Unit = {

    val resultado1 = integracion(3, 5, x => -x * x + 8 * x - 12)
    println("Integral 1 = " + resultado1)

    val resultado2 = integracion(0, 2, x => 3 * x * x)
    println("Integral 2 = " + resultado2)

    val resultado3 = integracion(-1, 1, x =>
      x + 2 * x * x - x * x * x + 5 * x * x * x * x
    )
    println("Integral 3 = " + resultado3)

    val resultado4 = integracion(1, 2, x => (2 * x + 1) / (x * x + x))
    println("Integral 4 = " + resultado4)

    val resultado5 = integracion(0, 1, x => math.exp(x))
    println("Integral 5 = " + resultado5)

    val resultado6 = integracion(2, 3, x => 1 / (x - 1))
    println("Integral 6 = " + resultado6)

    val resultado7 = integracion(0, 1, x => 1 / (1 + x * x))
    println("Integral 7 = " + resultado7)


    val error1 = calcularError(7.33, resultado1)
    println("Error 1 = " + error1)

    val error2 = calcularError(8, resultado2)
    println("Error 2 = " + error2)

    val error3 = calcularError(3.333, resultado3)
    println("Error 3 = " + error3)

    val error4 = calcularError(1.09861, resultado4)
    println("Error 4 = " + error4)

    val error5 = calcularError(1.71828, resultado5)
    println("Error 5 = " + error5)

    val error6 = calcularError(0.828427, resultado6)
    println("Error 6 = " + error6)

    val error7 = calcularError(0.785398, resultado7)
    println("Error 7 = " + error7)
  }
}

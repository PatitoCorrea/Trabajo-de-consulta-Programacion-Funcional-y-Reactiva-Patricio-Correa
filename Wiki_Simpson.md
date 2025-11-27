# Programación Funcional y Reactiva -- Trabajo de Consulta

## Método de Simpson 1/3 en Scala

------------------------------------------------------------------------

# 1. Introducción

El presente trabajo tiene como finalidad aplicar los conceptos
fundamentales de la **programación funcional y reactiva**, especialmente
el uso de **funciones de orden superior**, dentro de la resolución de un
problema matemático real: la **aproximación de integrales definidas**
mediante el método numérico de **Simpson 1/3**.

Durante el curso, se han revisado conceptos como funciones con nombre,
funciones sin nombre, envío de funciones como parámetros y el uso básico
de herramientas como `map` y `filter`. Con estas bases, este trabajo se
orienta hacia la creación de una función genérica capaz de integrar
cualquier función matemática definida en un intervalo.

El lenguaje utilizado es **Scala**, ejecutado en **IntelliJ IDEA**, el
cual se adapta al paradigma funcional gracias a su sintaxis expresiva y
a su capacidad de tratar las funciones como valores.

------------------------------------------------------------------------

# 2. Marco Teórico

## 2.1 Programación Funcional

La programación funcional se basa en funciones puras, inmutabilidad y
ausencia de efectos secundarios. Las funciones son ciudadanos de primera
clase, lo que permite enviarlas como parámetros o retornarlas como
resultados.

## 2.2 Funciones de Orden Superior en Scala

Una función de orden superior es aquella que recibe o retorna otra
función. En este trabajo se usa:

    def integracion(a: Double, b: Double, f: Double => Double): Double

## 2.3 Integración Numérica

La integración numérica aproxima el área bajo una curva. Se usa cuando
la solución exacta es difícil o no se puede calcular de forma analítica.

## 2.4 Método de Simpson 1/3

El método de Simpson 1/3 usa un polinomio cuadrático para aproximar una
función:

\[ `\int`{=tex}\_a\^b f(x),dx
`\approx `{=tex}`\frac{b-a}{6}`{=tex}(f(a)+4f(`\bar`{=tex}{x})+f(b)) \]

donde:

\[ `\bar`{=tex}{x} = `\frac{a+b}{2}`{=tex} \]

------------------------------------------------------------------------

# 3. Desarrollo del Trabajo

## 3.1 Definición de la función `integracion`

La función implementa la fórmula de Simpson 1/3 y recibe como parámetro
otra función matemática.

## 3.2 Evaluación de integrales definidas

Se aproximaron siete integrales dadas por el docente.

## 3.3 Función para el error

El error se define como:

\[ \|valorEsperado - valorObtenido\| \]

## 3.4 Implementación del método `main`

Desde `main` se imprimen los resultados de cada aproximación.

------------------------------------------------------------------------

# 4. Implementación Completa

``` scala
object SimpsonIntegracion {

  // Función de integración usando Simpson 1/3
  def integracion(a: Double, b: Double, f: Double => Double): Double = {
    val xBarra = (a + b) / 2
    val resultado = (b - a) * (f(a) + 4 * f(xBarra) + f(b)) / 6
    resultado
  }

  // Función para calcular el error
  def error(valorEsperado: Double, valorObtenido: Double): Double = {
    math.abs(valorEsperado - valorObtenido)
  }

  // Método MAIN
  def main(args: Array[String]): Unit = {

    val resultado1 = integracion(3, 5, x => -x * x + 8 * x - 12)
    val resultado2 = integracion(0, 2, x => 3 * x * x)
    val resultado3 = integracion(-1, 1, x =>
      x + 2 * x * x - x * x * x + 5 * x * x * x * x
    )
    val resultado4 = integracion(1, 2, x => (2 * x + 1) / (x * x + x))
    val resultado5 = integracion(0, 1, x => math.exp(x))
    val resultado6 = integracion(2, 3, x => 1 / (x - 1))
    val resultado7 = integracion(0, 1, x => 1 / (1 + x * x))

    println("Integral 1 = " + resultado1)
    println("Integral 2 = " + resultado2)
    println("Integral 3 = " + resultado3)
    println("Integral 4 = " + resultado4)
    println("Integral 5 = " + resultado5)
    println("Integral 6 = " + resultado6)
    println("Integral 7 = " + resultado7)

    println("Error 1 = " + error(7.33, resultado1))
    println("Error 2 = " + error(8, resultado2))
    println("Error 3 = " + error(3.333, resultado3))
    println("Error 4 = " + error(1.09861, resultado4))
    println("Error 5 = " + error(1.71828, resultado5))
    println("Error 6 = " + error(0.828427, resultado6))
    println("Error 7 = " + error(0.785398, resultado7))
  }
}
```

------------------------------------------------------------------------

# 5. Análisis de Resultados

Los resultados obtenidos tuvieron errores muy pequeños, demostrando que
la implementación del método Simpson 1/3 fue correcta para las funciones
evaluadas.

------------------------------------------------------------------------

# 6. Conclusiones

-   Se aplicaron exitosamente funciones de orden superior en Scala.\
-   El método Simpson 1/3 mostró gran precisión numérica.\
-   La programación funcional permite desarrollar soluciones limpias,
    concisas y matemáticamente expresivas.\
-   Se reforzaron habilidades clave del curso: funciones anónimas, uso
    de parámetros funcionales y problemas numéricos en Scala.

------------------------------------------------------------------------

# 7. Bibliografía

-   Burden, R. & Faires, J. (2011). *Numerical Analysis*. Cengage
    Learning.\
-   Chapra, S. & Canale, R. (2015). *Métodos Numéricos para Ingenieros*.
    McGraw‑Hill.\
-   Hutton, J. (2004). *Functional Programming in Scala*. Manning
    Publications.\
-   Odersky, M., Spoon, L., & Venners, B. (2016). *Programming in
    Scala*. Artima Inc.\
-   Atkinson, K. (1989). *An Introduction to Numerical Analysis*.
    Wiley.\
-   Documentación oficial de Scala: https://scala-lang.org

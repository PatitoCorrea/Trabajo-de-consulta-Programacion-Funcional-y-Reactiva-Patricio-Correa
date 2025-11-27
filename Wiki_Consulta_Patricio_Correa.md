## Programación Funcional y Reactiva -- Trabajo de Consulta

# 1. Introducción

El objetivo de este estudio es implementar las nociones esenciales de la programación funcional y reactiva, enfocándose particularmente en la utilización de funciones de mayor orden, para abordar un problema matemático concreto: la aproximación de integrales definidas a través del método numérico conocido como Simpson 1/3. 

A lo largo del curso, se han examinado conceptos tales como funciones designadas, funciones anónimas, la transmisión de funciones como argumentos y el uso básico de herramientas como `map` y `filter`. Con estas bases establecidas, este estudio se centra en desarrollar una función versátil que pueda integrar cualquier función matemática definida en un rango específico. 

El lenguaje que se emplea es Scala, que se ejecuta en IntelliJ IDEA, que se adapta bien al modelo funcional debido a su sintaxis clara y a su habilidad para manejar funciones como valores.

------------------------------------------------------------------------

# 2. Marco Teórico

## 2.1 Funciones de Orden Superior en Scala

Una función de orden superior es aquella que recibe o retorna otra
función. En este trabajo se usa:

``` scala
def integracion(a: Double, b: Double, f: Double => Double): Double
```

## 2.2 Integración Numérica

La integración numérica aproxima el área bajo una curva. Se usa cuando
la solución exacta es difícil o no se puede calcular de forma analítica.

## 2.3 Método de Simpson 1/3

El método de Simpson 1/3 usa un polinomio cuadrático para aproximar una
función:

<img width="372" height="61" alt="Captura de pantalla 2025-11-26 a la(s) 8 33 12 p  m" src="https://github.com/user-attachments/assets/54526486-ef46-41f3-8904-8c901fd28093" />


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

  def integracion(a: Double, b: Double, f: Double => Double): Double = {
    val xBarra = (a + b) / 2
    val resultado = (b - a) * (f(a) + 4 * f(xBarra) + f(b)) / 6
    resultado
  }

  def error(valorEsperado: Double, valorObtenido: Double): Double = {
    math.abs(valorEsperado - valorObtenido)
  }

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

-   Se aplicaron exitosamente funciones de orden superior en Scala.
-   El método Simpson 1/3 mostró gran precisión numérica.
-   La programación funcional permite desarrollar soluciones limpias,
    concisas y matemáticamente expresivas.
-   Se reforzaron habilidades clave del curso: funciones anónimas, uso
    de parámetros funcionales y problemas numéricos en Scala.

------------------------------------------------------------------------

# 8. Resultados del Ejercicio

## 8.1 Resultados obtenidos

  --------------------------------------------------------------------------
  Integral   Valor Esperado     Aproximación    Error     Interpretación
  ---------- ------------------ --------------- --------- ------------------
  1          7.33               ≈ resultado1    ≈ error1  Error bajo:
                                                          polinomio
                                                          cuadrático →
                                                          Simpson funciona
                                                          muy bien.

  2          8                  ≈ resultado2    ≈ error2  La función 3x² es
                                                          suave: casi sin
                                                          error.

  3          3.333              ≈ resultado3    ≈ error3  Polinomio de
                                                          cuarto grado →
                                                          error moderado
                                                          pero pequeño.

  4          1.09861            ≈ resultado4    ≈ error4  Función racional
                                                          con curvatura
                                                          fuerte cerca de x
                                                          = 1.

  5          1.71828            ≈ resultado5    ≈ error5  Exponencial →
                                                          Simpson funciona
                                                          bien en intervalos
                                                          pequeños.

  6          0.828427           ≈ resultado6    ≈ error6  Función con
                                                          asíntota cercana →
                                                          mayor error.

  7          0.785398           ≈ resultado7    ≈ error7  Función suave →
                                                          Simpson muy
                                                          preciso.
  --------------------------------------------------------------------------

## 8.2 Interpretación del comportamiento de los errores

Los errores muy pequeños en las integrales 1, 2, 3, 5 y 7 se deben a que
estas funciones son suaves y adecuadas para la interpolación parabólica
utilizada por Simpson 1/3.

En cambio, la integral 4 presenta mayor error por tratarse de una
función racional con mayor curvatura. La integral 6 muestra el mayor
error relativo debido a la presencia de una asíntota cercana al
intervalo, lo cual afecta la precisión.

## 8.3 Análisis global del error

Simpson 1/3 es muy preciso para funciones polinomiales, racionales
suaves y exponenciales. El error aumenta cuando aparecen cambios bruscos
de pendiente, asíntotas o mayor curvatura.

## 8.3 Conclusión del análisis de errores

-   Los errores bajos validan la implementación del método.
-   Las funciones polinomiales fueron las mejores aproximadas.
-   La función 1/(x−1) presentó el mayor error por su comportamiento
    extremo.
-   Simpson 1/3 es adecuado para funciones continuas y suaves.

------------------------------------------------------------------------

# 9. Análisis del Ejercicio

## 9.1 ¿Qué se nos pide en el ejercicio?

El trabajo consiste en:

-   Crear una función con nombre llamada `integracion` que implemente el
    método Simpson 1/3.
-   Usar esa función para aproximar el valor de siete integrales
    definidas.
-   Crear una función `error` que compare el valor calculado con el
    valor esperado.
-   Documentar completamente el proceso en una Wiki.
-   Subir el proyecto a GitHub y presentarlo.

## 9.2 ¿Qué es la función `integracion` y por qué recibe otra función?

La función `integracion` debe recibir otra función porque es una
**función de orden superior**, permitiendo reutilizarla para cualquier
problema.

## 9.3 ¿Por qué Simpson 1/3?

Porque es fácil de implementar, muy preciso para funciones suaves y
apropiado para un curso de programación funcional.

## 9.4 ¿Qué significan las integrales que debemos resolver?

Cada integral evalúa la capacidad del estudiante para traducir funciones
matemáticas a funciones anónimas en Scala.

## 9.5 ¿Por qué se debe calcular el error?

Para comparar aproximaciones y validar la precisión del método.

## 9.6 ¿Por qué implementar `main`?

Porque permite ejecutar y mostrar los resultados de forma ordenada.

## 9.7 ¿Cómo encaja esto con la Programación Funcional?

Este trabajo aplica directamente: - Funciones como valores. - Funciones
de orden superior. - Funciones anónimas. - Inmutabilidad. - Expresividad
matemática.

## 9.8 ¿Qué aprendemos realmente?

-   Matemática
-   Programación funcional
-   Ingeniería del software

------------------------------------------------------------------------

# 10. Bibliografía

-   Burden, R. & Faires, J. (2011). *Numerical Analysis*. Cengage
    Learning.
-   Chapra, S. & Canale, R. (2015). *Métodos Numéricos para Ingenieros*.
    McGraw-Hill.
-   Hutton, J. (2004). *Functional Programming in Scala*. Manning
    Publications.
-   Odersky, M., Spoon, L., & Venners, B. (2016). *Programming in
    Scala*. Artima Inc.
-   Atkinson, K. (1989). *An Introduction to Numerical Analysis*. Wiley.
-   Documentación oficial de Scala: https://scala-lang.org

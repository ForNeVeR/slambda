package ru.org.codingteam.slambda

import terms._

object Main extends App {
 	val tru = Lambda('t', Lambda('f', Variable('t')))
  val fls = Lambda('t', Lambda('f', Variable('f')))

  val and = Lambda('b', Lambda('c', Application(Application(Variable('b'), Variable('c')), fls)))

  println(Full.eval(Application(Application(tru, Variable('a')), Variable('b'))))
  println(CallByName.eval(Application(Application(and, tru), tru)))
  println(CallByName.eval(Application(Application(and, tru), tru)) == tru)
}
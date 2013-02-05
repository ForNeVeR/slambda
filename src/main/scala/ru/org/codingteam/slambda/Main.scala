package ru.org.codingteam.slambda

import terms._

object Main extends App {
  val id = Lambda('x', Variable('x'))
  val tru = Lambda('t', Lambda('f', Variable('t')))
  val fls = Lambda('t', Lambda('f', Variable('f')))

  val and = Lambda('b', Lambda('c', Application(Application(Variable('b'), Variable('c')), fls)))

  println(Full.eval(Application(Application(tru, Variable('a')), Variable('b'))))

  val test = Application(
    id,
    Application(
      id,
      Lambda('z', Application(id, Variable('z')))))
  println("Call by name:")
  println(CallByName.eval(test))
}

package ru.org.codingteam.slambda

import terms._

object Full extends Reduction {
  def eval(term: Term) = {
    term match {
      case Variable(name) => Variable(name)
      case Lambda(variable, body) => Lambda(variable, eval(body))
      case Application(Lambda(variable, body), argument) => {
        eval(replace(body, variable, argument))
      }
      case Application(Variable(name), argument) => Application(Variable(name), eval(argument))
      case Application(function, argument) => eval(Application(eval(function), eval(argument)))
    }
  }
}

package ru.org.codingteam.slambda

import terms._

object CallByName extends Reduction {
  override def eval(term: Term) = {
    term match {
      case Application(Lambda(variable, body), value) => {
        val reduced = replace(body, variable, value)
        eval(reduced)
      }
      case other => other
    }
  }
}

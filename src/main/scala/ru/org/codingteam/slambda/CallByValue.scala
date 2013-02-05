package ru.org.codingteam.slambda

import terms._

object CallByValue extends Reduction {
  override def eval(term: Term) = {
    term match {
      case Application(Lambda(variable, body), value) if isValue(value) => {
        val reduced = replace(body, variable, value)
        eval(reduced)
      }
      case Application(function, argument) => {
	eval(
	  Application(eval(function), eval(argument)))
      }
      case other => other
    }
  }

  def isValue(term: Term) = {
    term match {
      case Lambda(_, _) => true
      case _            => false
    }
  }
}

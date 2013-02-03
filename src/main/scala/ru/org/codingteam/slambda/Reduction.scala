package ru.org.codingteam.slambda

import terms._

trait Reduction {
  def eval(term: Term): Term

  def replace(body: Term, variable: Char, value: Term): Term = {
    body match {
      case Variable(name) if name == variable => value
      case Lambda(variableName, body) if variableName != variable => {
        Lambda(variableName, replace(body, variable, value))
      }
      case Application(function, argument) => {
        Application(replace(function, variable, value), replace(argument, variable, value))
      }
      case other => other
    }
  }
}

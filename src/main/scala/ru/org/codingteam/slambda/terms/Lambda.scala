package ru.org.codingteam.slambda.terms

abstract class Term
case class Variable(x: Char) extends Term
case class Lambda(x: Char, body: Term) extends Term
case class Application(function: Term, argument: Term) extends Term
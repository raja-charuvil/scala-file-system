package com.rtjvm.scala.oop.commands

import com.rtjvm.scala.oop.filesystem.State

trait Commands {
  def apply(state: State): State
}

object Commands {

  val MKDIR = "mkdir"

  def emptyCommand: Commands = new Commands {
    override def apply(state: State): State = state
  }

  def incompleteCommand(name: String): Commands = new Commands {
    override def apply(state: State): State = {
      state.setMessage(name + ": incomplete command")
    }
  }

  def from(input: String): Commands = {
    val tokens: Array[String] = input.split(" ")

    if (input.isEmpty || tokens.isEmpty) emptyCommand
    else if (MKDIR.equals(tokens(0))) {
      if (tokens.length < 2) incompleteCommand(MKDIR)
      else new Mkdir(tokens(1))
    } else new UnknownCommand
  }
}

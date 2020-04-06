package com.rtjvm.scala.oop.commands

import com.rtjvm.scala.oop.filesystem.State

trait Commands {
  def apply(state: State): State
}

object Commands {
  def from(input: String): Commands = {
    new UnknownCommand
  }
}

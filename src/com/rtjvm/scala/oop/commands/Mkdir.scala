package com.rtjvm.scala.oop.commands
import com.rtjvm.scala.oop.files.Directory
import com.rtjvm.scala.oop.filesystem.State

class Mkdir(name: String) extends Commands {
  override def apply(state: State): State = {

    val workingDir = state.workingDir

    if (workingDir.hasEntry(name)) {
      state.setMessage("Entry " + name + " already exists!")
    } else if (name.contains(Directory.SEPARATOR)) {
      state.setMessage(name + " must not contain separators!")
    } else if (checkIllegal(name)) {
      state.setMessage(name + " illegal entry name!")
    } else {
      doMkdir(state, name)
    }
  }

  def checkIllegal(name: String): Boolean = {
    name.contains(".")
  }

  def doMkdir(state: State, str: String): State = {
    ???
  }

}

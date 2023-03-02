package scalaparser.listmethodsnames

import java.io.File

class DirExplorer(filter: (Int, String, File) => Boolean, fileHandler: (Int, String, File) => Unit) {
  def explore(root: File): Unit = explore(0, "", root)

  private def explore(level: Int, path: String, file: File): Unit = {
    if (file.isDirectory) {
      file.listFiles.foreach(child => explore(level + 1, path + "/" + child.getName, child))
    } else {
      if (filter(level, path, file)) {
        fileHandler(level, path, file)
      }
    }
  }
}

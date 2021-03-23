import sbt.{AutoPlugin, Def, taskKey, _}
import Keys._

class MyPlugin extends AutoPlugin{

  lazy val dependenciesDiff = taskKey[Classpath]("dependencies diff between Compile and Test scope")

  object autoImport{
    def dependenciesDiff: TaskKey[Classpath] = MyPlugin.this.dependenciesDiff
  }

  override def projectSettings: Seq[Def.Setting[_]] = {
    Seq(
      name := name.value + version.value
    )
  }
}

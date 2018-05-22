import java.text.SimpleDateFormat
import java.util.Calendar

import com.typesafe.sbt.jse.JsEngineImport.JsEngineKeys
import com.typesafe.sbt.web.Import.WebKeys._
import com.typesafe.sbt.web.SbtWeb.autoImport._
import com.typesafe.sbt.web.incremental._
import com.typesafe.sbt.web._
import sbt.Keys._
import sbt._
import com.typesafe.sbt.jse.SbtJsTask
import sbt._
import sbt.Keys._
import com.typesafe.sbt.web.{PathMapping, SbtWeb}
import spray.json._
import com.typesafe.sbt.jse.{SbtJsEngine, SbtJsTask}

import scala.concurrent.duration.Duration


// from https://github.com/irundaia/sbt-sassify
object SbtDemoPlugin extends AutoPlugin {
  override def requires: Plugins = SbtWeb

  override def trigger: PluginTrigger = AllRequirements

  object autoImport {

    object MyKeys {
      val myTask = TaskKey[Seq[File]]("sassify2", "My main task.")
      val assetRootURL = SettingKey[String]("assetRootURL", "The base URL used to locate the assets.")
    }

  }

  import autoImport.MyKeys._
  import SbtJsTask.autoImport.JsTaskKeys._
  import SbtWeb.autoImport._
  import WebKeys._
  import SbtJsEngine.autoImport.JsEngineKeys._
  import autoImport._

  override lazy val buildSettings = Seq(
    assetRootURL := "/assets/",
    javaOptions += "-Djna.nosys=true" // ???
  )

  val baseSbtDemoSettings = Seq(
    excludeFilter in myTask := HiddenFileFilter || "_*",
    includeFilter in myTask := "*.js" || "*.js",

    managedResourceDirectories += (resourceManaged in myTask in Assets).value,
    resourceManaged in myTask in Assets := webTarget.value / "jssss" / "main",
    resourceGenerators in Assets += myTask in Assets,

    // SbtJsTask.executeJs()

    //val command: Option[File] =

    myTask in Assets := Def.task {

      val log = streams.value.log

      val cal = Calendar.getInstance
      val sdf = new SimpleDateFormat("HH:mm:ss")
      val now = sdf.format(cal.getTime)

      log.info(s"$now ---------------------------")
      log.info(s"$now -----  running    ---------")
      log.info(s"$now ---------------------------")

      SbtJsTask.executeJs(
        state = state.value,
        engineType = JsEngineKeys.EngineType.Node,
        command = None,
        nodeModules = (nodeModules in Plugin).value.map(_.getCanonicalPath),
        shellSource = baseDirectory.value / "project" / "myscript.js",
        args = Seq("arg1", "arg2"),
        timeout = Duration(30, "seconds")
      )

      log.info(s"$now ---------------------------")
      log.info(s"$now -----  end of running -----")
      log.info(s"$now ---------------------------")

      Seq.empty[sbt.File]
    }.value

    /*
    myTask in Assets := Def.task {

      val log = streams.value.log
      val sourceDir = (sourceDirectory in Assets).value
      val webJarsDir = (webJarsDirectory in Assets).value

      val sources = (sourceDir ** ((includeFilter in myTask in Assets).value -- (excludeFilter in myTask in Assets).value)).get
      lazy val compilerSettings = (
        Seq(sourceDir.toPath, webJarsDir.toPath),
        assetRootURL.value
      )

      implicit val fileHasherIncludingOptions: OpInputHasher[File] =
        OpInputHasher[File](f => OpInputHash.hashString(f.getCanonicalPath + compilerSettings.toString))

      val results = incremental.syncIncremental((streams in Assets).value.cacheDirectory / "run", sources) { modifiedSources: Seq[File] =>

        val cal = Calendar.getInstance
        val sdf = new SimpleDateFormat("HH:mm:ss")
        val now = sdf.format(cal.getTime)

        log.info(s"$now ---------------------------")
        log.info(s"$now ------ processing $sourceDir")
        log.info(s"$now ------ modifiedSources:")
        modifiedSources.foreach { modifiedSource =>
          log.info(s"$now ------ $modifiedSource")
        }
        log.info(s"$now ---------------------------")

        val opResults: Map[File, OpResult] = Map()
        val createdFiles: Seq[File] = Seq()

        (opResults, createdFiles)
      }(fileHasherIncludingOptions)

      // Return the dependencies
      (results._1 ++ results._2.toSet).toSeq
    }.dependsOn(WebKeys.webModules in Assets).value
	*/
  )

  override def projectSettings: Seq[Setting[_]] = inConfig(Assets)(baseSbtDemoSettings)
}
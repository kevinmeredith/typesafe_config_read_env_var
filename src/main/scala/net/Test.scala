package net

import com.typesafe.config.{Config, ConfigFactory}

object Test {

	def main(xs: Array[String]): Unit = {
		val config    = ConfigFactory.load()
		val fooConfig = config.getConfig("foo")
		println(fooConfig)
		val envVar    = fooConfig.getString("bar")
		println(envVar)
	}
}
# Summary

This repo provides a simple example of reading an environment variable from 
the TypeSafe Config.


## Code

### src/main/scala/net/Test.scala

```
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
```

### src/main/resources/application.conf

```
foo {
	bar = ${BAR}
}
```


## Run it

```
$sbt '; set envVars := Map("BAR" -> "hello") ; runMain net.Test'
...
[info] Config(SimpleConfigObject({"bar":"hello"}))
[info] hello
```

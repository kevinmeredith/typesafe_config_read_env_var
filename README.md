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

### Set the $BAR env var by passing it in with `set envVars`

```
$sbt '; set envVars := Map("BAR" -> "hello") ; runMain net.Test'
...
[info] Config(SimpleConfigObject({"bar":"hello"}))
[info] hello
```

### Blows up at Run-time due to no such $BAR env var

```
$unset BAR
$echo $BAR

$sbt '; runMain net.Test'
Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=512M; support was removed in 8.0
[info] Set current project to typesafeconfig (in build file:/Users/kmmere/Workspace/Work/scala_sandbox/TypesafeConfig/)
[info] Running net.Test 
[error] Exception in thread "main" com.typesafe.config.ConfigException$UnresolvedSubstitution: application.conf @ file:/Users/Kevin/Workspace/Work/scala_sandbox/TypesafeConfig/target/scala-2.11/classes/application.conf: 2: Could not resolve substitution to a value: ${BAR}
```
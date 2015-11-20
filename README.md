## How to Run

```
$sbt '; set envVars := Map("BAR" -> "hello") ; runMain net.Test'
...
[info] Config(SimpleConfigObject({"bar":"hello"}))
[info] hello
```

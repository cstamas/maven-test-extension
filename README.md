# Maven Test Extension and Mojo

Just execute it as

```
mvn org.cstamas.maven.test:maven-test-extension:1.0-SNAPSHOT:test -DclazzNames="java.lang.Object,java.lang.Exception"
```

To query `clazzNames` visibility from build extension and plugin. If you copy this jar into lib/ext, you can test 
core extension as well.


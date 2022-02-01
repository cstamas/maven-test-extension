# Maven Test Extension and Mojo

Just execute it as to see is given class (classes, comma separated list) on classpath from core-extension, build-extension and mojo:

```
~/bin/apache-maven-4.0.0-alpha-1-SNAPSHOT/bin/mvn \
  -DclazzNames="org.apache.http.HttpResponse" \
  org.cstamas.maven.test:maven-test-extension:1.0-SNAPSHOT:test
```
If you copy this jar into lib/ext, you can test core extension as well.

## Example

Locally built https://github.com/apache/maven/pull/635 that uses Maven Resolver 1.8.x transport-http w/o shading http-client, installed it into `~/bin/apache-maven-4.0.0-alpha-1-SNAPSHOT`. To check does http-client "leaks", copy the mojo into lib/ext, uncomment the build extension and run this:

```
✔ 15:46 ~/Worx/cstamas/maven-test-extension [ master L|✔] $ ~/bin/apache-maven-4.0.0-alpha-1-SNAPSHOT/bin/mvn -DclazzNames="org.apache.http.HttpResponse" org.cstamas.maven.test:maven-test-extension:1.0-SNAPSHOT:test
[INFO] Scanning for projects...
[WARNING] 'maven-test-extension' uses 'org.cstamas.maven.test:maven-test-extension' as extension which is not possible within the same reactor build. This plugin was pulled from the local repository!
[INFO] ### Class org.apache.http.HttpResponse is VISIBLE from TestExtension  <-- CORE EXTENSION
[INFO] ### Class org.apache.http.HttpResponse is NOT VISIBLE from TestExtension <-- BUILD-EXTENSION
[INFO] 
[INFO] -------------------------------------< org.cstamas.maven.test:maven-test-extension >--------------------------------------
[INFO] Building maven-test-extension 1.0-SNAPSHOT
[INFO] -----------------------------------------------------[ maven-plugin ]-----------------------------------------------------
[INFO] 
[INFO] --- maven-test-extension:1.0-SNAPSHOT:test (default-cli) @ maven-test-extension ---
[INFO] ### Class org.apache.http.HttpResponse is NOT VISIBLE from TestMojo  <-- MOJO
[INFO] --------------------------------------------------------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] --------------------------------------------------------------------------------------------------------------------------
[INFO] Total time:  0.194 s
[INFO] Finished at: 2022-02-01T15:48:21+01:00
[INFO] --------------------------------------------------------------------------------------------------------------------------
✔ 15:48 ~/Worx/cstamas/maven-test-extension [ master L|✚ 1] $ 
```

|dependency |version |url |
|---|:---:|---|
|Deployment Descriptor             |6.0                                   |https://jakarta.ee/specifications/servlet/6.0/ |
|Arquillian                        |1.8.0.Final                           |https://arquillian.org |
|Jakarta Web API                   |10.0.0                                |https://jakarta.ee/specifications/webprofile/10/ |
|Jakarta JSTL                      |3.0.0                                 |https://jakarta.ee/specifications/tags/3.0/ |
|Jakarta Persistence               |3.1                                   |https://jakarta.ee/specifications/persistence/3.1/ |
|Eclipselink                       |4.0.2                                 |https://eclipse.dev/eclipselink/ |
|MySql Connector                   |8.3.0                                 |https://www.mysql.com/products/connector/ |
|H2 database                       |1.4.200 _(pending 2.2.224)_ :warning: |https://www.h2database.com/html/main.html |
|Arquillian Payara Server Embedded |3.0.alpha8                            |[Payara Server Embedded Arquillian Container](https://docs.payara.fish/community/docs/Technical%20Documentation/Ecosystem/Connector%20Suites/Arquillian%20Containers/Payara%20Server%20Embedded.html) |
|Payara Server Embedded            |6.2024.1                              |[Payara Server Embedded](https://docs.payara.fish/community/docs/Technical%20Documentation/Payara%20Server%20Documentation/Payara%20Server%20Embedded.html)|

*Tested on Payara Community Server 6.2024.1 (Full) (https://www.payara.fish/downloads/payara-platform-community-edition/)*

Add the following line to VM arguments:
<pre>-Djdk.util.zip.disableZip64ExtraFieldValidation=true -Djdk.attach.allowAttachSelf=true --add-opens=java.base/java.io=ALL-UNNAMED --add-opens=java.base/sun.net.www.protocol.jar=ALL-UNNAMED --add-opens=java.base/java.net=ALL-UNNAMED --add-opens=java.naming/javax.naming.spi=ALL-UNNAMED --add-opens=java.base/java.lang=ALL-UNNAMED</pre>

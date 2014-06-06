stackoverflow-java-sdk
======================

This project aims to provide a Java wrapper to the Stack Exchange ? API.

* Cloned from : http://code.google.com/p/stackoverflow-java-sdk/
* SDK supports **Stack Exchange API V2.2**

### Interfaces
There are two interfaces to the library.

* Query Interface
* Facade Interface

### Get Started
Clone repository and build.  
<pre  style="font-family:arial;font-size:12px;border:1px dashed #CCCCCC;width:99%;height:auto;overflow:auto;background:#f0f0f0;;background-image:URL(http://2.bp.blogspot.com/_z5ltvMQPaa8/SjJXr_U2YBI/AAAAAAAAAAM/46OqEP32CJ8/s320/codebg.gif);padding:0px;color:#000000;text-align:left;line-height:20px;"><code style="color:#000000;word-wrap:normal;"> git clone https://github.com/sanjivsingh/stackoverflow-java-sdk.git  
 cd stackoverflow-java-sdk  
 mvn clean install  
</code></pre>

Following 3 artifacts will be generated after maven build.

* ./dist/target/stackoverflow-java-sdk-release-XXXX-release.jar
* ./core/target/stackexchange-java-core-XXXX.jar
* ./schema/target/stackexchange-java-schema-XXXX.jar

Include all JARs three in your classpath

Or you simply maven dependency in your project 

**Dependency**
<pre  style="font-family:arial;font-size:12px;border:1px dashed #CCCCCC;width:99%;height:auto;overflow:auto;background:#f0f0f0;;background-image:URL(http://2.bp.blogspot.com/_z5ltvMQPaa8/SjJXr_U2YBI/AAAAAAAAAAM/46OqEP32CJ8/s320/codebg.gif);padding:0px;color:#000000;text-align:left;line-height:20px;"><code style="color:#000000;word-wrap:normal;"> &lt;dependency&gt;  
  &lt;groupId&gt;com.googlecode.stackexchange&lt;/groupId&gt;  
  &lt;artifactId&gt;stackoverflow-java-sdk-release&lt;/artifactId&gt;  
  &lt;version&gt;2.2.0&lt;/version&gt;  
 &lt;/dependency&gt;  
</code></pre>
**Repository**
<pre  style="font-family:arial;font-size:12px;border:1px dashed #CCCCCC;width:99%;height:auto;overflow:auto;background:#f0f0f0;;background-image:URL(http://2.bp.blogspot.com/_z5ltvMQPaa8/SjJXr_U2YBI/AAAAAAAAAAM/46OqEP32CJ8/s320/codebg.gif);padding:0px;color:#000000;text-align:left;line-height:20px;"><code style="color:#000000;word-wrap:normal;">  &lt;repository&gt;                    
    &lt;id&gt;oss.sonatype&lt;/id&gt;                   
    &lt;url&gt;https://oss.sonatype.org/content/repositories/releases/&lt;url&gt;     
    &lt;releases&gt;                             
       &lt;enabled&gt;true&lt;/enabled&gt;                       
    &lt;/releases&gt;                       
  &lt;/repository&gt;   
</code></pre>

and start experimenting with SDK.


### Contributing

  Source code contributions can be submitted sumitting a [pull request](https://github.com/sanjivsingh/stackoverflow-java-sdk/pulls) 

### Feature 
* **[Asynchronous API](https://github.com/sanjivsingh/stackoverflow-java-sdk/wiki/Asynchronous-API)** Examples of using the API asynchronously are described in Asynchronous API.

* **[Advanced Usage](https://github.com/sanjivsingh/stackoverflow-java-sdk/wiki/AdvancedUsage)**
Advanced usage like changing API providers or paging through the results are described in Advanced Usage.

* **[Spring Configuration](https://github.com/sanjivsingh/stackoverflow-java-sdk/wiki/SpringConfiguration)**
If you plan to use the library in conjunction with Spring framework, this brief tutorial will guide you. Spring Configuration

* **[API Design](https://github.com/sanjivsingh/stackoverflow-java-sdk/wiki/API-Design)**
A brief design of the API is described here. API Design.

* **[Query API](https://github.com/sanjivsingh/stackoverflow-java-sdk/wiki/Query-API)**
Query API provides a Builder like syntax to the StackOverflow? API.There are similar Query interfaces for Answers, Comments, Timelines, Badges etc.

* **[Switch Site](https://github.com/sanjivsingh/stackoverflow-java-sdk/wiki/Switch-Site)**
Fetching records from different site are described here.

* **[Advance Search](https://github.com/sanjivsingh/stackoverflow-java-sdk/wiki/Advance-Search)** 
Advance search feature available in SDK.


For complete stand-alone examples see [Example Source](https://github.com/sanjivsingh/stackoverflow-java-sdk/tree/master/core/src/examples/java/com/google/code/stackexchange/client/examples).

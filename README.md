# ReflectionToString

This ReflectionToString project provides a Reflection based API to recursively print out the toString of a specific Class.

Please, be aware of performance issues of reflective methods. Thus, if the performance of your toString implementation is important, I recommend you to ignore this method and make your own implementation. However, if the performance doesn’t matter you can benefit from this method.

Overview
------------------------------
The toString method is widely implemented. It provides a simple, convenient mechanism for debugging classes during development. It's also widely used for logging, and for passing informative error messages to Exception constructors and assertions. When used in these informal ways, the exact format of toString is not part of the contract of the method, and callers should not rely on the exact format of the returned String.

The ReflectionToString implementation uses reflection to inspect both field names and field values. Note that superclass fields do not contribute to this implementation. 

The ReflectionToString implementation is contained within a MutableObject class.

#####Version
>Version 1.0 -> Design and development of Reflection based toString
#####Build
>Current Build (1.0) -> Java SDK 1.7 and JUnit 4

Usage
------------------------------
To use the ReflectionToString project the MutableObject.java, PropertiesCache.java, and mutable.properties must be imported into your project.  

>*MutableObject.java* -> This Java object is the main class of the project. You must extend this class to override your toString method to use this desired implementation.

>*PropertiesCache.java* -> This class is an implementation of Properties in Java. It is designed using Initialization-on-demand holder idiom.

>*mutable.properties* -> This properties file contains the recursive property which is defaulted to 'true'. 

License
------------------------------

*MIT License* --> A short, permissive software license. Basically, you can do whatever you want as long as you include the original copyright and license notice in any copy of the software/source.  There are many variations of this license in use.

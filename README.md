# ReflectionToString [![Build Status](https://travis-ci.org/rahulnadella/ReflectionToString.svg?branch=master)](https://travis-ci.org/rahulnadella/ReflectionToString)

This ReflectionToString project provides a Reflection based API to recursively print out the toString of a specific Class.

Please, be aware of **performance issues** of reflective methods. Thus, if the performance of your toString implementation is important, I recommend you to ignore this method and make your own implementation. However, if the performance doesn’t matter you can benefit from this method.

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
The user must import the following files from the src package into their project -> ***MutableObject.jar***. Any class that may want to use this implementation must extend the MutableObject class (which will override your implementation).

####Source
To use the ReflectionToString copy src folder into your project. The src package contains the following classes: MutableObject.java, PropertiesCache.java, and mutable.properties which must be imported into your project.  

>*MutableObject.java* -> This Java object is the main class of the project. You must extend this class to override your toString method to use this desired implementation.

>*PropertiesCache.java* -> This class is an implementation of Properties in Java. It is designed using Initialization-on-demand holder idiom.

>*mutable.properties* -> This properties file contains the recursive property which is defaulted to 'true'. 

####Test
The test package consist of Plain Old Java Objects (POJO) that construct a model of how to use the Reflection based toString. The test class can com.test.mutableObject package and is called ObjectModelTest.java. 

>*ObjectModelTest.java* -> In the ObjectModelTest consists of 2 test cases that using the toString to compare the various test cases that a user may encounter (recursive and non-recursive). The user can use theys to see the suggested output of the MutableObject.toString method.

License
------------------------------

*MIT License* --> A short, permissive software license. Basically, you can do whatever you want as long as you include the original copyright and license notice in any copy of the software/source.  There are many variations of this license in use.

# ReflectionToString

This ReflectionToString project provides a Reflection based API to recursively print out the toString of a specific Class.

Overview
-------------------
The toString method is widely implemented. It provides a simple, convenient mechanism for debugging classes during development. It's also widely used for logging, and for passing informative error messages to Exception constructors and assertions. When used in these informal ways, the exact format of toString is not part of the contract of the method, and callers should not rely on the exact format of the returned String.

The ReflectionToString implementation uses reflection to inspect both field names and field values. Note that superclass fields do not contribute to this implementation. 

#####Version
>Version 1.0 -> Design and development of Reflection based toString
#####Build
>Current Build (1.0) -> Java SDK 1.7 and JUnit 4

License
------------------------------

*MIT License* --> A short, permissive software license. Basically, you can do whatever you want as long as you include the original copyright and license notice in any copy of the software/source.  There are many variations of this license in use.

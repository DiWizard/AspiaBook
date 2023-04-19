@echo off

REM Use libprotoc 3.21.4

I:\protoc-22.2\bin\protoc.exe --java_out=..\app\src\main\java aspia.common.proto 
I:\protoc-22.2\bin\protoc.exe --java_out=..\app\src\main\java aspia.desktop.proto 
I:\protoc-22.2\bin\protoc.exe --java_out=..\app\src\main\java aspia.address_book.proto 
I:\protoc-22.2\bin\protoc.exe --java_out=..\app\src\main\java aspia.key_exchange.proto 


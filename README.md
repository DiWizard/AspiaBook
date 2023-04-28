# AspiaBot
Address book generator for Aspia remote control application (https://aspia.org) 

Usage
-------------------

```
AspiaBook [-rwnupsibxtvjh]

Arguments:
  -r=<..>, --addressBookRead=<..>    Aspia address book (*.aab) for read
  -w=<..>, --addressBookWrite=<..>   Aspia address book (*.aab) for write
  -n=<..>, --network=<..>            TCP/IP network [:port] for scan
  -u=<..>, --hostUser=<..>           Aspia host user name
  -p=<..>, --hostPassword=<..>       Aspia host user password
  -s,      --saveCredential          Save user/password to phonebook records
  -i,      --saveIp                  Save pure IP-address instead a hostname
  -b=<..>, --bookPassword=<..>       Password for Aspia adress book
  -x=<..>, --export=<..>             Export address book to JSON-файл
  -t=<..>, --timeout=<..>            Timeout in milliseconds (min: 200, max 5000)
  -v,      --version                 print AspiaBook version
  -j,      --java                    print Java version
  -h,      --help                    this help
```


Usage example (netscan)
```  sh
  AspiaBook -n=192.168.1.0/24:8050 -p=NewPa$$word -w="d:\newBook.aab"
```

Usage example (JSON export)
``` sh
  AspiaBook -r="d:\MyBook.aab" -p=Pa$$word -x="d:\MyBook.json"
```

Direct run
----------

Linux/MacOS
``` sh
/Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home/bin/java -cp "/Users/Shared/AspiaBook/lib/*" info.malenkov.aspiabook.App -n=192.168.1.0/24:8050 -p=NewPa$$word -w="d:\newBook.aab"
```

Windows
``` sh
C:\PROGRA~1\Zulu\zulu-8\bin\java.exe -cp C:\PROGRA~1\AspiaBook\lib\* info.malenkov.aspiabook.App -n=192.168.1.0/24:8050 -p=NewPa$$word -w="d:\newBook.aab"
```

System requirements
-------------------
- Java 8 or higher 

Contacts
--------
E-Mail: maxim.v.malenkov@gmail.com

Licensing
---------
Project code is available under the GNU General Public License 2.

# AspiaBook
Address book generator for Aspia remote control application (https://aspia.org)

Usage
-------------------

```
Usage: AspiaBook [-rwnpxh]

Arguments: 
  -r=<..>, --addressBookRead=<..>    Aspia address book (*.aab) for read
  -w=<..>, --addressBookWrite=<..>   Aspia address book (*.aab) for write
  -n=<..>, --network=<..>            TCP/IP network [:port] for scan
  -i=<..>, --saveIp                  Save pure IP-address instead a hostname
  -p=<..>, --bookPassword=<..>       Password for Aspia adress book
  -x=<..>, --export=<..>             Export address book to JSON-файл
  -v,      --version                 print AspiaBook version
  -j,      --java                    print Java version
  -h,      --help                    this help
```

Usage example (netscan)
-----------------------
```
AspiaBook -n=192.168.1.0/24:8050 -p=NewPa$$word -w="d:\newBook.aab"
```
Usage example (JSON export)
-----------------------
```
AspiaBook -r="d:\MyBook.aab" -p=Pa$$word -x="d:\MyBook.json"
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

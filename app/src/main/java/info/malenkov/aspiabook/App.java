package info.malenkov.aspiabook;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class App {
	private static final String CLK_BOOK = "--addressBookRead";
	private static final String CLK_BOOK_S = "-r";

	private static final String CLK_BOOK_WRITE = "--addressBookWrite";
	private static final String CLK_BOOK_WRITE_S = "-w";

	private static final String CLK_PASSWORD = "--bookPassword";
	private static final String CLK_PASSWORD_S = "-p";

	private static final String CLK_EXPORT = "--exportJSON";
	private static final String CLK_EXPORT_S = "-j";

	private static final String CLK_IPNET = "--network";
	private static final String CLK_IPNET_S = "-n";

	private static final String CLK_SAVEIP = "--saveIp";
	private static final String CLK_SAVEIP_S = "-i";

	private static final String CLK_HELP = "--help";
	private static final String CLK_HELP_S = "-h";

	private static final String CLK_VER = "--version";
	private static final String CLK_VER_S = "-v";

	private static final String CLK_JAVA = "--java";
	private static final String CLK_JAVA_S = "-j";

	private static String commandLineKeys[] = {
		CLK_BOOK, CLK_BOOK_S,
		CLK_BOOK_WRITE, CLK_BOOK_WRITE_S,
		CLK_PASSWORD, CLK_PASSWORD_S,
		CLK_EXPORT, CLK_EXPORT_S,
		CLK_IPNET, CLK_IPNET_S,
		CLK_HELP, CLK_HELP_S,
		CLK_SAVEIP, CLK_SAVEIP_S,
		CLK_VER, CLK_VER_S,
		CLK_JAVA, CLK_JAVA_S
	};

	private static CommandLineParcer commandLineParcer;

    public String getGreeting() {
        return "AspiaBook project";
    }

    public static void main(String[] args) throws Exception {
        AspiaBook aspiaBook = new AspiaBook();

		String jv = System.getProperty("java.version");

		if(jv != null){
			if(jv.length() > 0){
				if(jv.substring(0,2).equals("1.")){
					if(Integer.parseInt(jv.substring(2,3)) < 8){
						wrongJava();
					}
				}
			}
		}else{
			wrongJava();
		}

		commandLineParcer = new CommandLineParcer(args, commandLineKeys);

		if(commandLineParcer.getKeysCount() == 0 || commandLineParcer.getUnknownKeysCount() > 0)
		{
			help();
		}else if(commandLineParcer.isKeyExist(CLK_HELP_S) || commandLineParcer.isKeyExist(CLK_HELP)){
			help();
		}else if(commandLineParcer.isKeyExist(CLK_JAVA_S) || commandLineParcer.isKeyExist(CLK_JAVA)){
			printFullJVMInfo();
		}else if(commandLineParcer.isKeyExist(CLK_VER_S) || commandLineParcer.isKeyExist(CLK_VER)){
			aspiaBook.printVersion();
		}else{
			if(commandLineParcer.isKeyExist(CLK_PASSWORD_S)){
				aspiaBook.setPassword(commandLineParcer.getKeyValue(CLK_PASSWORD_S));
			}else if(commandLineParcer.isKeyExist(CLK_PASSWORD)){
				aspiaBook.setPassword(commandLineParcer.getKeyValue(CLK_PASSWORD));
			}

			if(commandLineParcer.isKeyExist(CLK_SAVEIP_S) || commandLineParcer.isKeyExist(CLK_SAVEIP)){
				aspiaBook.saveIpOnly(true);
			}

			if(commandLineParcer.isKeyExist(CLK_BOOK_S)){
				aspiaBook.setPath(commandLineParcer.getKeyValue(CLK_BOOK_S));
				aspiaBook.load();
			}else if(commandLineParcer.isKeyExist(CLK_BOOK)){
				aspiaBook.setPath(commandLineParcer.getKeyValue(CLK_BOOK));
				aspiaBook.load();
			}

			if(commandLineParcer.isKeyExist(CLK_EXPORT_S)){
				aspiaBook.setPathJSON(commandLineParcer.getKeyValue(CLK_EXPORT_S));
				aspiaBook.export();
			}else if(commandLineParcer.isKeyExist(CLK_EXPORT)){
				aspiaBook.setPathJSON(commandLineParcer.getKeyValue(CLK_EXPORT));
				aspiaBook.export();
			}

			if(commandLineParcer.isKeyExist(CLK_IPNET_S)){
				aspiaBook.setNet(commandLineParcer.getKeyValue(CLK_IPNET_S));
				aspiaBook.netScan();
			}else if(commandLineParcer.isKeyExist(CLK_IPNET)){
				aspiaBook.setNet(commandLineParcer.getKeyValue(CLK_IPNET));
				aspiaBook.netScan();
			}

			if(commandLineParcer.isKeyExist(CLK_BOOK_WRITE_S)){
				aspiaBook.setPathWrite(commandLineParcer.getKeyValue(CLK_BOOK_WRITE_S));
				aspiaBook.save();
			}else if(commandLineParcer.isKeyExist(CLK_BOOK_WRITE)){
				aspiaBook.setPathWrite(commandLineParcer.getKeyValue(CLK_BOOK_WRITE));
				aspiaBook.save();
			}
			
		}
    }

	private static void help(){
		System.out.println("Usage: AspiaBook [-rwnpxh]");
		System.out.println();
		System.out.println("Arguments: ");
		System.out.println("  -r=<..>, --addressBookRead=<..>    Aspia address book (*.aab) for read");
		System.out.println("  -w=<..>, --addressBookWrite=<..>   Aspia address book (*.aab) for write");
		System.out.println("  -n=<..>, --network=<..>            TCP/IP network [:port] for scan");
		System.out.println("  -i=<..>, --saveIp                  Save pure IP-address instead a hostname");		
		System.out.println("  -p=<..>, --bookPassword=<..>       Password for Aspia adress book");
		System.out.println("  -x=<..>, --export=<..>             Export address book to JSON-файл");
		System.out.println("  -v,      --version                 print AspiaBook version");		
		System.out.println("  -j,      --java                    print Java version");		
		System.out.println("  -h,      --help                    this help");		
		System.out.println();
		System.out.println("Usage example (netscan)");
		System.out.println("  AspiaBook -n=192.168.1.0/24:8050 -p=NewPa$$word -w=\"d:\\newBook.aab\"");
		System.out.println();
		System.out.println("Usage example (JSON export)");
		System.out.println("  AspiaBook -r=\"d:\\MyBook.aab\" -p=Pa$$word -x=\"d:\\MyBook.json\"");
		System.out.println();
	}

	private static void wrongJava(){
		System.out.println("<!>: Requires Java VM version 8 or higher!");
		System.out.println("Please, download your version from: ");
		System.out.println("1. Oracle - https://www.java.com/");
		System.out.println("2. Azul - https://www.azul.com/");
		System.out.println("3. Gluon - https://gluonhq.com/");
		System.out.println("... or install any other Open Java 8+ build you are prefer.");
	}

	public static void printFullJVMInfo() throws UnknownHostException{
		System.out.println("");
		// java.version						Java Runtime Environment version, which may be interpreted as a Runtime.Version
		System.out.println("Java Runtime Environment version: " + System.getProperty("java.version"));
		// java.version.date				Java Runtime Environment version date, in ISO-8601 YYYY-MM-DD format, which may be interpreted as a java.time.LocalDate
		System.out.println("Java Runtime Environment version date: " + System.getProperty("java.version.date"));
		// java.vendor						Java Runtime Environment vendor
		System.out.println("Java Runtime Environment vendor: " + System.getProperty("java.vendor"));
		// java.vendor.url					Java vendor URL
		System.out.println("Java vendor URL: " + System.getProperty("java.vendor.url"));
		// java.vendor.version				Java vendor version
		System.out.println("Java vendor version: " + System.getProperty("java.vendor.version"));
		// java.home						Java installation directory
		System.out.println("Java installation directory: " + System.getProperty("java.home"));
		// java.vm.specification.version	Java Virtual Machine specification version, whose value is the feature element of the runtime version
		System.out.println("Java Virtual Machine specification version: " + System.getProperty("java.vm.specification.version"));
		// java.vm.specification.vendor		Java Virtual Machine specification vendor
		System.out.println("Java Virtual Machine specification vendor: " + System.getProperty("java.vm.specification.vendor"));
		// java.vm.specification.name		Java Virtual Machine specification name
		System.out.println("Java Virtual Machine specification name: " + System.getProperty("java.vm.specification.name"));
		// java.vm.version					Java Virtual Machine implementation version which may be interpreted as a Runtime.Version
		System.out.println("Java Virtual Machine implementation version: " + System.getProperty("java.vm.version"));
		// java.vm.vendor					Java Virtual Machine implementation vendor
		System.out.println("Java Virtual Machine implementation vendor: " + System.getProperty("java.vm.vendor"));
		// java.vm.name						Java Virtual Machine implementation name
		System.out.println("Java Virtual Machine implementation name: " + System.getProperty("java.vm.name"));
		// java.specification.version		Java Runtime Environment specification version, whose value is the feature element of the runtime version
		System.out.println("Java Runtime Environment specification version: " + System.getProperty("java.specification.version"));
		// java.specification.vendor		Java Runtime Environment specification vendor
		System.out.println("Java Runtime Environment specification vendor: " + System.getProperty("java.specification.vendor"));
		// java.specification.name			Java Runtime Environment specification name
		System.out.println("Java Runtime Environment specification name: " + System.getProperty("java.specification.name"));
		// java.class.version				Java class format version number
		System.out.println("Java class format version number: " + System.getProperty("java.class.version"));
		// java.class.path					Java class path (refer to ClassLoader.getSystemClassLoader() for details)
		System.out.println("Java class path: " + System.getProperty("java.class.path"));
		// java.library.path				List of paths to search when loading libraries
		System.out.println("List of paths to search when loading libraries: " + System.getProperty("java.library.path"));
		// java.io.tmpdir					Default temp file path
		System.out.println("Default temp file path: " + System.getProperty("java.io.tmpdir"));
		// java.compiler					Name of JIT compiler to use
		System.out.println("Name of JIT compiler to use: " + System.getProperty("java.compiler"));
		// Host name
		System.out.println("Host name: " + InetAddress.getLocalHost().getHostName());
		// os.name							Operating system name
		System.out.println("Operating system name: " + System.getProperty("os.name"));
		// os.arch							Operating system architecture
		System.out.println("Operating system architecture: " + System.getProperty("os.arch"));
		// os.version						Operating system version
		System.out.println("Operating system version: " + System.getProperty("os.version"));
		// file.separator					File separator ("/" on UNIX)
		System.out.println("File separator: " + System.getProperty("file.separator"));
		// path.separator					Path separator (":" on UNIX)
		System.out.println("Path separator: " + System.getProperty("path.separator"));
		// line.separator					Line separator ("\n" on UNIX)
		System.out.println("Line separator: " + System.getProperty("line.separator"));
		// user.name						User's account name
		System.out.println("User's account name: " + System.getProperty("user.name"));
		// user.home						User's home directory
		System.out.println("User's home directory: " + System.getProperty("user.home"));
		// user.dir							User's current working directory
		System.out.println("User's current working directory: " + System.getProperty("user.dir"));
		System.out.println("");
	}


}

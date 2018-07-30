package Perfume.Dex2Jar;

import com.googlecode.d2j.dex.*;
import com.googlecode.d2j.reader.*;
import java.io.*;

public class Dex2Jar
	{
		private static boolean reuseReg = false;
		private static boolean debugInfo = false;
		private static boolean printIR = false;
		private static boolean optmizeSynchronized = false;
		private static boolean skipExceptions = false;
		private static boolean noCode = false;

		public static void from ( File in, File out ) throws IOException
			{
				long baseTS = System.currentTimeMillis ( );
				BaseDexFileReader reader = MultiDexFileReader.open ( in.getAbsolutePath ( )  );
				Dex2jar.from ( reader )
					.reUseReg ( reuseReg )
					.topoLogicalSort ( )
					.skipDebug ( !debugInfo )
					.optimizeSynchronized ( optmizeSynchronized )
					.printIR ( printIR )
					.noCode ( noCode )
					.skipExceptions ( skipExceptions )
					.to ( out );
				long endTS = System.currentTimeMillis ( );
				System.out.println ( String.format ( "Dex2Jar耗时->%.2f", (float) ( endTS - baseTS ) / 1000 ) );			
			}
		public static void from ( String in, String out ) throws IOException
			{
				from ( new File ( in ), new File ( out ) );
			}
	}

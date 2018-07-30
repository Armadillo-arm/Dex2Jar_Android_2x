package Perfume.Dex2Jar;

import java.io.*;

public class Jar2Dex
	{
		public static void from ( File in, File out )
			{
				long baseTS = System.currentTimeMillis ( );
				com.android.dx.command.Main.main ( new String[]{"--dex", "--verbose", "--no-strict", "--output="+out.getAbsolutePath(),in.getAbsolutePath()} );
				long endTS = System.currentTimeMillis ( );
				System.out.println ( String.format ( "Jar2Dex耗时->%.2f", (float) ( endTS - baseTS ) / 1000 ) );
			}
		public static void from ( String in, String out )
			{
				from ( new File ( in ), new File ( out ) );
			}
	}

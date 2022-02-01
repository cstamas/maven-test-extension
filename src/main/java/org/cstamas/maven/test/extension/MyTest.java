package org.cstamas.maven.test.extension;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class MyTest
{
    private static final Logger LOGGER = LoggerFactory.getLogger( MyTest.class );

    public static void perform( String caller )
    {
        String clazzNames = System.getProperty( "clazzNames" );
        if ( clazzNames != null )
        {
            for ( String clazzName : clazzNames.split( "," ) )
            {
                perform( caller, clazzName );
            }
        }
        else
        {
            LOGGER.info( "### No `clazzNames` given." );
        }
    }

    public static void perform( String caller, String clazzName )
    {
        try
        {
            MyTest.class.getClassLoader().loadClass( clazzName );
            LOGGER.info( "### Class {} is VISIBLE from {}", clazzName, caller );
        }
        catch ( ClassNotFoundException e )
        {
            LOGGER.info( "### Class {} is NOT VISIBLE from {}", clazzName, caller );
        }
    }
}

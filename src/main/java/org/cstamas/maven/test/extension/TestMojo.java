package org.cstamas.maven.test.extension;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo( name = "test" )
public class TestMojo extends AbstractMojo
{
    @Override
    public void execute()
    {
        MyTest.perform( getClass().getSimpleName() );
    }
}

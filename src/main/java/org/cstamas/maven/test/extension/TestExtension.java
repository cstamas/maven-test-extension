package org.cstamas.maven.test.extension;

import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.maven.AbstractMavenLifecycleParticipant;
import org.apache.maven.execution.MavenSession;

@Named
@Singleton
public class TestExtension extends AbstractMavenLifecycleParticipant
{
    @Override
    public void afterProjectsRead( MavenSession session )
    {
        MyTest.perform( getClass().getSimpleName() );
    }
}

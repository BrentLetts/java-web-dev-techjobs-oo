package Test;

import org.junit.Before;
import org.junit.Test;

import static java.util.Objects.isNull;
import static org.junit.Assert.*;

import org.launchcode.techjobs_oo.*;

public class JobTest {
    public Job job1;
    public Job job2;
    public Job fullJob;

    @Before
    public void setJob() {
        job1 = new Job();
        job2 = new Job();
    }

    @Before
    public void setFullJob(){
        fullJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId(){
        setJob();
        assertEquals(1, job2.getId() - job1.getId());
    }

    @Test
    public void testFullConstructor(){
        assertTrue(fullJob.getName() == "Product tester");
        assertTrue(fullJob.getEmployer() instanceof Employer);
        assertTrue(fullJob.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(fullJob.getLocation() instanceof Location);
        assertTrue(fullJob.getPositionType() instanceof PositionType);
    }

    @Test
    public void testJobsForEquality(){
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job3.equals(fullJob));
    }

    @Test
    public void testForIdOnlyToString(){
        assertEquals("OOPS! This job does not seem to exist", job1.toString());

    }

    @Test
    public void testForEmptyEmployerField(){
        Job fullJob = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("ID: "+
                fullJob.getId() +
                "\nName: Product tester" +
                "\nEmployer: Data not available" +
                "\nLocation: Desert" +
                "\nPosition Type: Quality control" +
                "\nCore Competency: Persistence",
                fullJob.toString());
    }

    @Test
    public void testForFullFields(){
        assertEquals("ID: "+
                fullJob.getId() +
                "\nName: Product tester" +
                "\nEmployer: ACME" +
                "\nLocation: Desert" +
                "\nPosition Type: Quality control" +
                "\nCore Competency: Persistence",
                fullJob.toString());
    }
}

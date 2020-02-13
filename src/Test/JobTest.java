package Test;

import org.junit.Before;
import org.junit.Test;
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
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job3.equals(job4));
    }

}

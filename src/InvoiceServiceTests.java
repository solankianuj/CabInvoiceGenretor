import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTests {

	 InvoiceGenrator InvoiceGenrator=null;

		@Before
		public void setUp() {
			InvoiceGenrator=new InvoiceGenrator();
		}
		
		@Test
		public void givenDistanceAndtime_ShouldRetirnTotalFare() {
			double distance=2.0;
			int time=5;
		double fare=InvoiceGenrator.calculateFare(distance,time);
			
		Assert.assertEquals(25, fare, 0.0);	
		}
		
		@Test
		public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
			double distance=0.1;
			int time=1;
		   double fare=InvoiceGenrator.calculateFare(distance,time);
			
		    Assert.assertEquals(5, fare, 0.0);	
			
		}
		
		@Test
		public void givenMultipalRides_ShouldReturnInoiceSumray() {
			Ride[] rides= { new Ride(2.0,5),
							new Ride(0.1, 1),
							};
			InvoiceSummary summary=InvoiceGenrator.calculateFare(rides);
			InvoiceSummary expactedInvoiceSummary=new  InvoiceSummary(2,30);
			
			Assert.assertEquals(expactedInvoiceSummary, summary);	
			}

}

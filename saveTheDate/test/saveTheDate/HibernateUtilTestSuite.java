package saveTheDate;

import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.junit.Test;

import com.revature.save_the_date.hibernate.util.HibernateUtil;


public class HibernateUtilTestSuite {
	@Test
	public void test_getSession_returnsValidSessuib_givenProviderCredentials() {
		try {
			Session sess = HibernateUtil.getSession();
			System.out.println(sess);
			HibernateUtil.closeSession();
			
			assertNotNull(sess);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

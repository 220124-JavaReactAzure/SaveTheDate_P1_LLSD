package saveTheDate;

import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.junit.Test;

import com.revature.save_the_date.hibernate.util.HibernateUtil;


public class HibernateUtilTestSuite {
	@Test
	public void test_getSession_returnValidSession_giverProvidedCredentials() {
		try {
			Session sess = HibernateUtil.getSession();
			HibernateUtil.closeSession();
			System.out.println(sess);
			assertNotNull(sess);
		}catch(Exception e) {
			
		}
	}

}

package com.reimbursement.junit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.reimbursement.dao.ReimbDao;
import com.reimbursement.dao.ReimbDaoImpl;
import com.reimbursement.model.Reimbursement;

public class DaoTests {

	private static ReimbDao reimbDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		reimbDao = new ReimbDaoImpl("jdbc:h2:./testDBFolder/testData", "sa", "sa");
		reimbDao.h2InitDao();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		//reimbDao.h2InitDao();
	}

	@After
	public void tearDown() throws Exception {
		reimbDao.h2DestroyDao();
	}

	@Test
	public void selectAllReimbursements() {
		List<Reimbursement> reimbs = reimbDao.selectAllReimbs();
		
		assertEquals(1, reimbs.size());
	}

}

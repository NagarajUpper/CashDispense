<dependency>
			<groupId>org.mockito</groupId>
			<artifactId>mockito-all</artifactId>
			<version>1.9.5</version>
			<scope>test</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/junit/junit -->
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version><!--$NO-MVN-MAN-VER$-->
			<scope>test</scope>
		</dependency>


package com.wns.cassdispense.cashmanspringboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.wns.cassdispense.cashmanspringboot.dao.CashDao;
import com.wns.cassdispense.cashmanspringboot.model.DenominationModel;
import com.wns.cassdispense.cashmanspringboot.model.DenominationModelList;

@RunWith(MockitoJUnitRunner.class)
public class CashServiceImplTest {

	@InjectMocks
	private CashServiceImpl cashServiceImpl;

	@Mock
	private CashDao cashDao;

	@Test
	public void tesAddNotest() {

		DenominationModelList denominationModelList = new DenominationModelList();
		List<DenominationModel> list = new ArrayList<>();
		DenominationModel model = new DenominationModel();

		model.setDenominationValue("20");
		model.setDenominationValueCount(100);

		DenominationModel model2 = new DenominationModel();

		model2.setDenominationValue("50");
		model2.setDenominationValueCount(100);

		list.add(model);
		list.add(model2);
		denominationModelList.setList(list);

		cashDao.addNotes(denominationModelList);
		Assert.assertTrue(denominationModelList.getList().size() != 0);
	}

	@Test
	public void testCountNotes() {

		DenominationModelList denominationModelList = new DenominationModelList();
		List<DenominationModel> list = new ArrayList<>();
		DenominationModel model = new DenominationModel();

		model.setDenominationValue("20");
		model.setDenominationValueCount(100);

		DenominationModel model2 = new DenominationModel();

		model2.setDenominationValue("50");
		model2.setDenominationValueCount(100);

		list.add(model);
		list.add(model2);
		denominationModelList.setList(list);

		Mockito.when(cashDao.countNotess()).thenReturn(denominationModelList);
		cashDao.countNotess();
		Assert.assertTrue(denominationModelList.getList().size() == 2);

	}

	@Test
	public void testGetcash() {

		DenominationModelList denominationModelList = new DenominationModelList();
		List<DenominationModel> list = new ArrayList<>();
		DenominationModel model = new DenominationModel();

		model.setDenominationValue("20");
		model.setDenominationValueCount(100);

		DenominationModel model2 = new DenominationModel();

		model2.setDenominationValue("50");
		model2.setDenominationValueCount(100);

		list.add(model);
		list.add(model2);
		denominationModelList.setList(list);

		Mockito.when(cashDao.countNotess()).thenReturn(denominationModelList);

		String getcash = cashServiceImpl.getcash(100);
		String expected = "50 Notes are:" + 2 + " & 20 Notes are : " + 0 + "issued";

		Assert.assertEquals(getcash, expected);

	}

}
